public class StandardCostComputeStrategy implements CostComputeStrategy {
    private static final double CAR_BASE_RATE = 10.0;
    private static final double BUS_BASE_RATE = 25.0;
    private static final double TRUCK_BASE_RATE = 20.0;

    private static final double SMALL_SPOT_MULTIPLIER = 1.0;
    private static final double MEDIUM_SPOT_MULTIPLIER = 1.3;
    private static final double LARGE_SPOT_MULTIPLIER = 1.5;

    private static final double MINIMUM_HOURS = 0.5;
    @Override
    public double computeCost(ParkingTicket parkingTicket) {
        if (parkingTicket == null) {
            throw new IllegalArgumentException("Parking Ticket is null");
        }

        long duration = System.currentTimeMillis() - parkingTicket.getEntryTime();
        double durationHours = Math.max(duration/(1000.0*60*60),MINIMUM_HOURS);
        double baseRate = getBaseRate(parkingTicket.getVehicle().getVehicleType());
        double spotMultiplier = getSpotMultiplier(parkingTicket.getParkingSpotType());
        double cost = durationHours*baseRate * spotMultiplier;
        return Math.round(cost*100.0)/100.0;
    }

    private double getBaseRate(VehicleType vehicleType) {
        switch (vehicleType) {
            case CAR:
                return CAR_BASE_RATE;
                case TRUCK:
                    return TRUCK_BASE_RATE;
                    case BUS:
                        return BUS_BASE_RATE;
                        default:
                            return  10.0;
        }
    }

    private double getSpotMultiplier(ParkingSpotType parkingSpotType) {
        switch (parkingSpotType) {
            case SMALL:
                return SMALL_SPOT_MULTIPLIER;
                case MEDIUM:
                    return MEDIUM_SPOT_MULTIPLIER;
                    case LARGE:
                        return LARGE_SPOT_MULTIPLIER;
                        default:
                            return  1.0;
        }

    }
}
