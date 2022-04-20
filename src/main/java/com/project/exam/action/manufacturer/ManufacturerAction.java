package com.project.exam.action.manufacturer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.exam.action.AbstractAction;
import com.project.exam.constants.AppConstants;
import com.project.exam.domain.City;
import com.project.exam.domain.Manufacturer;
import com.project.exam.service.CityService;
import com.project.exam.service.ManufactuererService;
import com.project.exam.service.impl.CityServiceImp;
import com.project.exam.service.impl.ManufacturerServiceImp;

public class ManufacturerAction extends AbstractAction {
	ManufactuererService manufactuererService;
	CityService cityService;
	public ManufacturerAction() {

		manufactuererService = new ManufacturerServiceImp();
		cityService = new CityServiceImp();
	}
	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		List<City> cities = cityService.findAll();
		List<Manufacturer> manufacturers = manufactuererService.findAll();
		request.setAttribute("manufacturers", manufacturers);
		request.setAttribute("cities", cities);
		return AppConstants.PAGE_MANUFACTURER;
	}

}
