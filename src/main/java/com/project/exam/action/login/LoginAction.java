package com.project.exam.action.login;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.exam.action.AbstractAction;
import com.project.exam.constants.AppConstants;
import com.project.exam.domain.User;
import com.project.exam.storage.UserStorage;



public class LoginAction extends AbstractAction {

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		User user = login(request);
		
		if (user!=null) {
			//user.setPassword(null);
			User loggedUser = user.clone();
			request.getSession(true).setAttribute("login-user", loggedUser);
			return AppConstants.PAGE_HOME;
		} else {
			request.setAttribute("error_message", "error: user does not exist");
			return AppConstants.PAGE_LOGIN;
		}
		
		
	}

	private User login(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		List<User> users = UserStorage.getInstance().getUsers();
		
		for (User current : users) {
			if (current.equals(user)) {
				return current;
			}
		}
		return null;
	}

}
