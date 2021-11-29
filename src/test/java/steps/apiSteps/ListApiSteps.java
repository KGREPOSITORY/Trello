package steps.apiSteps;

import endpoints.ListEndpoint;
import forms.BaseForm;
import forms.ListForm;
import io.restassured.response.Response;


public class ListApiSteps extends BaseApiSteps {
    private Response response;

    public ListApiSteps creteListOnBoard(ListForm listForm) {
        response = apiRequests
                .postRequest(listForm, ListEndpoint.CREATE_LIST);
        return this;
    }

    public ListApiSteps getList (ListForm listForm){
        response = apiRequests
                .getRequest(listForm.getId(), ListEndpoint.GET_LIST);
        return this;
    }

    public ListApiSteps archiveList (ListForm listForm){
        response = apiRequests
                .putRequest(listForm.getId(), ListEndpoint.ARCHIVE_LIST);
        return this;
    }

    public boolean isListClosed(ListForm listForm){
        return  Boolean
                .parseBoolean(getList(listForm)
                .getInformationFromResponse("closed"));
    }

    @Override
    public BaseApiSteps assertStatusCode(int httpStatusCode) {
        response
                .then()
                .assertThat()
                .statusCode(httpStatusCode);
        return this;
    }

    @Override
    public String getInformationFromResponse(String parameter) {
        return response.jsonPath().get(parameter).toString();
    }

    @Override
    public BaseForm serializeResponseToForm() {
        return response.then().extract().as(ListForm.class);
    }
}
