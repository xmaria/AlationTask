# Alation Task - Extract search result data from amazon.com
Steps to Open the project in Eclipse
1. Open Eclipse
2. File-> Open Projects from File System
3. Click Directory
4. Choose AlationTask Directory from the downloaded path
5. Click Open.
6. The project will be detected, click finish.

Unzip the folder required_jars, it contains Selenium and apache-poi jar files.
Steps to add jar files to build path
1. Right click project
2. Properties
3. Java Build path
4. Click Add external jars
5. Choose all the extracted jar files 
6. Click Open
7. Click OK

Ensure TestNG plugin is installed in eclipse.
If not follow below steps
1. Go to Help
2. Choose Eclipse Marketplace
3. Type TestNG in find and click Go
4. Install TestNG for Eclipse
5. Restart Eclipse

To run the script.
1. Open the project in Eclipse
2. Right Click testng.xml file
3. Run As- TestNG Suite

Firefox will be invoked and the script will run.

The data read from the webpage is exported to an excel file- extractedData.xls

The <test-output> folder contains the html reports for the execution.


