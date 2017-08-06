

`mvn gwt:codeserver -pl *-client -am`


`mvn clean install wildfly:deploy-only -pl *-server -Dwildfly.deployment.name=gwttest.war`