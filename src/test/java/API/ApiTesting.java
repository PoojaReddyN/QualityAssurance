package API;

import com.epam.utils.ConfigLoader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class ApiTesting {

    RequestSpecification reqSpec;

    @BeforeClass
    public void setUp() {
        String baseURI = ConfigLoader.getProperty("ApiUri");
        reqSpec = new RequestSpecBuilder()
                .setBaseUri(baseURI)
                .setContentType(ContentType.JSON)
                .build();
    }

   // @Test
    public void postMethod() {
        String body = "{\n" +
                "        \"userId\": 1,\n" +
                "        \"id\": 201,\n" +
                "        \"title\": \"put method\",\n" +
                "        \"completed\": false\n" +
                "    }";
        RestAssured.given().spec(reqSpec).body(body)
                .when().post()
                .then().statusCode(201);
    }

    @Test
    public void getMethod(){

        RestAssured
                .given()
                .spec(reqSpec)
                .queryParam("id",1)
                .when()
                .get()
                .then()
                .statusCode(200)
                .body("$", hasSize(1))
                .body("[0].userId", equalTo(1))
                .body("[0].id", equalTo(1))
                .body("[0].title", equalTo("delectus aut autem"))
                .body("[0].completed", equalTo(false))
                .body("[0].userId", instanceOf(Integer.class))
                .body("[0].id", instanceOf(Integer.class))
                .body("[0].title", instanceOf(String.class))
                .body("[0].completed", instanceOf(Boolean.class));
    }

}
