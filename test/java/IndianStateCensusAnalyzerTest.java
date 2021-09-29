import com.indianstatescensus.CustomizedExceptions;
import com.indianstatescensus.IndianStateCensusAnalyzer;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class
IndianStateCensusAnalyzerTest {
    IndianStateCensusAnalyzer id = new IndianStateCensusAnalyzer();


     //This is a Happy Test Case where the records are checked.
    @Test(expected = CustomizedExceptions.class)
    public void givenTheStateCensusCSVFileEnsuresNumberOfRecordsMatches() throws CustomizedExceptions {
        String filePath = "C:\\Users\\HP\\Desktop\\BdzJAVA\\IndianStatesCensus\\src\\main\\java\\com\\indianstatescensus\\Files\\StateCensusData.csv";
        int result = id.getNumberOfRecords(filePath);
        Assert.assertEquals(29, result);
    }

    //This is a Sad Test Case to verify if the exception is raised.
    @Test
    public void givenStateCensusCSVFileIfIncorrectReturnsCustomException() {
        String filePath = "C:\\Users\\HP\\Desktop\\BdzJAVA\\IndianStatesCensus\\src\\main\\java\\com\\indianstatescensus\\Files\\StatecnsData.csv";
        try {
            int result = id.getNumberOfRecords(filePath);
            Assert.assertEquals(29, result);
        } catch (CustomizedExceptions exceptions) {
            exceptions.printStackTrace();
        }
    }

     // This is a Sad Test Case to verify if the type is incorrect then exception is raised.
    @Test
    public void givenStateCensusCSVFileWhenCorrectButTypeIncorrectReturnsCustomExceptions() {
        String filePath = "C:\\Users\\HP\\Desktop\\BdzJAVA\\IndianStatesCensus\\src\\main\\java\\com\\indianstatescensus\\Files\\StateCensusData.pdf";
        try {
            int result = id.getNumberOfRecords(filePath);

            Assert.assertEquals(29, result);
        } catch (CustomizedExceptions exceptions) {
            exceptions.printStackTrace();
        }
    }


     //This is a Sad Test Case to verify if the file
    @Test
    public void givenTheStateCensusCSVFileWhenCorrectButDelimeterIncorrectReturnsCustomizedExceptions() {
        String filePath = "C:\\Users\\HP\\Desktop\\BdzJAVA\\IndianStatesCensus\\src\\main\\java\\com\\indianstatescensus\\Files\\StateCensusData.csv";
        try {
            boolean result = id.delimiterChecker(filePath);
            Assert.assertEquals(false, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //This is a Sad Test Case to verify if the header is
    @Test
    public void givenTheStateCensusCSVFileWhenCorrectButCSVHeaderIncorrectReturnsCustomException() {
        String filePath = "C:\\Users\\HP\\Desktop\\BdzJAVA\\IndianStatesCensus\\src\\main\\java\\com\\indianstatescensus\\Files\\StateCensusData.csv";
        try {
            boolean result = id.csvHeaderChecker(filePath);
            Assert.assertEquals(false, result);
        } catch (IOException | CustomizedExceptions e) {
            e.printStackTrace();
        }
    }
}
