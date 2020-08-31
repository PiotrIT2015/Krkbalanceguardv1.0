FROM ubuntu:18.04

MAINTAINER Peter Prochnicki <piotr.prochnicki@gmail.com>

RUN apt-get update && apt-get install -y default-jdk && apt-get install -y python3.7 && apt-get install -y apache2 && apt-get install -y phpmyadmin && apt-get install -y mysql-server && apt-get install -y mysql-client && apt-get install -y libmysqlclient-dev && apt-get install -y net-tools