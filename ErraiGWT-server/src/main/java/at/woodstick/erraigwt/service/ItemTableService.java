package at.woodstick.erraigwt.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import at.woodstick.erraigwt.ItemSpec;
import at.woodstick.erraigwt.data.DatatableResponse;
import at.woodstick.erraigwt.data.ItemTableData;
import at.woodstick.erraigwt.service.TableRequest.Order;

@Stateless
public class ItemTableService implements ItemTableEndpointService {

	@Context
	private UriInfo uriInfo;
	
	@Override
	public Response getTableSpecData() {
		TableRequest request = new TableRequest(uriInfo.getQueryParameters());

		final int draw = request.getDraw();
		final int start = request.getStart();
		final int length = request.getLength();
		int numberOfItems = request.getInt("numberOfItems");
		numberOfItems = numberOfItems > 0 ? numberOfItems : 100; 
		
		final String searchValue = request.get(TableRequest.PARAM_SEARCH_VALUE);
		
		List<ItemTableData> itemList = new ArrayList<>();
		
		for(int i = 0; i < numberOfItems; i++) {
			itemList.add(new ItemTableData(new ItemSpec("itemNumber" + i), ""+(numberOfItems-i)));
		}
		
		final int orderColumn = request.getOrderColumn();
		final Order orderDir = request.getOrderDir();
		
		if(orderColumn == 0) {
			Comparator<ItemTableData> comparator = Comparator.comparing(ItemTableData::getId);
			
			if(orderDir == Order.DESC) {
				comparator = comparator.reversed();
			}
			
			Collections.sort(itemList, comparator);
		}
		else if(orderColumn == 1) {
			Collections.sort(itemList, (o1, o2) -> {
				int compareRes = o1.getItemSpec().getItemNumber().compareTo(o2.getItemSpec().getItemNumber());
				return orderDir == Order.ASC ? compareRes : compareRes * -1;
			});
		}
		
		if(searchValue != null) {
			itemList = itemList.stream().filter(item -> {
				return item.getId().contains(searchValue) || item.getItemSpec().getItemNumber().contains(searchValue);
			})
			.collect(Collectors.toList());
		}
		
		final int filteredRecords = itemList.size();
		
		final int endIndex = (start + length);
		final int endOfSubList = endIndex > filteredRecords ? filteredRecords : endIndex;
		
		itemList = itemList.subList(start, endOfSubList);
		
		DatatableResponse<ItemTableData> responseData = new DatatableResponse<>();

		if(uriInfo == null) {
			responseData.setError("no uriinfo");
			return Response.serverError().entity(responseData).build();
		}
		
		responseData.setDraw(draw);
		responseData.setRecordsTotal(numberOfItems);
		responseData.setRecordsFiltered(filteredRecords);
		responseData.setData(itemList);
		
		return Response.ok(responseData).build();
	}

}
