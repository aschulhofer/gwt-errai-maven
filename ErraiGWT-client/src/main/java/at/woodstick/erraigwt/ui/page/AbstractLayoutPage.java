package at.woodstick.erraigwt.ui.page;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jboss.errai.ui.nav.client.local.PageShowing;
import org.jboss.errai.ui.nav.client.local.PageShown;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.slf4j.Logger;

import at.woodstick.erraigwt.Pages;
import at.woodstick.erraigwt.ui.layout.NavItem;
import at.woodstick.erraigwt.ui.layout.StandardLayout;

@Templated(AbstractLayoutPage.TEMPLATE)
public abstract class AbstractLayoutPage extends StandardLayout {
	
	public static final String TEMPLATE = StandardLayout.TEMPLATE;
	
	@Inject
	protected Logger log;
	
	@PostConstruct
	protected void constructed() {
		initNavigation();
	}
	
	@PageShowing
	protected void preparePage() {
		log.debug("Layout page showing");
	}
	
	@PageShown
	protected void showPage() {
		log.debug("Layout page shown");
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
