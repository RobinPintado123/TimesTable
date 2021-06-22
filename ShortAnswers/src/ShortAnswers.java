import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ShortAnswers {

	private static ArrayList<String> lines = new ArrayList<>();
	private static ArrayList<String> answer = new ArrayList<>();
	private static ArrayList<String> question = new ArrayList<>();
	private static int[]shuffleQuestions;
	private static JLabel lblNewLabel;
	private static JTextArea textArea;
	private static int counter = 0;
	private JFrame frame;

	/**
	 * Launch the application.
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		readFileInput("input.txt");
		populateArray();
		 shuffleQuestions = new int[question.size()];
		 for (int i = 0; i < question.size(); i++)
	       {
	         shuffleQuestions[i] = i;
	       }
		 shuffleArray(shuffleQuestions);
	
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShortAnswers window = new ShortAnswers();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ShortAnswers() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.setBounds(100, 100, 893, 716);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		
		textArea = new JTextArea();
		textArea.setFont(new Font("Arial", Font.PLAIN, 24));
		textArea.setBounds(15, 16, 841, 123);
		frame.getContentPane().add(textArea);
		textArea.setText(question.get(shuffleQuestions[counter]));
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(35, 283, 800, 58);
		lblNewLabel.setVisible(false);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Check Answer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setText(answer.get(shuffleQuestions[counter]));
				lblNewLabel.setVisible(true);
			}
		});
		btnNewButton.setBounds(35, 219, 215, 58);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Next");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				counter++;
				if(counter == answer.size())
					counter = 0;
				lblNewLabel.setVisible(false);
				textArea.setText(question.get(shuffleQuestions[counter]));
				
			}
		});
		btnNewButton_1.setBounds(508, 216, 221, 65);
		frame.getContentPane().add(btnNewButton_1);
		
		
	}
	
	
	public static void readFileInput(String file) throws FileNotFoundException{
		File f = new File(file);
		Scanner sc = new Scanner(f);
		
		while (sc.hasNext()) {
		    lines.add(sc.nextLine());
		}
	}
	
	public static void populateArray() {
		for(int i = 0; i < lines.size(); i++) {
			if(i%2 == 0) {
				question.add(lines.get(i));
			}else if(i%2 > 0) {
				answer.add(lines.get(i));
			}
		}
	}
	
	
	 // Implementing Fisher–Yates shuffle
	  static void shuffleArray(int[] ar)
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
