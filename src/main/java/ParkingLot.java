import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private List<ParkingFloor> parkingFloors;
    private int parkingLotId;
    private int parkingLotName;
    private static volatile ParkingLot instance;
    private Map<String, ParkingTicket> activeTickets;


    private ParkingLot(int parkingLotId, int parkingLotName) {
        this.parkingLotId = parkingLotId;
        this.parkingLotName = parkingLotName;
        parkingFloors = new ArrayList<>();
        activeTickets = new java.util.HashMap<>();
    }

    public void addParkingFloor(ParkingFloor parkingFloor) {
        parkingFloors.add(parkingFloor);
    }

    public static ParkingLot getInstance(int parkingLotId, int parkingLotName) {
        if(instance==null){
            synchronized (ParkingLot.class){
                if(instance==null){
                    instance = new ParkingLot(parkingLotId, parkingLotName);
                }
            }
        }
        return instance;
    }
    public void removeParkingFloor(ParkingFloor parkingFloor) {
        parkingFloors.remove(parkingFloor);
    }

    public boolean isParkingLotFull() {
        for (ParkingFloor parkingFloor : parkingFloors) {
            if (parkingFloor.isFull()) {
                return true;
            }
        }
        return false;
    }

    public void issueParkingTicket(ParkingTicket parkingTicket) {
        activeTickets.put(parkingTicket.getTicketId(), parkingTicket);
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public ParkingTicket getParkingTicket(String ticketId) {
        return activeTickets.get(ticketId);
    }

    public ParkingSpot getParkingSpotById(String spotId) {
        for (ParkingFloor parkingFloor : parkingFloors) {
            ParkingSpot parkingSpot = parkingFloor.getParkingSpotById(spotId);
            if(parkingSpot != null){
                return parkingSpot;
            }
        }
        return null;
    }

}
