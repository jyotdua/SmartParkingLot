import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ParkingFloor {
    private Map<ParkingSpotType, Set<ParkingSpot>> parkingSpotsMap = new HashMap<>();
    private int floorId;
    private boolean isUnderMaintenance;
    private boolean isFull;
    public ParkingFloor(int floorId, boolean isUnderMaintenance){
        this.floorId = floorId;
        this.isUnderMaintenance = isUnderMaintenance;
        for(ParkingSpotType parkingSpotType : ParkingSpotType.values()){
            parkingSpotsMap.put(parkingSpotType, new HashSet<>());
        }
    }

    public boolean isFloorFunctional(){
        return !this.isUnderMaintenance;
    }

    public void addParkingSpot(ParkingSpot parkingSpot){
        parkingSpotsMap.get(parkingSpot.getParkingSpotType()).add(parkingSpot);
    }

    public void removeParkingSpot(ParkingSpot parkingSpot){
        parkingSpotsMap.get(parkingSpot.getParkingSpotType()).remove(parkingSpot);
    }

    public ParkingSpot getParkingSpot(Vehicle vehicle){
        if(isUnderMaintenance){
            return null;
        }
        for(ParkingSpotType parkingSpotType : ParkingSpotType.values()){
            for(ParkingSpot parkingSpot : parkingSpotsMap.get(parkingSpotType)){
                if(parkingSpot.canFitVehicle(vehicle)){
                    return parkingSpot;
                }
            }
        }
        return null;
    }

    public void setFloorToFull(){
        this.isFull = true;
    }

    public boolean isFull(){
        return this.isFull;
    }

    public ParkingSpot getParkingSpotById(String parkingSpotId){
        for(ParkingSpotType parkingSpotType : ParkingSpotType.values()){
            for(ParkingSpot parkingSpot : parkingSpotsMap.get(parkingSpotType)){
                if(parkingSpot.getParkingSpotId().equals(parkingSpotId))
                    return parkingSpot;
            }
        }
        return null;
    }


}
