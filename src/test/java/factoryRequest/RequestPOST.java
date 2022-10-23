package factoryRequest;

import io.restassured.response.Response;
import util.GetProperties;

import static io.restassured.RestAssured.given;

public class RequestPOST implements IRequest{


    @Override
    public Response send(RequestInfo info) {
        Response response =given()
                .auth()
                .preemptive()
                .basic( GetProperties.getInstance().getUser(),
                      GetProperties.getInstance().getPwd())
                .body(info.getBody())
                .log().all()
                .when()
                .post(info.getUrl());
        response.then().log().all();
        return response;
    }

    @Override
    public Response sendToken(RequestInfo info) {
        Response response =given()
                .auth()
                .preemptive()
                .oauth2(info.getToken())
                .body(info.getBody())
                .log().all()
                .when()
                .post(info.getUrl());
        response.then().log().all();
        return response;

    }
}
