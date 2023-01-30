FROM openjdk:17-jdk-slim
RUN mkdir /app
WORKDIR /app
COPY ./*.jar .
RUN chmod +x *.jar
EXPOSE 8080
CMD ["java", "--jar", "*.jar"]