package tests.APITests.boardTests;

import forms.BoardForm;
import org.testng.annotations.DataProvider;
import steps.apiSteps.BoardAPISteps;
import tests.BaseTest;

public class BaseBoardTest extends BaseTest {
    protected BoardAPISteps boardAPISteps = new BoardAPISteps();


    @DataProvider(name = "boardSet")
    public Object[][] boarsSet(){
        return new Object[][]{
                {new BoardForm.Builder()
                        .withName("MandatoryFieldOnly")
                        .build()},
                {new BoardForm.Builder()
                        .withName("WithSeveralOptionalFields")
                        .build()}
        };
    }
}
