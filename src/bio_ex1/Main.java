package bio_ex1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Main extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new Main().setVisible(true);
	}
	
	private Main() {
		super("Game of life");
		setSize(600, 600);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(this);
		JTextField size = new JTextField(10);
		JLabel sizeText = new JLabel();        
		sizeText.setText ("Please choose size of board:");
		
		JTextField steps = new JTextField(10);
		JLabel stepsText = new JLabel();        
		stepsText.setText ("Please choose number of steps:");
		
		JTextField wait = new JTextField(10);
		JLabel waitText = new JLabel();        
		waitText.setText ("Please choose time for wait:");
		
		JCheckBox wraparound = new JCheckBox("Wraparound");
        add(wraparound);
		
		add(submit, BorderLayout.PAGE_END);
	    add(sizeText);
		add(size, BorderLayout.NORTH);
		add(stepsText);
		add(steps, BorderLayout.CENTER);
		add(waitText);
		add(wait, BorderLayout.CENTER);
		
//		int sizeOfBoard = Integer.parseInt(size.getText());
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Hello");
		
	}
}
