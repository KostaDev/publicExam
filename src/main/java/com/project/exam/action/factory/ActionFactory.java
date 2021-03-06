package com.project.exam.action.factory;

import com.project.exam.action.AbstractAction;
import com.project.exam.action.city.AddCityAction;
import com.project.exam.action.city.CityAction;
import com.project.exam.action.city.DeleteCityAction;
import com.project.exam.action.city.ShowCityAction;
import com.project.exam.action.login.LoginAction;
import com.project.exam.action.manufacturer.AddManufactuererAction;
import com.project.exam.action.manufacturer.ManufacturerAction;
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
		case AppConstants.PATH_CITY_DELETE:
			action = new DeleteCityAction();
			break;
		case AppConstants.PATH_CITY_SHOW:
			action = new ShowCityAction();
			break;
		case AppConstants.PATH_MANUFACTURER:
			action = new ManufacturerAction();
			break;
		case AppConstants.PATH_MANUFACTURER_ADD:
			action = new AddManufactuererAction();
			break;
		default:
			break;
		}
		
		
		return action;
	}

}
