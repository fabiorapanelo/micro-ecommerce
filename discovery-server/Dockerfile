FROM openjdk:8
EXPOSE 8761
ADD target/*.jar /discovery-server.jar
ADD wait-for-it.sh /wait-for-it.sh
RUN bash -c 'chmod 777 /wait-for-it.sh'
CMD ["java","-Dspring.profiles.active=container","-jar","/discovery-server.jar"]