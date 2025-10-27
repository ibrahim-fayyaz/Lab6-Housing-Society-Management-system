public class CornerPlot extends Plot{
	
	private double width2 = 10;
	
	public CornerPlot(String id, PlotType plot, ShapeType shape){
		super(id,plot,shape);
	}

	public double getPrice(){
		return super.getPlotType().getPrice() * (1+0.08);
	}
	
	public double getArea(){
		return ((super.getShape().getWidth() + width2)/2) * super.getShape().getDepth();
	}

	public String toString(){
		return String.format("Corner Plot: %s" , super.toString());
	}

	


}	