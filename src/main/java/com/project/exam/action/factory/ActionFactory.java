package com.project.exam.action.factory;

import com.project.exam.action.AbstractAction;
import com.project.exam.action.CityAction;
import com.project.exam.action.login.LoginAction;
import com.project.exam.constants.AppConstants;



public class ActionFactory {

	public static AbstractAction createAction(String path, String method) {
AbstractAction action = null;
		
		switch (path) {
		case AppConstants.PATH_LOGIN:
			action = new LoginAction();
			break;
		case AppConstants.PATH_CITY:
			action = new CityAction();
			break;
		default:
			break;
		}
		
		
		return action;
	}

}
