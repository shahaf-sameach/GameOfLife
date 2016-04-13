package bio_ex1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class Main {

	private JFrame frame;
	private JTextField txtBoardSize;
	private JTextField txtProb;
	private JTextField txtStepNumber;
	private JTextField txtStepDuration;
	private JCheckBox chckbxWraparound;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("The circle of life");
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(new Color(200,200,200));
		
		
		
		JButton btnRun = new JButton("run");
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int board_size = Integer.parseInt(txtBoardSize.getText());
				double prob = Double.parseDouble(txtProb.getText());
				int step_num = Integer.parseInt(txtStepNumber.getText());
				double duration = Double.parseDouble(txtStepDuration.getText());
				boolean wraparound = chckbxWraparound.isSelected();
				BoardView board_view = new BoardView(board_size, prob, step_num, duration, wraparound);
				board_view.setVisible(true);
			}
		});
		btnRun.setBounds(150, 233, 117, 29);
		frame.getContentPane().add(btnRun);
		
		JLabel lblBoardSize = new JLabel("Board Size:");
		lblBoardSize.setBounds(6, 17, 77, 16);
		frame.getContentPane().add(lblBoardSize);
		
		txtBoardSize = new JTextField();
		txtBoardSize.setBounds(150, 11, 45, 28);
		frame.getContentPane().add(txtBoardSize);
		txtBoardSize.setColumns(10);
		txtBoardSize.setText("100");
		
		JLabel lblFillProb = new JLabel("Init Prob");
		lblFillProb.setBounds(6, 56, 61, 16);
		frame.getContentPane().add(lblFillProb);
		
		txtProb = new JTextField();
		txtProb.setBounds(150, 50, 134, 28);
		frame.getContentPane().add(txtProb);
		txtProb.setColumns(10);
		txtProb.setText("0.5");
		
		JLabel lblStepNo = new JLabel("Step No:");
		lblStepNo.setBounds(6, 104, 61, 16);
		frame.getContentPane().add(lblStepNo);
		
		txtStepNumber = new JTextField();
		txtStepNumber.setText("stepNo");
		txtStepNumber.setBounds(150, 98, 134, 28);
		frame.getContentPane().add(txtStepNumber);
		txtStepNumber.setColumns(10);
		txtStepNumber.setText("-1");
		
		JLabel lblStepDuration = new JLabel("Step Duration");
		lblStepDuration.setBounds(6, 150, 61, 16);
		frame.getContentPane().add(lblStepDuration);
		
		txtStepDuration = new JTextField();
		txtStepDuration.setText("step duration");
		txtStepDuration.setBounds(150, 144, 134, 28);
		frame.getContentPane().add(txtStepDuration);
		txtStepDuration.setColumns(10);
		txtStepDuration.setText("0.5");
		
		chckbxWraparound = new JCheckBox("wraparound");
		chckbxWraparound.setBounds(150, 190, 128, 23);
		frame.getContentPane().add(chckbxWraparound);
		


	}
}
