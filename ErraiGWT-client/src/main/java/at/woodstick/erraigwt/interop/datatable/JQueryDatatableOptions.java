package at.woodstick.erraigwt.interop.datatable;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class JQueryDatatableOptions {

	@JsProperty
	public Object[] data;
	
	@JsProperty
	public Object ajax;
	
	@JsProperty
	public boolean serverSide;

	@JsProperty
	public boolean processing;

	@JsProperty
	public boolean deferRender;
	
	@JsProperty
	public ColumnDefinition[] columns;
	
}

