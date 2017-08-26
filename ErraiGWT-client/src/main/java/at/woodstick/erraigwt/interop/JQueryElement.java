package at.woodstick.erraigwt.interop;

import at.woodstick.erraigwt.interop.datatable.JQueryDatatableOptions;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(namespace = JsPackage.GLOBAL, isNative = true, name = "jQuery")
public class JQueryElement {

	@JsMethod(name = "DataTable")
    public native JQueryElement createDatatable(JQueryDatatableOptions options);
	
	public native String attr(String className);
	public native JQueryElement attr(String className, Object value);
	
	public native JQueryElement addClass(String className);
	public native JQueryElement removeClass(String className);
}
