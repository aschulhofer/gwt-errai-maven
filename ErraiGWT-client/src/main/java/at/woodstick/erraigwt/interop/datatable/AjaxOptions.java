package at.woodstick.erraigwt.interop.datatable;

import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class AjaxOptions {

	@JsProperty
	public String url;
	
	@JsProperty
	public Object data;
	
	@JsProperty
	public Object dataSrc;
	
	@JsProperty
	public Object success;
	
	@JsProperty
	public Object error;
	
	@JsFunction
	public interface DataRefiner<D, R> {
		R data(D data);
	}
	
	@JsFunction
	public interface DataSrc<D, R> {
		R dataSrc(D data);
	}
}
