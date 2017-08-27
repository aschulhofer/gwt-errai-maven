package at.woodstick.erraigwt.ui.layout.element;

import javax.inject.Inject;

import org.jboss.errai.ui.client.local.api.elemental2.IsElement;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;

@Templated
public class NavLink implements IsElement {

	private static final String CSS_DISABLED = "disabled";
	private static final String CSS_ACTIVE   = "active";
	
	@Inject
	@DataField("nav-item")
	private HTMLLIElement navItem;
	
	@Inject
	@DataField("nav-anchor")
	private HTMLAnchorElement navAnchor;

	public NavLink setDisplayText(final String displayText) {
		navAnchor.textContent = displayText;
		return this;
	}
	
	public NavLink setAnchor(final String href) {
		navAnchor.href = href;
		return this;
	}
	
	public void active() {
		addCSSClass(navItem, CSS_ACTIVE);
	}
	
	public void disable() {
		addCSSClass(navItem, CSS_DISABLED);
	}
	
	private void addCSSClass(HTMLElement element, final String cssClass) {
		if(element.classList != null) {
			element.classList.add(cssClass);
		}
		else {
			element.className += " " + cssClass;
		}
	}
	
	private void removeCSSClass(HTMLElement element, final String cssClass) {
		if(element.classList != null) {
			element.classList.remove(cssClass);
		}
		else {
			element.className = element.className.replaceAll("(\\s|^)" + cssClass + "(\\s|$)", "");
		}
	}
}
