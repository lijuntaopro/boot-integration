package boot;


import javax.servlet.annotation.WebServlet;

import org.apache.axis2.transport.http.AxisServlet;

@WebServlet(urlPatterns =  "/services/*", loadOnStartup = 1, name = "AxisServlet")
public class MyWebServlet extends AxisServlet {
	
	private static final long serialVersionUID = 1L;
	
}
