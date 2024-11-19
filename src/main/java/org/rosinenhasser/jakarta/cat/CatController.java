package org.rosinenhasser.jakarta.cat;

import java.util.List;
import java.util.logging.Logger;

import org.rosinenhasser.jakarta.cat.dto.CreateCatDto;
import org.rosinenhasser.jakarta.cat.dto.UpdateCatDto;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;

@Path("cats")
public class CatController {

	@Inject
	private CatService catService;

	private static final Logger logger = Logger.getLogger(CatController.class.getName());

	@GET
	@Path("details")
	@Produces({ MediaType.APPLICATION_JSON })
	public CatEntity readCat(@QueryParam("id") long id) {
		return catService.read(id);
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<CatEntity> readCats() {
		return catService.readAll();
	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public void createCat(CreateCatDto createCatDto) {
		CatEntity cat = new CatEntity();
		cat.setName(createCatDto.getName());
		cat.setSpecies(createCatDto.getSpecies());
		cat.setAge(createCatDto.getAge());
		cat.setIsVegan(createCatDto.isVegan());
		catService.create(cat);
	}

	@PUT
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public void updateCat(@QueryParam("id") long id, UpdateCatDto updateCatDto) {
		CatEntity cat = catService.read(id);
		cat.setName(updateCatDto.getName());
		cat.setSpecies(updateCatDto.getSpecies());
		cat.setAge(updateCatDto.getAge());
		cat.setIsVegan(updateCatDto.isVegan());
		catService.update(cat);
	}

	@DELETE
	@Produces({ MediaType.APPLICATION_JSON })
	public void deleteCat(@QueryParam("id") long id) {
		catService.delete(id);
	}
}
