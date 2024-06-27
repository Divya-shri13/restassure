package package_1;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Day2 {

	@Test

	void testHeaders() {
		given().when().get("https://open-meteo.com/").then().header("Content-Type", "text/html").and()
				.header("Transfer-Encoding", "chunked");

		// .and()
		// .header("Last-Modified","Fri, 13 Oct 2023 14:33:25 GMT");
		// .header("CDN-RequestId","834b87370a637258fcbe4a75691848e4");
	}

	// Getting Value of multiple headers
	@Test
	void getHeaders() {

		Response res = given().when().get("https://open-meteo.com/");
		Headers headers = res.getHeaders();

		for (Header S : headers) {
			System.out.println(S.getName() + "		" + S.getValue());
		}
	}

}
