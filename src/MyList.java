public class MyList {
    Node head;
    private int counterOfElements;

    MyList() {
        this.head = null;
    }

    public int size() {
        return counterOfElements;
    }

    public void add(short data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNextElement() != null) {
                current = current.getNextElement();
            }
            current.setNextElement(newNode);
        }
        counterOfElements++;
    }

    public short get(int index) {
        if (head == null || index < 0) {
            throw new IllegalArgumentException("Invalid index or empty list");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNextElement();
            if (current == null) {
                throw new IndexOutOfBoundsException("Index out of range");
            }
        }
        return current.getData();
    }

    public void delete(int index) {
        counterOfElements--;
        if (head == null || index < 0) {
            throw new IllegalArgumentException("Invalid index or empty list");
        }
        if (index == 0) {
            head = head.getNextElement();
            return;
        }
        Node prev = null;
        Node current = head;
        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.getNextElement();
            if (current == null) {
                throw new IndexOutOfBoundsException("Index out of range");
            }
        }
        prev.setNextElement(current.getNextElement());
    }

    public MyList findMultiples(short number) {
        short element;
        MyList multiples = new MyList();
        for (int i = 0; i < this.size(); i++) {
            element = this.get(i);
            if (element % number == 0) {
                multiples.add(element);
            }
        }
        return multiples;
    }

    public void replaceEvenPositionElementsWithZero() {
        for (int i = 0; i < this.size(); i++) {
            if (i % 2 != 0) {
                this.set(i, (short) 0);
            }
        }
    }

    public void set(int index, short value) {
        if (head == null || index < 0) {
            throw new IllegalArgumentException("Invalid index or empty list");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNextElement();
            if (current == null) {
                throw new IndexOutOfBoundsException("Index out of range");
            }
        }
        current.setData((value));
    }

    public MyList getValuesGreaterThanThreshold(short number) {
        short element;
        MyList list = new MyList();
        for (int i = 0; i < this.size(); i++) {
            element = this.get(i);
            if (element > number) {
                list.add(element);
            }
        }
        return list;
    }
    public void deleteElementsAtNonEvenPositions(){
        for (int i = this.size()-1; i >=0; i--) {
            if(i%2==0){
                this.delete(i);
            }
        }
    }
    public void printList(){
        System.out.print("[  ");
        for (int i = 0; i < this.size(); i++) {
            System.out.print(this.get(i)+" ");
        }
        System.out.println("]");
    }
}
