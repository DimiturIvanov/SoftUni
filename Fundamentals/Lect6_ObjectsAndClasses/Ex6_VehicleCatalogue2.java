package Fundamentals.Lect6_ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex6_VehicleCatalogue2 {
    public static class Vehicle {
        private String type;
        private String model;
        private String color;
        private int horsePower;

        public Vehicle(String type, String model, String color, int horsePower) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsePower = horsePower;
        }

        public String getType() {
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

        @Override
        public String toString() {
            return String.format("Type: %s\n" +
                            "Model: %s\n" +
                            "Color: %s\n" +
                            "Horsepower: %d", getType().toUpperCase().charAt(0) + this.getType().substring(1),
                    getModel(), getColor(), getHorsePower());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Vehicle> vehicles = new ArrayList<>();
        while (!"End".equals(input)) {

            String[] line = input.split("\\s+");

            String type = line[0];
            String model = line[1];
            String color = line[2];
            int horsePower = Integer.parseInt(line[3]);

            Vehicle vehicle = new Vehicle(type, model, color, horsePower);
            vehicles.add(vehicle);

            input = scanner.nextLine();
        }

        String model = scanner.nextLine();
        while (!"Close the Catalogue".equals(model)) {
            String finalModel = model;
            vehicles.stream()
                    .filter(v -> v.getModel().equals(finalModel))
                    .forEach(System.out::println);
        }

        System.out.println(String.format("Cars have average horsepower of: %.2f.", average(vehicles.stream()
                .filter(v -> v.getType().equals("car"))
                .collect(Collectors.toList()))));

        System.out.println(String.format("Trucks have average horsepower of: %.2f.", average(vehicles.stream()
                .filter(v -> v.getType().equals("truck"))
                .collect(Collectors.toList()))));

        model = scanner.nextLine();
    }

    private static double average(List<Vehicle> vehicles) {
        if (vehicles.size() == 0) {
            return 0.0;
        }
        double sum = 0;

        for (Vehicle vehicle : vehicles) {
            sum += vehicle.getHorsePower();
        }
        return sum / vehicles.size();
    }
}


