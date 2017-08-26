package at.woodstick.erraigwt.interop.datatable;

import at.woodstick.erraigwt.interop.JQueryElement;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = "jQuery", name = "DataTable")
public class JQueryDatatable {

	@JsMethod(namespace = JsPackage.GLOBAL, name = "DataTable")
    public native JQueryElement create(JQueryDatatableOptions options);
	
}
