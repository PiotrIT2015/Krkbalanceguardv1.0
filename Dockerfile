FROM ubuntu:18.04

MAINTAINER Peter Prochnicki <piotr.prochnicki@gmail.com>

RUN apt-get update && apt-get install -y openjdk-11-jre python3.7 phpmyadmin mysql-server mysql-client libmysqlclient-dev net-tools apache2 mariadb-server libapache2-mod-php7.4 php7.4-gd php7.4-mysql php7.4-curl php7.4-mbstring php7.4-intl php7.4-gmp php7.4-bcmath php-imagick php7.4-xml git php7.4-zip && apt-get upgrade && wget https://download.nextcloud.com/server/releases/nextcloud-18.0.2.zip 
