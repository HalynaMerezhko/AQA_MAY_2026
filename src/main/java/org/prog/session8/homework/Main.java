package org.prog.session8.homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args){

    }

    private static void IsReadyToRead(String fileName){
        FileReader fileReader = null;
        try{
            fileReader = new FileReader(fileName);
            boolean isFileReady = fileReader.ready();
            if (isFileReady){
                System.out.println("File is ready for reading");
            }
            else{
                System.out.println("File is not ready for reading");
            }
        }
        catch(FileNotFoundException exception){
            System.out.println("File was not found");
        }
        catch(Exception exception){
            System.out.println("Something else went wrong");
        }
        finally{
            try{
                fileReader.close();
            }
            catch(Exception exception){
                System.out.println("File Reader was not closed");
            }
        }
    }
}