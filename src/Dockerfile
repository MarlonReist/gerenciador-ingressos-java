FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY . .

RUN javac -d out application/*.java entities/*.java

EXPOSE 5000

CMD ["java", "-cp", "out", "application.Program"]