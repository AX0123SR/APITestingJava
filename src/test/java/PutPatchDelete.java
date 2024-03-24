import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PutPatchDelete {

    @Test
    public void PutExample()
    {
        JSONObject request = new JSONObject();
        request.put("name","Akshay");
        request.put("Age","28");

        System.out.println(request);
        baseURI = "https://reqres.in";
        given().body(request.toJSONString()).
                when().put("/api/users/2").
                then().statusCode(200).log().all();
    }

    @Test
    public void PatchExample()
    {
        JSONObject request = new JSONObject();
        request.put("name","Akshay");
        request.put("Age","28");

        System.out.println(request);
        baseURI = "https://reqres.in";
        given().body(request.toJSONString()).
                header("Content-type","application/json").contentType(ContentType.JSON).
                when().patch("/api/users/2").
                then().statusCode(200).log().all();
    }

    @Test
    public void DeleteExample()
    {
        baseURI = "https://reqres.in";
        when().
        delete("/api/users/2").
                then().statusCode(204).log().all();
    }


}
