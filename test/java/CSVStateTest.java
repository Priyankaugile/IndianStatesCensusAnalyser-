import com.indianstatescensus.CustomizedExceptions;
import com.indianstatescensus.main.CSVState;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class CSVStateTest<CSVStates> {
    CSVState id = null;

    @Test
    public void givenTheStateCensusCSVFileEnsuresNumberOfRecordsMatches() throws CustomizedExceptions {

        String filePath = "C:\\Users\\HP\\Desktop\\BdzJAVA\\IndianStatesCensus\\src\\main\\java\\com\\indianstatescensus\\Files\\StateCode.csv";

        int result = id.getNumberOfRecords(filePath);

        Assert.assertEquals(38, result);
    }


    @Test
    public void givenStateCensusCSVFileIfIncorrectReturnsCustomException() {
        //File Name is Incorrect
        String filePath = "C:\\Users\\HP\\Desktop\\BdzJAVA\\IndianStatesCensus\\src\\main\\java\\com\\indianstatescensus\\Files\\StaCode.csv";

        try {
            int result = id.getNumberOfRecords(filePath);
            Assert.assertEquals(38, result);
        } catch (CustomizedExceptions exceptions) {
            exceptions.printStackTrace();
        }
    }


    @Test
    public void givenStateCensusCSVFileWhenCorrectButTypeIncorrectReturnsCustomExceptions() {
        //File Type is different (.pdf)
        String filePath = "C:\\Users\\HP\\Desktop\\BdzJAVA\\IndianStatesCensus\\src\\main\\java\\com\\indianstatescensus\\Files\\StateCode.pdf";

        try {
            int result = id.getNumberOfRecords(filePath);

            Assert.assertEquals(38, result);
        } catch (CustomizedExceptions exceptions) {
            exceptions.printStackTrace();
        }
    }


    @Test
    public void givenTheStateCensusCSVFileWhenCorrectButDelimeterIncorrectReturnsCustomizedExceptions() {
        String filePath = "C:\\Users\\HP\\Desktop\\BdzJAVA\\IndianStatesCensus\\src\\main\\java\\com\\indianstatescensus\\Files\\StateCode.csv";
        try {
            boolean result = id.delimiterChecker(filePath);
            Assert.assertEquals(false, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void givenTheStateCensusCSVFileWhenCorrectButCSVHeaderIncorrectReturnsCustomException() {
        String filePath = "C:\\Users\\Chaithra\\IdeaProjects\\IndianStateCensusAnalyzer\\src\\main\\java\\org\\example\\Files\\StateCode.csv";
        try {
            boolean result = id.csvHeaderChecker(filePath);
            Assert.assertEquals(false, result);
        } catch (IOException | CustomizedExceptions e) {
            e.printStackTrace();
        }
    }
}
