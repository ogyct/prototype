# prototype
Web services prototype (Dmitry Avgustis)

Spring boot application, which provides a couple of "dumb" REST enpoints.
`StudentController`  
`/client/student/v1/`

Student controller, is a basic CRUD set of controllers. Student is an 
in-memory DB table. Controller works directly with a persistence layer for the sake of simplicity.  
Controller is protected by oauth2 token

`SoapToRestController`  
`GET /client/soaptorest/v1/add`

This controller uses a *http://www.dneonline.com/calculator.asmx* soap web service and returns a sum of two numbers.
Not protected by spring security.

**Complete api list** `http://localhost:8081/swagger-ui.html`

There is also a SOAP provider configured in `WebServiceConfig`

Security layer is made of spring security, oauth2 authorization and resource server, jwt tokens.