package com.project.exam.action.login;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.exam.action.AbstractAction;
import com.project.exam.constants.AppConstants;
import com.project.exam.domain.User;
import com.project.exam.service.UserService;
import com.project.exam.service.impl.UserServiceImp;
import com.project.exam.storage.UserStorage;



public class LoginAction extends AbstractAction {
	UserService userService;
	
	public LoginAction() {

		userService = new UserServiceImp();
	}
	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		
		
		User user = login(request);
		List<User>	users =(List<User>) request.getServletContext().getAttribute("ListOfLoggedInUsers");
		
		if (user!=null ) {
			User loggedUser = user.clone();
			HttpSession session = request.getSession(true);
			if (users.contains(user)) {
				request.setAttribute("errors", new String[]{"User allready Logged In"});
				return AppConstants.PAGE_LOGIN;
			}
			users.add(user);
			
			session.setAttribute("login-user", loggedUser);
			return AppConstants.PAGE_HOME;
		} else {
			request.setAttribute("errors", new String[]{"Invalid username or password"});
			return AppConstants.PAGE_LOGIN;
		}
		
		
	}

	private User login(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
//		User user = new User();
//		user.setUsername(username);
//		user.setPassword(password);
//		List<User> users = UserStorage.getInstance().getUsers();
//		System.out.println(users.size());
//		for (User current : users) {
//			System.out.println(current.toString());
//			if (current.equals(user)) {
//				return current;
//			}
//		}
		User user = userService.login(username,password);
		return user;
	}

}
