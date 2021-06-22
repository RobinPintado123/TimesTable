import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Questions {
	
	private int count;
	private String[] words;
	public Questions() {
		count = 0;
		words = new String[6];
	}
	
	public void addQuestion(String e) {
		words[count] = e;
		count++;
	}
	
	public int getCounter() {
		return count;
	}

	public String getWord(int i) {
		return words[i];
	}
	
	public String getAnswer() {
		return words[1];
	}
	
	public String getQuestion() {
		return words[0];
	}
	
	public ArrayList<String> getChoices() {
		
		String []choices = new String[5];
		String []choices1 = new String[5];
		for(int i=0; i < 4; i++) {
			choices[i] = words[i + 2];
		}
		
		
		ArrayList<String> solution = new ArrayList<>();
		for (int i = 0; i < choices.length - 1; i++) {
		    solution.add(choices[i]);
		}
		//Collections.shuffle(solution);
		
		return solution;
	}
	
	public int[] shuffledNumbers() {
		int[] solutionArray = { 0,1, 2, 3};
		shuffleArray(solutionArray);
		 for (int i = 0; i < 4; i++)
	       {
	         System.out.print(solutionArray[i] + " ");
	       }
		return solutionArray;
	}
	
	
	void shuffleArray(int[] ar)
	  {
	    // If running on Java 6 or older, use `new Random()` on RHS here
	    Random rnd = ThreadLocalRandom.current();
	    for (int i = ar.length - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      // Simple swap
	      int a = ar[index];
	      ar[index] = ar[i];
	      ar[i] = a;
	    }
	  }
}
