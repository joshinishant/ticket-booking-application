FROM maven:3.6.3-jdk-8-slim as stage2
COPY . .

FROM tomcat:8.0.51-jre8-alpine
RUN rm -rf /usr/local/tomcat/webapps/*
COPY --from=stage2 /target/TicketBookingApplication-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
#COPY ./tmp/TicketBookingApplication-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8081
CMD ["catalina.sh","run"]
