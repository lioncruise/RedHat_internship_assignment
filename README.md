# RedHat_Inc_Assignment

This assignment is an exam for Java developer internship in [RedHat Inc](https://www.redhat.com/en).The concrete contents are as follows:

> Create a maven project, The output of this project is a war which can be deployed to tomcat/jetty/jboss. The war/web app can respond “hello world “ with servlet for url “http://localhost:8080/test/hello”. It’s better you can add a test for this servlet. push it to github repo, Create a README to describe how to build and run your project in English.

So, firstly you need to prepare your development environment. My development environment is as follows:

* OS X 10.11.6
* Oracle JDK 1.8.0_65
* Apache Maven 3.3.9
* Apache Tomcat 8.0.32

Your JDK must be 1.5+ (due to the use of annotations) and Tomcat must be 7+.

To build and run this APP, clone it to your machine first:

```shell
git clone git@github.com:lioncruise/RedHat_Inc_Homework.git
```

Then use Maven to compile, test, package, install and deploy the APP.

```shell
mvn clean
mvn install
```

If it's the first time you use Maven, it will take a little long time. After successfully build the WAR of the App to the local Maven repository. Defaultly, You can `cd ~/.m2` to see the WAR.

Finally, deploy the WAR. You need to fix your tomcat  configuration file.Enter your tomcat installing root directory, add these to /conf/tomcat-users.xml.

```xml
<role rolename="manager-gui"/>  
<role rolename="manager-script"/>  
<user username="admin" password="admin" roles="manager-gui,manager-script"/>  
```

Then go back to the App's root directory to deploy

```shell
mvn tomcat7:deploy
```

At this time, you can enter webapps/ derictory under your tomcat installing root directory, there is a test.war file and test/ directory.

visit `http://localhost:8080/test/hello` and then you'll get what you want.

![](http://7xpq8u.com1.z0.glb.clouddn.com/E0AECB43-B7F2-4C2F-88B6-1C75E6328B36.png)

`mvn tomcat7:undeploy` to undeploy the WAR, and `mvn tomcat7:redeploy` to redeploy the WAR.

To deploy the WAR to JBoss, just copy test.war to `%jboss_home%/standalone/deployments/`. Please be careful with the path configuration of JBoss.

For Jetty, it's also very simple to deploy, just add the WAR file to webapps directory under installing root directory.