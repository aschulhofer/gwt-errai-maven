package at.woodstick.erraigwt.interop.wrapper;

import com.google.gwt.dom.client.Element;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "jQuery")
public class JQuery {

	@JsMethod(namespace = JsPackage.GLOBAL)
    public static native JQueryElement $(String selector);

    @JsMethod(namespace = JsPackage.GLOBAL)
    public static native JQueryElement $(String selector, Element context);
    
    @JsMethod(namespace = JsPackage.GLOBAL)
    public static native JQueryElement $(String selector, JQueryElement context);
	
}
