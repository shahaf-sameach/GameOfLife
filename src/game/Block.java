package game;


public class Block {
	
	private boolean upLeft;
	private boolean upRight;
	private boolean downLeft;
	private boolean downRight;
	
	
	public Block(boolean upLeft, boolean upRight, boolean downLeft,
			boolean downRight) {
		this.upLeft = upLeft;
		this.upRight = upRight;
		this.downLeft = downLeft;
		this.downRight = downRight;
	}
	
	public Block(Block block){
		this.upLeft = block.getUpLeft();
		this.upRight = block.getUpRight();
		this.downLeft = block.getDownLeft();
		this.downRight = block.getDownRight();
	}

	public boolean getUpLeft() {
		return upLeft;
	}

	public void setUpLeft(boolean upLeft) {
		this.upLeft = upLeft;
	}

	public boolean getUpRight() {
		return upRight;
	}


	public void setUpRight(boolean upRight) {
		this.upRight = upRight;
	}


	public boolean getDownLeft() {
		return downLeft;
	}


	public void setDownLeft(boolean downLeft) {
		this.downLeft = downLeft;
	}


	public boolean getDownRight() {
		return downRight;
	}


	public void setDownRight(boolean downRight) {
		this.downRight = downRight;
	}
	
	public void step(){
		int count = this.getLiveNumber();
		if((count==0)||(count==1)||(count==4)) {
			this.replaceCreature();
		}
		if(count==3) {
			this.replaceCreature();
			this.rotateBlock();
		}
	}
	
	private int getLiveNumber(){
		int count = 0;
		if(this.getUpLeft())
			count++;
		if(this.getUpRight())
			count++;
		if(this.getDownLeft())
			count++;
		if(this.getDownRight())
			count++;
		return count;
	}
	
	private void replaceCreature(){
		this.setUpLeft(!(this.getUpLeft()));
		this.setUpRight(!(this.getUpRight()));
		this.setDownLeft(!(this.getDownLeft()));
		this.setDownRight(!(this.getDownRight()));
	}
	
	private void rotateBlock() {
		Block tmpBlock = new Block(this);

		this.setUpLeft(tmpBlock.getDownRight());
		this.setDownRight(tmpBlock.getUpLeft());
		this.setUpRight(tmpBlock.getDownLeft());
		this.setDownLeft(tmpBlock.getUpRight());
	}
	
}

