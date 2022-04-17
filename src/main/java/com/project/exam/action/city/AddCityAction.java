package com.project.exam.action.city;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.exam.action.AbstractAction;

import com.project.exam.domain.City;
import com.project.exam.service.CityService;
import com.project.exam.service.impl.CityServiceImp;
import com.project.exam.storage.CityStorage;

public class AddCityAction extends AbstractAction{
	CityService cityService;
	public AddCityAction() {

		cityService = new CityServiceImp();
	}
	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		
		Long zipCode =Long.parseLong(request.getParameter("zip_code")) ;
		String name = request.getParameter("city_name");
		System.out.println("zip code to insert: "+zipCode);
		System.out.println("Name to insert: "+name);
		
		City city = new City(zipCode,name);
		//CityStorage.getInstance().add(city);
		cityService.insertCity(city);
		request.setAttribute("successes", new String[] {"successfully added City"});
		return new CityAction().executeRequest(request, response);
		//return AppConstants.PAGE_CITY;
	}

}
