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

@Templated(ItemSpecInfo.TEMPLATE)
public class ItemSpecInfo implements IsElement, HasModel<ItemSpec> {

	public static final String TEMPLATE = "/at/woodstick/erraigwt/ItemSpecInfo.html";

	@Inject
	@AutoBound
	private DataBinder<ItemSpec> binder;
	
	@Inject
	@Bound(property = "itemNumber")
	@DataField("item")
	private Label itemLabel;
	
	@PostConstruct
	private void constructed() {
		
	}
	
	@Override
	public ItemSpec getModel() {
		return binder.getModel();
	}

	@Override
	public void setModel(ItemSpec model) {
		binder.setModel(model);
	}
}
