package at.woodstick.erraigwt.service;

import javax.ejb.Stateless;
import javax.ws.rs.core.Response;

import at.woodstick.erraigwt.ItemSpec;
import at.woodstick.erraigwt.data.RestMessage;

@Stateless
public class TestRestEndpointServiceImpl implements TestRestEndpointService {

	@Override
	public Response getHelloWorld() {
		return Response
				.ok(new RestMessage("Hello World - cross origin")).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
				.header("Access-Control-Max-Age", "1209600").build();
	}
	
	@Override
	public Response getItemSpec(final String item) {
		return Response
				.ok(new ItemSpec(item)).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
				.header("Access-Control-Max-Age", "1209600").build();
	}
	
}
