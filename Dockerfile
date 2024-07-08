FROM amazoncorretto:22-alpine3.19

COPY build/quarkus-app/lib/ /opt/application/lib/
COPY build/quarkus-app/app/ /opt/application/app/
COPY build/quarkus-app/quarkus/ /opt/application/quarkus/
COPY build/quarkus-app/quarkus-run.jar /opt/application/quarkus-run.jar
COPY build/quarkus-app/quarkus-app-dependencies.txt /opt/application/quarkus-app-dependencies.txt

EXPOSE 80

WORKDIR /opt/application

CMD ["java", "-XX:+UseParallelGC", "-XX:MaxRAMPercentage=70.0", "-jar", "quarkus-run.jar"]
