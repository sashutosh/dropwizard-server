# sample

How to start the sample application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/dropwizard-server-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

Health Check
---

To see your application's health enter url `http://localhost:8081/healthcheck`
