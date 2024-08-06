import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetUsersTest {
    @Test
    public void testGetUsers(){
        Response response = RestAssured.get("https://reqres.in/api/users?page=1");

        Assert.assertEquals(response.getStatusCode(), 200);
        int userCount = response.jsonPath().getList("data").size();
        Assert.assertTrue(userCount > 0, "User count should be greater than 0");
    }
}
