# Versioning

The best approach to versioning is NOT to do it. Yeah, that’s right. Do not version as long as versioning is not needed.

** Build your services to backward compatible so that you can avoid versioning as much as possible!

## URI Versioning
Basic approach to versioning is to create a completely different URI for the new service. Example implementation is shown below.

Examples

http://localhost:8080/v1/person
http://localhost:8080/v2/person

## Request Parameter versioning

Next approach to versioning is to use the request parameter to differentiate versions.

Examples

http://localhost:8080/person/param?version=1
http://localhost:8080/person/param?version=2

## (Custom) Headers versioning


The third approach to versioning is to use a Request Header to differentiate the versions.

Examples

http://localhost:8080/person/header
headers=[X-API-VERSION=1]
http://localhost:8080/person/header
headers=[X-API-VERSION=2]

## Media type versioning(a.k.a "content negotiation" or "accept header")
     
The last versioning approach is to use the Accept Header in the request.

Examples

http://localhost:8080/person/produces
headers[Accept=application/vnd.company.app-v1+json]
http://localhost:8080/person/produces
headers[Accept=application/vnd.company.app-v2+json]
 
 
### Factors affecting Versioning Choice
* Following factors affect the choice of versioning:

* URI Pollution - URL versions and Request Param versioning pollute the URI space.
* Misuse of HTTP Headers - Accept Header is not designed to be used for versioning.
* Caching - If you use Header based versioning, we cannot cache just based on the URL. You would need take the specific header into consideration.
* Can we execute the request on the browser? - If you have non technical consumers, then the URL based version would be easier to use as they can be executed directly on the browser.
* API Documentation - How do you get your documentation generation to understand that two different urls are versions of the same service?
 

  ** No perfect solution
 

