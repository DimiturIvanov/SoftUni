/*
You have to make a catalogue for vehicles. You will receive two types of vehicle - car or truck.
Until you receive the command &quot;End&quot; you will receive lines of input in the format:
{typeOfVehicle} {model} {color} {horsepower}
After the "End" command, you will start receiving models of vehicles. Print for every received vehicle its data in the
format:
Type: {typeOfVehicle}
Model: {modelOfVehicle}
Color: {colorOfVehicle}
Horsepower: {horsepowerOfVehicle}
When you receive the command "Close the Catalogue", stop receiving input and print the average horsepower for
the cars and for the trucks in the format:
"{typeOfVehicles} have average horsepower of {averageHorsepower}."
The average horsepower is calculated by dividing the sum of horsepower for all vehicles of the type by the total
count of vehicles from the same type.
Format the answer to the 2 nd decimal point.
Constraints
- The type of vehicle will always be car or truck
- You will not receive the same model twice
- The received horsepower will be integer in the interval [1…1000]
- You will receive at most 50 vehicles
- Single whitespace will be used for separator
 */
package Fundamentals.Lect6_ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex6_VehicleCatalogue {

    static class Vehicle {
        private String type;
        private String model;
        private String color;
        private int horsePower;

        public Vehicle(String typeOfVehicle, String model, String color, int horsePower) {
            this.type = typeOfVehicle;
            this.model = model;
            this.color = color;
            this.horsePower = horsePower;
        }

        public String getTypeOfVehicle() {
            return type;
        }

        public String getModel() {
            return model;
        }

        public String getColor() {
            return color;
        }

        public int getHorsePower() {
            return horsePower;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Vehicle> carCatalogue = new ArrayList<>();
        List<Vehicle> truckCatalogue = new ArrayList<>();

        String command = scanner.nextLine();


        double sumCarHorsePower = 0;
        int countCar = 0;

        double sumTruckHorsePower = 0;
        int countTruck = 0;

        while (!command.equals("End")) {
            String[] line = command.split("\\s+");

            String type = "";
            String model = line[1];
            String color = line[2];
            int horsePower = Integer.parseInt(line[3]);

            if (line[0].equals("car")) {
                sumCarHorsePower += horsePower;
                countCar++;
                type = "Car";
                Vehicle vehicle = new Vehicle(type, model, color, horsePower);
                carCatalogue.add(vehicle);
            } else if (line[0].equals("truck")) {
                sumTruckHorsePower += horsePower;
                countTruck++;
                type = "Truck";
                Vehicle vehicle = new Vehicle(type, model, color, horsePower);
                truckCatalogue.add(vehicle);
            }

            command = scanner.nextLine();
        }

        String type = scanner.nextLine();

        while (!type.equals("Close the Catalogue")) {
            for (Vehicle car : carCatalogue) {
                if (type.equals(car.getModel())) {
                    System.out.printf("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d%n", car.getTypeOfVehicle(),
                            car.getModel(), car.getColor(), car.getHorsePower());
                }
            }

            for (Vehicle truck : truckCatalogue) {
                if (type.equals(truck.getModel())) {
                    System.out.printf("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d%n", truck.getTypeOfVehicle(),
                            truck.getModel(), truck.getColor(), truck.getHorsePower());
                }
            }

            type = scanner.nextLine();
        }

        if (countCar != 0) {
            System.out.printf("Cars have average horsepower of: %.2f.%n", sumCarHorsePower / countCar);
        } else {
            System.out.printf("Cars have average horsepower of: %.2f.%n", 0.00);
        }

        if (countTruck != 0) {
            System.out.printf("Trucks have average horsepower of: %.2f.", sumTruckHorsePower / countTruck);
        } else {
            System.out.printf("Trucks have average horsepower of: %.2f.", 0.00);
        }

    }
}
