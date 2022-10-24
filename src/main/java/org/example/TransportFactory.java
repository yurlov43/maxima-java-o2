package org.example;

public class TransportFactory {
    public Transport getTransport(City city, int weight, int hours) {
        Transport transport;
        int speed = getSpeed(city.getDistanceKm(), hours);
        int capacity = getCapacity(weight);

        if (speed <= 40 && city.isOnWater()) {
            transport = getShip(capacity, speed);
        } else if (speed >= 120 && city.isHasAirport()) {
            transport = getPlane(capacity, speed);
        } else {
            transport = getTruck(capacity, speed);
        }
        return transport;
    }
    private int getCapacity(int weight) {
        int multipleValue = 500;
        return weight <= multipleValue ? multipleValue : weight + (multipleValue - weight % multipleValue);
    }
    private int getSpeed(int distance, int hours) {
        int speed = distance / hours;
        int multipleValue = 10;
        return speed <= multipleValue ? multipleValue : speed + (multipleValue - speed % multipleValue);
    }
    private Ship getShip(int capacity, int speed) {
        String shipName = "Ship";
        int shipCostOfKm = 56;
        return new Ship(shipName, capacity, speed, shipCostOfKm);
    }

    private Plane getPlane(int capacity, int speed) {
        String planeName = "Plane";
        int planeCostOfKm = 15;
        return new Plane(planeName, capacity, speed, planeCostOfKm);
    }

    private Truck getTruck(int capacity, int speed) {
        String truckName = "Truck";
        int truckCostOfKm = 34;
        return new Truck(truckName, capacity, speed, truckCostOfKm);
    }
}
