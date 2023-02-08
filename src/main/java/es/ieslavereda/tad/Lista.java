package es.ieslavereda.tad;

import java.lang.reflect.Array;

public class Lista<E> {

    private Node<E> head;
    private int size;

    public Lista() {
        this.head = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public E getHead() {
        if (head==null)
            return null;
        return head.getElement();
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
            if (node.getElement().equals(elem))
                return i;
            node = node.getNext();
        }
        return result;
    }

    public E[] asArray(Class<E> c) {

        E[] aux =  (E[]) Array.newInstance(c, size);

        Node<E> n = head;
        int i = 0;
        while (n != null) {
            aux[i] = n.getElement();
            n = n.getNext();
            i++;
        }

        return aux;
    }

    public E remove(int index) {
        E result = null;
        if (isEmpty() || index < 0 || index >= size)
            return result;
        if (index == 0) {
            result = head.getElement();
            head = head.getNext();
        } else {
            Node<E> aux1 = head;
            Node<E> aux2 = head.getNext();
            while (index > 1) {
                aux1 = aux2;
                aux2 = aux2.getNext();
                index--;
            }
            result = aux2.getElement();
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
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        result = node.getElement();
        return result;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public Lista<E> addAll(Lista<E> list) {
        Node<E> node = head;
        for (int i = 0; i < list.size(); i++) {
            add(node.getElement());
            node = node.getNext();
        }
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Lista))
            return false;
        Lista<E> list = (Lista) obj;

        if (list.size() != this.size)
            return false;

        Node<E> aux1 = this.head;
        Node<E> aux2 = this.head;

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
            if (elem.equals(node.getElement()))
                return true;
            node = node.getNext();
        }
        return false;
    }

    private class Node<E> {
            private E element;
            private Node<E> next;

            public Node(){
                this.next= null;
            }

            public Node(E element){
                this.element = element;
                this.next=null;
            }

            public Node<E> getNext() {
                return next;
            }

            public E getElement() {
                return element;
            }

            public void setElement(E element) {
                this.element = element;
            }

            public void setNext(Node<E> next) {
                this.next = next;
            }

            @Override
            public String toString(){
                return element + ((next!=null)?", " + next : " }");
            }

            @Override
            public boolean equals(Object obj){
                if(!(obj instanceof Lista.Node))
                    return false;
                Node<E> node = (Node) obj;
                return node.getElement().equals(element);
            }
        }
}
