package bio_ex1;

import java.util.Random;

public class Board {
	private final static int DEF_SIZE = 100;
	private final static double DEF_PROBABILITY = 0.5;

	private int size;
	private boolean[][] board;
	
	public Board(){
		this(DEF_SIZE,DEF_PROBABILITY);
	}
	
	public Board(int size) {
		this(size,DEF_PROBABILITY);
	}
	
	public Board(int size, double prob) {
		this.size = size;
		this.board = new boolean[size][size];
		init(prob);
	}
	
	private void init(double prob){
		for(int i=0; i < size; i++) {
			for(int j=0; j< size; j++) {
				if(getRand() < prob) {
					 board[i][j] = true;
				} else {
					 board[i][j] = false;
				}
			}
		}
	}
	
	private double getRand() {
		Random r = new Random();
		return r.nextDouble();
	}
	
	public void draw() {
		String baordLayout ="";
		for(int i=0; i<this.size; i++) {
			for(int j=0; j<this.size; j++) {
				if(this.board[i][j])
					baordLayout += "[X]";
				else
					baordLayout += "[ ]";
			}
			baordLayout += "\n";
		}
		System.out.println(baordLayout);
	}
	
	public void step(int generation){
		step(generation, false);
	}
	
	public void step(int generation, boolean wrap){
		int step_type = generation % 2;
		for(int i=step_type; i<size-1; i=i+2) {
			for(int j=step_type; j<size-1; j=j+2) {
				Block block = new Block(board[i][j], board[i][j+1], board[i+1][j], board[i+1][j+1]);
				block.step();
				board[i][j] = block.getUpLeft();
				board[i][j+1] = block.getUpRight();
				board[i+1][j] = block.getDownLeft();
				board[i+1][j+1] = block.getDownRight();
			}
		}
		if ((wrap) && (step_type == 1)){
			wrap_step();
		}
	}
	
	private void wrap_step(){
		for(int i=1; i<size-1; i=i+2) {
			Block block = new Block(board[i][size-1], board[i][0], board[i+1][0], board[i+1][size-1]);
			block.step();
			board[i][size-1] = block.getUpLeft();
			board[i][0] = block.getUpRight();
			board[i+1][0] = block.getDownLeft();
			board[i+1][size-1] = block.getDownRight();
		}
		
		for(int j=1; j<size-1; j=j+2) {
			Block block = new Block(board[size-1][j], board[size-1][j+1], board[0][j], board[0][j+1]);
			block.step();
			board[size-1][j] = block.getUpLeft();
			board[size-1][j+1] = block.getUpRight();
			board[0][j] = block.getDownLeft();
			board[0][j+1] = block.getDownRight();
		}
		
		Block block = new Block(board[size-1][size-1], board[size-1][0], board[0][size-1], board[0][0]);
		block.step();
		board[size-1][size-1] = block.getUpLeft();
		board[size-1][0] = block.getUpRight();
		board[0][size-1] = block.getDownLeft();
		board[0][0] = block.getDownRight();
	}
	
	public boolean isAliveAt(int index){
		int i = index / size;
		int j = index % size;
		
		return board[i][j];
	}
				

}
