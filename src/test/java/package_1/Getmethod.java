package package_1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Getmethod {
	@Test
	public void getRequest() {
		given().when().get("https://reqres.in/api/users?page=2").then().statusCode(200)
				.body("total_pages", equalTo(2), "data[0].first_name", equalToIgnoringCase("Michael")).log().all();
	}
}
