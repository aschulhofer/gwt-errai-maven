package at.woodstick.erraigwt.ui.page.example;

import javax.inject.Inject;

import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.nav.client.local.PageShowing;
import org.jboss.errai.ui.nav.client.local.PageShown;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.slf4j.Logger;

import at.woodstick.erraigwt.Pages;
import at.woodstick.erraigwt.ui.content.example.DatatablePageContent;
import at.woodstick.erraigwt.ui.page.AbstractLayoutPage;

@Page(path = Pages.Paths.DATATABLE)
@Templated(AbstractLayoutPage.TEMPLATE)
public class DatatablePage extends AbstractLayoutPage {
	
	@Inject
	protected Logger log;
	
	@Inject
	@DataField(FIELD_CONTENT)
	protected DatatablePageContent content;
	
	@PageShowing
	protected void preparePage() {
		log.debug("Datatable page showing");
	}
	
	@PageShown
	protected void showPage() {
		log.debug("Datatable page shown");
		
		content.init();
	}
	
	@Override
	protected String getActivePage() {
		return Pages.DATATABLE.getPath();
	}
}
