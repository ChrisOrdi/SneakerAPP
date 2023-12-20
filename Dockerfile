FROM maven:3-eclipse-temurin-21 AS builder
#FROM ubuntu:latest
LABEL authors="chrisvandalen"
RUN mvn clean install
ENTRYPOINT ["top", "-b"]