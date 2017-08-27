package at.woodstick.erraigwt.ui.page;

import javax.inject.Inject;

import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import at.woodstick.erraigwt.Pages;
import at.woodstick.erraigwt.ui.content.LayoutContent;
import at.woodstick.erraigwt.ui.layout.StandardLayout;

@Page(path = Pages.Paths.LAYOUT, role = DefaultPage.class)
@Templated(StandardLayout.TEMPLATE)
public class LayoutPage extends AbstractLayoutPage {
	
	@Inject
	@DataField("layout-content")
	protected LayoutContent content;
	
	@Override
	protected String getActivePage() {
		return Pages.LAYOUT.getPath();
	}
}
