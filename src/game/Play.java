package game;

public class Play {
		
	public static void main(String[] args) {
		Board game = new Board(100, 0.9);
		
		for(int i = 0 ; i <= 0; i++){
			game.step(i,true);
			System.out.println("generation:" + i);
			game.draw();
		}

	}
}


