# README #

### CS 4230 Midterm Base Project ###

* Allows the project to be created and to get it running quickly
* 0.1

### How do I get set up? ###

* Clone the repository then open Eclipse
* File -> New Project -> Dynamic Web Project
* Project Name = whatever directory you've downloaded the repository into, `cs-4230-midterm-fall-2015` by default
    * Note that if you have the default name, it will cause problems with the build
    * It's probably easiest to just rename it "midterm"
    * Make sure you have run `git update-index --assume-unchanged src/config.properties`
* Configuration is simple
    * Run `database_create.sql` in MySQL
    * Make sure your user has access to the "midterm" database (via `GRANT PRIVILEGES`)
    * Add the username and password into the `src/config.properties` file in the project
* No automated tests exist for this midterm
* To deploy, make sure your Build Path and Targeted Runtime are set up correctly for Tomcat
    * Must have the JSTL library JAR files in either
        1. Tomcat `lib` folder OR
        2. The project `WebContent/WEB-INF/lib` folder
    * Add the project to Tomcat using either the Run As -> Run on Server OR by right-clicking the server and choosing Add and Remove
    * If not using Run As, make sure the server is highlighted and click on the Run or Debug button
    * Navigate to `http://localhost:8080/<context name here, 'midterm' if you renamed it>/login.jsp`
    * Login using either "testuser", "password" OR register a new user

### Contribution guidelines ###

* This project is not to be written to. You will create your own **private** BitBucket repository and give me access to it ("tcmarsh")
* Make sure you are cleaning up any errors or warnings as you go - when I inspect the code, warnings left in the code will be docked points, so keep your code clean
    * The only exception is that _one_ method can have an `unchecked` warning, as I will assume that method is the one you are currently working on
* Make sure you're following an MVC pattern throughout - that is the point of the course, and I'm going to be evaluating your understanding of MVC and how such a project should go together