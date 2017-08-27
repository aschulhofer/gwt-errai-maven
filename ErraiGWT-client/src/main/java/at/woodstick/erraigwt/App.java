package at.woodstick.erraigwt;

import javax.annotation.PostConstruct;

import org.jboss.errai.enterprise.client.jaxrs.api.RestClient;
import org.jboss.errai.ioc.client.api.EntryPoint;
import org.jboss.errai.ui.nav.client.local.Navigation;
import org.jboss.errai.ui.nav.client.local.UniquePageRole;
import org.jboss.errai.ui.nav.client.local.api.PageNavigationErrorHandler;
import org.slf4j.Logger;

import com.google.gwt.core.client.GWT;
import com.google.inject.Inject;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
@EntryPoint
public class App {

	@Inject
	private Logger log;
	
	@Inject
	private Navigation navigation;
	
	/**
	 * This is the entry point method.
	 */
	@PostConstruct
	public void onModuleLoad() {

		log.debug("Starting app entrypoint...");
		
		RestClient.setApplicationRoot("rest");
		RestClient.setJacksonMarshallingActive(true);
		
		navigation.setErrorHandler(new PageNavigationErrorHandler() {
			@Override
			public void handleInvalidPageNameError(Exception exception, String pageName) {
				log.error(pageName, exception);
			}

			@Override
			public void handleError(Exception exception, Class<? extends UniquePageRole> pageRole) {
				log.error("", exception);
			}

			@Override
			public void handleInvalidURLError(Exception exception, String urlPath) {
				log.error(urlPath, exception);
			}
		});
		 
		GWT.setUncaughtExceptionHandler(new GWT.UncaughtExceptionHandler() {
			@Override
			public void onUncaughtException(Throwable e) {
				log.error("Uncaught GWT exception!", e);
			}
		});
	}
}
