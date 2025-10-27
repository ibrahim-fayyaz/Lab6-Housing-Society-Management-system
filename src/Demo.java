public class Demo{
	public static void main(String[] args){
		
		CityHousing c = new CityHousing("Lahore");
		HousingSociety h = new HousingSociety("Lahore", "LDA");
		c.addSociety(h);
		Block b = new Block("LDA","A");
		h.addBlock(b);
		c.displayAllLayouts();
		System.out.println(c);
		

	}
}