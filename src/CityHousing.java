public class CityHousing{
	
	private HousingSociety societies[] = new HousingSociety[100];
	private int size;
	private String name;

	public CityHousing(String n){
		name = n;
	}

	public boolean bookPlot(String societyName, String blockName, String plotId){
		for(int i = 0; i < size;i++){
			if(societies[i].getName().equals(societyName)){
				return societies[i].bookPlot(blockName, plotId);
			}
		}
		return false;
	}

	public boolean cancelPlot(String societyName, String blockName, String plotId){
		for(int i = 0; i < size;i++){
			if(societies[i].getName().equals(societyName)){
				return societies[i].cancelPlot(blockName, plotId);
			}
		}
		return false;
	}

	public void addSociety(HousingSociety s){
		societies[size++] = s;	
	}
	
	public void removeSociety(String name){
		for(int i = 0; i < size;i++){
			if(societies[i].getName().equals(name)){
				for(int j = i; j < size - 1; j++){
					societies[j] = societies[j+1];
				}
				societies[size--]=null;
			}
		}
	}
	
	public HousingSociety findSociety(String name){
		for(int i = 0; i < size;i++){
			if(societies[i].getName().equals(name)){
				return societies[i];
			}
		}	
		return null;
	}

	public int countAllPlots(){
			int c = 0;
			for(int i = 0; i < size;i++){
				c += societies[i].totalPlots();
			}
		return c;
	}

	public int countAvailablePlots(){
			int c = 0;
			for(int i = 0; i < size;i++){
				c += societies[i].countAvailablePlots();
			}
		return c;
	}
	
	//findFirstAvailableKanalCorner
	public Plot findFirstAvailableKanalCorner(){
		for(int i = 0; i < size;i++){
			for(Block block:societies[i].getBlocks())
				for(Plot[] plots: block.getPlots())
					for(Plot plot: plots)
						if(plot.isAvailable() && plot.getPlotType().equals(PlotType.RES_1_KANAL) && 
						plot instanceof CornerPlot){
							System.out.printf("%s > %s > %s (%s, area %.0f sq.ft, %,.0f PKR)%n",
    societies[i].getName(),           
    block.getName(),             
    plot.getId(),                
    plot.getPlotType(),         
    plot.getArea(),        
    plot.getPrice()       
);

							return plot;
						}
		}
		return null;
	}

	//findFirstAvailableCommShop
	public Plot findFirstAvailableCommShop(){
		for(int i = 0; i < size;i++){
			for(Block block:societies[i].getBlocks())
				for(Plot[] plots: block.getPlots())
					for(Plot plot: plots)
						if(plot.isAvailable() && plot.getPlotType().equals(PlotType.RES_1_KANAL)){
							System.out.printf("%s > %s > %s (%s, area %.0f sq.ft, %,.0f PKR)%n",
    societies[i].getName(),           
    block.getName(),             
    plot.getId(),                
    plot.getPlotType(),         
    plot.getArea(),        
    plot.getPrice()       
);

							return plot;
						}
		}
		return null;
	}


	public Plot findLargestAvailableResidentialPlot(){
		for(int i = 0; i < size;i++){
			for(Block block:societies[i].getBlocks())
				for(Plot[] plots: block.getPlots())
					for(Plot plot: plots)
						if(plot.isAvailable() && plot.getPlotType().equals(PlotType.COMM_SHOP)){
							System.out.printf("%s > %s > %s (%s, area %.0f sq.ft, %,.0f PKR)%n",
    societies[i].getName(),           
    block.getName(),             
    plot.getId(),                
    plot.getPlotType(),         
    plot.getArea(),        
    plot.getPrice()       
);

							return plot;
							}
		}
		return null;
	}
	
	public void displayAll(){
		for(int i = 0; i < size;i++)
			societies[i].displayAll();
	}

	public void displayAllLayouts(){
		System.out.println(name);
		for(int i = 0; i < size;i++)
			societies[i].displayLayout();
	}
	
		
	@Override
public String toString() {
    int totalPlots = 0;
    int availablePlots = 0;
    int bookedPlots = 0;

    // Society summaries
    StringBuilder societySummaries = new StringBuilder();

    for (int i = 0; i < size; i++) {
        HousingSociety s = societies[i];
        if (s == null) continue;

        int societyTotal = s.totalPlots();
        int societyAvailable = s.countAvailablePlots();

        totalPlots += societyTotal;
        availablePlots += societyAvailable;
        bookedPlots += (societyTotal - societyAvailable);

        societySummaries.append(String.format("""
        %s
        ----------------------
        Total Blocks: %d
        Available: %d / %d plots

        """, 
        s.getName(), s.getBlocksCount(), societyAvailable, societyTotal));
    }

    return String.format("""
========================================================
              %s CITY HOUSING REPORT
========================================================
Total Societies:       %d
Total Plots:           %d
Available Plots:       %d
Booked Plots:          %d

---------------------- SOCIETIES ------------------------
%s========================================================
End of Lahore Report
========================================================
""", 
        name , size, totalPlots, availablePlots, bookedPlots, societySummaries.toString());
}

 
}