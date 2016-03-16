Prerequisite
-Apache tomcat should be installed
-set the catalina home in your environment variable(eg:D:/apache-tomcat-7.0.68 as CATALINA_HOME)
To run the project
1.Unzip the project folder which is attached
2.open command prompt navigate till the project location where you have unzipped(eg-<directory>\WordCount)
3.give 
	-ant build (to compile the application)
	-ant deploy (to create a war)
	-ant deploywar (to copy to webapps folder of tomcat sever)
Finally, navigate to localhost:<port>/wordcount/input.jsp
enter the input value(I have put some data already in files, few words are java,weblogic,bigdata)
Eg: Sample Input :java
sample Output:java {"count":6}
since java word is present 6 times in the sample input files.