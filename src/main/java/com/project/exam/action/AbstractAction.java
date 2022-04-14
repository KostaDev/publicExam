package com.project.exam.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractAction {
	public abstract String executeRequest(HttpServletRequest request, HttpServletResponse response);

}
