FROM openjdk:17-jdk-slim
RUN mkdir /app
WORKDIR /app
COPY build/libs/*.jar .
RUN chmod +x *.jar
EXPOSE 8080
CMD ["java", "-jar", "*.jar"]