public class ExitGate {
    private final PaymentProcessor paymentProcessor;
    private final CostComputeStrategy costComputeStrategy;

    public ExitGate(PaymentProcessor paymentProcessor, CostComputeStrategy costComputeStrategy) {
        this.paymentProcessor = paymentProcessor;
        this.costComputeStrategy = costComputeStrategy;
    }

    public void unparkVehicle(ParkingTicket parkingTicket, ParkingLot parkingLot ) {
        if(parkingTicket == null || parkingLot == null) {
            throw new IllegalArgumentException("Parking Ticket or Parking Lot is null");
        }

        double cost = costComputeStrategy.computeCost(parkingTicket);
        ParkingSpot parkingSpot = parkingLot.getParkingSpotById(parkingTicket.getParkingSpotId());
        if(parkingSpot != null){
            parkingSpot.unParkVehicle();
        }
        boolean paymentStatus = paymentProcessor.processPayment(cost);
        if(paymentStatus){
            System.out.println("Payment Completed");
        }
        else{
            System.out.println("Payment Failed");
        }
    }
}
