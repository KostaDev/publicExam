package com.project.exam.action.manufacturer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.exam.action.AbstractAction;
import com.project.exam.domain.City;
import com.project.exam.domain.Manufacturer;
import com.project.exam.service.ManufactuererService;
import com.project.exam.service.impl.ManufacturerServiceImp;

public class AddManufactuererAction extends AbstractAction{
	ManufactuererService manufactuererService;
	public AddManufactuererAction() {

		manufactuererService = new ManufacturerServiceImp();
	}

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		Long manufacturerId =Long.parseLong(request.getParameter("manufacturer_id"));
		Long taxID =Long.parseLong(request.getParameter("tax_id"));
		String adress = request.getParameter("adress");
		Long zipCode =Long.parseLong(request.getParameter("city"));
		Manufacturer manufacturer = new Manufacturer(manufacturerId,taxID,adress,new City(zipCode,null));
		Boolean isInserted = manufactuererService.insert(manufacturer);
		if (isInserted) {
			request.setAttribute("successes", new String[] {"successfully added Manufacturer"});
			
		} else {
			request.setAttribute("errors", new String[]{"Something went wrong!"});
		}
		return new ManufacturerAction().executeRequest(request, response);
	}

}
