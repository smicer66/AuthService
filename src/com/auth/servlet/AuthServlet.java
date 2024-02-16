package com.auth.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.rsa.authagent.authapi.AuthSession;

/**
 * Servlet implementation class AuthServlet
 */
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(AuthServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		log.info("Action ==" + action);
		String token = request.getParameter("token");
		log.info("Action ==" + action);
		String tokenPin = request.getParameter("tokenPin");
		log.info("Action ==" + action);
		if(action!=null && action.equalsIgnoreCase("setTokenPin"))
		{
			String config_path = "C://jcodes//dev//appservers//ecims//webapps//EUC-portlet//rsa_api.properties";
			AuthUser test;
			try {
				test = new AuthUser(config_path, tokenPin, "rsachief");
				int result = test.setPin(tokenPin);
				log.info("Result - " + result);
				String authStatus=null;
				if(result==AuthSession.PIN_ACCEPTED)
				{
					JSONObject jsonObject = new JSONObject();
					response.setContentType("application/json");
					PrintWriter out = response.getWriter();
					jsonObject.append("success", true);
					jsonObject.append("value", 0);
					out.print(jsonObject);
					out.flush();
					//portletState.addSuccess(aReq, "Pin accepted! Please provide the passcode displaying on your token", portletState);
					//aRes.setRenderParameter("jspPage", "/html/applicationmanagementportlet/dotoken.jsp");
					
				}else if(result==AuthSession.PIN_REJECTED)
				{
//					portletState.addSuccess(aReq, "Invalid pin provided! Please provide a valid memorable pin", portletState);
//					aRes.setRenderParameter("jspPage", "/html/applicationmanagementportlet/dotoken_pin.jsp");
					JSONObject jsonObject = new JSONObject();
					response.setContentType("application/json");
					PrintWriter out = response.getWriter();
					jsonObject.append("success", false);
					jsonObject.append("value", 1);
					out.print(jsonObject);
					out.flush();
					
				}
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

}
