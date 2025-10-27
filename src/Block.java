public class Block extends CityHousing{
	
	private String name;
	Plot plots[][] = new Plot[5][];
	CommercialMarket market;
	Park parks[] = new Park[2];
	ShapeType shape;
	PlotType plot;
	private int plotCount;
	private int cornerCount;
	private int parkingCount;
	private int commercialCount;
	private int residentialCount;

	public Block(String societyName , String name){ 
		super(societyName);
		this.name =name;
		market = new CommercialMarket("Central Market");
		parks[0] = new Park(20 , 30);
		parks[1] = new Park(40 , 50);

		for(int i = 0; i < plots.length; i++){
			plots[i] = new Plot[10+i];
		}
	
		
		for(int i=0 ; i < plots.length; i++){
			for(int j = 0; j < plots[i].length; j++){
				plotCount++;
				if(i == 0){
					
					if((j+1) % 4 == 0){
						plots[i][j] = new CornerPlot(String.format("S%d-%03d", i+1 , j+1), PlotType.RES_5_MARLA , ShapeType.RECTANGLE);
						cornerCount++;
						residentialCount++;
					}
					else if((j+1) % 5 == 0){
						plots[i][j] = new Parking(String.format("S%d-%03d", i+1 , j+1),ShapeType.RECTANGLE);
						parkingCount++;
					}
					
					else{
						plots[i][j] = new Plot(String.format("S%d-%03d", i+1 , j+1), PlotType.RES_5_MARLA , ShapeType.RECTANGLE);
						residentialCount++;
					}	
				}

				else if(i == 1){
					
					if((j+1) % 4 == 0){
						plots[i][j] = new CornerPlot(String.format("S%d-%03d", i+1 , j+1), PlotType.RES_10_MARLA , ShapeType.RECTANGLE);
						cornerCount++;
						residentialCount++;
					}
					else if((j+1) % 5 == 0){
						plots[i][j] = new Parking(String.format("S%d-%03d", i+1 , j+1),ShapeType.RECTANGLE);
						parkingCount++;
					}
					
					else{
						plots[i][j] = new Plot(String.format("S%d-%03d", i+1 , j+1), PlotType.RES_10_MARLA , ShapeType.RECTANGLE);
						residentialCount++;
					}	
				}

				else if(i == 2){
					
					if((j+1) % 4 == 0){
						plots[i][j] = new CornerPlot(String.format("S%d-%03d", i+1 , j+1), PlotType.RES_1_KANAL , ShapeType.TRAPEZOID);
						cornerCount++;
						residentialCount++;
					}
					else if((j+1) % 5 == 0){
						plots[i][j] = new Parking(String.format("S%d-%03d", i+1 , j+1),ShapeType.RECTANGLE);
						parkingCount++;

					}
					else{
						plots[i][j] = new Plot(String.format("S%d-%03d", i+1 , j+1), PlotType.RES_1_KANAL , ShapeType.TRAPEZOID);
						residentialCount++;
					}	
				}

				else if(i == 3){
					if((j+1) % 5 == 0){
						plots[i][j] = new Parking(String.format("S%d-%03d", i+1 , j+1),ShapeType.RECTANGLE);
						parkingCount++;
					}
					else{
						plots[i][j] = new Plot(String.format("S%d-%03d", i+1 , j+1), PlotType.COMM_SHOP,ShapeType.RECTANGLE);
						commercialCount++;
					}
				}

				else{
					if((j+1) % 5 == 0){
						plots[i][j] = new Parking(String.format("S%d-%03d", i+1 , j+1),ShapeType.RECTANGLE);
						parkingCount++;
					}
					else{
						plots[i][j] = new Plot(String.format("S%d-%03d", i+1 , j+1), PlotType.COMM_OFFICE,ShapeType.RECTANGLE);
						commercialCount++;
					}
				}
			
			}
		}
			
	}
	public String getName(){
		return name;
	}

	public Plot[][] getPlots(){
		return plots;
	}
	public void display(){
		for(int i=0 ; i < plots.length; i++){
			for(int j = 0; j < plots[i].length; j++){
				System.out.println(plots[i][j]);
			
			}	
				System.out.println();
		}
		
		System.out.println("Amenities");
		System.out.println(parks[0]);
		System.out.println(market);
		System.out.println(parks[1]);
	}

	public void displayLayout(){
		for(int i=0 ; i < plots.length; i++){
			for(int j = 0; j < plots[i].length; j++){
				System.out.printf("%s - %s - %s %s " ,
				plots[i][j].getId() , 
				plots[i][j].shape(), 
				(plots[i][j].isAvailable() ? "A" : "X"), 
				(plots[i][j] instanceof CornerPlot ? "⎤" : ""));
			}	
				System.out.println();
		}
		
		System.out.println("Amenities");
		System.out.println(parks[0]);
		System.out.println(market);
		System.out.println(parks[1]);

	}
	
	public boolean bookPlot(String id){
		for(int i=0 ; i < plots.length; i++)
			for(int j = 0; j < plots[i].length; j++)
				if(plots[i][j].getId().equals(id))
					return plots[i][j].book();
		return false;
	}

	public boolean cancelPlot(String id){
		for(int i=0 ; i < plots.length; i++)
			for(int j = 0; j < plots[i].length; j++)
				if(plots[i][j].getId().equals(id))
					return plots[i][j].cancel();
		return false;
	}

	public Plot findPlot(String id){
		for(int i=0 ; i < plots.length; i++)
			for(int j = 0; j < plots[i].length; j++)
				if(plots[i][j].getId().equals(id))
					return plots[i][j];
		return null;

	}
	
	public int countAvailablePlots(){
		int c = 0;
		for(int i=0 ; i < plots.length; i++)
			for(int j = 0; j < plots[i].length; j++)
				if(plots[i][j].isAvailable())
					c++;
		return c;
	}

	public int countPlots(){
		return plotCount;
	}
	public int cornerCount(){
		return cornerCount;
	}

	public int parkingCount(){
		return parkingCount;
	}
	public int commercialCount(){
		return commercialCount;
	}
	public int residentialCount(){
		return residentialCount;
	}
	public boolean addShop(){
		return market.addShop();
	}
	
	public boolean removeShop(String id){
		return market.removeShop(id);
	}
	
	public Shop findShop(String id){
		return market.findShop(id);
	}
	
	public boolean bookShop(String id){
		return market.book(id);
	}

	public boolean cancelShop(String id){
		return market.cancel(id);
	}
	
	public void displayShops(){
		market.displayLayout();
	}
	
	public int countShops(){
		return market.shopsCount();
	}
		
	public int availableCount(){
		return market.availableCount();
	}
	
	public String toString(){
		String s = String.format("""
------------------------------------------------
                 %s BLOCK REPORT
------------------------------------------------
Total Streets: 5
Total Plots: %d

------------------- PLOT DETAILS ----------------
Residential Plots: %d
Commercial Plots:  %d
Corner Plots:      %d 
Parking Spaces:    %d

Available Plots:   %d
Booked Plots:      %d

------------------- AMENITIES --------------------
Number of Parks:   2
Park 1 Area:       20 x 30
Park 2 Area:       40 x 50
Commercial Market: Central Market

------------------- SHOPS SUMMARY ----------------
Total Shops:       %d
Available Shops:   %d

------------------------------------------------
""" , name , plotCount , residentialCount , commercialCount , cornerCount , parkingCount , countAvailablePlots(), plotCount - countAvailablePlots(), countShops(), availableCount() );
		return s;
	}
	


}