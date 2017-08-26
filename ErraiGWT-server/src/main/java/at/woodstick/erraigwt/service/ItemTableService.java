package at.woodstick.erraigwt.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.core.Response;

import at.woodstick.erraigwt.ItemSpec;
import at.woodstick.erraigwt.data.DatatableResponse;
import at.woodstick.erraigwt.data.ItemTableData;

@Stateless
public class ItemTableService implements ItemTableEndpointService {

	@Override
	public Response getTableSpecData() {
		List<ItemTableData> itemList = new ArrayList<>();
		
		for(int i = 0; i < 10; i++) {
			itemList.add(new ItemTableData(new ItemSpec("itemNumber" + i), ""+i));
		}
		
		DatatableResponse<ItemTableData> responseData = new DatatableResponse<>(itemList);
		
		return Response.ok(responseData).build();
	}

}
