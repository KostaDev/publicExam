package com.project.exam.action.city;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.exam.action.AbstractAction;
import com.project.exam.storage.CityStorage;

public class DeleteCityAction extends AbstractAction {

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		Long idToRemove = Long.parseLong(request.getParameter("zip_code"));
		
		Boolean deleteCity = CityStorage.getInstance().delete(idToRemove);
		if (deleteCity) {
			request.setAttribute("successes", new String[]{"successfuly removed city with id of: "+idToRemove});
		} else {
			request.setAttribute("errors", new String[]{"Something went wrong!"});
			
		}
		return new CityAction().executeRequest(request, response);
	}

}
