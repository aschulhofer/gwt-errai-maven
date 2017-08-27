package at.woodstick.erraigwt.ui.layout.element;

import javax.inject.Inject;

import org.jboss.errai.ui.client.local.api.elemental2.IsElement;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import elemental2.dom.HTMLAnchorElement;
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

	public void active() {
		if(navItem.classList != null) {
			navItem.classList.add(CSS_ACTIVE);
		}
		else {
			navItem.className += " " + CSS_ACTIVE;
		}
	}
	
	public void disable() {
		if(navItem.classList != null) {
			navItem.classList.add(CSS_DISABLED);
		}
		else {
			navItem.className += " " + CSS_DISABLED;
		}
	}
	
	public HTMLAnchorElement getNavAnchor() {
		return navAnchor;
	}
}
