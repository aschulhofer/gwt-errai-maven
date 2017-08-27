package at.woodstick.erraigwt.ui.page;

import javax.annotation.PostConstruct;

import org.jboss.errai.ui.shared.api.annotations.Templated;

import at.woodstick.erraigwt.Pages;
import at.woodstick.erraigwt.ui.layout.NavItem;
import at.woodstick.erraigwt.ui.layout.StandardLayout;

@Templated(StandardLayout.TEMPLATE)
public abstract class AbstractLayoutPage extends StandardLayout {
	
	@PostConstruct
	protected void constructed() {
		initNavigation();
	}
	
	protected void initNavigation() {
		final String activePage = getActivePage();
		
		navBar.addNavigationSection(
			NavItem.item().withDisplayTextKey("TEST SECTION")
		);
		
		for(Pages page : Pages.values()) {
			NavItem navItem = NavItem.item().withPath(page.getPath()).withDisplayTextKey(page.getLinkName());
			
			boolean isActive = activePage.equals(page.getPath());
			
			navBar.addNavigationLink(navItem, isActive);
		}
	}
	
	protected abstract String getActivePage();
}
