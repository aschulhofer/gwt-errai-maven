package at.woodstick.erraigwt.interop;

import elemental2.core.JsObject;

public class JsObjectAccessor {

	private JsObject object;

	public JsObjectAccessor(JsObject object) {
		this.object = object;
	}
	
	public String getStringProperty(final String propertyName) {
		return JsUtil.getStringObjectProperty(object, propertyName);
	}
	
	public int getIntProperty(final String propertyName) {
		return JsUtil.getObjectProperty(object, propertyName);
	}
	
	public JsObject getObjectProperty(final String propertyName) {
		return JsUtil.getObjectProperty(object, propertyName);
	}
	
	public <R> R getProperty(final String propertyName) {
		return JsUtil.getObjectProperty(object, propertyName);
	}
	
	public void setProperty(final String propertyName, final int value) {
		JsUtil.setIntObjectProperty(object, propertyName, value);
	}
	
	public <V> void setProperty(final String propertyName, final V value) {
		JsUtil.setObjectProperty(object, propertyName, value);
	}
	
	public static JsObjectAccessor of(Object jsOject) {
		return of(new JsObject(jsOject));
	}
	
	public static JsObjectAccessor of(JsObject jsOject) {
		return new JsObjectAccessor(jsOject);
	}
	
	public static JsObjectAccessor access(Object jsOject) {
		return access(new JsObject(jsOject));
	}
	
	public static JsObjectAccessor access(JsObject jsOject) {
		return new JsObjectAccessor(jsOject);
	}
}
