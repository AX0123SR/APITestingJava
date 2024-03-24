import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class getAndPost {


    @Test
    public void getExample()
    {
        baseURI = "https://reqres.in";
        given().get("/api/users?page=2").
                then().body("data.first_name",hasItems("George","Byron"));

    }

    @Test
    public void postExample()
    {
        JSONObject request = new JSONObject();
        request.put("name","Akash");
        request.put("Age","25");

        System.out.println(request);
        baseURI = "https://reqres.in";
        given().body(request.toJSONString()).
                when().post("/api/users").
                then().statusCode(201).log().all();
    }

}
