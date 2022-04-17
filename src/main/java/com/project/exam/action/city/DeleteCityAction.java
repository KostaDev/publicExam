package com.project.exam.action.city;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.exam.action.AbstractAction;
import com.project.exam.service.CityService;
import com.project.exam.service.impl.CityServiceImp;
import com.project.exam.storage.CityStorage;

public class DeleteCityAction extends AbstractAction {
	CityService cityService;
	public DeleteCityAction() {
		cityService = new CityServiceImp();
	}
	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		Long idToRemove = Long.parseLong(request.getParameter("zip_code"));
		
		Boolean deleteCity = cityService.removeCity(idToRemove);
		System.out.println("is city deleted: "+deleteCity);
		if (deleteCity) {
			request.setAttribute("successes", new String[]{"successfuly removed city with id of: "+idToRemove});
		} else {
			request.setAttribute("errors", new String[]{"Something went wrong!"});
			
		}
		return new CityAction().executeRequest(request, response);
	}

}
