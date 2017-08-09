package at.woodstick.erraigwt;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jboss.errai.databinding.client.api.DataBinder;
import org.jboss.errai.ui.client.local.api.IsElement;
import org.jboss.errai.ui.client.widget.HasModel;
import org.jboss.errai.ui.shared.api.annotations.AutoBound;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.user.client.ui.Label;

@Templated(NameSpecInfo.TEMPLATE)
public class NameSpecInfo implements IsElement, HasModel<NameSpec> {

	public static final String TEMPLATE = "/at/woodstick/erraigwt/NameSpecInfo.html";

	@Inject
	@AutoBound
	private DataBinder<NameSpec> binder;
	
	@Inject
	@Bound(property = "name")
	@DataField("namespec")
	private Label nameLabel;
	
	@Inject
	@DataField("namespec-ext")
	private Label nameExtLabel;
	
	@Inject
	@DataField("namespec-const")
	private Label nameConstLabel;

	@PostConstruct
	private void constructed() {
		
	}
	
	@Override
	public NameSpec getModel() {
		return binder.getModel();
	}

	@Override
	public void setModel(NameSpec model) {
		binder.setModel(model);
		
		nameExtLabel.setText(getModel().getExtName());
		nameConstLabel.setText(getModel().getConst());
	}
}
