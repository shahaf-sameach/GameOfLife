package bio_ex1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;

public class Blinky {

    public static void main(String[] args) {
        new Blinky();
    }

    public Blinky() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                }

                JFrame frame = new JFrame("Game of life");
                frame.setBounds(100, 100, 450, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new BlinkyPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

    protected class BlinkyPane extends JPanel {

        private JLabel[] labels = new JLabel[100 * 100];
		private Board game = new Board(100);
		private int generationConuter = 0;

        public BlinkyPane() {
            setLayout(new GridLayout(100, 100));
            
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

            Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	game.step(generationConuter,true);
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
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(450, 300);
        }

    }

}