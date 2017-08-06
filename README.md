

Consider [http://samaxes.github.io/minify-maven-plugin](http://samaxes.github.io/minify-maven-plugin/) for webjar libs.

`mvn gwt:codeserver -pl *-client -am`


`mvn clean install wildfly:deploy-only -pl *-server -Dwildfly.deployment.name=gwttest.war`