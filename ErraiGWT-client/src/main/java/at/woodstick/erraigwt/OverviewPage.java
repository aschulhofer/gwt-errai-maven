package at.woodstick.erraigwt;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.nav.client.local.PageShowing;
import org.jboss.errai.ui.nav.client.local.PageShown;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.slf4j.Logger;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;

@Page(path = "overview")
@Templated
public class OverviewPage extends Composite {

	@Inject
	private Logger log;
	
	@Inject
	@DataField("in1")
	private Label itemField1;
	
	@Inject
	@DataField("in2")
	private Label itemField2;
	
	@Inject
	@DataField("in3")
	private Label itemField3;
	
	@PostConstruct
	private void constructed() {
		ItemSpec itemSpec1 = new ItemSpec("000.000");
		
		setItemText(itemField1, itemSpec1);
		setItemText(itemField2, itemSpec1);
		setItemText(itemField3, itemSpec1);
	}

	private void setItemText(HasText element, ItemSpec item) {
		element.setText(item.getItemNumber());
	}
	
	@PageShowing
	private void preparePage() {
		log.debug("Overview page showing");
	}

	@PageShown
	private void showPage() {
		log.debug("Overview page shown");
	}
}
