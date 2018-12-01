package linkedlistgeneric;

public class NodeGeneric<D> {
    // Properties
    NodeGeneric<D> next;
    D data;

    // Methods!

    // Constructors
    public NodeGeneric(D newData) {
        data = newData;
        next = null;
    }

    public NodeGeneric(D newData, NodeGeneric newNext) {
        data = newData;
        next = newNext;
    }

    // Getters and Setters


    public D getData() {
        return data;
    }

    public NodeGeneric<D> getNext() {
        return next;
    }

    public void setData(D newData) {
        data = newData;
    }

    public void setNext(NodeGeneric<D> newNode) {
        next = newNode;
    }
}
