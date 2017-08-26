package at.woodstick.erraigwt.interop.datatable;

import at.woodstick.erraigwt.interop.JQueryElement;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

//TODO: fix me
@JsType(namespace = JsPackage.GLOBAL, isNative = true, name = "jQuery")
public class JQueryDatatablePlugin extends JQueryElement {

	@JsMethod(name = "DataTable")
    public native JQueryElement createDatatable(JQueryDatatableOptions options);
}
