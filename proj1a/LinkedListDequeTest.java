/** Performs some basic linked list tests. */
public class LinkedListDequeTest {
	
	/* Utility method for printing out empty checks. */
	public static boolean checkEmpty(boolean expected, boolean actual) {
		if (expected != actual) {
			System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Utility method for printing out empty checks. */
	public static boolean checkSize(int expected, int actual) {
		if (expected != actual) {
			System.out.println("size() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Prints a nice message based on whether a test passed. 
	 * The \n means newline. */
	public static void printTestStatus(boolean passed) {
		if (passed) {
			System.out.println("Test passed!\n");
		} else {
			System.out.println("Test failed!\n");
		}
	}

	/** Adds a few things to the list, checking isEmpty() and size() are correct, 
	  * finally printing the results. 
	  *
	  * && is the "and" operation. */
	public static void addIsEmptySizeTest() {
		System.out.println("Running add/isEmpty/Size test.");
		System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

		LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst("front");
		
		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
		passed = checkSize(1, lld1.size()) && passed;
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.addLast("middle");
		passed = checkSize(2, lld1.size()) && passed;

		lld1.addLast("back");
		passed = checkSize(3, lld1.size()) && passed;

		System.out.println("Printing out deque: ");
		lld1.printDeque();

		printTestStatus(passed);

	}

	/** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
	public static void addRemoveTest() {

		System.out.println("Running add/remove test.");

		System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

		LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		// should be empty
		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.removeFirst();
		// should be empty
		passed = checkEmpty(true, lld1.isEmpty()) && passed;

		printTestStatus(passed);

	}
	public static void test_get_and_print(){
		LinkedListDeque<String> linkedListDeque = new LinkedListDeque<>();
		linkedListDeque.addFirst("your");
		linkedListDeque.addFirst("fuck");
		linkedListDeque.addLast("Mama!");
		linkedListDeque.addLast("and");
		linkedListDeque.addLast("you");
		linkedListDeque.addLast("and");
		linkedListDeque.addLast("dad!");
		System.out.println("size测试");
		System.out.println("数组当前大小为："+linkedListDeque.size());
		System.out.println("迭代get");
		System.out.println(linkedListDeque.get(2));
		System.out.println(linkedListDeque.get(6));
		System.out.println("递归get");
		System.out.println(linkedListDeque.getRecursive(2));
		System.out.println(linkedListDeque.getRecursive(5));
		System.out.println("打印测试");
		linkedListDeque.printDeque();
		System.out.println("removeLast测试");
		System.out.println(linkedListDeque.removeLast());
		linkedListDeque.printDeque();
		System.out.println("removeFirst测试");
		System.out.println(linkedListDeque.removeFirst());
		linkedListDeque.printDeque();
		System.out.println("数组当前大小为："+linkedListDeque.size());

		LinkedListDeque<Integer> LinkedListDeque = new LinkedListDeque<>();
		LinkedListDeque.addLast(0);
		LinkedListDeque.addFirst(1);
		LinkedListDeque.addLast(2);
		LinkedListDeque.addLast(3);
		System.out.println(LinkedListDeque.size());


	}

	public static void main(String[] args) {
		System.out.println("Running tests.\n");
		addIsEmptySizeTest();
		addRemoveTest();
		test_get_and_print();
	}
} 