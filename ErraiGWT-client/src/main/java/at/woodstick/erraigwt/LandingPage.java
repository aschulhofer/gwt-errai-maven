package at.woodstick.erraigwt;

import static at.woodstick.erraigwt.interop.JQuery.$;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

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

import at.woodstick.erraigwt.element.DataForm;
import at.woodstick.erraigwt.element.DataFormModel;
import at.woodstick.erraigwt.element.EventCountComponent;
import at.woodstick.erraigwt.element.ParanthesesLabel;
import at.woodstick.erraigwt.element.ParanthesesTextLabel;
import at.woodstick.erraigwt.interop.JQueryElement;
import at.woodstick.erraigwt.interop.wrapper.JSON;
import at.woodstick.erraigwt.interop.wrapper.SumWrapper;
import elemental2.dom.HTMLDivElement;

@Page(path = Pages.Paths.HOME) //, role = DefaultPage.class)
@Templated
public class LandingPage extends Composite {

	@Inject
	private Logger log;
	
	@Inject
	@DataField("root")
	private HTMLDivElement rootElement;
	
	@Inject
	@DataField("namespec")
	private NameSpecInfo namespecInfoField;
	
	@Inject
	@DataField("namespec2")
	private Label namespecParagraphField;
	
	@Inject
	@DataField("parantheses-label")
	private ParanthesesLabel parenthesesField;
	
	@Inject
	@DataField("parantheses-text-label")
	private ParanthesesTextLabel parenthesesTextField;
	
	@Inject 
	@DataField("nav-container")
	private Nav navContainer;
	
	@Inject 
	@DataField("overview-link")
	private TransitionAnchor<OverviewPage> overviewLink;
	
	@Inject
	@DataField("count-event-widget")
	private EventCountComponent countEvent;
	
	@Inject
	@DataField("data-form")
	private DataForm dataForm;
	
	@PostConstruct
	private void constructed() {
		NameSpec namespec = new NameSpec("Testname");
		namespecInfoField.setModel(namespec);
		
		namespecParagraphField.setText("Not set." + " " + namespec.getConst());
		
		navContainer.init(Arrays.asList(Pages.OVERVIEW, Pages.DATATABLE, Pages.LAYOUT));
	}
	
	@PageShowing
	private void preparePage() {
		log.debug("Default page showing");
	}

	@PageShown
	private void showPage() {
		log.debug("Default page shown");
		
		$("body").addClass("test-query");
		
		JQueryElement namespec = $("[data-field=namespec]");
		
		String classes = namespec.addClass("test test1 test2").attr("class");
		
		log.debug("Classes are {}", classes);
		
		namespecParagraphField.setText("Classes of namespec field are: " + classes);
		
		SumWrapper sum = new SumWrapper();
		sum.setOffset(100);
		
		log.debug(JSON.stringify(sum, null, 2));
		
		parenthesesField.setValue("TEST field");
		parenthesesTextField.setValue("TEST Text field");
		
		DataFormModel dataFormModel = new DataFormModel();
		
		dataFormModel.setStringProperty("string property");
		dataFormModel.setDateProperty(new Date());
		dataFormModel.setBigdecimalProperty(new BigDecimal("10123.456"));
		dataFormModel.setCounterProperty(countEvent.getCounterInstance());
		
		dataForm.setModel(dataFormModel);
	}
}
