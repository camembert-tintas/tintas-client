package utility;


public enum Color {
	
	BLUE, GREEN, RED, YELLOW, PURPLE;


	private String name = "";
	
	private Color(int name){
	  this.name = Color[name];
	}
	
	public String toString(){
	  return name;
	}
}