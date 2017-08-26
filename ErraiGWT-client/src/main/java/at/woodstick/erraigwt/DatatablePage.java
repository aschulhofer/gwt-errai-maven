package at.woodstick.erraigwt;

import static elemental2.dom.DomGlobal.console;
import static at.woodstick.erraigwt.interop.JsObjectAccessor.access;

import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jboss.errai.ioc.client.api.AfterInitialization;
import org.jboss.errai.ui.client.local.api.IsElement;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.nav.client.local.PageShowing;
import org.jboss.errai.ui.nav.client.local.PageShown;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.slf4j.Logger;

import at.woodstick.erraigwt.interop.JQuery;
import at.woodstick.erraigwt.interop.JsUtil;
import at.woodstick.erraigwt.interop.datatable.AjaxOptions;
import at.woodstick.erraigwt.interop.datatable.ColumnDefinition;
import at.woodstick.erraigwt.interop.datatable.DatatableUtil;
import at.woodstick.erraigwt.interop.datatable.JQueryDatatableOptions;
import elemental2.core.JsObject;

@Page(path = Pages.Paths.DATATABLE)
@Templated
public class DatatablePage implements IsElement {

	@Inject
	private Logger log;
	
	@Inject 
	@DataField("nav-container")
	private Nav navContainer;
	
	@PostConstruct
	private void constructed() {
		navContainer.init(Arrays.asList(Pages.HOME));
	}

	
	@PageShowing
	private void preparePage() {
		log.debug("Overview page showing");
	}

	@PageShown
	private void showPage() {
		log.debug("Overview page shown");
		
		ColumnDefinition col1 = DatatableUtil.createColumn()
				.className("col-1")
				.orderable(false)
				.data("id")
				;
		
		ColumnDefinition col2 = DatatableUtil.createColumn()
			.className("col-2")
			.data("itemSpec.itemNumber")
			.render(new ColumnDefinition.Render<String>() {
				@Override
				public String render(String data, String type, Object row, Object meta) {
					console.log("render >> ", data, type, row, meta);
					console.log(new JsObject(row));
					console.log(JsUtil.getStringObjectProperty(row, "id"));
					
					String id = access(row).getProperty("id");
					
					return data + " (" + id + ")";
				}
			})
			;
		
		JQueryDatatableOptions options = DatatableUtil.createOptions();
		options.columns = new ColumnDefinition[] {col1, col2};
		
//		options.data = new String[][] {
//			new String[] {"A1", "B1"},
//			new String[] {"A2", "B2"}
//		};
		
//		options.data = new String[][] {
//			new String[] {"A1", "B1"},
//			new String[] {"A2", "B2"}
//		};
		
		AjaxOptions ajaxOptions = DatatableUtil.createAjaxOptions();
		ajaxOptions.url = "rest/items/specs";
		
		options.ajax = ajaxOptions;
		
		options.serverSide = true;
		
		console.log(options);
		
		JQuery.$("#test-datatable").createDatatable(options);
	}
	
	@AfterInitialization
	private void afterInit() {
		
	}
}