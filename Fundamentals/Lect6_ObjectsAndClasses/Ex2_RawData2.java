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

public class Ex2_RawData2 {

    static class Tire {
        private double tirePressure;
        private int tireAge;

        public Tire(double tirePressure, int tireAge) {
            this.tirePressure = tirePressure;
            this.tireAge = tireAge;
        }

        public double getTirePressure() {
            return tirePressure;
        }
    }

    static class Engine {
        private int engineSpeed;
        private int enginePower;

        public Engine(int engineSpeed, int enginePower) {
            this.engineSpeed = engineSpeed;
            this.enginePower = enginePower;
        }

        public int getEnginePower() {
            return enginePower;
        }
    }

    static class Cargo {
        private int cargoWeight;
        private String cargoType;

        public Cargo(int cargoWeight, String cargoType) {
            this.cargoWeight = cargoWeight;
            this.cargoType = cargoType;
        }

        public String getCargoType() {
            return cargoType;
        }
    }

    static class Car {
        private String model;
        private Engine engine;
        private Cargo cargo;
        private List<Tire> tires;

        public Car(String model, Engine engine, Cargo cargo, List<Tire> tires) {
            this.model = model;
            this.engine = engine;
            this.cargo = cargo;
            this.tires = tires;
        }

        public String getModel() {
            return model;
        }

        public Engine getEngine() {
            return engine;
        }

        public Cargo getCargo() {
            return cargo;
        }

        public List<Tire> getTires() {
            return tires;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberCar = Integer.parseInt(scanner.nextLine());

        List<Car> carList = new ArrayList<>();

        for (int i = 1; i <= numberCar; i++) {
            String[] line = scanner.nextLine().split("\\s+");

            String model = line[0];
            int engineSpeed = Integer.parseInt(line[1]);
            int enginePower = Integer.parseInt(line[2]);
            int cargoWeight = Integer.parseInt(line[3]);
            String cargoType = line[4];

            List<Tire> tireList = new ArrayList<>();

            for (int j = 5; j < line.length; j += 2) {
                if (j < line.length - 1) {
                    double tirePressure = Double.parseDouble(line[j]);
                    int tireAge = Integer.parseInt(line[j + 1]);
                    Tire tire = new Tire(tirePressure, tireAge);
                    tireList.add(tire);
                }
            }

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Car car = new Car(model, engine, cargo, tireList);
            carList.add(car);
        }

        String command = scanner.nextLine();

        List<String> model = new ArrayList<>();

        switch (command) {
            case "fragile":
                for (int i = 0; i < carList.size(); i++) {
                    if (carList.get(i).getCargo().getCargoType().equals(command)) {
                        if (carList.get(i).getTires().get(i).getTirePressure() < 1) {
                            model.add(carList.get(i).getModel());
                        }
                    }
                }
                model.forEach(System.out::println);
                break;
            case "flamable":
                carList.forEach(e -> {
                    if (e.getCargo().getCargoType().equals("flamable")
                            && e.getEngine().getEnginePower() > 250) {
                        System.out.println(String.format("%s", e.getModel()));
                    }
                });
                break;
            default:
                break;
        }

    }
}
