PROJECT=mendix-on-openshift

DATEBASE_NAME=medix
DATEBASE_USER=mendix
DATEBASE_PASSWORD=mendix
##DATEABASE_PASSWORD=`echo -n mendix | base64`

DATABASE_SERVICE_NAME=postgresql-mendix

DATEBASE_ENDPOINT=postgres://${DATEBASE_USER}:${DATEBASE_PASSWORD}@${DATABASE_SERVICE_NAME}.${PROJECT}.svc.cluster.local:5432/${DATEBASE_NAME}

oc new-project mendix-on-openshift

oc new-app --template=openshift/postgresql-persistent --param=DATABASE_SERVICE_NAME=${DATABASE_SERVICE_NAME}l-mendix --param=POSTGRESQL_USER=${DATEBASE_USER} --param=POSTGRESQL_PASSWORD=${DATEBASE_PASSWORD} --param=POSTGRESQL_DATABASE=${DATEBASE_NAME}

#oc create -f postgres-deployment.yaml
#oc create -f postgres-service.yaml

##oc create -f  mendix-app-secrets.yaml
#oc create -f  mendix-app.yaml



