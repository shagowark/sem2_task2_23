import java.util.Objects;

public class Logic {
    public static LinkedList<Integer> getNewSortedList(LinkedList<Integer> list1, LinkedList<Integer> list2) throws Exception{
        checkIfListSorted(list1);
        checkIfListSorted(list2);

        if (list2.size() > list1.size()){
            LinkedList<Integer> temp = list1;
            list1 = list2;
            list2 = temp;
        }
        LinkedList<Integer> result = new LinkedList<>();

        int i = 0;
        int j = 0;
        while (list1.size() != 0){
            if (list2.size() == 0){
                result.add(list1.get(i));
                list1.remove(i);
                continue;
            }

            if (list1.get(i) < list2.get(j)){
                result.add(list1.get(i));
                list1.remove(i);
            } else if (Objects.equals(list1.get(i), list2.get(j))){
                result.add(list1.get(i));
                result.add(list2.get(j));
                list1.remove(i);
                list2.remove(j);
            } else{
                result.add(list2.get(j));
                list2.remove(j);
            }
        }

        while (list2.size() != 0){
            result.add(list2.get(j));
            list2.remove(j);
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
