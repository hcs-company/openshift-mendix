#!/bin/bash
set -x

PROJECT=mendix-on-openshift-test
APP_NAME=mendix-app
ADMIN_PASSWORD=P@ssw0rd

DATEBASE_NAME=mendix-db0
DATEBASE_USER=mendix-user
DATEBASE_PASSWORD=mendix-pwd
DATABASE_SERVICE_NAME=mendix-db
DATEBASE_ENDPOINT=postgres://${DATEBASE_USER}:${DATEBASE_PASSWORD}@${DATABASE_SERVICE_NAME}.${PROJECT}.svc.cluster.local:5432/${DATEBASE_NAME}

oc new-project ${PROJECT}

oc new-build https://github.com/hcs-company/openshift-mendix --name=${APP_NAME}

oc new-app --template=openshift/postgresql-persistent --param=DATABASE_SERVICE_NAME=${DATABASE_SERVICE_NAME} --param=POSTGRESQL_USER=${DATEBASE_USER} --param=POSTGRESQL_PASSWORD=${DATEBASE_PASSWORD} --param=POSTGRESQL_DATABASE=${DATEBASE_NAME}

oc create secret generic mendix-app-secrets --from-literal=admin-password=${ADMIN_PASSWORD} --from-literal=db-endpoint=${DATEBASE_ENDPOINT}

oc create -f https://raw.githubusercontent.com/hcs-company/openshift-mendix/master/$(APP_NAME}.yaml
