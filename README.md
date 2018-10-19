Spring practice
-

**Task**

  - Create controller and service layer
  - Create endpoint with URI: /v1/car/{licencePlate} -> {licencePlate} is a PathVariable
  - Service should creates and returns a new model (car) with the given license plate {licencePlate}
  - Throw exception (CarException) when license plate is longer than 7 digit
  - If CarException is thrown then catch it and return with "Bad licence plate format!" string
  - If request is successful -> 200 OK otherwise status code is 400 BAD_REQUEST
  - Store data in-memory
  - Make all tests green :)

**Nice to have**

  - Use java 8 features
  - Upgrade java version and use new features
  - Use H2 database
  - Add logging (with/without AOP)
  - Add Swagger
  - Use Gradle instead of Maven
  
