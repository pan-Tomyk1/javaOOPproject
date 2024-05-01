public class Node {
    private Node nextElement;

    public short getData() {
        return data;
    }

    public void setData(short data) {
        this.data = data;
    }

    private short data;
    public Node(short data){
        this.data=data;
        this.nextElement=null;
    }

    public Node getNextElement() {
        return nextElement;
    }
    public void setNextElement(Node reference){
        this.nextElement=reference;
    }
}
