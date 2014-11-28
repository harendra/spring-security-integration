/**
 * 
 */
package org.krams.tutorial.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Handles and retrieves the login or denied page depending on the URI template
 */
@Controller
@RequestMapping("/auth")
public class LoginLogoutController {
        
	protected static Logger logger = Logger.getLogger("controller");

	/**
	 * Handles and retrieves the login JSP page
	 * 
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	public ResponseData getLoginPage(@RequestParam(value="error", required=false) boolean error, 
			ModelMap model) {
		logger.debug("Received request to show login page");

		// Add an error message to the model if login is unsuccessful
		// The 'error' parameter is set to true based on the when the authentication has failed. 
		// We declared this under the authentication-failure-url attribute inside the spring-security.xml
		/* See below:
		 <form-login 
				login-page="/krams/auth/login" 
				authentication-failure-url="/krams/auth/login?error=true" 
				default-target-url="/krams/main/common"/>
		 */
		
		List<Map<String,String>> message=new ArrayList<Map<String,String>>();
		Map<String,String> msgmap=new HashMap<String,String>();
		
		ResponseData data=new ResponseData();
		data.setStatus("failure");
		msgmap.put("JSON001", "Not Authenticated");
		message.add(msgmap);
		data.setMessage(message);
		data.setData(msgmap);
		return data;
		
}
	
	/**
	 * Handles and retrieves the denied JSP page. This is shown whenever a regular user
	 * tries to access an admin only page.
	 * 
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/denied", method = RequestMethod.GET)
	@ResponseBody
 	public ResponseData getDeniedPage() {
		logger.debug("Received request to show denied page");
		
		List<Map<String,String>> message=new ArrayList<Map<String,String>>();
		Map<String,String> msgmap=new HashMap<String,String>();
		
		ResponseData data=new ResponseData();
		data.setStatus("failure");
		msgmap.put("JSON003", "Access Denied");
		message.add(msgmap);
		data.setMessage(message);
		data.setData(msgmap);
		return data;
	}
	
	/**
	 * Handles and retrieves the denied JSP page. This is shown whenever a regular user
	 * tries to access an admin only page.
	 * 
	 * @return the name of the JSP page
	 * @throws JsonProcessingException 
	 */
	@RequestMapping(value = "/loginsuccess", method = RequestMethod.GET)
	@ResponseBody
 	public String handleLoginSuccess() throws JsonProcessingException {
		logger.debug("Received request to show accept page");
		
		List<Map<String,String>> message=new ArrayList<Map<String,String>>();
		Map<String,String> msgmap=new HashMap<String,String>();
		
		ResponseData data=new ResponseData();
		data.setStatus("failure");
		msgmap.put("JSON002", "Login Success");
		message.add(msgmap);
		data.setMessage(message);
		data.setData(msgmap);
		ObjectMapper mapper=new ObjectMapper();
		return mapper.writeValueAsString(data);
	}
}