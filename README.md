# featureservice

## Developing

Start databases:
```
docker-compose down
docker-compose up
```

Set env vars:
```
export ORG_GRADLE_PROJECT_dbUriEdit="jdbc:postgresql://edit-db/edit"
export ORG_GRADLE_PROJECT_dbUserEdit="gretl"
export ORG_GRADLE_PROJECT_dbPwdEdit="gretl"
export ORG_GRADLE_PROJECT_dbUriPub="jdbc:postgresql://pub-db/pub"
export ORG_GRADLE_PROJECT_dbUserPub="gretl"
export ORG_GRADLE_PROJECT_dbPwdPub="gretl"
export ORG_GRADLE_PROJECT_dbUriOereb="jdbc:postgresql://oereb-db/oereb"
export ORG_GRADLE_PROJECT_dbUserOereb="gretl"
export ORG_GRADLE_PROJECT_dbPwdOereb="gretl"

```


Does GRETL work?
```
./start-gretl.sh --docker-image sogis/gretl-runtime:latest --docker-network featureservice_default --job-directory $PWD/development_dbs/oerebdb tasks --all

./start-gretl.sh --docker-image sogis/gretl-runtime:latest --docker-network featureservice_default --job-directory $PWD/development_dbs/pubdb tasks --all

```

Import Administrative Einteilungen (Pub-DB):
```
./start-gretl.sh --docker-image sogis/gretl-runtime:latest --docker-network featureservice_default --job-directory $PWD/development_dbs/pubdb 
```

OEREB (oereb-db):
```
./start-gretl.sh --docker-image sogis/gretl-runtime:latest --docker-network featureservice_default --job-directory $PWD/development_dbs/oerebdb/codelisten

./start-gretl.sh --docker-image sogis/gretl-runtime:latest --docker-network featureservice_default --job-directory $PWD/development_dbs/oerebdb/bundesgesetze

./start-gretl.sh --docker-image sogis/gretl-runtime:latest --docker-network featureservice_default --job-directory $PWD/development_dbs/oerebdb/kantonale_gesetze

./start-gretl.sh --docker-image sogis/gretl-runtime:latest --docker-network featureservice_default --job-directory $PWD/development_dbs/oerebdb/npl
```


