package frame.api;

import endpoints.Endpoint;
import forms.Ifrom;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIRequests {

    public APIRequests (RequestSpecification requestSpecification){
        RestAssured.requestSpecification = requestSpecification;
    }

    public Response getRequest(String parameter, Endpoint endpoint){
        return RestAssured
                .given()
                .log().all()
                .get(endpoint.getEndPoint(),parameter);
    }

    public Response postRequest(Ifrom form, Endpoint endpoint){
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(form)
                .log().all()
                .post(endpoint.getEndPoint());

    }

    public Response deleteRequest(String id, Endpoint endpoint){
        return RestAssured
                .given()
                .log().all()
                .delete(endpoint.getEndPoint(), id);
    }

    public Response putRequest(String parameter, Endpoint endpoint){
        return RestAssured
                .given()
                .log().all()
                .put(endpoint.getEndPoint(), parameter);
    }
}
