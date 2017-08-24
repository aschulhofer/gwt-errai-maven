package at.woodstick.erraigwt.element;

import org.jboss.errai.common.client.api.annotations.Element;
import org.jboss.errai.common.client.dom.Label;
import org.jboss.errai.common.client.ui.HasValue;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsType;

@JsType(isNative = true)
@Element("label")
public interface ParanthesesTextLabel extends Label, HasValue<String> {
	
	@JsOverlay
	@Override
	default String getValue() {
		return wrapValue(getTextContent());
	}
	
	@JsOverlay
	@Override
	default void setValue(String value) {
		setTextContent(wrapValue(value));
	}
	
	@JsOverlay
	default String wrapValue(String value) {
		return " (( " + value + " )) ";
	}
}
