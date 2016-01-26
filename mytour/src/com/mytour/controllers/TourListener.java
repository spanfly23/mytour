package com.mytour.controllers;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.mytour.models.Place;

/**
 * Application Lifecycle Listener implementation class TourListener
 *
 */
@WebListener
public class TourListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public TourListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent event)  { 
         // TODO Auto-generated method stub
    	
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
         // TODO Auto-generated method stub
    	ServletContext sc = event.getServletContext();
    	ArrayList<Place> pList = (ArrayList<Place>) sc.getAttribute("places");
    	if(pList == null){
    		System.out.println("No places list created yet. Let's create the list here...");
    		pList = new ArrayList<Place>();
    		sc.setAttribute("places", pList);
    	}
    }
	
}
