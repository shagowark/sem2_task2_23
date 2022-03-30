import java.util.Objects;

public class Logic {
    public static LinkedList<Integer> getNewSortedList(LinkedList<Integer> list1, LinkedList<Integer> list2) throws Exception{
        checkIfListSorted(list1);
        checkIfListSorted(list2);

        LinkedList<Integer> result = new LinkedList<>();

        int i = 0;
        int j = 0;
        while (list1.size() != 0 || list2.size() != 0){
            if (list2.size() == 0){
                result.addElem(list1, i);
                continue;
            }

            if (list1.size() == 0){
                result.addElem(list2, j);
                continue;
            }

            if (list1.get(i) < list2.get(j)){
                result.addElem(list1, i);
            } else if (Objects.equals(list1.get(i), list2.get(j))){
                result.addElem(list1, i);
                result.addElem(list2, j);
            } else{
                result.addElem(list2, j);
            }
        }

        return result;
    }

    public static void checkIfListSorted(LinkedList<Integer> list) throws Exception{
        list.checkEmptyError();
        int prev = list.get(0);
        for (int i = 1; i < list.size(); i++){
            if (list.get(i) < prev){
                throw new Exception("Unsorted list");
            }
            prev = list.get(i);
        }
    }
}
