# micro-ecommerce

[![Build Status][travis-image]][travis-url] 

[travis-url]:https://travis-ci.org/fabiorapanelo/micro-ecommerce
[travis-image]:https://img.shields.io/travis/fabiorapanelo/micro-ecommerce/master.svg

An ecommerce with Microservices

Modules:
 - config-server: A Spring configuration server
 - discovery-server: [Eureka](https://github.com/Netflix/eureka) as service discovery
 - gateway: [Zuul](https://github.com/Netflix/zuul) as gateway service.
 - catalog: A catalog micro service
 - ordering: A ordering micro service
