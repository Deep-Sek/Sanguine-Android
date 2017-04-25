# Sanguine-Android

INTRODUCTION:
Sanguine’s software system will provide a platform for the blood banks to digitally connect to its donors. This system will be designed to streamline the blood donation process which can help both the blood bank and users (otherwise known as donors). The donors will primarily use the mobile application and blood banks will have access to the web application. The donors will also have access to the web application, but will have different features available than the blood banks or hospitals.

Donors can download the application from the Google Play Store free of charge and blood banks can access the Web App from all of the major browsers. The web app will help the blood bank to communicate with potential donors in the locale. The donors will be able to receive either push notifications or text messages about urgent blood requests for any blood type. It will also notify the user if they are eligible to fulfill any blood request. 

Additionally, the software needs an Internet connection for both the web app and mobile app to obtain the data from the server. Mobile devices also need a GPS connection so that the web app can identify the location of the donors.

PRODUCT DESCRIPTION:
This system will consist of two parts: A mobile app for the donors and a web app for the blood banks. The mobile app will be used by the donors to register their profile, receive notifications and retrieve their health and donation statistics. The web app helps the blood bank to locate donors and send individual or group notifications. It will also provide an option to validate a user to reduce the creation of fake profiles.

The Mobile Application will use the GPS services in the mobile devices to send the location information to the server. The database transitions between mobile app and database will be done using Web API and JSON.

The Web App uses Google Maps API and Google Location Services to locate the donors. Web App will also use Web API to do transactions in database. Web App and Mobile device will use Google Messaging service to send notifications to mobile devices.

As this system requires the data to be stored in a secure centralized location, a frelational database system will be used. All the transactions to and from the database will be going through the web API which will help to manage and update the transactions effectively.
