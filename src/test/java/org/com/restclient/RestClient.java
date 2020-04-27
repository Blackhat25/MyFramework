package org.com.restclient;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {

	// Get Method

	public void get(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault(); // http connection
		HttpGet httpget = new HttpGet(url); // http get request
		CloseableHttpResponse httpresponse = httpclient.execute(httpget); // hit the GET url

		int statuscode = httpresponse.getStatusLine().getStatusCode(); // status code
		System.out.println("Status code : " + statuscode);

		String responsestring = EntityUtils.toString(httpresponse.getEntity(), "UTF-8"); // JSON String

		JSONObject responsejson = new JSONObject(responsestring);
		System.out.println("JSON Response from API : " + responsejson);

		Header[] headerarray = httpresponse.getAllHeaders();
		HashMap<String, String> responseheaders = new HashMap<String, String>();
		for (Header head : headerarray) {
			responseheaders.put(head.getName(), head.getValue()); // Converting headers response to Map
		}
		
		System.out.println("Headers response : "+responseheaders);

	}

}
