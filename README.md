# micro-ecommerce

[![Build Status][travis-image]][travis-url] 

[travis-url]:https://travis-ci.org/fabiorapanelo/micro-ecommerce
[travis-image]:https://img.shields.io/travis/fabiorapanelo/micro-ecommerce/master.svg

A ecommerce developed in micro-services architecture using Spring Boot

Modules:
 - config-server: A [Spring configuration server](https://cloud.spring.io/spring-cloud-config/spring-cloud-config.html)
 - discovery-server: [Eureka](https://github.com/Netflix/eureka) as service discovery
 - gateway: [Zuul](https://github.com/Netflix/zuul) as gateway service.
 - catalog: A catalog micro service using Spring JPA to store data and Spring Solr to search in the catalog
 - ordering: A ordering micro service


Running:

It requires to run the service in the following order:

1. config-server
    - Change application.properties to point to your git repository in order to change the properties
2. discovery-server
3. gateway
4. Apache Solr instance:
    - solr start -p 8983
    - solr create -c catalog-item
5. catalog
6. ordering

Credits to:
 - https://github.com/idugalic/micro-ecommerce/ - I have learned several things on his git repo. Thanks!