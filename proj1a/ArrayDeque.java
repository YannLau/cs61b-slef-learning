public class ArrayDeque<Item> {
    private int length = 8;
    private Item[] items = (Item[]) (new Object[8]);
    private int size = 0;
    private int front = 0;
    private int rear = 0;

    public ArrayDeque() {

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private boolean isFull() {
        return size == length;
    }

    private void multiLen() {
        int new_length = (length * 2);
        change_length(new_length);
    }

    private void reduce_the_length() {
        int new_length = length / 2;
        change_length(new_length);
    }

    private void change_length(int new_length) {
        Item[] new_items = (Item[]) (new Object[new_length]);
        for (int i = 0; i < size; ++i) {
            new_items[i] = get(i);
        }
        length = new_length;
        rear = size;
        front = length - 1;
        items = new_items;
    }

    public void addFirst(Item item) {
        if (isFull()) {
            this.multiLen();
        }
        if (isEmpty()) {
            items[front] = item;
            front = (front + length - 1) % length;
            ++size;
            rear = (rear + 1 + length) % length;
        } else {
            items[front] = item;
            front = (front + length - 1) % length;
            ++size;
        }
    }

    public void addLast(Item item) {
        if (isFull()) {
            this.multiLen();
        }
        if (isEmpty()) {
            addFirst(item);
        } else {
            items[rear] = item;
            rear = (rear + length + 1) % length;
            ++size;
        }
    }

    public Item get(int index) {
        if (index + 1 <= size && index>=0) {
            return items[(length + front + index + 1) % length];
        }
        return null;
    }

    public Item removeLast() {
        if (!isEmpty()) {
            rear = (rear + length - 1) % length;
            --size;
            if(size==0){
                front=rear;
            }
            Item temp = items[rear];
            if (isSmallerThan25()) {
                reduce_the_length();
            }
            return temp;
        } else {
            return null;
        }
    }

    public Item removeFirst() {
        if (!isEmpty()) {
            front = (front + 1 + length) % length;
            --size;
            if(size==0){
                rear=front;
            }
            Item temp = items[front];
            if (isSmallerThan25()) {
                reduce_the_length();
            }
            return temp;
        } else {
            return null;
        }
    }

    private boolean isSmallerThan25() {
        return (size / (double) length) <= 0.25 && length>8;
    }

    public void printDeque() {
        if (size > 0) {
            for (int i = 0; i < size; ++i) {
                System.out.print(get(i)+" ");
            }
            System.out.println();
        }
    }

    public int getLength(){
        return length;
    }
}
