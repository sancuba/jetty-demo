# jetty-demo
Demo Java8 Jetty Web Server for Heroku

Based on [heroku/java-getting-started](https://github.com/heroku/java-getting-started)

Local Test Run:
http://127.0.0.1:8080/

Deploying Executable JAR Files to Heroku:
[deploying-executable-jar-files](https://devcenter.heroku.com/articles/deploying-executable-jar-files)

Memory aid:
<p>
mvn clean install
<p>
mvn assembly:single
<p>
heroku deploy:jar target/jetty-demo-1.0-jar-with-dependencies.jar --app jetty-demo

Revision Control:
<p>
1.0 - 1st Simple Http Web Server Demo
