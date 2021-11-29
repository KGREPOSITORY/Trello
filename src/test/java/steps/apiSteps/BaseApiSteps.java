package steps.apiSteps;

import forms.BaseForm;
import frame.api.APIRequests;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import utils.PropertyReader;

public abstract class BaseApiSteps {
   private static final String baseUrl = PropertyReader.getReader("C:\\Users\\anduser\\IdeaProjects\\Trello\\src\\test\\java\\resources\\URLData.properies")
           .getProperty("baceAPIURL");

    private static RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri(baseUrl)
            .addHeader("Authorization", String.format("OAuth oauth_consumer_key=\"%s\", oauth_token=\"%s\"",
                    System.getProperty("APIkey"), System.getProperty("APIToken")))
            .build();

    protected APIRequests apiRequests = new APIRequests(requestSpecification);

    public abstract BaseApiSteps assertStatusCode(int httpStatusCode);

    protected abstract String getInformationFromResponse(String parameter);

    public abstract BaseForm serializeResponseToForm();
}
