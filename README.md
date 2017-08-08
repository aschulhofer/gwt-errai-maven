**Notes**

Base from modular-webapp archetype:
[https://github.com/tbroyer/gwt-maven-archetypes/](https://github.com/tbroyer/gwt-maven-archetypes/)

[gwt-maven-plugin](https://tbroyer.github.io/gwt-maven-plugin/)

Consider [http://samaxes.github.io/minify-maven-plugin](http://samaxes.github.io/minify-maven-plugin/) for webjar libs.

[sass-maven-plugin](http://www.geodienstencentrum.nl/sass-maven-plugin/)


**Important**

Set `WF_HOME` enviornment variable to root of wildfly installation. Or set user property `${wildfly.home}` on `mvn` command `-Dwildfly.home=<wf root dir path>`.

**Build**

`mvn clean install`

**Deploy to standalone wildfly**

`mvn wildfly:deploy-only -Dwildfly.deployment.name=<name>.war`


**SDM**

Start devmode: `mvn gwt:devmode`

    Wait for codeserver to start and open url, autocompile changes on browser refresh.

Works for changes on client and shared code.

Servercode changes or shared code changes used on server:

Run in different console `mvn package -pl *-server` to repackage server war and change to tab `Web Server` in `GWT development mode` window and hit `Restart Server` button.


**Misc**

`mvn clean install wildfly:deploy-only -pl *-server -Dwildfly.deployment.name=gwttest.war`

`mvn wildfly:deploy-only -pl *-server -Dwildfly.deployment.name=gwt.war`

Package war and install do not compile gwt-app
`mvn install -pl *-server -am -Dgwt.skipCompilation=true`

Package war and install do not compile gwt-app and deploy to wildfly with context name `gwt`
`mvn install -pl *-server -am -Dgwt.skipCompilation=true && mvn wildfly:deploy-only -pl *-server -Dwildfly.deployment.name=gwt.war`

Start super dev mode (this call is deprecated in this project):
`mvn gwt:codeserver -pl *-client -am`

Use bookmarks to compile, [http://localhost:9876](http://localhost:9876).
