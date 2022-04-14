package com.project.exam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.exam.action.AbstractAction;
import com.project.exam.action.factory.ActionFactory;

public class ApplicationController {

	public String processRequest(HttpServletRequest request, HttpServletResponse response) {
		String method = request.getMethod();
		String path = request.getPathInfo();
		
		System.out.println("METHOD: " + method);
		System.out.println("PATH: " + path);
		
		AbstractAction action = ActionFactory.createAction(path,method);
		return action.executeRequest(request, response);

	}
	
}
