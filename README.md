# Smart Parking Lot System - Demo Guide

## Overview
This is a comprehensive smart parking lot management system demonstrating various design patterns and OOP principles.

## Running the Demo

### Compile and Run
```bash
mvn clean compile exec:java -Dexec.mainClass="ParkingLotDemo"
```

### Or compile and run separately
```bash
mvn clean compile
java -cp target/classes ParkingLotDemo
```

## What the Demo Shows

The `ParkingLotDemo` class demonstrates:

1. **Parking Lot Initialization**
   - Creates a parking lot with 2 floors
   - Adds 7 parking spots of different types (Small, Medium, Large)

2. **Vehicle Parking**
   - Parks a Car (uses Medium spot)
   - Parks a Bus (uses Large spot)
   - Parks a Truck (uses Large spot)

3. **Payment Processing**
   - Car exits with Cash payment
   - Bus exits with Online payment

4. **Spot Reuse**
   - After vehicles exit, new vehicles can use the freed spots
   - Demonstrates the nearest available spot strategy

## Design Patterns Used

### 1. Singleton Pattern
- `ParkingLot` class ensures only one instance exists

### 2. Strategy Pattern
- **Parking Strategy**: `NearestAvailableSpotStrategy` finds the nearest available spot
- **Cost Computation**: `StandardCostComputeStrategy` calculates parking fees
- **Payment Processing**: `CashPaymentProcessor` and `OnlinePaymentProcessor`

### 3. Factory Pattern
- `ParkingTicketGenerator` creates unique parking tickets

## Key Features

- ✓ Multiple vehicle types (Car, Bus, Truck)
- ✓ Multiple spot types (Small, Medium, Large)
- ✓ Smart spot allocation based on vehicle size
- ✓ Entry and exit gate management
- ✓ Ticket generation with UUID
- ✓ Cost calculation based on duration and spot type
- ✓ Multiple payment methods
- ✓ Thread-safe singleton implementation

## Architecture

```
ParkingLot (Singleton)
├── ParkingFloor (multiple)
│   └── ParkingSpot (multiple)
│       └── Vehicle
├── EntryGate
│   ├── ParkingStrategy
│   └── ParkingTicketGenerator
└── ExitGate
    ├── PaymentProcessor
    └── CostComputeStrategy
```

## Sample Output

```
=== Smart Parking Lot System Demo ===

Parking lot initialized with 2 floors and 7 spots

--- Scenario 1: Parking a Car ---
✓ Car parked successfully!
  Vehicle: ABC-1234
  Ticket ID: a4f54c42-44af-436d-8e1d-d43174c0b41a
  Spot ID: F1-M1
  Spot Type: MEDIUM

[... more scenarios ...]

=== Demo Complete ===
```

## Extending the System

You can easily extend this system by:

1. Adding new parking strategies (e.g., `ClosestToExitStrategy`)
2. Implementing new payment processors (e.g., `CardPaymentProcessor`)
3. Creating custom cost computation strategies (e.g., `PeakHourPricingStrategy`)
4. Adding more vehicle types (e.g., Motorcycle, Electric Vehicle)
5. Implementing reservation system
6. Adding parking spot availability notifications

## Notes

- The system uses time-based cost calculation
- Minimum parking duration is 0.5 hours
- Different spot types have different pricing multipliers
- The singleton pattern ensures centralized parking lot management
