import java.util.*;
import java.io.*;
public class Tester {
  public static void main(String[] args) {
    MyLinkedList test = new MyLinkedList();
    ArrayList<String> cmp = new ArrayList<String>();
    String[] datas = {"second", "tird", "fourth", "fifth", "sixth", "eighth", "ninth", "ten"};
    for (int i = 0; i < datas.length; i++) {
      test.add(datas[i]);
      cmp.add(datas[i]);
    }
    System.out.println(test.toString().equals(cmp.toString()));
    test.add(0, "first");
    cmp.add(0, "first");
    System.out.println(test.toString().equals(cmp.toString()));
      System.out.println(test);
      System.out.println(cmp);
    test.add(6, "seventh");
    cmp.add(6, "seventh");
    System.out.println(test.toString().equals(cmp.toString()));
    test.set(2, "third");
    cmp.set(2, "third");
    System.out.println(test.toString().equals(cmp.toString()));
    test.set(9, "tenth");
    cmp.set(9, "tenth");
    System.out.println(test.toString().equals(cmp.toString()));
  }
}
