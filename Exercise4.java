package ass;


import java.util.*;

public class Exercise4{
    public static void exercise4a() {
        System.out.println("Part A:");
        Element oxygen = new Element(8, "O", "Oxygen", 16, 2, 15.999);
        System.out.println(oxygen);
    }

    public static void exercise4b(){
        System.out.println("\nPart B:  (First 20 shown)");
        List<Element> elementList = Element.readElements();
        //Print out first 20 elements
        for (int i = 0; i < 20; i++){
            System.out.println(elementList.get(i).toString());
        }
    }

    public static void exercise4c(){
        System.out.println("\nPart C:");
        List<Element> elementList = Element.readElements();
        /// Elements sorted by atomic number
        Collections.sort(elementList, Element.CompareByAtomicNum);
        System.out.println("Sort elements by atomic number... (First 20 shown)");
        for (int i = 0; i < 20; i++){
            System.out.println(elementList.get(i).toString());
        }

        /// Elements sorted by element groups, elements with same group are sorted by atomic number
        Collections.sort(elementList, Element.CompareByGroup);
        System.out.println("\nSort elements by group & if group is the same then sort by atomic number... (First 20 shown)");
        for (int i = 0; i < 20; i++){
            System.out.println(elementList.get(i).toString());
        }
    }

    public static void exercise4d(){
        System.out.println("\nPart D:");
        List<Element> elementList = Element.readElements();
        Collections.sort(elementList, Element.CompareByGroup);
        Map<Integer, Set<Element>> elementMap = Element.elementsByGroup(elementList);
        //invoke method elementsByGroup with element list
        //map is returned
        //then out put first 3 Elements in each set
        for (Integer group : elementMap.keySet()){
            System.out.println("Group "+group+":");
            int i = 0;
            for (Element element : elementMap.get(group)){
                System.out.println(element);
                i++;
                if (i == 3) break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Exercise 4 - Conor Hennessy - ch17811");
        exercise4a();
        exercise4b();
        exercise4c();
        exercise4d();
    }
}