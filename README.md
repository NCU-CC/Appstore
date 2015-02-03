## Appstore for NCU[![Build Status](http://140.115.3.96:8080/jenkins/buildStatus/icon?job=Appstore)](http://140.115.3.96:8080/jenkins/job/Appstore/)
An App Store website written in Java.

### Maven
- mvn jetty:run  ->  run embedded server
- mvn install  -> export war file

### Resources

- production : put following files into
 **src/main/resources**
    - log4j.properties 
    - dataAccessDAO.properties
        - ```jdbc.driver = com.mysql.jdbc.Driver```
        - ```jdbc.url = jdbc:mysql://localhost/dbname```
        - ```jdbc.username=xxx```
        - ```jdbc.password=xxx```
    
    - openid-setting.properties 
        - see https://github.com/NCU-CC/OpenID-Consumer/tree/master/openid-ncu-consumer

