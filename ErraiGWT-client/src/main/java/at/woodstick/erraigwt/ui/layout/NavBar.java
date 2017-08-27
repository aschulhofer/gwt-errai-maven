package at.woodstick.erraigwt.ui.layout;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import org.jboss.errai.ui.client.local.api.elemental2.IsElement;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import at.woodstick.erraigwt.ui.layout.element.NavLink;
import elemental2.dom.HTMLUListElement;

@Templated(NavBar.TEMPLATE)
public class NavBar implements IsElement {

	public static final String TEMPLATE = "/at/woodstick/erraigwt/ui/layout/NavBar.html";
	
	@Inject
	@DataField("nav")
	private HTMLUListElement navContainer;
	
	@Inject
	private Instance<NavLink> navLinkInstance;
	
	public void addNavigationSection(NavItem navItem) {
		NavLink navLink = navLinkInstance.get();
		
		navLink.getNavAnchor().href = "#" + navItem.getLinkPath().getPath();
		navLink.getNavAnchor().innerHTML = navItem.getDisplayTextKey();
		
		navLink.disable();
		
		navContainer.appendChild(navLink.getElement());
	}
	
	public void addNavigationLink(NavItem navItem) {
		addNavigationLink(navItem, false);
	}
	
	public void addNavigationLink(NavItem navItem, boolean isActive) {
		NavLink navLink = navLinkInstance.get();
		
		navLink.getNavAnchor().href = "#" + navItem.getLinkPath().getPath();
		navLink.getNavAnchor().innerHTML = navItem.getDisplayTextKey();
		
		if(isActive) {
			navLink.active();
		}
		
		navContainer.appendChild(navLink.getElement());
	}
	
	public void addNavigationLinkButton(NavItem navItem) {
		
	}
}
