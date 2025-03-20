import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class DeckOfCards {
    private static final char[] suits = {'S', 'H', 'D', 'C'};
    private static final String[] rank = {"1", "2", "3", "4", "5", "6", "7",
            "8", "9", "10", "11", "12", "13"};

    public static String[] dealHand(int n) {
        String[] hand = new String[n];
        Set<String> dealtCards = new HashSet<>();
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            String card;
            do {
                char suit = suits[random.nextInt(suits.length)];
                String value = rank[random.nextInt(rank.length)];
                card = suit + value;
            } while (dealtCards.contains(card));
            hand[i] = card;
            dealtCards.add(card);
        }
        return hand;
    }

    public static int calculateSum(String[] hand) {
        int sum = 0;
        for (String card : hand) {
            sum += Integer.parseInt(card.substring(1));
        }
        return sum;
    }

    public static int countSpades(String[] hand) {
        int count = 0;
        for (String card : hand) {
            if (card.charAt(0) == 'S') {
                count++;
            }
        }
        return count;
    }

    public static boolean hasSpadeQueen(String[] hand) {
        for (String card : hand) {
            if (card.equals("S12")) {
                return true;
            }
        }
        return false;
    }

    public static boolean isFlush(String[] hand) {
        char suit = hand[0].charAt(0);
        for (String card : hand) {
            if (card.charAt(0) != suit) {
                return false;
            }
        }
        return true;
    }
}
