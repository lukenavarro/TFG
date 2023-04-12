FROM openjdk:20-oraclelinux7
COPY target/tfg-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD ["java","-jar","tfg-0.0.1-SNAPSHOT.jar"]
