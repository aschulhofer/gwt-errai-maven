package at.woodstick.erraigwt.interop.datatable;

public class DatatableUtil {

	public static JQueryDatatableOptions createOptions() {
		return new JQueryDatatableOptions();
	}
	
	public static ColumnDefinition createColumn() {
		return new ColumnDefinition();
	}
	
	public static AjaxOptions createAjaxOptions() {
		return new AjaxOptions();
	}
}
