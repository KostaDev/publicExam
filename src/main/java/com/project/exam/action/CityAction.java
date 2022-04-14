package com.project.exam.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.exam.constants.AppConstants;
import com.project.exam.domain.City;
import com.project.exam.storage.CityStorage;

public class CityAction extends AbstractAction {

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		List<City> cityList = CityStorage.getInstance().getCities();
		request.setAttribute("cities", cityList);
		return AppConstants.PAGE_CITY;
	}

}
