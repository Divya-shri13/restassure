package package_1;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import static io.restassured.matcher.RestAssuredMatchers.*;
public class Day1 {
	int id;
	@Test(priority = 2)
	public void createUser() {
 
		HashMap data = new HashMap();
		data.put("name", "Manasa");
		data.put("job", "Analyst");
 
		id = given()
				.contentType("application/json")
				.body(data)
 
				.when()
				.post("https://reqres.in/api/users")
				.jsonPath().getInt("id");
 
//		.then()
//			.statusCode(201).log().all();
		//System.out.println(id);
		//System.out.println("User is Created");
 
	}

	
	//----------Using JSON
	@Test
	void createUserUsingJSON() {
		JSONObject js = new JSONObject();
		js.put("name", "AMOGHA");
		js.put("Specification", "Analyst");
		js.put("Phone", "7890123456");
		String coursesArr[] = {"Java", "Selenium", "Manual Testing"};
		js.put("Courses", coursesArr);
			given()
				.contentType("Application/json")
				.body(js.toString())
				
				.when()
				.post("https://reqres.in/api/users")
			.then()
			.statusCode(201)
				.log().all();				
	}

	
		//----------Using POJO
	@Test
	void createUserUsingPOJO() {
		POJO_class cls = new POJO_class();
		cls.setName("Divya");
		cls.setSpecification("Artist");
		cls.setPhone("9012345678");
		String coursesCol[] = {"Violet","Black","Red"};
		cls.setCoursesCol(coursesCol);
		given()
				.contentType("application/json")
				.body(cls)
			.when()
				.post("https://reqres.in/api/users")
			.then()
			.statusCode(201)
				.log().all();
}
	
	@Test
	void createUserUsingExternalFile() throws FileNotFoundException {
	File f = new File(".\\info.json");
	FileReader fr = new FileReader(f);
	JSONTokener jt = new JSONTokener(fr);
	JSONObject data = new JSONObject(jt);
	given()
	.contentType("application/json")
	.body(data.toString())
	.when()
	.post("https://reqres.in/api/users")
	.then()
	.statusCode(201)
	.log().all();
	
	}
	
}


















