public class MyList2 {
    Node head;
    int counterOfElements;
    MyList2() {
    this.head=null;
    }
    public void add(short val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNextElement() != null) {
                current.setNextElement(current.getNextElement());
            }
            current.setNextElement(newNode);
        }
    }
    public void delete(int val) {
        if (head == null) {
            return; // Список порожній, немає чого видаляти
        }
        if (head.getData() == val) {
            head = head.getNextElement(); // Видаляємо перший елемент
            return;
        }
        Node prev = head;
        Node current = head.getNextElement();
        while (current != null) {
            if (current.getData() == val) {
                prev.setNextElement(current.getNextElement()); // Пропускаємо поточний вузол
                return;
            }
            prev = current;
            current= current.getNextElement();
        }
    }

}
