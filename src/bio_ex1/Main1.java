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

public class Main1 extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new Main1().setVisible(true);
	}
	
	private Main1() {
		super("Game of life");
		setSize(400, 300);
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
		
		JTextField random = new JTextField(10);
		JLabel randomText = new JLabel();        
		randomText.setText ("Please choose option for random:");
		
		JCheckBox wraparound = new JCheckBox("Wraparound");
		
	    add(sizeText);
		add(size, BorderLayout.PAGE_START);
		add(stepsText);
		add(steps, BorderLayout.CENTER);
		add(waitText);
		add(wait, BorderLayout.PAGE_END);
		add(randomText);
        add(random, BorderLayout.PAGE_END);
        add(wraparound, BorderLayout.PAGE_END);
		add(submit, BorderLayout.PAGE_END);
		
//		theHandler handler = new theHandler();
//		submit.addActionListener(handler);
//		size.addActionListener(handler);
//		steps.addActionListener(handler);
//		wait.addActionListener(handler);
//		wraparound.addActionListener(handler);
//		
//		private class theHandler implements ActionListener {
//			
//			public void actionPerformed(ActionEvent event) {
//				if(event.getSource() == submit) {
//					
//				}
//			}
//		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("hhh");
//		Blinky blink = new Blinky();
		
	}
}
