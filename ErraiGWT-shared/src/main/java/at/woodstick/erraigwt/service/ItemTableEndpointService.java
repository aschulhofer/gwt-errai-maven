package at.woodstick.erraigwt.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("items")
public interface ItemTableEndpointService {

	@GET
	@Path("specs")
	@Produces("application/json")
	public Response getTableSpecData();
	
}
