public class CityDemo {
    
    /**
     * Helper method to quickly create a HousingSociety and add Blocks A, B, and C.
     */
    public static HousingSociety createSociety(String cityName, String societyName) {
        // CityHousing constructor is called via super() in HousingSociety
        HousingSociety society = new HousingSociety(cityName, societyName); 
        
        // Blocks automatically create their jagged 5-street grids
        society.addBlock(new Block(societyName, "A"));
        society.addBlock(new Block(societyName, "B"));
        society.addBlock(new Block(societyName, "C"));
        
        return society;
    }

    public static void main(String[] args) {
        System.out.println("================ LAHORE CITY HOUSING DEMO ================");

        // 1. Preload Lahore with LDA Avenue 1 and LDA Avenue 2
        CityHousing lahore = new CityHousing("Lahore");
        HousingSociety lda1 = createSociety("Lahore", "LDA Avenue 1");
        HousingSociety lda2 = createSociety("Lahore", "LDA Avenue 2");
        lahore.addSociety(lda1);
        lahore.addSociety(lda2);

        // 2. Print compact layouts for each society and block
        System.out.println("\n--- Initial Compact Layouts ---");
        System.out.println("\n--- LDA Avenue 1 Layout ---");
        lda1.displayLayout();
        System.out.println("\n--- LDA Avenue 2 Layout ---");
        lda2.displayLayout();


        // 3. Simulate Workflow: book plot S3-007 in LDA Avenue 1, Block A
        String societyName = "LDA Avenue 1";
        String blockName = "A";
        String plotId = "S3-007"; // S3 is the 3rd street (index 2), 007 is the 7th plot (index 6)
        
        System.out.printf("\n--- Workflow Simulation on %s, Block %s ---\n", societyName, blockName);
        
        System.out.printf("1. Booking plot %s... ", plotId);
        boolean booked = lahore.bookPlot(societyName, blockName, plotId);
        System.out.println(booked ? "SUCCESS" : "FAILED");
        
        // 4. Attempt to book the same plot again to show proper rejection
        System.out.printf("2. Attempting to book plot %s again... ", plotId);
        booked = lahore.bookPlot(societyName, blockName, plotId);
        System.out.println(booked ? "FAILED (Error in logic or should have failed)" : "REJECTED (Already booked)");

        // 5. Cancel the booking
        System.out.printf("3. Cancelling plot %s... ", plotId);
        boolean cancelled = lahore.cancelPlot(societyName, blockName, plotId);
        System.out.println(cancelled ? "SUCCESS" : "FAILED");
        
        // 6. Print the affected street layout to confirm the state change.
        System.out.printf("\n--- Street 3 Layout in %s, Block %s (S3-007 should be Available 'A') ---\n", societyName, blockName);
        Block blockA = lda1.findBlock(blockName);
        if (blockA != null) {
            // S3 is the 3rd street array (index 2)
            Plot[] street3 = blockA.getPlots()[2]; 
            for(int i = 0; i < street3.length; i++) {
                 Plot p = street3[i];
                 System.out.printf("%s-%s-%s %s | ", 
                    p.getId() , p.shape(), (p.isAvailable() ? "A" : "X"), (p instanceof CornerPlot ? "⎤" : ""));
            }
            System.out.println();
        }

        // 7. Add two quick searches

        // Search 1: Print the first available RES_1_KANAL CornerPlot in LDA Avenue 2.
        System.out.println("\n--- Search 1: First available 1-Kanal Corner Plot (RES_1_KANAL) ---");
        // findFirstAvailableKanalCorner is implemented in CityHousing to print the result.
        Plot foundKanalCorner = lahore.findFirstAvailableKanalCorner();
        if (foundKanalCorner == null) {
            System.out.println("No available RES_1_KANAL CornerPlot found.");
        }
        
        // Search 2: List the first three vacant shops in the Block C market of LDA Avenue 1.
        System.out.println("\n--- Search 2: First three vacant shops in LDA Avenue 1, Block C Market ---");
        Block blockC_lda1 = lda1.findBlock("C");
        if (blockC_lda1 != null) {
            int count = 0;
            // Assuming CommercialMarket.market and CommercialMarket.shops are accessible
            CommercialMarket market = blockC_lda1.market; 
            Shop[] allShops = market.shops; 

            // Manual, array-only loop to find and count the first 3 available shops
            for (int i = 0; i < market.size && count < 3; i++) {
                if (allShops[i] != null && allShops[i].isAvailable()) {
                    System.out.println(allShops[i]);
                    count++;
                }
            }
            if (count == 0) {
                 System.out.println("No available shops found in Block C Market.");
            }
        } else {
             System.out.println("Block C not found in LDA Avenue 1.");
        }
        
        // Final comprehensive report
        System.out.println("\n--- Final Comprehensive Report ---");
        System.out.println(lahore);
        System.out.println("================ END OF DEMO ================");
    }
}