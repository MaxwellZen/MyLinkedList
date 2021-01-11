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

  public boolean add(String value){
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

  public void add(int index, String value) throws IndexOutOfBoundsException {
    if (index<0 || index>size) {
      throw new IndexOutOfBoundsException("index cannot be " + index);
    }
    if (index==size) add(value);
    else {
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

  public String get(int index) throws IndexOutOfBoundsException {
    if (index<0 || index>=size) {
      throw new IndexOutOfBoundsException("index cannot be " + index);
    }
    Node cur = atindex(index);
    return cur.getdata();
  }

  public String set(int index, String value) throws IndexOutOfBoundsException {
    if (index<0 || index>=size) {
      throw new IndexOutOfBoundsException("index cannot be " + index);
    }
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

  public String toStringReversed() {
    if (size==0) return "[]";
    String ans = "[";
    Node cur = end;
    while (cur != start) {
      ans += cur.getdata() + ", ";
      cur = cur.getprev();
    }
    return ans + cur.getdata() + "]";
  }

  public String remove (int index) throws IndexOutOfBoundsException{
    if (index<0 || index>=size) {
      throw new IndexOutOfBoundsException("index cannot be " + index);
    }
    Node cur = atindex(index);
    String ans = cur.getdata();
    if (index>0) cur.getprev().setnext(cur.getnext());
    else {
      if (size>1) start.getnext().setprev(null);
      start = start.getnext();
    }
    if (index<size-1) cur.getnext().setprev(cur.getprev());
    else {
      if (size>1) end.getprev().setnext(null);
      end = end.getprev();
    }
    size--;
    return ans;
  }

  public void extend (MyLinkedList other) {
     if (size==0) {
          start = other.start;
     } else if (other.size>0) {
          end.setnext(other.start);
          other.start.setprev(end);
     }
     end = other.end;
    size += other.size;
    other.start = null;
    other.end = null;
    other.size = 0;
  }

}
