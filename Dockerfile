FROM ubuntu:18.04

MAINTAINER Peter Prochnicki <piotr.prochnicki@gmail.com>

RUN apt-get update && apt-get install -y default-jdk && apt-get install -y python3.7 && apt-get install apache2 && apt-get install phpmyadmin && apt-get install mysql-server && apt-get install mysql-client && apt-get instal libmysqlclient-dev && apt-get install net-tools