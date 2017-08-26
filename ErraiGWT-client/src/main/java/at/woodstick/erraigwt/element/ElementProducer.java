package at.woodstick.erraigwt.element;

import javax.enterprise.inject.Produces;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLTableElement;

public class ElementProducer {

	@Produces
	public HTMLTableElement tableElement() {
		return (HTMLTableElement) DomGlobal.document.createElement("table");
	}
	
	@Produces
	public HTMLDivElement divElement() {
		return (HTMLDivElement) DomGlobal.document.createElement("div");
	}
	
}
