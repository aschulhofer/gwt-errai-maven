package at.woodstick.erraigwt.element;

import org.jboss.errai.common.client.ui.HasValue;

import elemental2.dom.HTMLLabelElement;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "HTMLLabelElement")
public class ParanthesesTextLabel extends HTMLLabelElement implements HasValue<String> {
	
	@Override
	@JsOverlay
	public final String getValue() {
		return wrapValue(textContent);
	}
	
	@Override
	@JsOverlay
	public final void setValue(String value) {
		textContent = wrapValue(value);
	}
	
	@JsOverlay
	public final String wrapValue(String value) {
		return " (( " + value + " )) ";
	}
}
