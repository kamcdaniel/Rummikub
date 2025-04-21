import java.util.ArrayList;
class Group {

  private int num;
  private ArrayList <Card> group = new ArrayList <Card> ();
  boolean consecutive;

  public Group() {
    num = 0;
    consecutive = true;
    Card c = null;
    group.add(c);
  }

  public Group (Card a, Card b, Card c, int num, boolean consecutive) {
    this.num = num;
    group.add(a);
    group.add(b);
    //group.add(c);
    this.consecutive = consecutive;
    if (consecutive) {
      if (a.getNum() == (b.getNum() - 1) || a.getNum() == (b.getNum() + 1)) {
        if (checkConsecutive(c)) {
          group.add(c);
        } else {
          group.set(0, null);
        }
      } else {
        group.set(0, null);
      }
    } else {
      if (a.getNum() == b.getNum()) {
        if (checkSameNum(c)) {
          group.add(c);
        } else {
          group.set(0, null);
        }
      } else {
        group.set(0, null);
      }
    }
  }

  public boolean checkConsecutive(Card c) {
    boolean b = false;
    if (c.getColor().equals((group.get(0)).getColor())) {
    b = true;
    } 
    if (b && (c.getNum() == (group.get(0).getNum() - 1) || (c.getNum() == (group.get(group.size() - 1).getNum() + 1)))) {
    return true;
    } else {
      return false;
    }
  } 

  public boolean checkSameNum(Card c) {
    boolean b = false;
    if (c.getNum() == group.get(0).getNum()) {
      b = true;
    }
    int sameColor = 0;
    for (int i = 0; i < group.size(); i++) {
      if (c.getColor().equals(group.get(i).getColor())) {
        sameColor++;
      }
    }
    if (b && sameColor == 0) {
      return true;
    } else {
      //cSystem.out.println("Cannot group, try again");
      return false;
    }
  }

  public ArrayList <Card> getGroup() {
    return group;
  }

  public Card getElement(int index) {
    return group.get(index);
  }

  public int getNum() {
    return num;
  }

  public boolean getCons() {
    return consecutive;
  }

  public void add(Card c) {
    if (getCons()) {
      if (checkConsecutive(c)) {
        if (c.getNum() == (group.get(0).getNum() - 1)) {
          group.add(0, c);
        } else {
          group.add(c);
        }
      }
    } else {
      if (checkSameNum(c)) {
        group.add(c);
      }
    }
  } 

}
