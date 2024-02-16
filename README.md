## About AuthService

AuthService is the web application component that integrates the ecims application to the RSA SecureID hardware token. The ecims application can be found on https://github.com/smicer66/ecims
##


## Technical Details

The AuthService mobile application is developed using Java, database is Microsoft SQL

## Install the Java
Before proceeding, make sure your computer has Java installed. Minimum version is Java 8. See Oracle website for documentation on Java installation

## Install the Microsoft SQL
Before proceeding, make sure your computer has Microsoft SQL installed. See guidance online for installtion of Microsoft SQL and its tools.

## Dependency
Generate WAR file using your favorite IDE such as Eclipse or your command prompt/bash. <br><br>

Using Eclipse:<br>
Right Click on Project and click on "Export"<br>
Proceed with the steps to generate the war file.<br>
Go to your project Directory and inside Dist Folder you will get war file that you copy on your tomcat webApp Folder.<br>
Start the tomcat.<br>
It automatically extracts the folder from the war file.
