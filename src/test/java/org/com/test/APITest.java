package org.com.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.com.base.RestBase;
import org.com.restclient.RestClient;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class APITest extends RestBase {

	RestBase restbase;
	String serviceUrl;
	String apiUrl;
	String url;
	RestClient restClient;

	@BeforeMethod
	public void setup() {
		restbase = new RestBase();
		serviceUrl = prop.getProperty("url");
		apiUrl = prop.getProperty("service_url");
		url = serviceUrl + apiUrl;
	}

	@Test
	public void getTestApi() throws ClientProtocolException, IOException {
		restClient = new RestClient();
		restClient.get(url);
	}
}
