package es.ieslavereda.tad;

public class ListLib<E> {

    private Node<E> head;
    private int size;

    public ListLib() {
        this.head = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public Node<E> getHead() {
        return head;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E elem) {
        Node<E> node = new Node<>(elem);
        if (isEmpty()) {
            head = node;
        } else {
            node.setNext(head);
            head = node;
        }
        size++;
    }

    public int search(E elem) {
        int result = -1;
        if (isEmpty())
            return result;
        Node<E> node = head;
        for (int i = 0; i < size; i++) {
            if (node.getElem().equals(elem))
                return i;
            node = node.getNext();
        }
        return result;
    }

    public E[] toArray() {
        E[] vector = (E[]) new Object[size];
        Node<E> node = head;
        for (int i = 0; i < size; i++) {
            vector[i] = (E) node.getElem();
            node = node.getNext();
        }
        return vector;
    }

    public E remove(int index) {
        E result = null;
        if (isEmpty() || index < 0 || index >= size)
            return result;
        if (index == 0) {
            result = head.getElem();
            head = head.getNext();
        } else {
            Node<E> aux1 = head;
            Node<E> aux2 = head.getNext();
            while (index > 1) {
                aux1 = aux2;
                aux2 = aux2.getNext();
                index--;
            }
            result = aux2.getElem();
            aux1.setNext(aux2.getNext());
        }
        size--;
        return result;
    }

    public E get(int index) {
        E result = null;
        if (isEmpty() || index < 0 || index >= size)
            return result;
        Node<E> node = head;
        for (int i = 0; i <= index; i++) {
            node = node.getNext();
        }
        result = node.getElem();
        return result;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public ListLib<E> addAll(ListLib<E> list) {
        Node<E> node = list.getHead();
        for (int i = 0; i < list.size(); i++) {
            add(node.getElem());
            node = node.getNext();
        }
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ListLib))
            return false;
        ListLib<E> list = (ListLib) obj;

        if (list.size() != this.size)
            return false;

        Node<E> aux1 = this.head;
        Node<E> aux2 = list.getHead();

        while (aux1 != null) {
            if (!aux1.equals(aux2))
                return false;
            aux1 = aux1.getNext();
            aux2 = aux2.getNext();
        }
        return true;
    }

    @Override
    public String toString() {
        return "{ size: " + size + ", Element: " + ((head == null) ? "}" : head.toString());
    }

    public boolean contains(E elem) {
        Node<E> node = head;
        for (int i = 0; i < size; i++) {
            if (elem.equals(node.getElem()))
                return true;
            node = node.getNext();
        }
        return false;
    }

}
