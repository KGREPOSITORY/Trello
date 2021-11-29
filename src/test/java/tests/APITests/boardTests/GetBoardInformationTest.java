package tests.APITests.boardTests;


import org.apache.http.HttpStatus;
import org.apache.logging.log4j.Level;
import org.testng.annotations.Test;

public class GetBoardInformationTest extends BaseBoardTest {

    @Test
    public void getBoardInformationTest(){
        logger.log(Level.INFO, "========Start Get Board Information Test =========");
        boardAPISteps
                .getBoardInformation("GsuEv2MD")
                .assertStatusCode(HttpStatus.SC_OK);
    }
}
