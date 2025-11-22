public class EntryGate {
    private int entryPanelId;
    private ParkingStrategy parkingStrategy;
    private ParkingTicketGenerator parkingTicketGenerator;

    public EntryGate(int entryPanelId, ParkingStrategy parkingStrategy, ParkingTicketGenerator parkingTicketGenerator) {
        this.entryPanelId = entryPanelId;
        this.parkingStrategy = parkingStrategy;
        this.parkingTicketGenerator = parkingTicketGenerator;
    }

    public int getEntryPanelId() {
        return entryPanelId;
    }
    public void setEntryPanelId(int entryPanelId) {
        this.entryPanelId = entryPanelId;
    }
    public ParkingStrategy getParkingStrategy() {
        return parkingStrategy;
    }
    public void setParkingStrategy(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }
    public ParkingTicketGenerator getParkingTicketGenerator() {
        return parkingTicketGenerator;
    }
    public void setParkingTicketGenerator(ParkingTicketGenerator parkingTicketGenerator) {
        this.parkingTicketGenerator = parkingTicketGenerator;
    }

    public ParkingTicket getParkingTicket(Vehicle vehicle, ParkingLot parkingLot) {
        ParkingSpot parkingSpot = parkingStrategy.findParkingSpot(vehicle, parkingLot);
        if (parkingSpot == null) {
            return null;
        }
        ParkingTicket parkingTicket = parkingTicketGenerator.generateParkingTicket(parkingSpot);
        return parkingTicket;
    }





}
