# jCAT - Electronic educational testing platform

jCAT (formerly Brodus) is a web application whose purpose is to apply an electronic version of [Provinha Brasil](http://provinhabrasil.inep.gov.br/), a nation-wide educational evaluation for Brazilian students in the second year of basic school. In its current form, items are created by an specialist and stored in an item bank. This specialist then selects one or more items and creates a *test*. After that, students can take this test while proctored by a teacher or any other test administrator.

One of the prerequisites of *Provinha Brasil* is that item text and alternatives must be read to students by the test administrator. In order to do that electronically, jCAT allows an audio file to be uploaded by the item creator and played by the student during the test. Also, just like the original test, in the electronic version items and their alternatives may or may not be accompanied by images.

As an additional step, video support was added for the electronic version.

## Architecture

The application can be separated in two phases:

### Phase 1 (2012)

The application was originally created in 2012 using Java and the J2EE layered architecture. The application connects to a database (originally MySQL) and performs object-relational mapping using Hibernate; business rules are created through Enterprise Java Beans (EJB); and finally, the view layer is done with PrimeFaces, a free and open source implementation of Java Server Faces (JSF). Everything is built using Ant.

The generated web pages are hosted in a web server (originally [Tomcat 7](http://tomcat.apache.org/)) and the EJBs and Data Access Objects (DAO) are hosted in an application server (originally [JBoss 5.0.1](http://jbossas.jboss.org/downloads)).

* Java version: 1.6;
* Architecture: J2EE layered architecture;
* Database: MySQL 5;
* ORM: Hibernate 4;
* Business rules: EJB;
* Front-end: PrimeFaces 4;
* Application server: JBoss 5.0.1;
* Web server: Tomcat 7;
* Build: Ant.

### Phase 2 (2015-16)

As of 2015, there has been an increased effort in transforming jCAT into a [computerized adaptive test](https://en.wikipedia.org/wiki/Computerized_adaptive_testing), hence the name change. In order to do that, a minor hoverhaul was done in the application architecture, to accomodate the newest trends in web application development and the new versions of old frameworks.

* Java version: 1.7;
* Architecture: J2EE layered architecture;
* Database: MariaDB 10.1;
* ORM: Hibernate 4;
* Business rules: EJB;
* Front-end: PrimeFaces 5.3;
* Application/web server: Wildfly 9;
* Build: Maven 3.

### More info

You can find a copy of my term paper (in portuguese) detailing the architecture I used in 2012 [here](https://www.researchgate.net/publication/282914214_Desenvolvimento_de_um_sistema_de_aplicao_de_testes_informatizados_com_contedo_multimdia).

### Acknowledgements

This work was originally my term project for graduation. I did alongside my friend [Bruno de Jesus Destro](https://br.linkedin.com/in/brunodestro), having prof. Fabio Cabrini as a supervisor and profs. Marcos Roberto Macedo and Ocimar Munhoz Alavarse as examining board members.

# Instructions to build and run

As of 2015, the project has been built on top of a quickstart example from JBoss. The sections below are the instructions from the quickstart.

## System requirements

To build this project, you'll need:

* Java 7.0 (Java SDK 1.7) or better;
* Maven 3.1 or better;
* MariaDB 10.0 or better.

The application this project produces is designed to be run on JBoss WildFly.

## Start JBoss WildFly with the Web Profile

1. Open a command line and navigate to the root of the JBoss server directory.
2. The following shows the command line to start the server with the web profile:

        For Linux:   JBOSS_HOME/bin/standalone.sh
        For Windows: JBOSS_HOME\bin\standalone.bat
 
## Build and Deploy the Quickstart

_NOTE: The following build command assumes you have configured your Maven user settings. If you have not, you must include Maven setting arguments on the command line. See [Build and Deploy the Quickstarts](https://github.com/jboss-developer/jboss-eap-quickstarts#build-and-deploy-the-quickstarts) for complete instructions and additional options._

1. Make sure you have started the JBoss Server as described above.
2. Open a command line and navigate to the root directory of this quickstart.
3. Type this command to build and deploy the archive:

        mvn clean package wildfly:deploy

4. This will deploy `target/jCAT.war` to the running instance of the server.

## Access the application

The application will be running at the following URL: <http://localhost:8080/jCAT/>.

## Undeploy the Archive

1. Make sure you have started the JBoss Server as described above.
2. Open a command line and navigate to the root directory of this application.
3. When you are finished testing, type this command to undeploy the archive:

        mvn wildfly:undeploy

## Run the Application in JBoss Developer Studio or Eclipse

You can also start the server and deploy the quickstarts from Eclipse using JBoss tools. For more information, see [Use JBoss Developer Studio or Eclipse to Run the Quickstarts](https://github.com/jboss-developer/jboss-developer-shared-resources/blob/master/guides/USE_JBDS.md) 

## Debug the Application

If you want to debug the source code or look at the Javadocs of any library in the project, run either of the following commands to pull them into your local repository. The IDE should then detect them.

    mvn dependency:sources
    mvn dependency:resolve -Dclassifier=javadoc
