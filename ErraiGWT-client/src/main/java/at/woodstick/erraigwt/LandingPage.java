package at.woodstick.erraigwt;

import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.nav.client.local.PageShowing;
import org.jboss.errai.ui.nav.client.local.PageShown;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.slf4j.Logger;

import com.google.gwt.user.client.ui.Composite;
import com.google.inject.Inject;

@Page(role = DefaultPage.class, path = "home")
@Templated
public class LandingPage extends Composite {

	@Inject
	private Logger log;

	@PageShowing
	private void preparePage() {
		log.debug("Default page showing");
	}

	@PageShown
	private void showPage() {
		log.debug("Default page shown");
	}
}
