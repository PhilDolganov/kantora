package linkedlistgeneric;



import java.util.LinkedList;

public class LinkedListUSGeneric<D> {

    // Properties
    NodeGeneric<D> head;
    int count;

    // Constructors

//    public LinkedListUS() {
//        head = null;
//        count = 0;
//    }

    public LinkedListUSGeneric(NodeGeneric<D> newHead) {
        head = newHead;
        count = 1;
    }
    // Methods

    //add
    public void add(D newData){
        NodeGeneric<D> temp = new NodeGeneric<>(newData);
        NodeGeneric<D> current = head;
        while (current.getNext()!= null){
            current = current.getNext();
        }
        current.setNext(temp);
        count++;
    }

    //get
    public D get(int index){
//        if (index <= 0){
//            return -1;
//        }
        NodeGeneric<D> current = head;
        for (int i = 1; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    //size
    public int size(){
        return count;
    }
    //isEmpty
    public boolean isEmpty(){
        return head == null;
    }
    //remove
    public void remove(){
        // remove from the back of the list
        NodeGeneric<D> current = head;
        while (current.getNext().getNext() != null){
            current = current.getNext();
        }
        current.setNext(null);
        count--;
    }

    public static void main(String[] args){
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("Alice");
        System.out.println(linkedList);
        linkedList.add("Alicey");
        System.out.println(linkedList);
    }
}
