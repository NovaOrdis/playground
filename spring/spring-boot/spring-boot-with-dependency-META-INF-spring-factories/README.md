# Spring Boot with Dependency   

A multi-project Gradle build. One of the projects is a Spring Boot application, the other is a non-Spring dependency.

The dependency and main package are different, so 
```
@ComponentScan(basePackageClasses = {MainApplication.class, Dependency.class})
```
was used.

NOKB: https://kb.novaordis.com/index.php?title=Enabling_Non-Spring_Libraries_to_Access_Spring_Boot_Components