public class Plot{

	private PlotType plot;
	private String id;
	private ShapeType shape;
	private boolean availability;


	public Plot(String id , PlotType plot, ShapeType shape){
		this.id = id;
		this.plot = plot;
		this.shape = shape;
		this.availability = true;
	}

	public boolean book(){
		if(availability){
			availability = false;
			return true;
		}
		return false;

	}
	
	public boolean isAvailable(){
		return availability;
	}
	
	public String getId(){
		return id;
	}

	public ShapeType getShape(){
		return shape;
	}
	
	public String shape(){
		if(shape == ShapeType.RECTANGLE)
			return "▭";
		return "⏢";
	}

	public PlotType getPlotType(){
		return plot;
	}

	public double getPrice(){
		return plot.getPrice();
	}

	public double getArea(){
		return shape.getArea();
	}
	
	public boolean cancel(){
		if(!availability){
			availability = true;
			return true;
		}
		return false;

	}

	public String toString(){

		return String.format("[ID: %s, PLOT TYPE: %s, PLOT SHAPE: %s, AVAILABILITY: %s]" , id , plot , shape , (availability)? "YES" : "NO");
	}
	

}
	