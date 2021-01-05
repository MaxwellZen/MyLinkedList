public class MyLinkedList{
  private int size;
  private Node start,end;

  public MyLinkedList() {
    size = 0;
  }

  public int size() {
    return size;
  }

  private Node atindex(int index) {
    int pos = 0;
    Node cur = start;
    while (pos<index) {
      cur = cur.getnext();
      pos++;
    }
    return cur;
  }

  public boolean add(String value) {
    Node n = new Node();
    n.setdata(value);
    n.setprev(end);
    end.setnext(n);
    end = n;
    size++;
    return true;
  }

  public boolean add(int index, String value) {
    Node cur = atindex(index);
    Node toadd = new Node();
    toadd.setdata(value);
    toadd.setnext(cur);
    toadd.setprev(cur.getprev());
    cur.setprev(toadd);
    if (cur.getprev() != null) {
      cur = cur.getprev();
      cur.setnext(toadd);
    }
    size++;
    return true;
  }

  public String get(int index) {
    Node cur = atindex(index);
    return cur.getdata();
  }

  public String set(int index, String value) {
    Node cur = atindex(index);
    String temp = cur.getdata();
    cur.setdata(value);
    return temp;
  }

  public String toString() {
    String ans = "[";
    Node cur = start;
    for (int i = 0; i < size; i++) {
      ans += cur.getdata();
      if (i < size - 1) ans += ", ";
      cur = cur.getnext();
    }
    return ans + "]";
  }
}
