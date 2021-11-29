package tests.APITests.boardTests.listTests;

import forms.BoardForm;
import forms.ListForm;
import org.testng.annotations.DataProvider;
import steps.apiSteps.ListApiSteps;
import tests.BaseTest;

public class BaseListTest extends BaseTest {
    protected ListApiSteps listApiSteps = new ListApiSteps();

    @DataProvider(name="BoardAndEmptyListClass")
    public Object[][] simpleBoard(){
        return new Object[][]{
           {new BoardForm.Builder().withName("SimpleValidBoard").build(),
                   new ListForm("TestListName", null)}
        };
    }
}
