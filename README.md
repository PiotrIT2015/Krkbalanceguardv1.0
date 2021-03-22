## Greenroom(system for entertainment in free time)

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Run](#setup)

## General info
This is main part of my system which can share i.e. music or mems. It'll also remind you about shopping and will communicate in other ways. It helps maintain balance i.e.in COVID-19. It should be
use with "HealthMonitor" and "Reminder". These are another project which I created. 
	
## Technologies
Project is created with:
* python version: 3.7
* Java version: 11.0.7
* mysql-connector-java library version: 5.1.35
	
## Setup
To setup this project on Windows you must first install a Linux Subsystem for Windows.

This is a video with a description how to do it: https://www.youtube.com/watch?v=1ap3hL-UR9I

...,then install it locally using Docker:

```
$ bash
$ git clone https://github.com/PiotrIT2015/Greenroom.git
$ docker build -t dockerfile .
$ docker run -dit --name my-running-app -p 8080:80 dockerfile
$ docker run --rm httpd:2.4 cat /usr/local/apache2/conf/httpd.conf > my-httpd.conf
$ docker run -d -p 8080:80 nextcloud
$ wget https://www.jetbrains.com/idea/download/download-thanks.html?platform=linux&code=IIC
```

How to configure Nextcloud with Apache on Ubuntu: https://www.youtube.com/watch?v=-tW3_cmGkns

## Run
To run this project:
* run several services in IntelliJ IDEA
* run Cellular Automata(GUI's module) in IntelliJ IDEA
* run FIRA(GUI's module) on SimurSot(This is a football game in which gamers can change how robots run).

SimurSot source code:https://github.com/fira-simurosot/FIRASim

```
$ cd ../io.greenroom/dao/gekon/src/engine/pp
$ javac Server.java
$ javac ServerInt.java
$ javac Client.java
$ javac MySQLTest.java
$ java Server
$ java Client
```
