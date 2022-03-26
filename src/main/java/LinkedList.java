public class LinkedList<T> {

    private class LinkedListNode {
        public T value;
        public LinkedListNode next;

        public LinkedListNode(T value, LinkedListNode next) {
            this.value = value;
            this.next = next;
        }

        public LinkedListNode(T value) {
            this(value, null);
        }
    }


    private LinkedListNode head = null;
    private LinkedListNode tail = null;
    private int size = 0;


    public void checkEmptyError() throws Exception {
        if (size == 0) {
            throw new Exception("Empty list");
        }
    }

    private LinkedListNode getNode(int index) {
        LinkedListNode curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    public void add(T value) {
        if (size == 0) {
            head = tail = new LinkedListNode(value);
        } else {
            tail.next = new LinkedListNode(value);
            tail = tail.next;
        }
        size++;
    }

    public void remove(int index) throws Exception {
        checkEmptyError();
        if (index < 0 || index >= size) {
            throw new Exception("Incorrect index");
        }
        if (index == 0) {
            head = head.next;
            if (size == 1) {
                tail = null;
            }
        } else {
            LinkedListNode prev = getNode(index - 1);
            prev.next = prev.next.next;
            if (prev.next == null) {
                tail = prev;
            }
        }
        size--;
    }

    public void addElem(LinkedList<T> list, int index) throws Exception{
        if (size == 0){
            tail = list.getNode(index);
            list.remove(index);
            tail.next = null;
            head = tail;
        } else {
            tail.next = list.getNode(index);
            list.remove(index);
            tail.next.next = null;
            tail = tail.next;
        }
        size++;
    }

    public int size() {
        return size;
    }


    public T get(int index) throws Exception {
        checkEmptyError();
        if (index >= size){
            throw new Exception("Index out of bounds");
        }
        return getNode(index).value;
    }

}
