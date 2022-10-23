package testClean;

import factoryRequest.FactoryRequest;
import factoryRequest.RequestInfo;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import util.ApiConfiguration;

import static org.hamcrest.Matchers.equalTo;

public class UserTest {

    Response response;
    JSONObject body = new JSONObject();
    String token = null;
    RequestInfo requestInfo = new RequestInfo();


    @Test
    public void verifyCRUDProjectToken() {
        requestInfo.setUrl(ApiConfiguration.TOKEN);
        response = FactoryRequest.make("get").send(requestInfo);
        token = response.then().extract().path("TokenString");


        body.put("FullName", "Mario Ramirez");
        body.put("Email", "marioramirez@gmail.com");
        body.put("Password", "1234567");

        requestInfo.setUrl(ApiConfiguration.CREATE_USER);
        requestInfo.setBody(body.toString());
        requestInfo.setToken(token);
        response = FactoryRequest.make("post").sendToken(requestInfo);
        response.then().body("Email", equalTo(body.get("Email"))).statusCode(200);


        //proyecto
        body.put("Content","Cato2022");
        requestInfo.setUrl(ApiConfiguration.CREATE_PROJECT);
        requestInfo.setBody(body.toString());

        response= FactoryRequest.make("post").send(requestInfo);
        response.then().body("Content",equalTo(body.get("Content"))).statusCode(200);
        int idProj=response.then().extract().path("Id");

        body.put("Content","CatoUpdated2022");
        requestInfo.setUrl(String.format(ApiConfiguration.UPDATE_PROJECT,idProj));
        requestInfo.setBody(body.toString());
        response= FactoryRequest.make("put").send(requestInfo);
        response.then().body("Content",equalTo(body.get("Content"))).statusCode(200);

        requestInfo.setUrl(String.format(ApiConfiguration.READ_PROJECT,idProj));
        requestInfo.setBody(body.toString());
        response= FactoryRequest.make("get").send(requestInfo);
        response.then().body("Content",equalTo(body.get("Content"))).statusCode(200);

        requestInfo.setUrl(String.format(ApiConfiguration.DELETE_PROJECT,idProj));
        requestInfo.setBody(body.toString());
        response= FactoryRequest.make("delete").send(requestInfo);
        response.then().body("Content",equalTo(body.get("Content"))).statusCode(200);

    }
}