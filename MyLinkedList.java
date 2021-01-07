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
    Node cur = start;
    for (int i = 0; i < index; i++) {
      cur = cur.getnext();
    }
    return cur;
  }

  public boolean add(String value) {
    if (size==0) {
      Node n = new Node();
      n.setdata(value);
      start = n;
      end = n;
      size++;
      return true;
    } else {
      Node n = new Node();
      n.setdata(value);
      n.setprev(end);
      end.setnext(n);
      end = n;
      size++;
      return true;
    }
  }

  public void add(int index, String value) {
    if (index<0 || index>size) {}
    else if (index==size) {add(value);}
    else {
      Node cur = atindex(index);
      Node toadd = new Node();
      toadd.setdata(value);
      toadd.setnext(cur);
      toadd.setprev(cur.getprev());
      if (index==0) start = toadd;
      if (index>0) cur.getprev().setnext(toadd);
      cur.setprev(toadd);
      size++;
    }
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
    while (cur != end) {
      ans += cur.getdata();
      ans += ", ";
      cur = cur.getnext();
    }
    return ans + cur.getdata() + "]";
  //   Node cur = end;
  //   while (cur != start) {
  //     ans = ", " + cur.getdata() + ans;
  //     cur = cur.getprev();
  //   }
  //   return "[" + cur.getdata() + ans;
  }
}
