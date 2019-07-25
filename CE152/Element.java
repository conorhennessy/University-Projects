package ass;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Element{
    public int atomicNumber;
    public int group;
    public int period;
    public String symbol;
    public String name;
    public double weight;

    public Element(int atomicNumber, String symbol, String name, int group, int period, double weight) {
        this.atomicNumber = atomicNumber;
        this.symbol = symbol;
        this.name = name;
        this.group = group;
        this.period = period;
        this.weight = weight;
    }

    private int getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return String.format("%d, %s, %s, %d, %d, %s", atomicNumber, symbol, name, group, period, String.format("%.3f", weight));
    }

    public static List<Element> readElements() {
        Scanner input = null;
        try {
            URL url = new URL("http://orb.essex.ac.uk/ce/ce152/data/assign/elements.csv");
            input = new Scanner(url.openConnection().getInputStream());
        } catch (IOException e){
            e.printStackTrace();
        }
        input.nextLine(); //Skips header
        List<Element> elementList = new ArrayList<>();
        while(input.hasNextLine()){
            //Create Element object for each row & add to list
            String line = input.nextLine();
            String[] splitted = line.split(",");
            Element element = new Element(Integer.parseInt(splitted[0]), splitted[1], splitted[2], Integer.parseInt(splitted[3]), Integer.parseInt(splitted[4]), Double.parseDouble(splitted[5]));
            elementList.add(element);
        }
        input.close();
        return elementList;
    }

    // Sorting list by using a custom comparator interface and then Collections.sort() with reference to particular one
    public static Comparator<Element> CompareByAtomicNum = new Comparator<Element>() {
        @Override
        public int compare(Element o1, Element o2) {
            return Integer.compare(o1.atomicNumber, o2.atomicNumber);
        }
    };

    public static Comparator<Element> CompareByGroup = new Comparator<Element>() {
        @Override
        public int compare(Element o1, Element o2) {
            int result = Integer.compare(o1.group, o2.group);
            if (result == 0) result = Integer.compare(o1.atomicNumber, o2.atomicNumber);
            return result;
        }
    };

    public static Map<Integer, Set<Element>> elementsByGroup(List<Element> elements){
        //for list of elements, use each element
        //Check if element's group is a key in map
        //if it IS: tempSet becomes what current set is, element is added and then the set is added to map
        //if it is NOT: tempSet is cleared, then element is put into tempSet and this Set is added to the map

        // Note: map is sorted by keys already as Group sorting occurred with the use of Collections.sort()
        Map<Integer, Set<Element>> elementMap = new TreeMap<>();   // Map to be returned
        for (Element element : elements){
            if (!elementMap.containsKey(element.getGroup())){
                Set<Element> tempSet = new TreeSet<>(new Comparator<Element>() { // create temp Set for a group to be added into map
                    @Override
                    public int compare(Element arg0, Element arg1) {
                        return Integer.compare(arg0.atomicNumber, arg1.atomicNumber);
                    }
                });
                tempSet.add(element);
                elementMap.put(element.getGroup(), tempSet);
            }
            else{
                elementMap.get(element.getGroup()).add(element);
            }
        }
        return elementMap;
    }
}