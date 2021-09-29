package com.indianstatescensus;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class
IndianStateCensusAnalyzer {
    public static void main(String[] args) throws CustomizedExceptions {
          String filepath = "C:\\Users\\HP\\Desktop\\BdzJAVA\\IndianStatesCensus\\src\\main\\java\\com\\indianstatescensus\\Files\\StateCensusData.csv";
        IndianStateCensusAnalyzer id = new IndianStateCensusAnalyzer();
    }

    public int getNumberOfRecords(String filePath) throws CustomizedExceptions {
        FileReaderWriter fileReaderWriter = new FileReaderWriter();
        int count = fileReaderWriter.getTotalRecords(filePath);

        return count;
    }

    public boolean delimiterChecker(String filePath) {
        FileReaderWriter fileReaderWriter = new FileReaderWriter();
        boolean flag = fileReaderWriter.checkDelimiter(filePath);
        return flag;
    }

    public  boolean csvHeaderChecker(String filePath) throws IOException, CustomizedExceptions {
        FileReaderWriter fileReaderWriter = new FileReaderWriter();
        ArrayList<String> stringArrayList = new ArrayList<>(Arrays.asList("State","Population","Area","Density"));
        boolean flag = fileReaderWriter.checkCSVHeader(filePath, stringArrayList);
        return flag;
    }

}
