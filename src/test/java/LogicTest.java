import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogicTest {
    LogicTest(){

    }

    @Test
    void test1() throws Exception{
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(7);
        list1.add(8);
        list1.add(9);
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        LinkedList<Integer> result = Logic.getNewSortedList(list1, list2);

        LinkedList<Integer> assertList = new LinkedList<>();
        assertList.add(4);
        assertList.add(5);
        assertList.add(6);
        assertList.add(7);
        assertList.add(8);
        assertList.add(9);

        for (int i = 0; i<assertList.size(); i++){
            assertEquals(assertList.get(i), result.get(i));
        }
        assertEquals(0, list1.size());
        assertEquals(0, list2.size());
    }

    @Test
    void test2() throws Exception{
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(2);
        list1.add(2);
        list1.add(9);
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        LinkedList<Integer> result = Logic.getNewSortedList(list1, list2);

        LinkedList<Integer> assertList = new LinkedList<>();
        assertList.add(2);
        assertList.add(2);
        assertList.add(4);
        assertList.add(5);
        assertList.add(6);
        assertList.add(9);

        for (int i = 0; i<assertList.size(); i++){
            assertEquals(assertList.get(i), result.get(i));
        }
        assertEquals(0, list1.size());
        assertEquals(0, list2.size());
    }

    @Test
    void test3() throws Exception{
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(1);
        list1.add(1);
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(1);
        list2.add(1);
        list2.add(1);
        LinkedList<Integer> result = Logic.getNewSortedList(list1, list2);

        LinkedList<Integer> assertList = new LinkedList<>();
        assertList.add(1);
        assertList.add(1);
        assertList.add(1);
        assertList.add(1);
        assertList.add(1);
        assertList.add(1);

        for (int i = 0; i<assertList.size(); i++){
            assertEquals(assertList.get(i), result.get(i));
        }
        assertEquals(0, list1.size());
        assertEquals(0, list2.size());
    }

    @Test
    void test4() throws Exception{
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(3);
        list1.add(7);
        list1.add(9);
        list1.add(10);
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        LinkedList<Integer> result = Logic.getNewSortedList(list1, list2);

        LinkedList<Integer> assertList = new LinkedList<>();
        assertList.add(1);
        assertList.add(1);
        assertList.add(2);
        assertList.add(3);
        assertList.add(3);
        assertList.add(7);
        assertList.add(9);
        assertList.add(10);

        for (int i = 0; i<assertList.size(); i++){
            assertEquals(assertList.get(i), result.get(i));
        }
        assertEquals(0, list1.size());
        assertEquals(0, list2.size());
    }

    @Test
    void test5() throws Exception{
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(3);
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(1);
        list2.add(3);
        list2.add(3);
        LinkedList<Integer> result = Logic.getNewSortedList(list1, list2);

        LinkedList<Integer> assertList = new LinkedList<>();
        assertList.add(1);
        assertList.add(1);
        assertList.add(3);
        assertList.add(3);
        assertList.add(3);


        for (int i = 0; i<assertList.size(); i++){
            assertEquals(assertList.get(i), result.get(i));
        }
        assertEquals(0, list1.size());
        assertEquals(0, list2.size());
    }
}