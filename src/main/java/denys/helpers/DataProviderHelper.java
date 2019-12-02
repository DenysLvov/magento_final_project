package denys.helpers;

import lombok.extern.log4j.Log4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * @author DP
 *
 * Reads data from file and creates Object for DataProvider methods in tests Classes 
 */
@Log4j
public class DataProviderHelper {

    private ArrayList<Object[]> obj = new ArrayList<Object[]>();
    private String separator = "\t";

/*
 * FOR DEBUGGING

	 public static void main(String[] args) {
		DataProviderHelper d = new DataProviderHelper();
		d.readTestData("sourcefile.txt");
		} */

    public Object[][] readTestData(String fileName) {
        try {
            fileProcess(fileName);
        } catch (IOException e) {
            log.error("I/O exception"+ e);
        }
        Object[][] newObj = new Object[(obj.size())][obj.get(0).length];		//create Object[][] with length as ArrayList<Object[]> obj
        for(int i=obj.size()-1; i>=0; i--){
            newObj[i] = obj.get(i);
        }

        return newObj;
    }

    // Read line from a file
    private void fileProcess(String fileName) throws IOException{
        File file = new File(System.getProperty("user.dir")+"\\TestData\\"+fileName);
        BufferedReader bufferReader;
        FileReader reader = new FileReader(file);
        bufferReader = new BufferedReader(reader);
        String line =null;
        try {
            while((line=bufferReader.readLine())!=null){
                //System.out.println(line);
                parseLine(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error in read file method. Please check file location.");
        }finally{
            bufferReader.close();
            reader.close();
        }
    }

    //Parse line from a file and compare with value in text field. Show result
    private void parseLine(String line){
        if(line.startsWith("//")){				//ignore comments in testdata file
            return;
        }else{
            Object[] parsedLine = line.split(separator);
            obj.add(parsedLine);
        }
    }
}