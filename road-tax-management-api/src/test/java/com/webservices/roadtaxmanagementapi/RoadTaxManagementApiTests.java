package com.webservices.roadtaxmanagementapi;

import java.net.URI;
import java.net.URISyntaxException;

import com.webservices.roadtaxmanagementapi.entities.*;

import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.json.*;  

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RoadTaxManagementApiTests {

    @LocalServerPort
    private int port;

    @Test
    void contextLoads() {
    }

	@Autowired
    private TestRestTemplate restTemplate;

	public static ResponseEntity<String> authenticate(String user, String pass, TestRestTemplate restTemplate) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
		map.add("client_id", "road-tax-management-service");
		map.add("username", user);
		map.add("password", pass);
		map.add("grant_type", "password");
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8180/auth/realms/RoadTaxManagementService/protocol/openid-connect/token", request , String.class );
		return response;
	}

	private <T> ResponseEntity<String> postRequest(T body, String path, String token) throws URISyntaxException {
		URI uri = new URI("http://localhost:" + port + "/" + path);
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "True");
		headers.set("AUTHORIZATION", "Bearer " + token);
		HttpEntity<T> request = new HttpEntity<>(body, headers);
		ResponseEntity<String> response = restTemplate.postForEntity(uri, request, String.class);
		return response;
	}

	@Test
	@Order(1)
	public void authenticateUser() throws URISyntaxException, JSONException {
		ResponseEntity<String> response = authenticate("app-admin", "admin", restTemplate);
		Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
	}
	
	@Test
	@Order(2)
	public void TestAddRegisteredKeeper() throws URISyntaxException, JSONException {
		String token = new JSONObject(authenticate("app-admin", "admin", restTemplate).getBody()).getString("access_token");;
		RegisteredKeepers registeredKeeper = new RegisteredKeepers("ridwan", "chowdhury", "295 the drive", "ig13pn", "07908629217");
		ResponseEntity<String> response = postRequest(registeredKeeper, "registeredkeepers", token);
		Assert.assertEquals(HttpStatus.SC_CREATED, response.getStatusCodeValue());
	}

	@Test
	@Order(3)
	public void TestAddVehicle() throws URISyntaxException, JSONException {
		String token = new JSONObject(authenticate("app-admin", "admin", restTemplate).getBody()).getString("access_token");;
		Vehicles vehicle = new Vehicles("volkswagen", "golf", 2020, "petrol");
		ResponseEntity<String> response = postRequest(vehicle, "vehicles", token);
		Assert.assertEquals(HttpStatus.SC_CREATED, response.getStatusCodeValue());
	}

	@Test
	@Order(4)
	public void TestAddTaxBand() throws URISyntaxException, JSONException {
		String token = new JSONObject(authenticate("app-admin", "admin", restTemplate).getBody()).getString("access_token");;
		TaxBands taxBand = new TaxBands("a", 100, "petrol");
		ResponseEntity<String> response = postRequest(taxBand, "taxbands", token);
		Assert.assertEquals(HttpStatus.SC_CREATED, response.getStatusCodeValue());
	}

	// @Test
	// @Order(3)
	// public void TestGetRegisteredKeeper() throws URISyntaxException, JSONException {
	// 	String token = new JSONObject(authenticate("app-admin", "admin", restTemplate).getBody()).getString("access_token");;
	// 	String uri = "http://localhost:8080/registeredkeepers/1";
    //     ResponseEntity<String> response = postRequest(uri, "registeredkeepers", token);
    //     Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    //     Assert.assertEquals("ridwan", response.getBody().getFirstName());
    //     Assert.assertEquals("chowdhury", response.getBody().getLastName());
    //     Assert.assertEquals("295 the drive", response.getBody().getFirstLineAddress());
	// 	Assert.assertEquals("ig13pn", response.getBody().getPostCode());
	// 	Assert.assertEquals("07908629217", response.getBody().getPhoneNumber());
	// }


}