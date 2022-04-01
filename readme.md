# Spring Boot "Challenge - 1" by "ITB-Two-Factor"


The objective of this project is to exercise all the learning acquired during module 2 (01/2022) of IT MELI BOOTCAMP


## How to Run 

You run it using the ```java -jar``` or the ```mvn spring-boot:run``` commands.

* Clone this repository 
* Make sure you are using JDK 1.8 and Maven 3.x
* You can build the project and run the tests by running ```mvn clean package```
* To run tests execute : 
```
       mvn  test --file pom.xml
```
* Once successfully built, you can run the service by one of these two methods:
```
       mvn spring-boot:run -X 
```
* Check the stdout on your console to view logs, exceptions  and more 

Once the application runs you should confirm  something like this

```
http:/localhost:8080
```

## About the Service

An online product sales platform wants to improve search options and
filtering your products; For that, I decided to implement a search engine that,
of the options that the user determines, returns the product(s) that he
matches.

## ENDPOINTS 
Here are explication about endpoints you can call:

 * [Template](/docs/Template.MD)

#### 1.0.0 (2022-04-01)

##### Documentation Changes

*  javadoc to class test PropertyServiceTest ([f7be9f18](https://github.com/jefbarbosa/desafio_quality/commit/f7be9f18762de289d6c72c38d7927811ee1d31bb))
*  create java docs to DistrictServiceTest, PropertyController and PropertyService ([3dad81a3](https://github.com/jefbarbosa/desafio_quality/commit/3dad81a30f760020b3d31b259d14d96432f81b72))
*  add javadocs to DistrictService and PropertyExceptionHandler ([31f1eeeb](https://github.com/jefbarbosa/desafio_quality/commit/31f1eeebf163f9386bec364eb8d4b69392b63b98))
*  add javadocs in PropertyService ([b2a908ee](https://github.com/jefbarbosa/desafio_quality/commit/b2a908eef8a4965149ce20115ac64bc131ae0d16))

##### New Features

*  tweaks on existent tests and new tests added ([2835a372](https://github.com/jefbarbosa/desafio_quality/commit/2835a372fc924e205eb4a1ed53448dcf342a2564))
*  add new exception when district not found ([c6fa5661](https://github.com/jefbarbosa/desafio_quality/commit/c6fa5661931640f9d8fb37dbfdb90ae0d2dfa13e))
*  add new repository and service to district ([0601c943](https://github.com/jefbarbosa/desafio_quality/commit/0601c943f7232185c8c1d434bd8581c011badda1))
*  github actions test ([fb9870ce](https://github.com/jefbarbosa/desafio_quality/commit/fb9870ce26951f82c46f8c12afc06c812caad018))
*  Added first Integration test with webmvc mock ([a5ecf9f2](https://github.com/jefbarbosa/desafio_quality/commit/a5ecf9f2d11b02bf3c11aeecd2ba331565f0692c))
*  create validations and exceptions ([26df3f0f](https://github.com/jefbarbosa/desafio_quality/commit/26df3f0fc3cb47b6a907e165b316a5e42a80a01f))
*  Add calculate property price ([2ac8df4e](https://github.com/jefbarbosa/desafio_quality/commit/2ac8df4e0d40363d33f38e1cd6d4f27fbf74d307))
*  calculate area Rooms for a specific property ([31e9495d](https://github.com/jefbarbosa/desafio_quality/commit/31e9495d2e2e4e0405e929f54082767d82d6f4bd))
*  Added first Unit test ([af3499e9](https://github.com/jefbarbosa/desafio_quality/commit/af3499e918a0810228d0bd22a86467b81a5c7a20))
*  Find largest Room ([ebbbb973](https://github.com/jefbarbosa/desafio_quality/commit/ebbbb9732fbc259666bb1e0fbf2ca5f966e29333))
*  Added PropertyTotalAreaDTO to beautify the return ([3d9c0241](https://github.com/jefbarbosa/desafio_quality/commit/3d9c024138d603fd2d4f93029e2a863b7919812b))
*  Calculate Property Area ([62338ab2](https://github.com/jefbarbosa/desafio_quality/commit/62338ab22aa71067ad00dd8692656019155acdf3))
*  Create Service ([2db0999f](https://github.com/jefbarbosa/desafio_quality/commit/2db0999f904f1ce63fad238d3a5cb78eb5838549))
*  Create Controller ([4ce6b122](https://github.com/jefbarbosa/desafio_quality/commit/4ce6b1221b3d489fa28795ef7fc8b880d32e6757))
*  Create Repository ([3984d460](https://github.com/jefbarbosa/desafio_quality/commit/3984d460964f3057cc668c6d4022ff8153b9d2f7))
*  Create Entities ([017b1236](https://github.com/jefbarbosa/desafio_quality/commit/017b1236e1612b0c2704d2f2b28225500dcb3fd7))
*  Added DTO entities ([f8ff0535](https://github.com/jefbarbosa/desafio_quality/commit/f8ff0535e635052131e98a3eb1361d1b7b82246d))

##### Bug Fixes

*  mvn add ([1693b5e7](https://github.com/jefbarbosa/desafio_quality/commit/1693b5e788d5cdf43a94f8e403a619ad56e5281d))
*  resolved problem on pom ([111f29a1](https://github.com/jefbarbosa/desafio_quality/commit/111f29a190e71c091cb7e7bb64fcee5864021829))
*  resolve conflicts ([e0eb0d97](https://github.com/jefbarbosa/desafio_quality/commit/e0eb0d9707c5e9ddae59918af93eca648b5c4da5))
*  change java version for 11 ([f9c53aa7](https://github.com/jefbarbosa/desafio_quality/commit/f9c53aa7a0f3c5abc97ceb4bf7c4aeb0a0457e73))
*  getAllPropertiesTest remove inconsistency in values ([401281f5](https://github.com/jefbarbosa/desafio_quality/commit/401281f51573b24372f7304f33e39ba2e25c8134))

##### Other Changes

* jefbarbosa/desafio_quality ([06cb5223](https://github.com/jefbarbosa/desafio_quality/commit/06cb52236bf489ab543f8966621a05fe3db9d689))
*  config to run javadoc test ([989a3498](https://github.com/jefbarbosa/desafio_quality/commit/989a3498dd9256cd43791566711df528bb6c89d1))
* jefbarbosa/desafio_quality ([9382090e](https://github.com/jefbarbosa/desafio_quality/commit/9382090e3131fdd5675999809c466dbc2dbeceaa))
* jefbarbosa/desafio_quality ([be4f5b96](https://github.com/jefbarbosa/desafio_quality/commit/be4f5b96d40596633926d2c4088f4c12399b312d))
*  all tests run ([201a6c1a](https://github.com/jefbarbosa/desafio_quality/commit/201a6c1a29c4242e7fa64536ddfdf06f43c88540))
*  Initial project Spring ([ea1aacf4](https://github.com/jefbarbosa/desafio_quality/commit/ea1aacf4f735ee0c6b4b79018dce80ff36bd302f))

##### Refactors

*  tweaks to improve validation in room DTO ([73d1dce0](https://github.com/jefbarbosa/desafio_quality/commit/73d1dce0f59f040daf0fdc0566fae3d85f4d9266))
*  tweaks in property repository to add clean method ([b20f5581](https://github.com/jefbarbosa/desafio_quality/commit/b20f5581f267c652bfca65b40f465f132b8f6c43))
*  add new clean method in district ([74f2b55a](https://github.com/jefbarbosa/desafio_quality/commit/74f2b55a0422e5aebf82df0cb41c051ac49ca9ca))
*  tweaks on district exception ([014cfc0f](https://github.com/jefbarbosa/desafio_quality/commit/014cfc0fe4c61ac30916fcdf23d45ed27ba7720f))
*  name calculatePropertyTest in PropertyServiceTest ([612c4766](https://github.com/jefbarbosa/desafio_quality/commit/612c4766d1bb7463df612ea07a922e7b1a39b7e3))
*  tweaks on property service and test to handle new district service ([3fec1768](https://github.com/jefbarbosa/desafio_quality/commit/3fec17684eb0d30ab05b5921f7d23c62b043e82d))

##### Tests

*  Thorough integration test ([130ee42c](https://github.com/jefbarbosa/desafio_quality/commit/130ee42c7f7b82906ee848c1bdd8d98b0b0569ba))
*  create calculate Property Price Test ([adba27b8](https://github.com/jefbarbosa/desafio_quality/commit/adba27b8603a8430c8d076bd4d62be9787fa8006))
*  add integrations tests ([bd4972ec](https://github.com/jefbarbosa/desafio_quality/commit/bd4972ec5358429e30b1381ab5b2fd595b68ce59))
*  Add test for all Properties, convert to DTO ([fac97c0a](https://github.com/jefbarbosa/desafio_quality/commit/fac97c0a9f08859e54710f0b9b34221093c93d54))
*  Add initial test for District repository ([60d35d30](https://github.com/jefbarbosa/desafio_quality/commit/60d35d309987edae6693a52ffd2ae9cde4850cd2))
*  create calculate room area test ([36826db3](https://github.com/jefbarbosa/desafio_quality/commit/36826db36b42d1084e1b9b034cd710036330753c))
*  test calculate total area and calculate price property ([a79f0909](https://github.com/jefbarbosa/desafio_quality/commit/a79f0909f8603760073e158a5d73eb5f6dc8a468))
*  Added one more integration test ([b9caa67d](https://github.com/jefbarbosa/desafio_quality/commit/b9caa67df31c7e79987e16f9644ba981efdf40c5))



# About Spring Boot

Spring Boot is an "opinionated" application bootstrapping framework that makes it easy to create new RESTful services (among other types of applications). It provides many of the usual Spring facilities that can be configured easily usually without any XML. 



# Questions and Comments:
     Open a issue on this project 
