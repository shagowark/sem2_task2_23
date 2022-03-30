public class Main {
    public static void main(String[] args) throws Exception{
        new Frame();
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(7);
        list1.add(8);
        list1.add(9);
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        LinkedList<Integer> result = Logic.getNewSortedList(list1, list2);

        for (int i = 0; i < result.size(); i++){
            System.out.println(result.get(i));
        }
    }
}
