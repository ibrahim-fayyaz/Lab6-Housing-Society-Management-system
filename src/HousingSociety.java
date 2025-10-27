public class HousingSociety extends CityHousing{

	private Block blocks[] = new Block[100];
	private int size;
	private String name;

	
	
	public HousingSociety(String cityName , String name){
		super(cityName);
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public int getBlocksCount(){
		return size;
	}

	public void addBlock(Block b){
		blocks[size++] = b;
	}
	
	public Block[] getBlocks(){
		Block[] b = new Block[size];
		for(int i = 0; i < size; i++){
			b[i] = blocks[i];

		}
		return b;
	}

	public void removeBlock(String name){
		for(int i = 0; i < size; i++){
			if(blocks[i].getName().equals(name)){
				for(int j = i; j < size - 1; j++){
					blocks[j] = blocks[j+1];
				} 
				blocks[size--] = null;
			}
		}
	}

	public Block findBlock(String name){
		for(int i = 0; i < size; i++){
			if(blocks[i].getName().equals(name)){
				return blocks[i];
			}
		}
		return null;

	}
	
	public boolean bookPlot(String blockName, String pName){
		for(int i = 0; i < size; i++)
			if(blocks[i].getName().equals(blockName))
				return blocks[i].bookPlot(pName);
		return false;
	}

	public boolean cancelPlot(String blockName, String pName){
		for(int i = 0; i < size; i++)
			if(blocks[i].getName().equals(blockName))
				return blocks[i].cancelPlot(pName);
		return false;
	}

	public Plot findPlot(String blockName, String pName){
		for(int i = 0; i < size; i++)
			if(blocks[i].getName().equals(blockName))
				return blocks[i].findPlot(pName);
		return null;
	}

	public int countAvailablePlots(){
		int c = 0;
		for(int i = 0; i < size; i++)
			c += blocks[i].countAvailablePlots();
		return c;
	}
	
	public boolean addShop(String name){
		for(int i = 0; i < size; i++)
			if(blocks[i].getName().equals(name))
				return blocks[i].addShop();
		return false;
	}

	public boolean removeShop(String blockName, String shopId){
		for(int i = 0; i < size; i++)
			if(blocks[i].getName().equals(blockName))
				return blocks[i].removeShop(shopId);
		return false;
	}

	public Shop findShop(String blockName, String shopId){
		for(int i = 0; i < size; i++)
			if(blocks[i].getName().equals(blockName))
				return blocks[i].findShop(shopId);
		return null;
	}

	public boolean bookShop(String blockName, String shopId){
		for(int i = 0; i < size; i++)
			if(blocks[i].getName().equals(blockName))
				return blocks[i].bookShop(shopId);
		return false;
	}

	public boolean cancelShop(String blockName, String shopId){
		for(int i = 0; i < size; i++)
			if(blocks[i].getName().equals(blockName))
				return blocks[i].cancelShop(shopId);
		return false;
	}
	
	public void displayBlock(String blockName){
		for(int i = 0; i < size; i++)
			if(blocks[i].getName().equals(blockName))
				blocks[i].display();
	}

	public void displayAll(){
		for(int i = 0; i < size; i++)
				blocks[i].display();
	}

	public void displayLayout(){
		System.out.println(name);
		for(int i = 0; i < size; i++)
				blocks[i].displayLayout();
	}

	public int totalPlots(){
		int totalPlots = 0;
		for (int i = 0; i < size; i++) {
        Block b = blocks[i];
        totalPlots += b.countPlots();
		}
		return totalPlots;
	}

	public String toString() {
    int totalPlots = 0, totalAvailablePlots = 0, totalShops = 0, totalAvailableShops = 0;

    StringBuilder report = new StringBuilder();
    report.append("\n====================================================\n");
    report.append(String.format("           %s HOUSING SCHEME REPORT\n", name));
    report.append("====================================================\n\n");

    for (int i = 0; i < size; i++) {
        Block b = blocks[i];
        totalPlots += b.countPlots();
        totalAvailablePlots += b.countAvailablePlots();
        totalShops += b.countShops();
        totalAvailableShops += b.availableCount();
        report.append(b.toString());
		report.append("\n");
    }

    report.append("====================================================\n");
    report.append("                 OVERALL SUMMARY\n");
    report.append("====================================================\n");
    report.append(String.format("Total Blocks:         %d\n", size));
    report.append(String.format("Total Plots:          %d\n", totalPlots));
    report.append(String.format("Available Plots:      %d\n", totalAvailablePlots));
    report.append(String.format("Booked Plots:         %d\n", totalPlots - totalAvailablePlots));
    report.append(String.format("Total Shops:          %d\n", totalShops));
    report.append(String.format("Available Shops:      %d\n", totalAvailableShops));
    report.append(String.format("Booked Shops:         %d\n", totalShops - totalAvailableShops));
    report.append("====================================================\n");

    return report.toString();
}

	
	
	



}