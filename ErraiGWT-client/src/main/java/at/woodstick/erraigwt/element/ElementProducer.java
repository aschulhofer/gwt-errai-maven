package at.woodstick.erraigwt.element;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;

public class ElementProducer {

	@Produces
	@Named("inputtext")
	public HTMLInputElement inputTextElement() {
		
		HTMLInputElement element = (HTMLInputElement) DomGlobal.document.createElement("input");
		element.type = "text";
		
		return element;
	}
	
	@Produces
	@Named("span")
	public HTMLElement spanElement() {
		
		HTMLElement element = (HTMLElement) DomGlobal.document.createElement("span");
		
		return element;
	}
}
