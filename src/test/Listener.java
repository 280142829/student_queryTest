package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class Listener
 *
 */
@WebListener
public class Listener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public Listener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	 System.out.println("contextDestroyed");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         System.out.println("contextInitialized");
         ServletContext sc = arg0.getServletContext();
         String dizhi = sc.getInitParameter("appContext");
         String dizhi2 = sc.getRealPath(dizhi);
         System.out.println("dizhi2:"+dizhi2);
         FileInputStream fis=null;
         try {
        	 fis = new FileInputStream(dizhi2);
        	 System.out.println(dizhi);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         System.out.println(fis);
         
         
         
         
         
         
    }
	
}
