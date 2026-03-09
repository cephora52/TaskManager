# image Java
FROM eclipse-temurin:17-jdk-jammy

# dossier de travail
WORKDIR /app

# copier le jar généré
COPY target/*.jar app.jar

# port utilisé par Spring Boot
EXPOSE 8080

# lancer l'application
ENTRYPOINT ["java","-jar","app.jar"]