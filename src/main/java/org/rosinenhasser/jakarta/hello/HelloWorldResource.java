package org.rosinenhasser.jakarta.hello;

import java.util.logging.Logger;

import org.rosinenhasser.jakarta.cat.CatEntity;
import org.rosinenhasser.jakarta.cat.CatService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("hello")
public class HelloWorldResource {

	@Inject
	private CatService catService;

	private static final Logger logger = Logger.getLogger(HelloWorldResource.class.getName());

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Hello hello(@QueryParam("name") String name) {
		if ((name == null) || name.trim().isEmpty()) {
			name = "world";
		}

		CatEntity cat = new CatEntity();
		logger.info("cat: " + cat);
		cat.setName("Bruno");
		cat.setSpecies("Britisch Kurzhaar");
		cat.setAge(0);
		cat.setIsVegan(false);
		logger.info("cat after init: " + cat);

		catService.create(cat);

		logger.info("read cat: " + catService.read(1L));
		
		cat = catService.read(1L);

		cat.setAge(5);
		catService.update(cat);

		logger.info("read all cats: " + catService.readAll());

		catService.delete(1L);

		logger.info("read all cats: " + catService.readAll());

		return new Hello(name);
	}
}