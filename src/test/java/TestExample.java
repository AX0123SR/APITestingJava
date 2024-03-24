import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestExample {

    @Test
    public void tc01() {
        Response res = get("https://reqres.in/api/users?page=2");
        System.out.println(res.getStatusCode());
        System.out.println(res.getTime());
        System.out.println(res.getBody().asString());
        System.out.println(res.getHeader("content-type"));

        int code = res.getStatusCode();
        Assert.assertEquals(code,200);
    }


    @Test
    public void tc02()
    {
        baseURI = "https://reqres.in";
        given().get("/api/users?page=2").
                then().statusCode(200).
                body("data[1].id",equalTo(8));
    }


}
