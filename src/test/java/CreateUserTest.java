import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class CreateUserTest {
    @Test
    public void testCreateUser(){
        Map<String,Object> user = new HashMap<>();
        user.put("name", "John");
        user.put("job", "developer");

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(user)
                .post("https://reqres.in/api/users");

        Assert.assertTrue(response.getStatusCode(), 201);
        String name = response.jsonPath().getString("name");
        Assert.assertEquals(name, "John");

    }
}
