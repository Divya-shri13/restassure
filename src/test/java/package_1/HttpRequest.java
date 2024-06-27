package package_1;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HttpRequest {

	int id;

	@Test(enabled=true,priority = 1)
	public void getUsers() {

		System.out.println("--------------------------------");
		
		given()

				.when().get("https://reqres.in/api/users?page=2")

				.then().statusCode(200).body("page", equalTo(2)).log().all();
		System.out.println("-------------------------------------");

	}

	@Test(priority = 2)
	public void createUser() {

		HashMap data = new HashMap();
		data.put("name", "John");
		data.put("job", "leader");

		id = given().contentType("application/json").body(data)

				.when().post("https://reqres.in/api/users").jsonPath().getInt("id");

//		.then()
//			.statusCode(201).log().all();
		System.out.println(id);
		System.out.println("--------------------------");

	}
	
	@Test(priority=3, dependsOnMethods= {"createUser"})
	public void updateUser() {
		HashMap data = new HashMap();
		data.put("name", "John");
		data.put("job", "politician");
		
		given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.put("https://reqres.in/api/users/"+id)
		
		.then().statusCode(200).log().all();
		System.out.println("-------------------------------");
		
	}
	
	@Test(enabled=true,priority=4,dependsOnMethods= {"updateUser"})  
	public void deleteUser() {
		given()
		
		.when().delete("https://reqres.in/api/users/"+id)
		
		.then().statusCode(204).log().all();
		System.out.println("User Record Deleted");
		;
	}

}
