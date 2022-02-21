package RestAssuredTest;

import static io.restassured.RestAssured.given;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class PetStoreTestCases {

	String baseURI = "https://petstore.swagger.io/v2";
	String username = "avishek", password ="roy";
	String createdUser="";
	
	
	@Test(description = "Logs user into the system", priority = 0)
    public void getUserLogin() {
        

        Response res=given().when().get(baseURI+"/user/login?username="+username+"&password="+password);
        System.out.println("GET user Login response:"+res.getBody().asString());
    }
	
	
	
	@Test(description = "Create single user", priority = 2)
	public void createSingleUser() throws Exception {
				
		String file = System.getProperty("user.dir")+"/src/test/resources/jsonPayloads/CreatePetUser.json";
        String request_json = new String(Files.readAllBytes(Paths.get(file)));
        System.out.println("Request body passed for POST call: "+request_json);
		
		Response res=given().header("Content-Type", "Application/JSON").body(request_json).post(baseURI+"/user");

		System.out.println("Create single user Response:"+res.getBody().asString());
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	
	@Test(description = "Get user by Username", priority = 3)
    public void getUser() {
        
        Response res=given().when().get(baseURI+"/user/"+username);
        System.out.println("GET user response:"+res.getBody().asString());
        Assert.assertEquals(res.getStatusCode(), 200);
    }
	

	
	@Test(description = "Get unknown user", priority = 3)
    public void getUnknownUser() {
        
        Response res=given().when().get(baseURI+"/user/harry");
        System.out.println("GET unknown user response:"+res.getBody().asString());
        Assert.assertEquals(res.getStatusCode(), 404);
    }
	
	
	@Test(description = "Update user details", priority = 4)
	public void updateSingleUser() throws Exception {
				
		String file = System.getProperty("user.dir")+"/src/test/resources/jsonPayloads/UpdatePetUser.json";
        String request_json = new String(Files.readAllBytes(Paths.get(file)));
        System.out.println("Request body passed for Update User: "+request_json);
		
		Response res=given().header("Content-Type", "Application/JSON").body(request_json).put(baseURI+"/user/"+username);
		//Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println("Update user call response:"+res.getBody().asString());
	}
	
	
	@Test(description = "DELETE existing user", priority = 5)
	public void deleteUser() throws Exception {
		
		Response res=given().header("Content-Type", "Application/JSON").delete(baseURI+"/user/"+username);
		System.out.println("DELETE user call response:"+res.getBody().asString());
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	
	@Test(description = "DELETE unkown user", priority = 5)
	public void deleteinvalidUser() throws Exception {
		
		Response res=given().header("Content-Type", "Application/JSON").delete(baseURI+"/user/harry");
		
		System.out.println("DELETE unknown user call response:"+res.getBody().asString());
		Assert.assertEquals(res.getStatusCode(), 404);
	}
	

	@Test(description = "Create multiple user array", priority = 6)
	public void createMultipleUserArray() throws Exception {
				
		String file = System.getProperty("user.dir")+"/src/test/resources/jsonPayloads/CreateMultiplePetUser.json";
        String request_json = new String(Files.readAllBytes(Paths.get(file)));
        System.out.println("Request body passed for Create multiple array of users: "+request_json);
		
		Response res=given().header("Content-Type", "Application/JSON").body(request_json).post(baseURI+"/user/createWithArray");

		System.out.println("Create multiple array of users Response:"+res.getBody().asString());
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	
	@Test(description = "Create multiple user list", priority = 7)
	public void createMultipleUserList() throws Exception {
				
		String file = System.getProperty("user.dir")+"/src/test/resources/jsonPayloads/CreateMultiplePetUser.json";
        String request_json = new String(Files.readAllBytes(Paths.get(file)));
        System.out.println("Request body passed for Create multiple list of users: "+request_json);
		
		Response res=given().header("Content-Type", "Application/JSON").body(request_json).post(baseURI+"/user/createWithList");

		System.out.println("Create multiple list of users Response:"+res.getBody().asString());
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	
	@Test(description = "Logs out current user", priority = 8)
    public void getUserLogout() {
        		
        Response res=given().when().get(baseURI+"/user/logout");
        System.out.println("GET user logout response:"+res.getBody().asString());
        Assert.assertEquals(res.getStatusCode(), 200);
      
    }
	
	
}
