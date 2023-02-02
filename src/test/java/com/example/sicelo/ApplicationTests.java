package com.example.sicelo;

import com.example.sicelo.persistence.model.Person;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.Optional;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

@SpringBootTest
class ApplicationTests {
	private static final String API_ROOT = "http://localhost:8081/api/books";
	private Person person;
	@BeforeEach
	public Person createNewPerson() {
		return new Person(
				"joe",
				"Doe",
				"epic1@gmail.com",
				"0684791743",
				"9302225626085"
		);
	}

	private String createPersonUri(Person person) {
		Response response = RestAssured.given()
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.body(person)
				.post(API_ROOT);
		return API_ROOT + "/" + response.jsonPath().get("id");
		}
 //Post
	@Test
	void createPersonValid() {
		this.person = createNewPerson();
		//String location = createPersonUri(this.person);

		Response response = RestAssured.given().
				contentType(MediaType.APPLICATION_JSON_VALUE).
				body(this.person)
				.post(API_ROOT);

		Assertions.assertEquals(HttpStatus.CREATED.value(),response.getStatusCode());

	}

}
