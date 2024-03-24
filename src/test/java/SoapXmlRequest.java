import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SoapXmlRequest {

    @Test
    public void validateSoapRequest() throws IOException {

        File file =  new File("C:/Users/Ayush Srivastava/IdeaProjects/APITestingJava/src/test/SoapRequest/soap.xml");
        if(file.exists())
            System.out.println(">>> File exists");
        FileInputStream fi = new FileInputStream(file);
        String requestBody = IOUtils.toString(fi,"UTF-8");

        baseURI = "https://webservices.daehosting.com/";
        given().contentType("text/xml").accept(ContentType.XML).
                body(requestBody).
                when().post("services/isbnservice.wso?op=IsValidISBN13").then().statusCode(200).log().all();

    }
}
