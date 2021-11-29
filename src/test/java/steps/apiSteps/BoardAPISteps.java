package steps.apiSteps;

import endpoints.BoardsEndpoint;
import forms.BaseForm;
import forms.BoardForm;
import io.restassured.response.Response;

public class BoardAPISteps extends BaseApiSteps {
    private Response response;


    public BoardAPISteps getBoardInformation(String boardId){
        response = apiRequests.getRequest(boardId, BoardsEndpoint.GET_BOARD);
        return this;
    }

    public BoardAPISteps createBoard(BoardForm boardForm){
       response = apiRequests.postRequest(boardForm, BoardsEndpoint.CREATE_BOARD);
       return this;
    }

    public BoardAPISteps deleteBoardById(String id) {
        response = apiRequests.deleteRequest(id, BoardsEndpoint.GET_BOARD);
        return this;
    }

    @Override
    public BoardAPISteps assertStatusCode(int httpStatusCode){
        response.then().assertThat().statusCode(httpStatusCode);
        return this;
    }

    @Override
    public String getInformationFromResponse(String parameter){
        return response.jsonPath().get(parameter).toString();
    }

    @Override
    public BaseForm serializeResponseToForm() {
        return response.then().extract().as(BoardForm.class);
    }
}
