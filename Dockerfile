# Learn about Docker here: https://docs.docker.com/get-started/
FROM openjdk:8u312-oracle

LABEL Maintainer="Daniel Obot"
LABEL "Code Repo"="https://github.com/robot297/spring-example"
# This ARG comes from the "target" folder that won't be in github
ARG JAR="obot-api-0.0.1-SNAPSHOT.jar"
ENV JAR $JAR

COPY target/$JAR .

# Exposes port 8080 so that it can be accessed
EXPOSE 8080

# Runs the java app
CMD java -jar ${JAR}
