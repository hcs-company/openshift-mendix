#!/bin/bash
#set -x

PROJECT=mendix-on-openshift
MENDIX_APP_DIR=mendix-sample-app
APP_NAME=mendix-app
ADMIN_PASSWORD=P@ssw0rd

DATEBASE_NAME=mendix-db0
DATEBASE_USER=mendix-user
DATEBASE_PASSWORD=mendix-pwd
DATABASE_SERVICE_NAME=mendix-db
DATEBASE_ENDPOINT=postgres://${DATEBASE_USER}:${DATEBASE_PASSWORD}@${DATABASE_SERVICE_NAME}.${PROJECT}.svc.cluster.local:5432/${DATEBASE_NAME}

echo
echo "#####"
echo "Create new project: ${PROJECT}" 
echo "#####"
oc new-project ${PROJECT}

echo "#####"
echo "Build Mendix image with name: ${APP_NAME}"
echo "#####"
#oc new-build . --strategy=docker --build-arg=BUILD_PATH=${MENDIX_APP_DIR} --name=${APP_NAME}
oc new-build https://github.com/hcs-company/openshift-mendix.git --build-arg=BUILD_PATH=${MENDIX_APP_DIR} --name=${APP_NAME}

echo "#####"
echo "Create PostegreSql Database"
echo "#####"
oc new-app --template=openshift/postgresql-persistent --param=DATABASE_SERVICE_NAME=${DATABASE_SERVICE_NAME} --param=POSTGRESQL_USER=${DATEBASE_USER} --param=POSTGRESQL_PASSWORD=${DATEBASE_PASSWORD} --param=POSTGRESQL_DATABASE=${DATEBASE_NAME}

echo "#####"
echo "Create a secret for the MxAdmin password and the datebase endpoint"
echo "#####"
oc create secret generic mendix-app-secrets --from-literal=admin-password=${ADMIN_PASSWORD} --from-literal=db-endpoint=${DATEBASE_ENDPOINT}

echo "#####"
echo "Create a statefuleset of the application"
echo "#####"
oc create -f ${APP_NAME}.yaml

echo "#####"
echo "Set a deployment trigger if the image changes"
echo "#####"
#oc set triggers statefulset/mendix-ocp-stateful --from-image=${PROJECT}/${APP_NAME}:latest -c mendix-app

echo "Go to URL: https://mendix.ocp.hcs-company.com"
echo ""
echo "UserID: MxAdmin"
echo "Password: ${ADMIN_PASSWORD}"

