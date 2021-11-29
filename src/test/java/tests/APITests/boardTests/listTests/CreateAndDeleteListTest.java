package tests.APITests.boardTests.listTests;

import forms.BoardForm;
import forms.ListForm;
import frame.Logger;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.Level;
import org.testng.annotations.Test;
import steps.apiSteps.BoardAPISteps;


public class CreateAndDeleteListTest extends BaseListTest{

    @Test(dataProvider = "BoardAndEmptyListClass")
    public void createAndDeleteListTest(BoardForm board, ListForm listForm){
        Logger.getLogger().log(Level.INFO,"Create new board for list test");
        listForm.setIdBoard(new BoardAPISteps()
                            .createBoard(board)
                            .assertStatusCode(HttpStatus.SC_OK)
                            .getInformationFromResponse("id"));

        Logger.getLogger().log(Level.INFO,"Create new list");
        ListForm actualList = (ListForm) listApiSteps
                .creteListOnBoard(listForm)
                .assertStatusCode(HttpStatus.SC_OK)
                .serializeResponseToForm();


        Logger.getLogger().log(Level.INFO,"Assert that new list was created correctly");
        assertEquals(listForm.hashCode(),actualList.hashCode());
        assertTrue(listForm.equals(actualList));

        Logger.getLogger().log(Level.INFO,"Archive list");
        listApiSteps
                .archiveList(actualList)
                .assertStatusCode(HttpStatus.SC_OK);

        Logger.getLogger().log(Level.INFO,"Assert that new list is archived");
        assertTrue(listApiSteps.isListClosed(actualList));

        Logger.getLogger().log(Level.INFO,"Delete tested board");
        new BoardAPISteps()
                .deleteBoardById(listForm.getIdBoard())
                .assertStatusCode(HttpStatus.SC_OK) ;
    }
}
