public class CommercialMarket{

	Shop shops[] = new Shop[100];
	int size;
	String name;

	public CommercialMarket(String name){
		this.name = name;
		for(int i = 0; i < 20; i++){
			shops[i] = new Shop(String.format("S-%03d",i), PlotType.COMM_SHOP, ShapeType.RECTANGLE);
		size++;
		}
	}

	public int shopsCount(){
		return size;
	}

	public int availableCount(){
		int c = 0;
		for(int i = 0; i < size; i++)
			if(shops[i].isAvailable())
				c++;
		return c;
		
	}

	public boolean addShop(){
		if(size < shops.length){
		shops[size++] = new Shop(String.format("S-%03d",size), PlotType.COMM_SHOP, ShapeType.RECTANGLE);
		System.out.println("Added to market | " + shops[size-1]);
		return true;
		}
		return false;
	}

	public Shop findShop(String id){
		for(int i = 0; i < size; i++)
			if(shops[i].getId().equals(id))
				return shops[i];

		return null;
	}

	public boolean removeShop(String id){
		for(int i = 0; i < size; i++){
			if(shops[i].getId().equals(id)){
				for(int j = i; j < size-1; j++){
					shops[j] = shops[j+1];
				}
				shops[size--] = null;
				return true;
			}
		}
		return false;
	}

	public boolean book(String id){
		for(int i = 0; i < size; i++){
			if(shops[i].getId().equals(id)){
				return shops[i].book();
			}
		}
		return false;
	}

	public boolean cancel(String id){
		for(int i = 0; i < size; i++){
			if(shops[i].getId().equals(id)){
				return shops[i].cancel();
			}
		}
		return false;
	}
		
		
	public void displayLayout(){
		for(int i = 0; i < size; i++){
			System.out.println(shops[i]);
		}
	}

	public String toString(){
		return String.format("| Market Name: %s| Total Shops: %d |", name , size);

	}



}