# DREXEL RECREATION CENTER APP

## Pre-requisites:
  - Android Studio 2.0
  - Android Virtual Device with API<=25 (or) Android Phone with Android 7.1.1 or less 

## Steps to run (USB Debugging):
 - Clone or download the zip file and unzip.
 - In Android Studio, go to File -> New -> Import Project and select the unzipped file.
 - To enable USB Debugging, go to Settings -> Developer Options -> Enable USB Debugging.
 - Press Ctrl + F10 to build and run the code.
 
 ## Steps to run (Android Virtual Device):
 - Clone or download the zip file and unzip.
 - In Android Studio, go to File -> New -> Import Project and select the unzipped file.
 - On pressing Ctrl + F10 and post building the code, the Android Virtual Monitor asks you to select the device you want to use or create a new device if no devices have been used in the past.
 - Make sure that the Virtual Device created has Android API <=25 in order to be able to notice all the functionalities of the app (see Constraints section below for more detail). 

## About the Architecture:
 The languages used in this app include XML for designing the activities (frontend) and Java for the functional aspects of the activities (backend).
 Here, we have implemented an Android app that recreates the Drexel Recreation Center website. This includes database connections (mocking the drexel server, which is not accessible to us at the moment) for signing up and creating sports and group exercise accounts. 
 
 We used the SQLiteOpenHelper as an interface to connect the activities to the database. We created 3 databases - one maintains sports accounts, another maintains list of group exercises and timings and the third one maintains the list of people enrolled in each group exercise.
 
 We separated the activities into modules, with each module representing a distinct facility. The modules that are common to most facilities (like Database connection or login forms) have been separated into Helper Module and SQL Module.
 
## Constraints:
  - Alarm notification does not work in Android O (API 26 and above) since background tasks are killed in the kernel from this API version.
  - As mentioned earlier, since access to the actual Drexel server was not possible, we created a mock database instead.
  
 
 
 
 
  
  

