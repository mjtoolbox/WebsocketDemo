package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import serverApp.MyWebSocketApplication;

import com.sun.grizzly.websockets.WebSocketEngine;


public class WebSocketServlet extends HttpServlet
{
	private MyWebSocketApplication myApp = new MyWebSocketApplication();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public void init(ServletConfig config) throws ServletException {
        WebSocketEngine.getEngine().register(myApp);
		System.out.println("***MyWebSocketApplication registered successfully in the Servlet***");
    }
}
