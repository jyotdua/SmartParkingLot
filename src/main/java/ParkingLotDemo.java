public class ParkingLotDemo {
    public static void main(String[] args) {
        System.out.println("=== Smart Parking Lot System Demo ===\n");

        // Initialize Parking Lot using getInstance method
        ParkingLot parkingLot = ParkingLot.getInstance(1, 101);
        
        // Create parking floors
        ParkingFloor floor1 = new ParkingFloor(1, false);
        ParkingFloor floor2 = new ParkingFloor(2, false);
        
        // Add parking spots to floor 1
        ParkingSpot spot1 = new ParkingSpot("F1-S1", ParkingSpotType.SMALL);
        spot1.unParkVehicle(); // Initialize as empty
        floor1.addParkingSpot(spot1);
        
        ParkingSpot spot2 = new ParkingSpot("F1-M1", ParkingSpotType.MEDIUM);
        spot2.unParkVehicle();
        floor1.addParkingSpot(spot2);
        
        ParkingSpot spot3 = new ParkingSpot("F1-M2", ParkingSpotType.MEDIUM);
        spot3.unParkVehicle();
        floor1.addParkingSpot(spot3);
        
        ParkingSpot spot4 = new ParkingSpot("F1-L1", ParkingSpotType.LARGE);
        spot4.unParkVehicle();
        floor1.addParkingSpot(spot4);
        
        // Add parking spots to floor 2
        ParkingSpot spot5 = new ParkingSpot("F2-M1", ParkingSpotType.MEDIUM);
        spot5.unParkVehicle();
        floor2.addParkingSpot(spot5);
        
        ParkingSpot spot6 = new ParkingSpot("F2-L1", ParkingSpotType.LARGE);
        spot6.unParkVehicle();
        floor2.addParkingSpot(spot6);
        
        ParkingSpot spot7 = new ParkingSpot("F2-L2", ParkingSpotType.LARGE);
        spot7.unParkVehicle();
        floor2.addParkingSpot(spot7);
        
        // Add floors to parking lot
        parkingLot.addParkingFloor(floor1);
        parkingLot.addParkingFloor(floor2);
        
        System.out.println("Parking lot initialized with 2 floors and 7 spots\n");
        
        // Setup strategies and processors
        ParkingStrategy parkingStrategy = new NearestAvailableSpotStrategy();
        ParkingTicketGenerator ticketGenerator = new ParkingTicketGenerator();
        
        CostComputeStrategy costStrategy = new StandardCostComputeStrategy();
        PaymentProcessor cashProcessor = new CashPaymentProcessor();
        PaymentProcessor onlineProcessor = new OnlinePaymentProcessor();
        ExitGate exitGateCash = new ExitGate(cashProcessor, costStrategy);
        ExitGate exitGateOnline = new ExitGate(onlineProcessor, costStrategy);
        
        // Scenario 1: Park a car
        System.out.println("--- Scenario 1: Parking a Car ---");
        Vehicle car1 = new Vehicle("V001", "ABC-1234", VehicleType.CAR);
        
        // Find and assign spot before getting ticket
        ParkingSpot carSpot = parkingStrategy.findParkingSpot(car1, parkingLot);
        if (carSpot != null) {
            carSpot.parkVehicle(car1);
            ParkingTicket carTicket = ticketGenerator.generateParkingTicket(carSpot);
            
            System.out.println("✓ Car parked successfully!");
            System.out.println("  Vehicle: " + car1.getRegistrationNumber());
            System.out.println("  Ticket ID: " + carTicket.getTicketId());
            System.out.println("  Spot ID: " + carTicket.getParkingSpotId());
            System.out.println("  Spot Type: " + carTicket.getParkingSpotType());
            parkingLot.issueParkingTicket(carTicket);
        } else {
            System.out.println("✗ No parking spot available for car");
        }
        
        // Scenario 2: Park a bus
        System.out.println("\n--- Scenario 2: Parking a Bus ---");
        Vehicle bus1 = new Vehicle("V002", "BUS-5678", VehicleType.BUS);
        
        ParkingSpot busSpot = parkingStrategy.findParkingSpot(bus1, parkingLot);
        if (busSpot != null) {
            busSpot.parkVehicle(bus1);
            ParkingTicket busTicket = ticketGenerator.generateParkingTicket(busSpot);
            
            System.out.println("✓ Bus parked successfully!");
            System.out.println("  Vehicle: " + bus1.getRegistrationNumber());
            System.out.println("  Ticket ID: " + busTicket.getTicketId());
            System.out.println("  Spot ID: " + busTicket.getParkingSpotId());
            System.out.println("  Spot Type: " + busTicket.getParkingSpotType());
            parkingLot.issueParkingTicket(busTicket);
        } else {
            System.out.println("✗ No parking spot available for bus");
        }
        
        // Scenario 3: Park a truck
        System.out.println("\n--- Scenario 3: Parking a Truck ---");
        Vehicle truck1 = new Vehicle("V003", "TRK-9012", VehicleType.TRUCK);
        
        ParkingSpot truckSpot = parkingStrategy.findParkingSpot(truck1, parkingLot);
        if (truckSpot != null) {
            truckSpot.parkVehicle(truck1);
            ParkingTicket truckTicket = ticketGenerator.generateParkingTicket(truckSpot);
            
            System.out.println("✓ Truck parked successfully!");
            System.out.println("  Vehicle: " + truck1.getRegistrationNumber());
            System.out.println("  Ticket ID: " + truckTicket.getTicketId());
            System.out.println("  Spot ID: " + truckTicket.getParkingSpotId());
            System.out.println("  Spot Type: " + truckTicket.getParkingSpotType());
            parkingLot.issueParkingTicket(truckTicket);
        } else {
            System.out.println("✗ No parking spot available for truck");
        }
        
        // Simulate some parking duration
        System.out.println("\n--- Simulating parking duration (2 seconds) ---");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Scenario 4: Exit with cash payment
        System.out.println("\n--- Scenario 4: Car Exit with Cash Payment ---");
        if (carSpot != null && carSpot.getVehicle() != null) {
            System.out.println("Vehicle: " + car1.getRegistrationNumber());
            ParkingTicket carTicketForExit = ticketGenerator.generateParkingTicket(carSpot);
            exitGateCash.unparkVehicle(carTicketForExit, parkingLot);
            System.out.println("✓ Car exited successfully");
        }
        
        // Scenario 5: Exit with online payment  
        System.out.println("\n--- Scenario 5: Bus Exit with Online Payment ---");
        if (busSpot != null && busSpot.getVehicle() != null) {
            System.out.println("Vehicle: " + bus1.getRegistrationNumber());
            ParkingTicket busTicketForExit = ticketGenerator.generateParkingTicket(busSpot);
            exitGateOnline.unparkVehicle(busTicketForExit, parkingLot);
            System.out.println("✓ Bus exited successfully");
        }
        
        // Scenario 6: Park another car in the freed spot
        System.out.println("\n--- Scenario 6: Parking Another Car ---");
        Vehicle car2 = new Vehicle("V004", "XYZ-7890", VehicleType.CAR);
        
        ParkingSpot car2Spot = parkingStrategy.findParkingSpot(car2, parkingLot);
        if (car2Spot != null) {
            car2Spot.parkVehicle(car2);
            ParkingTicket car2Ticket = ticketGenerator.generateParkingTicket(car2Spot);
            
            System.out.println("✓ Second car parked successfully!");
            System.out.println("  Vehicle: " + car2.getRegistrationNumber());
            System.out.println("  Ticket ID: " + car2Ticket.getTicketId());
            System.out.println("  Spot ID: " + car2Ticket.getParkingSpotId());
            System.out.println("  Spot Type: " + car2Ticket.getParkingSpotType());
        } else {
            System.out.println("✗ No parking spot available for second car");
        }
        
        System.out.println("\n=== Demo Complete ===");
        System.out.println("\nKey Features Demonstrated:");
        System.out.println("✓ Singleton pattern for ParkingLot");
        System.out.println("✓ Strategy pattern for parking spot allocation");
        System.out.println("✓ Strategy pattern for cost computation");
        System.out.println("✓ Strategy pattern for payment processing");
        System.out.println("✓ Multiple vehicle types (Car, Bus, Truck)");
        System.out.println("✓ Multiple spot types (Small, Medium, Large)");
        System.out.println("✓ Entry and exit gate management");
        System.out.println("✓ Ticket generation and tracking");
    }
}
