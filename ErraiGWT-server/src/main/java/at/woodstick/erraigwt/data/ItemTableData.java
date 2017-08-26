package at.woodstick.erraigwt.data;

import at.woodstick.erraigwt.ItemSpec;

public class ItemTableData {

	private ItemSpec itemSpec;
	private String id;
	
	public ItemTableData(ItemSpec itemSpec, String id) {
		this.itemSpec = itemSpec;
		this.id = id;
	}
	
	public ItemSpec getItemSpec() {
		return itemSpec;
	}
	
	public void setItemSpec(ItemSpec itemSpec) {
		this.itemSpec = itemSpec;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
}
