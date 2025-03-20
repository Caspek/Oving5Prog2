import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class javafx extends Application {

    private String[] hand;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button dealButton = new Button("Deal Hand");
        Button checkButton = new Button("Check Hand");
        Label handLabel = new Label();
        Label sumLabel = new Label();
        Label spadesCountLabel = new Label();
        Label spadeQueenLabel = new Label();
        Label flushLabel = new Label();

        dealButton.setOnAction(event -> {
            hand = DeckOfCards.dealHand(5);
            handLabel.setText("Hand: " + java.util.Arrays.toString(hand));
        });

        checkButton.setOnAction(event -> {
            if (hand != null) {
                sumLabel.setText("Sum of cards: " + DeckOfCards.calculateSum(hand));
                spadesCountLabel.setText("Number of Spades: " + DeckOfCards.countSpades(hand));
                spadeQueenLabel.setText("Has Spade Queen: " + DeckOfCards.hasSpadeQueen(hand));
                flushLabel.setText("Is Flush: " + DeckOfCards.isFlush(hand));
            } else {
                sumLabel.setText("Please deal a hand first.");
            }
        });

        VBox root = new VBox(10, dealButton, checkButton, handLabel, sumLabel, spadesCountLabel, spadeQueenLabel, flushLabel);
        Scene scene = new Scene(root, 600, 400);

        primaryStage.setTitle("Card Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
