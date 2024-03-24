import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class TestonLocalAPI {


    @Test
    public void getRequest()
    {
        baseURI="http://localhost:3000";
        given().get("/users").
                then().statusCode(200);
    }

    @Test
    public void postRequest()
    {
        JSONObject request = new JSONObject();
        request.put("first_name","Akhil");
        request.put("last_name","Sharma");
        request.put("subjectId",2);

        baseURI="http://localhost:3000";
        given().contentType(ContentType.JSON).
                body(request.toJSONString()).
                when().post("/users").
                then().statusCode(201).log().all();
    }

    @Test
    public void putRequest()
    {
        JSONObject request = new JSONObject();
        request.put("subjectId",2);

        baseURI="http://localhost:3000";
        given().contentType(ContentType.JSON).
                body(request.toJSONString()).
                when().put("/users/6").
                then().statusCode(200).log().all();
    }


    @Test
    public void patchRequest()
    {
        JSONObject request = new JSONObject();
        request.put("first_name","Milan");
        request.put("last_name","Benji");
        request.put("subjectId",2);

        baseURI="http://localhost:3000";
        given().contentType(ContentType.JSON).
                body(request.toJSONString()).
                when().patch("/users/6").
                then().statusCode(200).log().all();
    }

    @Test
    public void deleteRequest()
    {
        JSONObject request = new JSONObject();
        request.put("subjectId",2);

        baseURI="http://localhost:3000";
        when().delete("/users/4").then().statusCode(200);
    }
}

