
Base from modular-webapp archetype:
[https://github.com/tbroyer/gwt-maven-archetypes/](https://github.com/tbroyer/gwt-maven-archetypes/)

[gwt-maven-plugin](https://tbroyer.github.io/gwt-maven-plugin/)

Consider [http://samaxes.github.io/minify-maven-plugin](http://samaxes.github.io/minify-maven-plugin/) for webjar libs.

[sass-maven-plugin](http://www.geodienstencentrum.nl/sass-maven-plugin/)


Start super dev mode:
`mvn gwt:codeserver -pl *-client -am`

Use bookmarks to compile, [http://localhost:9876](http://localhost:9876).



`mvn clean install wildfly:deploy-only -pl *-server -Dwildfly.deployment.name=gwttest.war`



`mvn wildfly:deploy-only -pl *-server -Dwildfly.deployment.name=gwt.war`


Package war and install do not compile gwt-app
`mvn install -pl *-server -am -Dgwt.skipCompilation=true`


Package war and install do not compile gwt-app and deploy to wildfly with context name `gwt`
`mvn install -pl *-server -am -Dgwt.skipCompilation=true && mvn wildfly:deploy-only -pl *-server -Dwildfly.deployment.name=gwt.war`