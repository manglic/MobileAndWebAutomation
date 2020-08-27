# Mobile And Web Automation Task


## Overview
The solution for both Mobile and Web Automation is designed in a single maven project and in similar framework structure with different set of tools like,
1. Language : Java
2. Automation tools : Appium(for mobile) , Selenium/Webdriver( for Web)
3. Test Execution library : TestNG
4. Reporting : Maven surefile
5. Build tool : Maven
6. Logging : log4j
7. Design Pattern : Page Object Model (POM)

# Reasons for using tool
1. Appium and Selenium are of same family, meaning, there library functions are similar, so automation framework would look similar for both mobile and web automation. And code written for mobile automation using Appium library can be used  for both android and iOs devices.
2. Maven and Java are great open source and could be used to build and execute test cases on any environment. Need not to carry all dependent libraries within project.
3. POM pattern is used to make framework flexible for future enhancement and addition of new test cases are super easy.

# Working
1. The test cases are executed using maven command.by passing testng xml files as parameters .
2. Execution starting point are TestNG xml files.
3. Values related to mobile and web setup are defined in properties file and are picked automatically during execution.
4. Test cases are completely separated from Page Objects and Drivers setup. 

## Prerequisite for system running tests:-
1. Windows or MAC operating system
1. Java 1.8 or higher
2. node.js.
3. Appium server.
4. Maven
5. web browser: chrome / firefox (WebDriverManager is used to automatically download version of compatible executables)


## Steps to execute Mobile tests:-
1. Connect any android device or run simulator
2. Fetch device name and android version.
3. Update below mandatory fields in TestData.properties file, available @ "src/test/resources" :-
   
   deviceName: name of the device connected to system where mobile tests are to be executed.
   platformVersion: Android version running on mobile device.

4. Open cmd and cd to the project directory and execute command:- 
"mvn clean test -Dsurefire.suiteXmlFiles=testng_mobile.xml"

## Steps to execute Web tests:-
1. Open cmd and cd to the project directory and execute below command:-
"mvn clean test -Dsurefire.suiteXmlFiles=testng_web.xml"
