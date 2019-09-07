package dominos;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        ConsoleGame consoleGame = new ConsoleGame();
        consoleGame.playGame();

        System.exit(0);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
