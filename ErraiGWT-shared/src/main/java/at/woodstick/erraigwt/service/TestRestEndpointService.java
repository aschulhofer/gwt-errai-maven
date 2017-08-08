package at.woodstick.erraigwt.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("message")
public interface TestRestEndpointService {

	@GET
	@Path("helloworld")
	@Produces("application/json")
	public Response getHelloWorld();
	
	@GET
	@Path("itemspec/{item}")
	@Produces("application/json")
	public Response getItemSpec(@PathParam("item") final String item);
	
}
