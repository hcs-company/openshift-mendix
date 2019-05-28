set -x

PROJECT=mendix-on-openshift
APP_NAME=mendix-app

DATEBASE_NAME=memdix
DATEBASE_USER=mendix
DATEBASE_PASSWORD=mendix
DATABASE_SERVICE_NAME=postgresql-mendix
DATEBASE_ENDPOINT=postgres://${DATEBASE_USER}:${DATEBASE_PASSWORD}@${DATABASE_SERVICE_NAME}.${PROJECT}.svc.cluster.local:5432/${DATEBASE_NAME}
ADMIN_PASSWORD=P@ssw0rd

oc new-project ${PROJECT}

oc new-build https://github.com/hcs-company/mendix --name=${APP_NAME}
oc new-app --template=openshift/postgresql-persistent --param=DATABASE_SERVICE_NAME=${DATABASE_SERVICE_NAME} --param=POSTGRESQL_USER=${DATEBASE_USER} --param=POSTGRESQL_PASSWORD=${DATEBASE_PASSWORD} --param=POSTGRESQL_DATABASE=${DATEBASE_NAME}

oc create secret generic mendix-app-secrets --from-literal=admin-password=${ADMIN_PASSWORD} --from-literal=db-endpoint=${DATEBASE_ENDPOINT}

oc create -f $(APP_NAME}.yaml

