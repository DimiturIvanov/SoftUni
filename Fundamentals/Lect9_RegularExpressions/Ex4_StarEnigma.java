package Fundamentals.Lect9_RegularExpressions;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex4_StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int msgCount = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> decryptedMsgs = new LinkedHashMap<>();
        Pattern msgReq = Pattern.compile("[STARstar]+");

        for (int i = 0; i < msgCount; i++) {

            String message = scanner.nextLine();
            Matcher msgReqMatch = msgReq.matcher(message);
            StringBuilder valid = new StringBuilder();

            while (msgReqMatch.find()) {
                valid.append(msgReqMatch.group());
            }
            int count = valid.toString().length();
            decryptedMsgs.put(message, count);

        }
        Pattern messageReader = Pattern.compile("(?<planet>[A-Z][a-z]+)(?:[^@\\-!:>]*):(?<population>(\\d)+)" +
                "(?:[^@\\-!:>]*)!(?<attack>[AD])!(?:[^@\\-!:>]*)->(?<soldierCount>\\d+)");

        Map<String, List<String>> planets = new LinkedHashMap<>();
        planets.put("A", new ArrayList<>());
        planets.put("D", new ArrayList<>());

        for (Map.Entry<String, Integer> entry : decryptedMsgs.entrySet()) {

            StringBuilder decrypted = new StringBuilder();
            String currentMessage = entry.getKey();

            for (int i = 0; i < currentMessage.length(); i++) {
                char currentChar = (char) (currentMessage.charAt(i) - entry.getValue());
                decrypted.append(currentChar);
            }
            Matcher matcher = messageReader.matcher(decrypted);

            if (matcher.find()) {
                String attackType = matcher.group("attack");
                String planet = matcher.group("planet");
                planets.get(attackType).add(planet);
            }
        }
        planets.entrySet().forEach(pair -> {
            String type = "";
            if (pair.getKey().equals("A")) {
                type = "Attacked planets: ";
            } else {
                type = "Destroyed planets: ";
            }
            System.out.println(type + pair.getValue().size());
            pair.getValue().stream().sorted().forEach(e -> System.out.println("-> " + e));
        });

    }
}
