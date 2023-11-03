public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();

        System.out.println("------------------------------");
        System.out.println("初始化测试");
        System.out.println("初始length为");
        System.out.println(arrayDeque.getLength());
        System.out.println("初始size为");
        System.out.println(arrayDeque.size());

        System.out.println("------------------------------");
        System.out.println("一个元素测试“ lucky！ ”");
        arrayDeque.addFirst("lucky!");
        System.out.println("get方法index为0");
        System.out.println(arrayDeque.get(0));
        System.out.println("get方法index为-1和1");
        System.out.println(arrayDeque.get(-1));
        System.out.println(arrayDeque.get(1));
        System.out.println("removeLast删除测试");
        System.out.println(arrayDeque.removeLast());
        System.out.println("size为");
        System.out.println(arrayDeque.size());
        System.out.println("length为");
        System.out.println(arrayDeque.getLength());

        System.out.println("------------------------------");
        System.out.println("多元素200个测试");
        int i = 100;
        while (i-- > 0) {
            arrayDeque.addFirst("fuck");
            arrayDeque.addLast("you");
        }
        System.out.println("length为");
        System.out.println(arrayDeque.getLength());
        System.out.println("size为");
        System.out.println(arrayDeque.size());
        System.out.println("打印结果");
        arrayDeque.printDeque();

        System.out.println("------------------------------");
        System.out.println("删除前后各97个元素");
        i = 97;
        while (i-- > 0) {
            arrayDeque.removeLast();
            arrayDeque.removeFirst();
        }
        System.out.println("length为");
        System.out.println(arrayDeque.getLength());
        System.out.println("size为");
        System.out.println(arrayDeque.size());
        System.out.println("打印结果");
        arrayDeque.printDeque();

    }
}
