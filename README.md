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
To setup this project, install it locally using Docker:

```
$ docker build Dockerfile
$ docker run
$ mkdir Greenroom
$ cd ../Greenroom
$ git init
$ git pull https://github.com/PiotrIT2015/Greenroom.git
$ wget https://www.jetbrains.com/idea/download/download-thanks.html?platform=linux&code=IIC
```
##Run
To run this project:
* run several services in InteliJ
* run GUI in InteliJ
```
$ cd ../io.greenroom/dao/gekon/src/engine/pp
$ javac Server.java
$ javac ServerInt.java
$ javac Client.java
$ javac MySQLTest.java
$ java Server
$ java Client
```
