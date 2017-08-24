package at.woodstick.erraigwt.interop.wrapper;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(namespace = JsPackage.GLOBAL, isNative = true, name = "$")
public final class JQueryElement {

	public native String attr(String className);
	public native JQueryElement attr(String className, Object value);
	
	public native JQueryElement addClass(String className);
	public native JQueryElement removeClass(String className);
}
