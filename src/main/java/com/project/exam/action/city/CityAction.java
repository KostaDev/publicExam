package com.project.exam.action.city;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.exam.action.AbstractAction;
import com.project.exam.constants.AppConstants;
import com.project.exam.domain.City;
import com.project.exam.service.CityService;
import com.project.exam.service.impl.CityServiceImp;
import com.project.exam.storage.CityStorage;

public class CityAction extends AbstractAction {
	CityService cityService;
	public CityAction() {

		cityService = new CityServiceImp();
	}
	
	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		List<City> cityList = cityService.findAll();
		System.out.println("City list length: "+cityList.size());
		request.setAttribute("cities", cityList);
		return AppConstants.PAGE_CITY;
	}

}
