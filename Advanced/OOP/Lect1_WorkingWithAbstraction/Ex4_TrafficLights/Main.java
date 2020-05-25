/*
Implement a simple state machine in the form of a traffic light. Every traffic light has three possible signals - red,
green and yellow. Each traffic light can be updated, which changes the color of its signal (e.g. if it is currently red, it
changes to green, if it is green it changes to yellow). The order of signals is red -> green -> yellow -> red and so on.
On the first line you will be given multiple traffic light signals in the format &quot;RED GREEN YELLOW&quot;. They may be 3,
more or less than 3. You need to make as many traffic lights as there are signals in the input.
On the second line, you will receive the n number of times you need to change each traffic light`s signal.
Your output should consist of n number of lines, including each updated traffic light`s signal. To better understand
the problem, see the example below.
 */
package Advanced.OOP.Lect1_WorkingWithAbstraction.Ex4_TrafficLights;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TrafficLight[] trafficLights = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(TrafficLight::valueOf)
                .toArray(TrafficLight[]::new);

        int n = scanner.nextInt();

        TrafficLight[] lights = TrafficLight.values();

        StringBuilder builder = new StringBuilder();

        while (n-- > 0) {
            for (int i = 0; i < trafficLights.length; i++) {
                int index = (trafficLights[i].ordinal() + 1) % lights.length;
                trafficLights[i] = lights[index];
                builder.append(trafficLights[i].toString()).append(" ");
            }
            builder.append(System.lineSeparator());
        }

        System.out.println(builder.toString());

    }
}
