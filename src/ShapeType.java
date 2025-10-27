public enum ShapeType{

	RECTANGLE(20 , 30), TRAPEZOID(20 , 30 , 25) , L_SHAPE(15 , 20 , 10 , 10);

	private double width;
	private double depth;
	private double width2;
	private double depth2;
	private double back;
	private double front;
	private double area;


	ShapeType(double w, double d){
		this.width = w;
		this.depth = d;
	}

	ShapeType(double f, double b, double d){
		this.front = f;
		this.back = b;
		this.depth = d;
	}

	ShapeType(double w1 , double d1, double w2, double d2){
		this.width = w1;
		this.depth = d1;
		this.width2 = w2;
		this.depth2 = d2;

	}

	public double getArea(){
		switch(this){
			case RECTANGLE -> area = width * depth;
			case TRAPEZOID -> area = ((front + back) / 2) * depth;
			case L_SHAPE -> area = (width * depth) + (width2 * depth2);
		}
		return area;
	}
	
	public double getWidth(){
		return width;
	}
	
	public double getDepth(){
		return depth;
	}
	
	public double getWidth2(){
		return width2;
	}
	
	public double getDepth2(){
		return depth2;
	}
	
	public double getFront(){
		return front;
	}
	
	public double getBack(){
		return back;
	}
	




	
}