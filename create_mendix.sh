#!/bin/bash
set -x

PROJECT=mendix-on-openshift
MENDIX_APP_DIR=mendix-sample-app
APP_NAME=mendix-app
ADMIN_PASSWORD=P@ssw0rd

DATEBASE_NAME=mendix-db0
DATEBASE_USER=mendix-user
DATEBASE_PASSWORD=mendix-pwd
DATABASE_SERVICE_NAME=mendix-db
DATEBASE_ENDPOINT=postgres://${DATEBASE_USER}:${DATEBASE_PASSWORD}@${DATABASE_SERVICE_NAME}.${PROJECT}.svc.cluster.local:5432/${DATEBASE_NAME}

echo "Create new project: ${PROJECT}" 
oc new-project ${PROJECT}

echo "Build Mendix image with name: ${APP_NAME}"
oc new-build . --strategy=docker --build-arg=BUILD_PATH=${MENDIX_APP_DIR} --name=${APP_NAME}

echo "Create PostegreSql Database"
oc new-app --template=openshift/postgresql-persistent --param=DATABASE_SERVICE_NAME=${DATABASE_SERVICE_NAME} --param=POSTGRESQL_USER=${DATEBASE_USER} --param=POSTGRESQL_PASSWORD=${DATEBASE_PASSWORD} --param=POSTGRESQL_DATABASE=${DATEBASE_NAME}

echo "Create a secret for the MxAdmin password and the datebase endpoint"
oc create secret generic mendix-app-secrets --from-literal=admin-password=${ADMIN_PASSWORD} --from-literal=db-endpoint=${DATEBASE_ENDPOINT}

echo "Create a statefuleset of the application"
oc create -f ${APP_NAME}.yaml

echo "Set a deployment trigger if the image changes"
oc set triggers statefulset/mendix-ocp-stateful --from-image=${PROJECT}/${APP_NAME}:latest -c mendix-app

echo "Go to URL: https://mendix.ocp.hcs-company.com"
echo ""
echo "UserID: MxAdmin"
echo "Password: ${ADMIN_PASSWORD}"

