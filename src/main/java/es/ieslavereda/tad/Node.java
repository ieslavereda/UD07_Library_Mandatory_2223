package es.ieslavereda.tad;

class Node<E> {
        private E elem;
        private Node<E> next;

        public Node(){
            this.next= null;
        }

        public Node(E elem){
            this.elem=elem;
            this.next=null;
        }

        public Node<E> getNext() {
            return next;
        }

        public E getElem() {
            return elem;
        }

        public void setElem(E elem) {
            this.elem = elem;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        @Override
        public String toString(){
            return elem + ((next!=null)?", " + next : " }");
        }

        @Override
        public boolean equals(Object obj){
            if(!(obj instanceof Node))
                return false;
            Node<E> node = (Node) obj;
            return (node.getElem().equals(elem));
        }

    }
