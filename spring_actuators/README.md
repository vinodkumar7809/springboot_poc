# Adding Spring Boot Actuator

* Spring boot actuator provides production grade metrics, auditing, and monitoring features to your application.
* Just adding the actuator dependency makes it available on our 8080 port. If
  we add hateoas as well, it will make it restfully navigable under /actuator.
  No code is required.
* We’ll also disable actuator endpoint security to make this demo run smoother of course J. We can do this by adding these two properties:
 
 ```sh
 1 security.basic.enabled=false
 2 management.security.enabled=false
  ```

## Actuator Features to Notice
* Live thread dumps
* Live stack traces
* Logger configurations
* Password-masked properties file auditing
* Heap dump trigger (can be disabled)
* Web-request traces
* Application metrics
* Spring bean analysis
* More! (and it’s extensible)

## Enabling Spring Boot Actuator And Hal browser

```sh
 <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
 </dependency>
 <dependency>
			<groupId>org.springframework.data</groupId>
			<artifactId>spring-data-rest-hal-browser</artifactId>
 </dependency>
  ```
## Spring Boot Actuator endpoints:

[![Image](https://github.com/vinodkumar7809/springboot_poc/spring_actuators/spring_boot_actuator/actuator_end_points.PNG "Spring Boot Actuator End points")]

