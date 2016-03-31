/*
 * @(#)WordCount.java        6.56 16/03/31
 *
 * Copyright (c) comes here
 * 
 */

package custom.wordcount;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

 /**
 *  
         Class which tells the specification for the jetty server to start and stop
 *
 * @version      
         1.0 31 Mar 2016 
 * @author          
         Deepa Anbalagan 
*/

public class App {
	
	static String inputPath;
		
	public static void main(String[] args) throws Exception {
		
		inputPath=args[0];
		
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
		// tells the port for the application
        Server jettyServer = new Server(8097);
        jettyServer.setHandler(context);
 
        ServletHolder jerseyServlet = context.addServlet(
             org.glassfish.jersey.servlet.ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);
 
        // tells the Jersey Servlet which REST service/class to load.
        jerseyServlet.setInitParameter(
           "jersey.config.server.provider.classnames",
           WordCount.class.getCanonicalName());
 
        try {
            jettyServer.start();
            jettyServer.join();
        } finally {
            jettyServer.destroy();
        }
    }
}