package testClean;

import factoryRequest.FactoryRequest;
import factoryRequest.RequestInfo;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import util.ApiConfiguration;

import static org.hamcrest.Matchers.equalTo;

public class ProjectTestParametrized {
 /*   Response response;
    JSONObject body= new JSONObject();
    RequestInfo requestInfo = new RequestInfo();
    @ParameterizedTest
    @CsvSource(
            {
                 "eynar,3",
                 "eynar2,4",
                 "eynar3,5"

            }
    )
   / public void verifyCRUDProject(String nameProject,int icon){

        body.put("Content",nameProject);
        body.put("Icon",icon);
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

    }*/

}
