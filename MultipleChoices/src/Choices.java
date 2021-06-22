import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class Choices {

	private JFrame frame;
	
	private static ArrayList<String> lines = new ArrayList<>();
	private static ArrayList<Questions> q = new ArrayList<>();
	private JPanel answer1;
	
	private JLabel lblAnswer;
	private String answer = "";
	private JRadioButton A, B, C, D;
	private JButton Next;
	private JTextArea txtrQuestion;
	private static String question, ans, a, b, c, d;
	private static boolean start;
	private static int counter = 0;
	private static int[]shuffleQuestions;
	/**
	 * Launch the application.
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		readFileInput("input.txt");
		populateList();

		int[] solutionArray = { 0,1, 2, 3};
		shuffleArray(solutionArray);
		
		 shuffleQuestions = new int[q.size()];
		 for (int i = 0; i < q.size(); i++)
	       {
	         shuffleQuestions[i] = i;
	       }

		 shuffleArray(shuffleQuestions);
			question = q.get(shuffleQuestions[0]).getQuestion();
			
			ans = q.get(shuffleQuestions[0]).getAnswer();
			a = q.get(shuffleQuestions[0]).getChoices().get(solutionArray[0]);
			b = q.get(shuffleQuestions[0]).getChoices().get(solutionArray[1]);
			c = q.get(shuffleQuestions[0]).getChoices().get(solutionArray[2]);
			d = q.get(shuffleQuestions[0]).getChoices().get(solutionArray[3]);
			
		counter++;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Choices window = new Choices();
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
	public Choices() {
		initialize();
	}
	
	public void switchPanels(JPanel panel) {
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//if(start == false)
	
		
		Menu();
		MultipleChoices();

		if(start == true) {
			frame.setVisible(true);
			txtrQuestion.setVisible(true);
			A.setVisible(true);
			B.setVisible(true);
			C.setVisible(true);
			D.setVisible(true);
			Next.setVisible(true);
			lblAnswer.setVisible(true);
		}
		
		
	}
	
	public void Menu() {
		frame = new JFrame();
		frame.setBounds(100, 100, 710, 567);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMenu = new JLabel("Menu", SwingConstants.CENTER);
		lblMenu.setFont(new Font("Times New Roman", Font.BOLD, 44));
		lblMenu.setBounds(110, 31, 464, 62);
		frame.getContentPane().add(lblMenu);
		
		
		
	}
	
	
	public void MultipleChoices() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		txtrQuestion = new JTextArea();
		txtrQuestion.setFont(new Font("Monotype Corsiva", Font.PLAIN, 25));
		txtrQuestion.setText(question);
		txtrQuestion.setBounds(15, 16, 848, 157);
		txtrQuestion.setLineWrap(true);
		txtrQuestion.setEditable(false);
		
		
		//txtrQuestion.disable();
		frame.getContentPane().add(txtrQuestion);
		
		A = new JRadioButton("A.) "  + a);
		A.setFont(new Font("Tahoma", Font.PLAIN, 23));
		A.setBounds(15, 185, 450, 29);
		A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(A.isSelected()) {
					B.setSelected(false);
					C.setSelected(false);
					D.setSelected(false);
				}
			}
		});
		frame.getContentPane().add(A);		
		
	    B = new JRadioButton("B.) "  + b);
		B.setFont(new Font("Tahoma", Font.PLAIN, 23));
		B.setBounds(15, 284, 450, 29);
		B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(B.isSelected()) {
					A.setSelected(false);
					C.setSelected(false);
					D.setSelected(false);
				}
			}
		});
		frame.getContentPane().add(B);
		
		C = new JRadioButton("C.) "  + c);
		C.setFont(new Font("Tahoma", Font.PLAIN, 23));
		C.setBounds(462, 185, 416, 29);
		C.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(C.isSelected()) {
					B.setSelected(false);
					A.setSelected(false);
					D.setSelected(false);
				}
			}
		});
		frame.getContentPane().add(C);
		
		D = new JRadioButton("D.) "  + d);
		D.setFont(new Font("Tahoma", Font.PLAIN, 23));
		D.setBounds(462, 284, 416, 29);
		D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(D.isSelected()) {
					B.setSelected(false);
					C.setSelected(false);
					A.setSelected(false);
				}
			}
		});
		frame.getContentPane().add(D);
	
	
		lblAnswer = new JLabel("Answer: ");
		lblAnswer.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAnswer.setBounds(38, 417, 604, 78);
		frame.getContentPane().add(lblAnswer);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(A.isSelected() == true) {
					lblAnswer.setText("Answer: " + ans);
				}
				else if(B.isSelected() == true ) {
					lblAnswer.setText("Answer: " + ans);
				}
				else if(C.isSelected() == true) {
					lblAnswer.setText("Answer: " + ans);
				}
				else if(D.isSelected() == true) {
					lblAnswer.setText("Answer: " + ans);
				}
			}
		});
		btnNewButton.setBounds(52, 347, 161, 54);
		frame.getContentPane().add(btnNewButton);

		Next = new JButton("Next");
		Next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					lblAnswer.setText("Answer: ");
					A.setSelected(false);
					B.setSelected(false);
					C.setSelected(false);
					D.setSelected(false);
					
					if(counter == q.size())
						counter = 0;
					
					question = q.get(shuffleQuestions[counter]).getQuestion();
					
					ans = q.get(shuffleQuestions[counter]).getAnswer();
					
					int[] solutionArray = { 0,1, 2, 3};
					shuffleArray(solutionArray);
				

					a = q.get(shuffleQuestions[counter]).getChoices().get(solutionArray[0]);
					b = q.get(shuffleQuestions[counter]).getChoices().get(solutionArray[1]);
					c = q.get(shuffleQuestions[counter]).getChoices().get(solutionArray[2]);
					d = q.get(shuffleQuestions[counter]).getChoices().get(solutionArray[3]);
					
					txtrQuestion.setText(question);
					A.setText(a);
					B.setText(b);
					C.setText(c);
					D.setText(d);
					
					
					
					counter++;
			}
		});
		Next.setBounds(439, 347, 161, 54);
		frame.getContentPane().add(Next);	
		
		
		
	}
	
	
	public static void readFileInput(String file) throws FileNotFoundException{
		File f = new File(file);
		Scanner sc = new Scanner(f);
		
		while (sc.hasNext()) {
		    lines.add(sc.nextLine());
		}
	}
	
	
	public static void populateList() {
		Questions question = new Questions();
		for(int i=0; i < lines.size(); i++) {
			if(question.getCounter() < 6) {
			question.addQuestion(lines.get(i));
			System.out.println(question.getCounter());
			}
			
			if(question.getCounter() == 6) {
				q.add(question);
				question = new Questions();
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
