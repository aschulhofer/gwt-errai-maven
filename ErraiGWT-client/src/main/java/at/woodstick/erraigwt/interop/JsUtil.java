package at.woodstick.erraigwt.interop;

public final class JsUtil {

	public static <O> String getStringObjectProperty(O object, String propertyName) {
	    return getObjectProperty(object, propertyName);
	};
	
	public static native <O, R> R getObjectProperty(O object, String propertyName) /*-{
	    return object[propertyName];
	}-*/;
	
	public static native <O> void setIntObjectProperty(O object, String propertyName, int value) /*-{
		object[propertyName] = value;
	}-*/;
	
	public static native <O, V> void setObjectProperty(O object, String propertyName, V value) /*-{
    	object[propertyName] = value;
	}-*/;
	
}
