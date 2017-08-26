package at.woodstick.erraigwt.interop;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class JsConsole {
	public native void log(Object... objects);
}
