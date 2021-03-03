FROM ubuntu:18.04

MAINTAINER Peter Prochnicki <piotr.prochnicki@gmail.com>

RUN apt-get update && apt-get install -y openjdk-11-jre && apt-get install -y python3.7 && apt-get install -y phpmyadmin && apt-get install -y mysql-server && apt-get install -y mysql-client && apt-get install -y libmysqlclient-dev && apt-get install -y net-tools && apt-get install apache2 && apt-get install mariadb-server && apt-get install libapache2-mod-php7.4 && apt-get install php7.4-gd && apt-get php7.4-mysql && apt-get install php7.4-curl && apt-get install php7.4-mbstring && apt-get install php7.4-intl && apt-get install php7.4-gmp && apt-get install php7.4-bcmath && apt-get install php-imagick && apt-get install php7.4-xml && apt-get upgrade && apt-get install git && apt-get install php7.4-zip && wget https://download.nextcloud.com/server/releases/nextcloud-18.0.2.zip 
