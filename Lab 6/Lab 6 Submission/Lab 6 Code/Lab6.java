import java.util.*;
import java.io.*;

public class Lab6 {
    static HashMap<String,Integer> marks = new HashMap<String,Integer>();

    static void results(Map<String, Integer> marksMap){
        // A for loop to iterate over the items in the HashMap and print them in required format
        for (HashMap.Entry<String, Integer> person : marksMap.entrySet()){
            System.out.println(person.getKey() + ": " + person.getValue());
        }

    }

    //Method which takes an argument of type Map<String,Integer> and uses an iterator for the map's values collection to calculate the total of the marks
    // Then return this divided by the lists size
    static Integer average(Map<String, Integer> marksMap){
        Integer sumOfMarks = 0;
        try {

            for (HashMap.Entry<String, Integer> person : marksMap.entrySet()) {
                sumOfMarks += person.getValue();
            }

            return sumOfMarks / marksMap.size();
        }
        catch (Exception e){
            //TODO
        }
    }

    static Map.Entry<String, Integer> highestMark(Map<String, Integer> marksMap) {
        Map.Entry<String, Integer> highestMark = null;
        try {
            for (HashMap.Entry<String, Integer> person : marksMap.entrySet()) {
                if (person.getValue() > highestMark.getValue()) {
                    highestMark = person;
                }
            }
            return highestMark;
        }
        catch (Exception e){
            //TODO
        }
    }



    public static void main(String[] args) {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        boolean more = true;
        while (more) {

            System.out.print("Name: ");
            String name = null;
            try { name = buf.readLine();
            }
            catch (Exception e) {
            }


            System.out.print("Mark: ");
            int mark = 0;
            try {
                mark = Integer.parseInt(buf.readLine().trim());
                if (mark < 0){
                    throw new InvalidNumberException();  //TODO
                }
            }
            catch (InvalidNumberException e) {
                System.out.println("invalid input - using 0");
            }


            System.out.print("More? ");
            try {
                if (buf.readLine().charAt(0)!='y')
                more = false;
            }
            catch (Exception e) {
            }

        }
        // Call the new method instead of printing map directly
        results(marks);
        // call of new average() method to find the average mark and print the result
        System.out.println("Average mark overall: " + average(marks));
        // Call of new highestMark() method to find the entry with the highest mark in the map
        System.out.println("Highest mark: " + highestMark(marks));
    }
}

