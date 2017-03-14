FROM openjdk:8
EXPOSE 80
ADD target/*.jar /gateway.jar
ADD wait-for-it.sh /wait-for-it.sh
RUN bash -c 'chmod 777 /wait-for-it.sh'
CMD ["java","-Dspring.profiles.active=container","-jar","/gateway.jar"]