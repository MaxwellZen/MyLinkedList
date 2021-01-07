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
    if (index <= size/2) {
      Node cur = start;
      for (int i = 0; i < index; i++) {
        cur = cur.getnext();
      }
      return cur;
    } else {
      Node cur = end;
      for (int i = size-1; i > index; i--) {
        cur = cur.getprev();
      }
      return cur;
    }
  }

  public boolean add(String value) {
    Node n = new Node();
    n.setdata(value);
    if (size==0) {
      start = n;
    } else {
      n.setprev(end);
      end.setnext(n);
    }
    end = n;
    size++;
    return true;
  }

  public void add(int index, String value) {
    if (index==size) add(value);
    else if (index>=0 && index<size){
      Node cur = atindex(index);
      Node toadd = new Node();
      toadd.setdata(value);
      toadd.setnext(cur);
      toadd.setprev(cur.getprev());
      if (index==0) start = toadd;
      else cur.getprev().setnext(toadd);
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
    if (size==0) return "[]";
    String ans = "[";
    Node cur = start;
    while (cur != end) {
      ans += cur.getdata() + ", ";
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
