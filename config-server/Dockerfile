FROM openjdk:8
EXPOSE 8888
ADD target/*.jar /config-server.jar
ADD wait-for-it.sh /wait-for-it.sh
RUN bash -c 'chmod 777 /wait-for-it.sh'
CMD ["java","-Dspring.profiles.active=container","-jar","/config-server.jar"]