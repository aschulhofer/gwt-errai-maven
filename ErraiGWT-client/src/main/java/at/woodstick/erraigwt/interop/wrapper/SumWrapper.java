package at.woodstick.erraigwt.interop.wrapper;

import jsinterop.annotations.JsType;

@JsType(name = "CSum")
public class SumWrapper {
	
	public int offset = 0;
	
	public int sum(int x, int y) {
		return x + y + offset;
	}
	
	public void setOffset(int offset) {
		this.offset = offset;
	}
}
