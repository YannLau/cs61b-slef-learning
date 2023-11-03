public class LinkedListDeque<T> {
    private Node<T> head_item;
    private int size;

    public LinkedListDeque() {
        this.head_item = new Node<>();
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return head_item.getNext() == null && head_item.getLast() == null;
    }

    public void addFirst(T item) {
        if (isEmpty()) {
            Node<T> i = new Node<>(item, head_item, head_item);
            head_item.setNext(i);
            head_item.setLast(i);
        } else {
            Node<T> i = new Node<>();
            i.setItem(item);
            Node<T> temp = head_item.getNext();
            temp.setLast(i);
            i.setNext(temp);
            i.setLast(head_item);
            head_item.setNext(i);
        }
        ++size;
    }

    public void addLast(T t) {
        if (isEmpty()) {
            this.addFirst(t);
            return;
        } else {
            Node<T> i = new Node<>();
            i.setItem(t);
            Node<T> temp = head_item.getLast();
            temp.setNext(i);
            i.setLast(temp);
            i.setNext(head_item);
            head_item.setLast(i);
        }
        ++size;
    }

    public T removeFirst() {
        T t;
        if (this.isEmpty()) {
            return null;
        } else if (this.size == 1) {
            t = head_item.getNext().getItem();
            head_item.setNext(null);
            head_item.setLast(null);
        } else {
            t = head_item.getNext().getItem();
            Node<T> n = head_item.getNext().getNext();
            head_item.setNext(n);
            n.setLast(head_item);
        }
        --size;
        return t;
    }

    public T removeLast() {
        T t;
        if (this.isEmpty()) {
            return null;
        } else if (this.size == 1) {
            return removeFirst();
        } else {
            t = head_item.getLast().getItem();
            Node<T> n = head_item.getLast().getLast();
            head_item.setLast(n);
            n.setNext(head_item);
        }
        --size;
        return t;
    }

    public void printDeque() {
        if (size > 0) {
            for (Node<T> temp = head_item.getNext(); temp != head_item; temp = temp.getNext()) {
                System.out.print(temp.getItem() + " ");
            }
            System.out.println();
        }
    }

    public T get(int index) {
        if (index + 1 <= size && index>=0) {
            Node<T> node = head_item;
            int i = index + 1;
            while (i-- > 0) {
                node = node.getNext();
            }
            if (node != null) {
                return node.getItem();
            }
        }
        return null;
    }

    public T getRecursive(int index) {
        if (index + 1 <= size && index>=0) {
            return recursive_assist(head_item, index + 1);
        }
        return null;
    }

    private T recursive_assist(Node<T> n, int index) {
        if (index == 1) {
            return n.getNext().getItem();
        } else {
            return recursive_assist(n.getNext(), index - 1);
        }
    }

}

class Node<Item> {
    private Item item;
    private Node<Item> next;
    private Node<Item> last;

    public Node() {
        this.item = null;
        this.next = null;
        this.last = null;
    }

    public Node(Item item, Node<Item> last, Node<Item> next) {
        this.item = item;
        this.last = last;
        this.next = next;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Node<Item> getNext() {
        return next;
    }

    public void setNext(Node<Item> next) {
        this.next = next;
    }

    public Node<Item> getLast() {
        return last;
    }

    public void setLast(Node<Item> last) {
        this.last = last;
    }
}
