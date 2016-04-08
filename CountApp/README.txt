Prerequisite
-Software:Maven and Jetty
To run the project
1.Make a JAR using maven
2.Pass the input file folder location as a argument to the App class(java -cp target/WordCountJerseyApp-1.0-SNAPSHOT.jar custom.wordcount.App D:/files)
3.use this URL http://<localhost/IP>:8097/wordcount/{Search keyword}
	eg:http://localhost:8097/wordcount/java
	sample Output:java {"count":6}
