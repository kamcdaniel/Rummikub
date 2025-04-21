import java.util.Scanner;
import java.util.ArrayList;
public class Main {
  
  public static void main(String[] args) {
    play();
  }

  public static void play() {
    Scanner scan = new Scanner(System.in);
    Deck d = new Deck();
    d.shuffle();
    ArrayList <Card> player = new ArrayList <Card>();
    ArrayList <Card> computer = new ArrayList <Card>();
    ArrayList <Group> groups = new ArrayList <Group>();
    for (int i = 0; i < 14; i++) {
      player.add(d.draw());
      computer.add(d.draw());
    }
    int turns = 0;
    Card test1 = new Card(1, "red");
    Card test2 = new Card(2, "red");
    Card test3 = new Card(3, "red");
    Group g1 = new Group(test1, test2, test3, 1, true);
    Card test4 = new Card(1, "blue");
    Card test5 = new Card(2, "blue");
    Card test6 = new Card(3, "blue");
    Group g2 = new Group(test4, test5, test6, 2, true);
    groups.add(g1);
    groups.add(g2);
    while (turns < 10) {
      printBoard(groups);
      printPlayerHand(player);
      scan = new Scanner(System.in);
      System.out.println();
      System.out.print("Would you like to a. play or b. draw? ");
      String opt = scan.next();
      if (opt.equalsIgnoreCase("a")) {
        scan = new Scanner(System.in);
        System.out.print("Do you want to a. create a new group or b. add to an existing group? ");
        String play = scan.next();
        if (play.equalsIgnoreCase("a")) {
          scan = new Scanner(System.in);
          System.out.print("Is this new group comprised of a. same color or b. same number? ");
          String numOrCol = scan.next();
          scan = new Scanner(System.in);
          System.out.print("Which of your cards do you want to add first? (index #) ");
          int a = scan.nextInt();
          Card cA = player.get(a-1);
          scan = new Scanner(System.in);
          System.out.print("Which of your cards do you want to add next? (index #) ");
          int b = scan.nextInt();
          Card cB = player.get(b-1);
          scan = new Scanner(System.in);
          System.out.print("Which of your cards do you want to add last? (index #) ");
          int c = scan.nextInt();
          Card cC = player.get(c-1);
          if (numOrCol.equalsIgnoreCase("a")) {
            Group add = new Group(cA, cB, cC, groups.size()+1, true);
            groups.add(add);
          } else {
            Group add = new Group(cA, cB, cC, groups.size()+1, false);
            groups.add(add);
          }
          player.remove(a-1);
          player.remove(b-2);
          player.remove(c-3);
        } else {
          scan = new Scanner(System.in);
          System.out.print("What group do you want to add to? ");
          int whichGroup = scan.nextInt();
          Group g = groups.get(whichGroup);
          scan = new Scanner(System.in);
          System.out.print("Which of your cards (index #) do you want to add to the group? ");
          int cardNum = scan.nextInt();
          Card add = player.get(cardNum - 1);
          g.add(add);
          player.remove(cardNum);
          printPlayerHand(player);
          System.out.println("TEST");
        }
      } else {
        player.add(d.draw());
      }

      Group g = new Group();
      Group f = new Group();
      sort(computer);
      boolean makeCons = false;
      boolean makeSameNum = false;
      boolean w = false;
      boolean els = false;
      System.out.println("Computer hand: ");
      printPlayerHand(computer);
      while (w == false) {
        for (int i = 0; i < computer.size(); i++) {
          for (int j = 0; j < computer.size(); j++) {
            for (int k = 0; k < computer.size(); k++) {
              if (!w) {
                g = new Group(computer.get(i), computer.get(j), computer.get(k), groups.size(), true);
                f = new Group(computer.get(i), computer.get(j), computer.get(k), groups.size(), false);
                System.out.println("test32");
                if (g.getGroup().get(0) != null) {
                  System.out.println("test1");
                  makeCons = true;
                  groups.add(g);
                  //printBoard(groups);
                  w = true;
                  
                } else if (g.getGroup().get(0) == null && f.getGroup().get(0) != null) {
                  System.out.println("test3");
                  groups.add(f);
                  w = true;
                } else {
                  w = true;
                  els = true;
                  System.out.println("Computer drew");
                }
              }
            }
          }
        }
      }
      //System.out.println("test");
      computer.add(d.draw());
      turns++;
      
    }
    System.out.println("GAME OVER");
    if (player.size() < computer.size()) {
      System.out.println("Player wins");
    } else if (computer.size() < player.size()) {
      System.out.println("Computer wins");
    } else {
      System.out.println("Tie");
    }
  }

  public static void printPlayerHand(ArrayList <Card> hand) {
    for (int i = 0; i < hand.size(); i++) {
      System.out.print("|" + hand.get(i).getNum() + hand.get(i).getColor().substring(0,1).toUpperCase() + "| ");
    }
  }

  public static void printBoard(ArrayList <Group> groups) {
    //System.out.println(groups.size());
    //System.out.println(groups.get(1).getElement(0).getNum());
    for (int i = 0; i < groups.size(); i++) {
       for (int j = 0; j < 13; j++) { //why not just use group.size()? 
         try {
           System.out.print("|" + groups.get(i).getElement(j).getNum() + groups.get(i).getElement(j).getColor().substring(0,1).toUpperCase() + "| ");
           System.out.println();
         } catch (Exception E) {}
      }
      System.out.println();
    }
  }

  public static void sort(ArrayList <Card> hand) {
    ArrayList <Card> red = new ArrayList <Card>();
    ArrayList <Card> blue = new ArrayList <Card>();
    ArrayList <Card> green = new ArrayList <Card>();
    ArrayList <Card> yellow = new ArrayList <Card>();
    for (int i = 0; i < hand.size(); i++) {
      if (hand.get(i).getColor().equals("red")) {
        red.add(hand.get(i));
      } else if (hand.get(i).getColor().equals("blue")) {
        blue.add(hand.get(i));
      } else if (hand.get(i).getColor().equals("green")) {
        green.add(hand.get(i));
      } else if (hand.get(i).getColor().equals("yellow")) {
        yellow.add(hand.get(i));
      }
    } 
  }



}
