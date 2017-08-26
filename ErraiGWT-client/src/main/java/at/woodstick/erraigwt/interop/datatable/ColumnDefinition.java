package at.woodstick.erraigwt.interop.datatable;

import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ColumnDefinition {

	@JsProperty
	public String className;
	
	@JsProperty
	public String name;
	
	@JsProperty
	public boolean orderable;
	
	@JsProperty
	public Object data;
	
	@JsProperty
	public Object render;
	
	@JsFunction
	public interface Render<D> {
		String render(D data, String type, Object row, Object meta);
	}
	
	@JsOverlay
	public final ColumnDefinition className(String className) {
		this.className = className;
		return this;
	}
	
	@JsOverlay
	public final ColumnDefinition name(String name) {
		this.name = name;
		return this;
	}
	
	@JsOverlay
	public final ColumnDefinition orderable(boolean orderable) {
		this.orderable = orderable;
		return this;
	}
	
	@JsOverlay
	public final ColumnDefinition data(Object data) {
		this.data = data;
		return this;
	}
	
	@JsOverlay
	public final ColumnDefinition render(Object render) {
		this.render = render;
		return this;
	}
}
