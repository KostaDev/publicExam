package com.project.exam.action.login;

import java.util.ArrayList;
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
		List<User>	users =(List<User>) request.getServletContext().getAttribute("ListOfLoggedInUsers");
		
		if (user!=null && !users.contains(user)) {
			User loggedUser = user.clone();


			users.add(user);
			
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
		System.out.println(users.size());
		for (User current : users) {
			System.out.println(current.toString());
			if (current.equals(user)) {
				return current;
			}
		}
		return null;
	}

}
