public class Node{
  private String data;
  private Node next, prev;
  public Node() {
    data = "";
  }
  public String getdata() {
    return data;
  }
  public void setdata(String s) {
    data = s;
  }
  public Node getnext() {
    return next;
  }
  public void setnext(Node onext) {
    next = onext;
  }
  public Node getprev() {
    return prev;
  }
  public void setprev(Node oprev) {
    prev = oprev;
  }
}
