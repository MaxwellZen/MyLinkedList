public class Tester {
  public static void main(String[] args) {
    MyLinkedList test = new MyLinkedList();
    String[] datas = {"first", "tird", "fourth", "fifth", "sixth", "eighth", "ninth", "ten"};
    for (int i = 0; i < datas.length; i++) {
      test.add(datas[i]);
    }
    System.out.println(test);
    test.add(1, "second");
    System.out.println(test);
    test.add(6, "seventh");
    System.out.println(test);
    test.set(2, "third");
    System.out.println(test);
    test.set(9, "tenth");
    System.out.println(test);
  }
}
