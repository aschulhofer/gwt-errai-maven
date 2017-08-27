package at.woodstick.erraigwt.element;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.errai.databinding.client.BindableProxy;
import org.jboss.errai.databinding.client.api.DataBinder;
import org.jboss.errai.ioc.client.api.AfterInitialization;
import org.jboss.errai.ui.client.local.api.IsElement;
import org.jboss.errai.ui.client.widget.HasModel;
import org.jboss.errai.ui.shared.api.annotations.AutoBound;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.ForEvent;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import elemental2.dom.Event;
import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;

@Templated
public class EventCountComponent implements IsElement, HasModel<Counter> {

	@Inject
	@AutoBound
	private DataBinder<Counter> binder;
	
	@Inject
	@DataField("root")
	private HTMLDivElement rootElement;
	
	@Inject
	@Named("span")
	@DataField("element-count")
	@Bound(property = "element")
	private HTMLElement elementCountDisplay;

	@Inject
	@Named("span")
	@DataField("button-count")
	@Bound(property = "button")
	private HTMLElement buttonCountDisplay;
	
	@Inject
	@DataField("count-button")
	private HTMLButtonElement countButton;
	
	private Counter counterInstance = new Counter(0, 0);
	
	@PostConstruct
	protected void constructed() { 
		countButton.innerHTML = "Click me!";
	}
	
	@AfterInitialization
	protected void afterInit() {
		setModel(counterInstance);
	}
	
	@EventHandler("root")
	public void handleRootClick(@ForEvent("click") Event e) {
		getModel().incElementCount();
	}
	
	@EventHandler("count-button")
	public void handleButtonClick(@ForEvent("click") Event e) {
		getModel().incButtonCount();
	}
	
	public Counter getCounterInstance() {
		return counterInstance;
	}
	
	@SuppressWarnings("unchecked")
	public Counter getModelRef() {
		return (Counter) ((BindableProxy<Counter>) binder.getModel()).unwrap();
	}
	
	@Override
	public Counter getModel() {
		return binder.getModel();
	}

	@Override
	public void setModel(Counter model) {
		binder.setModel(model);
	}
}
