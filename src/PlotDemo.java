public class PlotDemo {
    public static void main(String[] args) {
        System.out.println("================ PLOT DEMO ================");

        // Plot: RES_5_MARLA (Price: 4,000,000), Shape: RECTANGLE (Area: 20*30 = 600 sq.ft)
        Plot p1 = new Plot("P-001", PlotType.RES_5_MARLA, ShapeType.RECTANGLE);
        
        // CornerPlot: RES_10_MARLA (Base Price: 7,500,000), Shape: RECTANGLE 
        // CornerPlot custom area: ((W + 10)/2) * D = ((20 + 10)/2) * 30 = 450 sq.ft
        CornerPlot cp1 = new CornerPlot("CP-002", PlotType.RES_10_MARLA, ShapeType.RECTANGLE);

        System.out.println("--- Standard Plot ---");
        System.out.println(p1);
        System.out.printf("Area: %.2f sq.ft, Price: %,.2f PKR%n", p1.getArea(), p1.getPrice());
        
        // Booking simulation
        System.out.println("Booking P-001: " + (p1.book() ? "Success" : "Failure"));
        System.out.println("P-001 Available: " + p1.isAvailable());
        System.out.println("Booking P-001 again: " + (p1.book() ? "Success" : "REJECTED (Already booked)"));
        System.out.println("Cancelling P-001: " + (p1.cancel() ? "Success" : "Failure"));
        System.out.println("P-001 Available: " + p1.isAvailable());

        System.out.println("\n--- Corner Plot (with 8%% premium) ---");
        System.out.println(cp1);
        
        // CornerPlot Price: 7,500,000 * 1.08 = 8,100,000 PKR
        double basePrice = PlotType.RES_10_MARLA.getPrice();
        double finalPrice = cp1.getPrice();
        
        System.out.printf("Area: %.2f sq.ft (CornerPlot custom calculation), Base Price: %,.2f PKR, Final Price: %,.2f PKR%n", 
            cp1.getArea(), basePrice, finalPrice);
        
        System.out.println("=========================================");
    }
}