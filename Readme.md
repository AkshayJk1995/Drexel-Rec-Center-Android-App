# DREXEL RECREATION CENTER APP

## Pre-requisites:
  - Android Studio 2.0
  - Android Virtual Device with API<=25 (or) Android Phone with Android 7.1.1 or less 

## Steps to run (USB Debugging):
 - Clone or download the zip file and unzip.
 - In Android Studio, go to File -> New -> Import Project and select the unzipped file.
 - To enable USB Debugging, go to Settings -> Developer Options -> Enable USB Debugging.
 - Press Ctrl + F10 to build and run the code.
 
## About the Architecture:
 The languages used in this app include XML for designing the activities (frontend) and Java for the functional aspects of the activities (backend).
 Here, we have implemented an Android app that recreates the Drexel Recreation Center website. This includes database connections (mocking the drexel server, which is not accessible to us at the moment) for signing up and creating sports and group exercise accounts. 
 
 We used the SQLiteOpenHelper as an interface to connect the activities to the database. We created 3 databases - one maintains sports accounts, another maintains list of group exercises and timings and the third one maintains the list of people enrolled in each group exercise.
 
 We separated the activities into modules, with each module representing a distinct facility. The modules that are common to most facilities (like Database connection or login forms) have been separated into Helper Module and SQL Module.
 
 
 
  
  

