package utility;


public enum Color {
	WHITE(1),
	BLUE(2),
	YELLOW(3),
	ORANGE(4),
	PURPLE(5),
	GREEN(6),
	RED(7);
	
	private final int val;
	
	Color(int color){
		this.val = color;
	}
	
	public int getColor() {
		return val;
	}
}