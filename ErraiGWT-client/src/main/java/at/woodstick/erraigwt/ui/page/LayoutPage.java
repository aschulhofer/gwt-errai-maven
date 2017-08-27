package at.woodstick.erraigwt.ui.page;

import javax.inject.Inject;

import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.slf4j.Logger;

import at.woodstick.erraigwt.Pages;
import at.woodstick.erraigwt.ui.content.LayoutContent;

@Page(path = Pages.Paths.LAYOUT, role = DefaultPage.class)
@Templated(AbstractLayoutPage.TEMPLATE)
public class LayoutPage extends AbstractLayoutPage {
	
	@Inject
	protected Logger log;
	
	@Inject
	@DataField(FIELD_CONTENT)
	protected LayoutContent content;
	
	@Override
	protected void preparePage() {
		log.debug("Layout page showing");
	}
	
	@Override
	protected void showPage() {
		log.debug("Layout page shown");
	}
	
	@Override
	protected String getActivePage() {
		return Pages.LAYOUT.getPath();
	}
}
