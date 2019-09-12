package dominos;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    private Boneyard boneyard = new Boneyard(6);

    private Board board = new Board();

    private  HumanPlayer p1 = new HumanPlayer(boneyard, board);

    private ComputerPlayer p2 = new ComputerPlayer(boneyard, board);

    private EventHandler e;

    private Text numberOfBoneyard;

    private Text numberOfComputerDominos;

    private BorderPane bp = new BorderPane();

    private Canvas canvas = new Canvas(1200, 600);

    private int dominoStartY = 500;

    private GameGui gui = new GameGui(p1, board,canvas, dominoStartY);

    private Scene scene = new Scene(bp, 1200, 1000);

    private Alert alert = new Alert(Alert.AlertType.INFORMATION);

    @Override
    public void start(Stage primaryStage) throws Exception{

        /* Uncomment to play the console game
        ConsoleGame consoleGame = new ConsoleGame();
        consoleGame.playGame();
        **/



        canvas.setOnMousePressed(new javafx.event.EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                e = new EventHandler(p1, p2, board, event.getX(), event.getY(), boneyard);
                e.handleEvent();
            }
        });

        AnimationTimer animator = new AnimationTimer() {
            @Override
            public void handle(long now) {

                gui.updateCanvas();

            }
        };

        animator.start();

        bp.setCenter(canvas);
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
