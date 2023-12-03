# SpringRestExampleProject
##### in this project i worked on CRUD operatios and logs folder
##### Read JSON(student) Convert into the object format
##### Store it into the database and return the message
### /Save
<pre>
&#8594; i)Reading the data from Request and covert it to the object and store and return
&#8594; ii)Here we used logger for storing in log file this is uses for production environment
&#8594; iii)if the project will be at production environment at that we are unable to check the Request processs by using this log folder we are able
&#8594; to see the statement of the code
&#8594; iv)we added by using the logback.xml file and change the package flow in logback.xml file and we have another way to add it by using application.properties same as below
</pre>
### Example
<pre>
&#8594; #logging.file.clean-history-on-start=true
&#8594; logging.file.name=D:/Rest.log
&#8594; logging.file.max-size=200MB
&#8594; logging.level.ram.learn=DEBUG
&#8594; #logging.pattern.file=%d{dd-MM-YYY hh:mm:ss SSS}
</pre>
### /GetALL
<pre>
&#8594; i)Fetch all rows from the DataBase by using service
&#8594; ii)Sort the data by using name,Return as JSON
&#8594; iii)Else message part return the No data found and catch block give the response as unable to fetch the data*/
</pre>
### /GetOne Record
<pre>
&#8594; Get one Student object based on Id (@Pathvariable) if exist the student
&#8594; object it return the Student object else it return the String message
&#8594; Delete a record based id by using @PathVariable it will check the data.
&#8594; if it is exist it will return the record else it will the message like Data not found
</pre>
