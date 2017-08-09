package at.woodstick.erraigwt;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.nav.client.local.PageShowing;
import org.jboss.errai.ui.nav.client.local.PageShown;
import org.jboss.errai.ui.nav.client.local.TransitionAnchor;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.slf4j.Logger;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;

@Page(role = DefaultPage.class, path = "home")
@Templated
public class LandingPage extends Composite {

	@Inject
	private Logger log;
	
	@Inject
	@DataField("namespec")
	private NameSpecInfo namespecInfoField;
	
	@Inject
	@DataField("namespec2")
	private Label namespecParagraphField;
	
	@Inject 
	@DataField("overview-link")
	private TransitionAnchor<OverviewPage> overviewLink;
	
	@PostConstruct
	private void constructed() {
		NameSpec namespec = new NameSpec("Testname");
		namespecInfoField.setModel(namespec);
		
		namespecParagraphField.setText("Not set." + " " + namespec.getConst());
	}

	@PageShowing
	private void preparePage() {
		log.debug("Default page showing");
	}

	@PageShown
	private void showPage() {
		log.debug("Default page shown");
	}
}
