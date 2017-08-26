package at.woodstick.erraigwt.interop;

import com.google.gwt.dom.client.Element;

import elemental2.dom.HTMLElement;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "jQuery")
public class JQuery {

	@JsMethod(namespace = JsPackage.GLOBAL)
    public static native JQueryElement $(String selector);
	
	@JsMethod(namespace = JsPackage.GLOBAL)
    public static native JQueryElement $(Element element);
	
	@JsMethod(namespace = JsPackage.GLOBAL)
    public static native JQueryElement $(HTMLElement element);

    @JsMethod(namespace = JsPackage.GLOBAL)
    public static native JQueryElement $(String selector, Element context);
    
    @JsMethod(namespace = JsPackage.GLOBAL)
    public static native JQueryElement $(String selector, HTMLElement context);
    
    @JsMethod(namespace = JsPackage.GLOBAL)
    public static native JQueryElement $(String selector, JQueryElement context);
	
}
