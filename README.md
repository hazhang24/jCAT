# Brodus - Electronic educational testing platform

Brodus is a web application whose purpose is to apply an electronic version of [Provinha Brasil](http://provinhabrasil.inep.gov.br/), a nation-wide educational evaluation for Brazilian students in the second year of basic school. In its current form, items are created by an specialist and stored in an item bank. An administrator then selects one or more items and creates a *test*. After that, students can take this test while proctored by a teacher.

One of the prerequisites of *Provinha Brasil* is that item text and alternatives must be read to students by the test administrator. In order to do that electronically, Brodus allows an audio file to be uploaded and played by the student during the test. Also, just like the original test, in the electronic version items and they alternatives may or may not be accompanied by images.

As an additional step, video support was added for the electronic version.

## Architecture

The application was originally created in 2012 using Java and a J2EE layered architecture. The application connects to a database (originally MySQL) and performs object-relational mapping using Hibernate; business rules are created through Enterprise Java Beans (EJB); and finally, the view layer is done with PrimeFaces, a free and open source implementation of Java Server Faces (JSF). Everything is built using Ant.

The generated web pages are hosted in a web server (originally Tomcat) and the EJBs and Data Access Objects (DAO) are hosted in an application server (originally JBoss 5.0.1).

### More info

You can find a copy of my term paper [here](https://www.researchgate.net/publication/282914214_Desenvolvimento_de_um_sistema_de_aplicao_de_testes_informatizados_com_contedo_multimdia).

### Acknowledgements

This work was my term project for graduation. I did alongside my friend and partner [Bruno de Jesus Destro](https://br.linkedin.com/in/brunodestro), having prof. Fabio Cabrini as a supervisor and profs. Marcos Roberto Macedo and Ocimar Munhoz Alavarse as examining board members.