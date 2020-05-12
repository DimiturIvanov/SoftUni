/*
You are the owner of a courier company and want to make a system for tracking your cars and their cargo. Define a
class Car that holds information about model, engine, cargo and a collection of exactly 4 tires. The engine, cargo
and tire should be separate classes, create a constructor that receives all information about the Car and creates and
initializes its inner components (engine, cargo and tires).
On the first line of input you will receive a number N - the number of cars you have, on each of the next N lines you
will receive information about a car in the format “<Model> <EngineSpeed> <EnginePower> <CargoWeight> <CargoType>
<Tire1Pressure> <Tire1Age> <Tire2Pressure> <Tire2Age> <Tire3Pressure> <Tire3Age> <Tire4Pressure> <Tire4Age>”
where the speed, power, weight and tire age are integers, tire pressure is a double.
After the N lines you will receive a single line with one of 2 commands “fragile” or “flamable” , if the command is
“fragile” print all cars whose Cargo Type is “fragile” with a tire whose pressure is &lt; 1, if the command is “flamable”
print all cars whose Cargo Type is “flamable” and have Engine Power &gt; 250. The cars should be printed in order of
appearing in the input.
 */
package Fundamentals.Lect6_ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex2_RawData {

    static class Tire {
        private double tirePressure;
        private int tireAge;

        public Tire(double tirePressure, int tireAge) {
            this.tirePressure = tirePressure;
            this.tireAge = tireAge;
        }
    }

    static class Car {
        private String model;
        private int engineSpeed;
        private int enginePower;
        private int cargoWeight;
        private String cargoType;
        private List<Tire> tires;

        public Car(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType, List<Tire> tires) {
            this.model = model;
            this.engineSpeed = engineSpeed;
            this.enginePower = enginePower;
            this.cargoWeight = cargoWeight;
            this.cargoType = cargoType;
            this.tires = tires;
        }

        public String getModel() {
            return model;
        }

        public String getCargoType() {
            return cargoType;
        }

        public List<Tire> getTires() {
            return tires;
        }

        public int getEnginePower() {
            return enginePower;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberCars = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 1; i <= numberCars; i++) {
            String[] line = scanner.nextLine().split(" +");

            String model = line[0];
            int engineSpeed = Integer.parseInt(line[1]);
            int enginePower = Integer.parseInt(line[2]);
            int cargoWeight = Integer.parseInt(line[3]);
            String cargoType = line[4];

            List<Tire> tires = new ArrayList<>();

            for (int j = 5; j < line.length - 1; j += 2) {
                double tirePressure = Double.parseDouble(line[j]);
                int tireAge = Integer.parseInt(line[j + 1]);

                Tire tire = new Tire(tirePressure, tireAge);
                tires.add(tire);
            }

            Car car = new Car(model, engineSpeed, enginePower, cargoWeight, cargoType, tires);
            cars.add(car);
        }

        String command = scanner.nextLine();

        List<String> model = new ArrayList<>();

        if (command.equals("fragile")) {
            for (Car car : cars) {
                if (car.getCargoType().equals("fragile")) {
                    List<Tire> tires = car.getTires();
                    for (int i = 0; i < tires.size(); i++) {
                        if (tires.get(i).tirePressure < 1) {
                            System.out.println(car.getModel());
                            break;
                        }
                    }
                }
            }
        } else if (command.equals("flamable")) {
            for (Car car : cars) {
                if (car.getCargoType().equals("flamable")) {
                    if (car.getEnginePower() > 250) {
                        System.out.println(car.getModel());
                    }
                }
            }
        }

    }
}
