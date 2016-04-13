package bio_ex1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class BoardView extends JFrame {

	private JPanel contentPane;
	private JLabel lblGenerationValue;
	private Board game;
	private boolean wrap_around;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoardView frame = new BoardView(100, 0.5, 250, 1.0, false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BoardView(int board_size, double prob, int step_num, double duration, boolean wraparound) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel info_panel = new JPanel();
		info_panel.setBounds(6, 6, 438, 25);
		contentPane.add(info_panel);
		info_panel.setLayout(null);
		
		JLabel lblGeneration = new JLabel("Generation:");
		lblGeneration.setBounds(0, 6, 72, 16);
		info_panel.add(lblGeneration);
		
		lblGenerationValue = new JLabel("");
		lblGenerationValue.setBounds(77, 6, 61, 16);
		info_panel.add(lblGenerationValue);
		
		JPanel board_panel = new JPanel();
		board_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		board_panel.setBounds(6, 38, 444, 294);
		contentPane.add(board_panel, BorderLayout.CENTER);
		
		game = new Board(board_size, prob);
		wrap_around = wraparound;
		
		BlinkyPane blinky = new BlinkyPane(board_size, step_num, duration);
		
		board_panel.add(blinky);
	}
	
	protected class BlinkyPane extends JPanel {

        private JLabel[] labels;
		private int generationConuter = 0;

        public BlinkyPane(int size, int step_num, double duration) {
        	labels = new JLabel[size * size];
            setLayout(new GridLayout(size, size));
            
        	for (int i = 0; i < labels.length; i++) {
    		    JLabel label = new JLabel();
    		    Color color = Color.WHITE;
           		if (game.isAliveAt(i)) {
        			color = Color.BLACK;
        		}
           		
    		    label.setBackground(color);
    		    label.setOpaque(true);
    		    labels[i] = label;
    		    add(labels[i]);
    		}

            Timer timer = new Timer((int)(duration * 1000), new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	lblGenerationValue.setText(Integer.toString(generationConuter));
                	game.step(generationConuter,wrap_around);
                	generationConuter++;
                	for (int i = 0; i < labels.length; i++) {
                		Color color = Color.WHITE;
                		if (game.isAliveAt(i)) {
                			color = Color.BLACK;
                		}
                		
                		labels[i].setBackground(color);
                		labels[i].setOpaque(true);
            		}
                    repaint();
                }
            });
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.start();
            
            if ((step_num > 0) && (generationConuter > step_num)){
            	timer.stop();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(450, 300);
        }

    }
}
