# Internationalization in Spring Boot

Internationalization is a process that makes your application adaptable to different languages and regions without engineering
changes on the source code. In ither words, Internationalization is a readiness of Localization.
* The most common approach to i18n in Spring Boot is to use the messages.properties file to store all the messages for a specific language.

## Database:
We use a table to store all the localized messages for our application. The table has the following columns
* id: an auto-increment value
* locale: the language code
* messagekey: the key of the message which is used in the HTML page to refer to the target message
* messagecontent: the content of the message

## Custom DBMessageSource

### Messages Sources
* Spring Boot application by default takes the message sources from src/main/resources folder under the classpath. 
The default locale message file name should be message.properties and files for each locale should name as messages_XX.properties. 
The “XX” represents the locale code.

* All the message properties should be used as key pair values. If any properties are not found on the locale, 
the application uses the default property from messages.properties file.

## Maven Dependencies
For Web App
```sh
<dependencies>
    <dependency>
        <groupId>com.h2database</groupId>
	<artifactId>h2</artifactId>
    </dependency>
		
    <dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
    </dependency>
		
    <dependency>
        <groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
		
    <dependency>
        <groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
		
</dependencies>
```
## LocaleResolver and LocaleChangeInterceptor
We need to determine default Locale of your application. We need to add the LocaleResolver bean in our Spring Boot application.
the LocaleChangeInterceptor allows the application to switch to another locale. Here, 
we will use the request parameter lang to decide the target locale.

```sh
 @Bean
public LocaleResolver localeResolver() {
   SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
   sessionLocaleResolver.setDefaultLocale(Locale.US);
   return sessionLocaleResolver;
}

@Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        registry.addInterceptor(localeChangeInterceptor);
    }
  ```
  
* Bean annotation is added to mark this method as a Spring bean.
* LocaleResolver interface is implemented using Spring’s built-in CookieLocaleResolver implementation.
<<<<<<< HEAD
* The default locale is set for this locale resolver to return in the case that no cookie is found.
=======
* The default locale is set for this locale resolver to return in the case that no cookie is found.
>>>>>>> 68b35bb3e4474c651b1d58fd82f5453ac7816ac3
