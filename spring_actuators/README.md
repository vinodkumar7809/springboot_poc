# Adding Spring Boot Actuator

  ### Production ready features to help you Monitor and manage your application.

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
  
### Links From cource:
- http://localhost:8080/actuator
- http://localhost:8080/browser/index.html#/

## Spring Boot Actuator endpoints:

[![Image](https://github.com/vinodkumar7809/springboot_poc/blob/main/spring_actuators/spring_boot_actuator/actuator_end_points.PNG "Spring Boot Actuator End points")]

* http://localhost:8080/actuator/scheduledtasks
this scheduledtasks endpoint is use ful when you have a bunch of scheduled tasks in your application and thngs are not runnng as expected you can go to this actuator and see if the configuration is right for your scheduled tasks. 

* http://localhost:8080/actuator/sessions
sessions endpoint is available when we have Spring Session in our classpath. And as you can see the below the response somewhat looks like below

[![Image](https://github.com/vinodkumar7809/springboot_poc/blob/main/spring_actuators/spring_boot_actuator/sessions_endpoint.PNG "Spring Boot Actuator End points")]

### Reference links:

  - https://spring.io/guides/gs/actuator-service/
  - https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html

