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
    if (size==0) {
      Node n = new Node();
      n.setdata(value);
      start = n;
      end = n;
      size++;
      return true;
    }
    Node n = new Node();
    n.setdata(value);
    n.setprev(end);
    end.setnext(n);
    end = n;
    size++;
    return true;
  }

  public boolean add(int index, String value) {
    if (index<0 || index>size) return false;
    if (index==size) return add(value);
    Node cur = atindex(index);
    Node toadd = new Node();
    toadd.setdata(value);
    toadd.setnext(cur);
    if (index==0) start = cur;
    if (index>0) {
      cur = cur.getprev();
      toadd.setprev(cur);
      cur.setnext(toadd);
    }
    toadd.getnext().setprev(toadd);
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
    while (cur != end) {
      ans += cur.getdata();
      ans += ", ";
      cur = cur.getnext();
    }
    return ans + cur.getdata() + "]";
  //   String ans = "]";
  //   Node cur = end;
  //   while (cur != start) {
  //     ans = ", " + cur.getdata() + ans;
  //     cur = cur.getprev();
  //   }
  //   return "[" + cur.getdata() + ans;
  }
}
