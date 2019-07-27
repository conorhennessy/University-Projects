import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class fileInsert {
    public static ArrayList insertFile(Statement statement, File file) {
        ArrayList ordersList = new ArrayList<>();
        //Exercise 2
        String valueStr = "";
        try{
            Scanner scan = new Scanner( file );
            // to read orders_2.txt
            while ( scan.hasNextLine()){
                String currentLine = scan.nextLine();

                valueStr = "(";
                // Form a value string for all the attributes of each entities in the DB
                for (int i = 0; i < currentLine.length() - 1; i++) {

                    char currentChar = currentLine.charAt(i);
                    if (Character.isDigit(currentChar)) {

                        //If the next char is not another number close this attribute with a ,
                        if (!Character.isDigit(currentLine.charAt(i + 1))) {

                            if(currentLine.charAt(i + 1) == '.'){
                                valueStr += currentChar + ".";
                            }
                            else valueStr += currentChar + ", ";
                        }
                        else {
                            valueStr += currentChar;
                        }
                    }
                    if (Character.isLetter(currentChar)) {
                        //If the char is the first found start off with a '
                        if (!Character.isLetter(currentLine.charAt(i - 1))) {
                            valueStr += "'";
                        }
                        //If the next char is not another letter close this attribute with a ',
                        if (!Character.isLetter(currentLine.charAt(i + 1))) {
                            valueStr += currentChar + "', ";
                        }
                        else{
                            valueStr += currentChar;
                        }
                    }
                }
                valueStr += currentLine.charAt(currentLine.length() - 1) + ")";

                ordersList.add(valueStr);
            }
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return ordersList;
    }
}