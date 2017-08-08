package at.woodstick.erraigwt.data;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

public class RestMessageTest {
	private static final String REST_MESSAGE = "default-message";
	
	private RestMessage restMessage;
	
	@Before
	public void setup() {
		restMessage = new RestMessage(REST_MESSAGE);
	}
	
	@After
	public void tearDown() {
		restMessage = null;
	}
	
	@Test
	public void message_ctor_shouldBeSetToDefault() {
		final String actualMessage = restMessage.getMsg();
		Assert.assertThat(actualMessage, Matchers.equalTo(REST_MESSAGE));
	}
}
