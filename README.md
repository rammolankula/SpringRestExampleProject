# SpringRestExampleProject
#### in this project i worked on CRUD operatios and logs folder
#### Read JSON(student) Convert into the object format
#### Store it into the database and return the message
### /Save
#### i)Reading the data from Request and covert it to the object and store and return
#### ii)Here we used logger for storing in log file this is uses for production environment
#### iii)if the project will be at production environment at that we are unable to check the Request processs by using this log folder we are able
#### to see the statement of the code
#### iv)we added by using the logback.xml file and change the package flow in logback.xml file and we have another way to add it by using application.properties same as below
### Example
#### #logging.file.clean-history-on-start=true
#### logging.file.name=D:/Rest.log
#### logging.file.max-size=200MB
#### logging.level.ram.learn=DEBUG
#### #logging.pattern.file=%d{dd-MM-YYY hh:mm:ss SSS}
### /GetALL
#### i)Fetch all rows from the DataBase by using service
#### ii)Sort the data by using name,Return as JSON
#### iii)Else message part return the No data found and catch block give the response as unable to fetch the data*/
