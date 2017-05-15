import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BlockGame {
	public static void main(String [] args) {
		CardList cardList = new CardList();
		
		Scanner in = null;

		try {
		     in = new Scanner(new File("blocks.in"));
		     String numOfCard = in.nextLine();
		     while (in.hasNext()) {
		    	 String input = in.nextLine();
		    	 String[] array = input.split(" ");
		    	 Card card = new Card(array[0], array[1]);
		    	 cardList.add(card);
		     }
	//	     cardList.listCombination();
		     cardList.calcCombination();
		     cardList.printScore();
		} catch(IOException i) {
		     System.out.println("Error: " + i.getMessage());
		}
	}
}

class CardList {
	final int NUM_CHARACTERS = 26;
	public ArrayList<Card>    _list;   // list of cards
	public ArrayList<Integer> _score;  // number of occurrence of each lower-case character
	
	CardList() {
		_list  = new ArrayList<Card>();
		_score = new ArrayList<Integer>(NUM_CHARACTERS);
		for (int i = 0; i < NUM_CHARACTERS; i++) {
			_score.add(0);
		}
	}
	
	public void add(Card card) {
		_list.add(card);
	}
	
	public ArrayList<String> genCombination(int num) {
		int NUM_CARDS = _list.size();
		ArrayList<String> comb = new ArrayList<String>(NUM_CARDS);
		for (int i = 0; i < NUM_CARDS; i++) {
			comb.add("");
		}
		for (int i = 0; i < NUM_CARDS; i++) {
			int rem = num % 2;
			num = num / 2;
			int pos = (NUM_CARDS-1)-i;
			Card card = _list.get(pos);
			String str = card.get(rem);
			comb.set(pos, str);
		}
	    return comb;
	}
	
	public void listCombination() {
		for (int i = 0; i < (1 << _list.size()) ; i++) {
		   ArrayList<String> comb = genCombination(i);
		   for (int j = 0; j < comb.size(); j++) {
			   String str = comb.get(j);
			   System.out.printf(" %s", str);
		   }
		   System.out.printf("\n");
		}
	}
	
	public void replaceScore(ArrayList<Integer> tmpScore) {
		for (int i = 0; i < NUM_CHARACTERS; i++) {
			if (tmpScore.get(i) > _score.get(i)) {
				_score.set(i, tmpScore.get(i));
			}
		}
	}
	
	public void printScore() {
		for (int i = 0; i < NUM_CHARACTERS; i++) {
			System.out.println(_score.get(i));
		}	
	}
	
	public void calcCombination() {
		for (int i = 0; i < Math.pow(2, _list.size()); i++) {
			ArrayList<String> comb = genCombination(i);
			ArrayList<Integer> tmpScore = new ArrayList<Integer>(NUM_CHARACTERS);
			for (int k = 0; k < NUM_CHARACTERS; k++) {
				tmpScore.add(0);
			}
			for (int j = 0; j < comb.size(); j++) {
				String str = comb.get(j);
				for (int k = 0; k < str.length(); k++) {
					int pos = Character.getNumericValue(str.charAt(k)) - Character.getNumericValue('a');
					int count = tmpScore.get(pos);
					tmpScore.set(pos, count+1);
				}
			}
			replaceScore(tmpScore);
	    }
	}
}

class Card {
	public String _head;
	public String _tail;
	
	public Card(String head, String tail) {
		_head = head;
		_tail = tail;
	}
	
	public String get(int i) {
		return (i == 0) ? _head : _tail;
	}
	
    public void print() {
    	System.out.printf("%s %s\n", _head, _tail);
    }
}