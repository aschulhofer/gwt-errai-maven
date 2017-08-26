**Notes**

Base from modular-webapp archetype:

[https://github.com/tbroyer/gwt-maven-archetypes/](https://github.com/tbroyer/gwt-maven-archetypes/)

User maven plugins:

- [gwt-maven-plugin](https://tbroyer.github.io/gwt-maven-plugin/)
- [sass-maven-plugin](http://www.geodienstencentrum.nl/sass-maven-plugin/)
- Consider [http://samaxes.github.io/minify-maven-plugin](http://samaxes.github.io/minify-maven-plugin/) for webjar libs.

**Important**

Set `WF_HOME` enviornment variable to root of wildfly installation. Or set user property `${wildfly.home}` on `mvn` command `-Dwildfly.home=<wf root dir path>`.

**Build**

`mvn clean install`


Skip gwt compilation with user property `gwt.skipCompilation`

E.g.:
`mvn clean install -Dgwt.skipCompilation=true -pl *-client`


**Deploy to standalone wildfly**

`mvn wildfly:deploy-only -Dwildfly.deployment.name=<name>.war`


**SDM - Super Dev Mode**

Start devmode: `mvn gwt:devmode`

    Wait for codeserver to start and open url, autocompile changes on browser refresh.

Works for changes on client and shared code.

Servercode changes or shared code changes used on server:

Run in different console `mvn package -pl ErraiGWT-server,webapp` to repackage server and webapp war and change to tab `Web Server` in `GWT development mode` window and hit `Restart Server` button.


**Misc**

Start super dev mode (this call is _deprecated_ in this project):
`mvn gwt:codeserver -pl *-client -am`

Use bookmarks to compile, [http://localhost:9876](http://localhost:9876).
