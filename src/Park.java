public class Park{

	private String name;
	private ShapeType shape;
	private double width;
	private double length;
	private double area;
	
	Park(double width , double length){
		this.width = width;
		this.length = length;
		area = width * length;
		name = "Family Park";
		shape = ShapeType.RECTANGLE;
	}

	Park(String n, ShapeType s){
		name = n;
		shape = s;
	}
	
	public String toString(){

		return String.format("| Park Name: %s | Park Shape: %s | Park Area: %.2f sq\u00b2|" , name , shape , area);
	}

	


}
	