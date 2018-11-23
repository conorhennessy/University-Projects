import java.util.List;

public class Exercise2 {
    static List<Integer> sharedItems(List<Integer> list1, List<Integer> list2){
        List<Integer> sharedList = null;
        int listSize = list1.size() < list2.size() ? list1.size() : list2.size();
        for (int i = 0; i < listSize; i++){
            if (list1.get(i) == list2.get(i)){
                sharedList.add(list1.get(i));
            }
        }
        return sharedList;
    }

    public static void main(String[] args) {
    
    }
}
