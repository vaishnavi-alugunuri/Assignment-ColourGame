import java.util.*;

public class ColourGame {
    private static final Map<String, List<String>> things = new HashMap<>();
    private static final Set<String> subscriptions = new HashSet<>();

    static {
        things.put("Banana", Arrays.asList("Green", "Yellow"));
        things.put("Ink", Arrays.asList("Red", "Black"));
        things.put("Salt", List.of("White"));
        things.put("Blood", List.of("Red"));
        things.put("Sky", Arrays.asList("Blue", "Black"));
        things.put("Apple", Arrays.asList("Green", "Red"));
        things.put("Frog", Arrays.asList("Blue", "Yellow"));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Colour Game started. Enter a command:");

        while (true) {
            input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting Colour Game.");
                break;
            } else if (input.equalsIgnoreCase("list")) {
                listSubscriptions();
            } else if (input.startsWith("+")) {
                subscribe(input.substring(1).trim());
            } else if (input.startsWith("-")) {
                unsubscribe(input.substring(1).trim());
            } else {
                notifySubscribedThings(input);
            }
        }

        scanner.close();
    }

    private static void subscribe(String thing) {
        if (things.containsKey(thing)) {
            subscriptions.add(thing);
            System.out.println(thing + " has been subscribed.");
        } else {
            System.out.println(thing + " is not in the list of things.");
        }
    }

    private static void unsubscribe(String thing) {
        if (subscriptions.remove(thing)) {
            System.out.println(thing + " has been unsubscribed.");
        } else {
            System.out.println(thing + " was not subscribed.");
        }
    }

    private static void listSubscriptions() {
        if (subscriptions.isEmpty()) {
            System.out.println("No subscriptions.");
        } else {
            System.out.println("Subscribed things:");
            for (String subscription : subscriptions) {
                System.out.println(subscription);
            }
        }
    }

    private static void notifySubscribedThings(String color) {
        // Loop through each subscribed item
        for (String subscription : subscriptions) {
            // Get the list of colors for the current subscription
            List<String> colors = things.get(subscription);

            // Check if the current subscription has a list of colors
            if (colors != null) {
                if (colors.contains(color)) {
                    // Print the general message if the color matches
                    System.out.println("I'm " + subscription + "! I'm sometimes " + color.toLowerCase() + "!");
                } else {
                    // Print the message for non-matching color
                    System.out.println("I'm " + subscription + "! I am " + color.toLowerCase() + " today.");
                }
            }
        }
    }
}