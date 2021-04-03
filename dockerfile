FROM ubuntu:18.04

MAINTAINER Peter Prochnicki <piotr.prochnicki@gmail.com>

RUN apt-get update && apt-get install -y openjdk-11-jre python3.7 phpmyadmin net-tools && apt-get upgrade 
