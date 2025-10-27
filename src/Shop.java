public class Shop{

	private PlotType plot;
	private String id;
	private ShapeType shape;
	private boolean availability;


	public Shop(String id , PlotType plot, ShapeType shape){
		this.id = id;
		this.plot = plot;
		this.shape = shape;
		this.availability = true;
	}
	
	public boolean isAvailable(){
		return this.availability;
	}

	public boolean book(){
		if(availability){
			availability = false;
			return true;
		}
		return false;

	}
	
	public String getId(){
		return id;
	}

	public ShapeType getShape(){
		return shape;
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

		return String.format("[SHOP ID: %s, PLOT TYPE: %s, PLOT SHAPE: %s, AVAILABILITY: %s]" , id , plot , shape , (availability)? "YES" : "NO");
	}
	

}
	