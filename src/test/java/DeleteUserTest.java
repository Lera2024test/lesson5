import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class DeleteUserTest {
    @Test
    public void testDeleteUser(){
        Map<String, Object> user = new HashMap<>();
        user.put("name", "John");
        user.put("job", "developer");

        Response createUserResponse = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(user)
                .post("https://reqres.in/api/users");

        int userId = createUserResponse.jsonPath().getInt("id");

        Response deletResponse = RestAssured.delete("https://reqres.in/api/users/"+ userId);

        Assert.assertEquals(deletResponse.getStatusCode(), 204);
    }
}
