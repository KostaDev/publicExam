package com.project.exam.action.factory;

import com.project.exam.action.AbstractAction;
import com.project.exam.action.city.AddCityAction;
import com.project.exam.action.city.CityAction;
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
		case AppConstants.PATH_CITY_ADD:
			action = new AddCityAction();
			break;
		default:
			break;
		}
		
		
		return action;
	}

}
