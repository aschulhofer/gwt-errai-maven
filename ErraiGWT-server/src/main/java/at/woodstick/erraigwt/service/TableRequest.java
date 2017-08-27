package at.woodstick.erraigwt.service;

import javax.ws.rs.core.MultivaluedMap;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TableRequest {

	public static final String PARAM_DRAW    = "draw";
	public static final String PARAM_START   = "start";
	public static final String PARAM_LENGTH  = "length";
	public static final String PARAM_SEARCH_VALUE  = "search[value]";
	public static final String PARAM_ORDER_COLUMN  = "order[0][column]";
	public static final String PARAM_ORDER_DIR  = "order[0][dir]";
	
	public enum Order {
		  ASC("asc")
		, DESC("desc")
		;
		
		private String order;

		private Order(String order) {
			this.order = order;
		}

		public String getOrder() {
			return order;
		}
		
		public static Order byOrder(final String orderString) {
			for(Order orderEnum : values()) {
				if(orderEnum.order.equalsIgnoreCase(orderString)) {
					return orderEnum;
				}
			}
			
			throw new IllegalArgumentException(orderString);
		}
	}
	
	private final MultivaluedMap<String, String> queryParameters;

	public TableRequest(MultivaluedMap<String, String> queryParameters) {
		this.queryParameters = queryParameters;
	}
	
	private static int asInt(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			log.error("{} is not an integer", value, e);
		}
		return -1;
	}
	
	public final String get(String draw) {
		return queryParameters.getFirst(draw);
	}
	
	public final int getInt(String draw) {
		return asInt(queryParameters.getFirst(draw));
	}
	
	public int getDraw() {
		return getInt(PARAM_DRAW);
	}
	
	public int getStart() {
		return getInt(PARAM_START);
	}
	
	public int getLength() {
		return getInt(PARAM_LENGTH);
	}
	
	public int getOrderColumn() {
		return getInt(PARAM_ORDER_COLUMN);
	}
	
	public Order getOrderDir() {
		return Order.byOrder(get(PARAM_ORDER_DIR));
	}
}
