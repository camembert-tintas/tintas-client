package utility;

public enum State {
	LIBRE(0),
	PIECE(1);
	
	private final int val;
	
	State(int state){
		this.val = state;
	}
	
	public int getState() {
		return val;
	}
}
