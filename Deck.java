import java.util.ArrayList;
import java.util.Collections;
class Deck {
  
  private ArrayList <Card> deck = new ArrayList <Card>();

  public Deck() {
    for (int i = 1; i < 14; i++) {
      Card c1 = new Card(i, "red");
      deck.add(c1);
      Card c2 = new Card(i, "red");
      deck.add(c2);
    }
    for (int i = 1; i < 14; i++) {
      Card c1 = new Card(i, "blue");
      deck.add(c1);
      Card c2 = new Card(i, "blue");
      deck.add(c2);
    }
    for (int i = 1; i < 14; i++) {
      Card c1 = new Card(i, "green");
      deck.add(c1);
      Card c2 = new Card(i, "green");
      deck.add(c2);
    }
    for (int i = 1; i < 14; i++) {
      Card c1 = new Card(i, "yellow");
      deck.add(c1);
      Card c2 = new Card(i, "yellow");
      deck.add(c2);
    }
  }

  public void shuffle() {
    Collections.shuffle(deck);
  }

  public ArrayList<Card> getDeck() {
    return deck;
  }

  public Card draw() {
    Card c = deck.get(0); 
    deck.remove(0);
    return c;
  }
  
}
