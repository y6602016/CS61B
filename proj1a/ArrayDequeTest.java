public class ArrayDequeTest {
    public static void addGetRemoveTest() {
        ArrayDeque<String> testing = new ArrayDeque<String>();
        testing.addLast("A");
        testing.addLast("B");
        testing.addLast("C");
        testing.removeFirst();

        System.out.println(testing.get(0));
    }
    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        addGetRemoveTest();
    }
}
