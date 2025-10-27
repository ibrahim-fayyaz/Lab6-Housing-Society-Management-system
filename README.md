# Lab6-Housing-Society-Management-System: Arrays-Only

This project demonstrates a complete object-oriented Housing Society Management System in Java, strictly adhering to the requirement of using **only plain Java arrays** for all data structures (no Java Collections).

---

## Constraints & Design

All containers (`CityHousing`, `HousingSociety`, `CommercialMarket`) rely on manual array capacity management. Multi-result queries use the **two-pass filtering** technique.

### Key Policies
| Feature | Implementation |
| :--- | :--- |
| **Grid Structure** | Each `Block` generates a **5-street jagged plot grid** (`Plot[][]`) with variable street lengths. |
| **Pricing** | **`PlotType`** defines base price. **`CornerPlot`** applies an **8% price premium** via method overriding. |
| **Area** | **`ShapeType`** (RECTANGLE, TRAPEZOID) defines plot dimensions for area calculation. |
| **Plot ID** | Auto-generated in the format `S<Street>-<PlotID>` (e.g., `S3-007`). |

---

## Demonstration (`CityDemo.java`)

The demo preloads **Lahore** with **LDA Avenue 1** and **LDA Avenue 2** (Blocks A, B, C) and runs a full simulation.

### Workflow Simulation
1.  **Book:** Plot `S3-007` in **LDA Avenue 1, Block A** is booked.
2.  **Rejection:** An attempt to book `S3-007` again is **rejected**.
3.  **Cancel:** The booking for `S3-007` is **cancelled**.
4.  **Verification:** The Street 3 layout is printed to confirm `S3-007` status is now **Available ('A')**.

### Array-Based Queries
1.  **Plot Search:** Find the first available **RES\_1\_KANAL CornerPlot** in LDA Avenue 2.
2.  **Amenity Search:** List the **first three vacant shops** in the Block C market of LDA Avenue 1.

---

## Submission Files

The complete code requires the following classes:

* **Demos:** `CityDemo.java`, `PlotDemo.java`
* **Hierarchy:** `CityHousing.java`, `HousingSociety.java`, `Block.java`
* **Units:** `Plot.java`, `CornerPlot.java`, `Parking.java`
* **Amenities:** `CommercialMarket.java`, `Shop.java`, `Park.java`
* **Enums:** `PlotType.java`, `ShapeType.java`
