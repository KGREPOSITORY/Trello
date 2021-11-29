package tests.APITests.boardTests;


import forms.BoardForm;
import frame.Logger;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.Level;
import org.testng.annotations.Test;

public class CreateAndDeleteBoardTest extends BaseBoardTest {

    @Test(dataProvider = "boardSet", singleThreaded = true)
    public void createBoardTest(BoardForm boardForm){
        Logger.getLogger().log(Level.INFO, "========Start Create Board Test=========");

        Logger.getLogger().info("Create new board");
        boardAPISteps.createBoard(boardForm)
                .assertStatusCode(HttpStatus.SC_OK);

        Logger.getLogger().info("Get board id from response");
        boardForm.setId(boardAPISteps.getInformationFromResponse("id"));

        Logger.getLogger().info("Delete board");
        boardAPISteps.deleteBoardById(boardForm.getId())
                .assertStatusCode(HttpStatus.SC_OK);

        Logger.getLogger().info("Assert that created board was deleted");
        boardAPISteps.getBoardInformation(boardForm.getId())
                .assertStatusCode(HttpStatus.SC_NOT_FOUND);
    }
}
