package at.woodstick.erraigwt.interop.wrapper;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(namespace = JsPackage.GLOBAL, name = "JSON", isNative = true)
public class JSON {

	@JsMethod
	public static native String stringify(Object value);
	
	@JsMethod
	public static native String stringify(Object value, Object replacer);
	
	@JsMethod
	public static native String stringify(Object value, Object replacer, Number space);
	
}
