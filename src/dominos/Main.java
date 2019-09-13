/**
 * Project 2 - CS351, Fall 2019, Main Class to run the Dominos Game
 * @version Date 2019-09-13
 * @author Amun Kharel
 *
 *
 */

package dominos;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    /** Boneyard of the game where we draw from: largest Number is 6*/
    private Boneyard boneyard = new Boneyard(6);

    /** Board where we each player place their dominos*/
    private Board board = new Board();

    /** Human Player of the game*/
    private  HumanPlayer p1 = new HumanPlayer(boneyard, board);

    /** Computer Player of the game*/
    private ComputerPlayer p2 = new ComputerPlayer(boneyard, board);

    /** Object that handles the click in the board*/
    private EventHandler e;

    /** Text to show number of boneyard in the GUI*/
    private Text numberOfBoneyard = new Text();

    /** Text to show number of computer dominos in the GUI*/
    private Text numberOfComputerDominos = new Text();

    /** BorderPane layout for the game*/
    private BorderPane bp = new BorderPane();

    /** Canvas to draw the game board and player's tray*/
    private Canvas canvas = new Canvas(1200, 600);

    /** starting postion of y-axis of player's tray*/
    private int dominoStartY = 500;

    /** Dynamic GUI object for the game*/
    private GameGui gui = new GameGui(p1, board,canvas, dominoStartY);

    /** Scene where the pane is stored in the game*/
    private Scene scene = new Scene(bp, 1200, 1000);

    /** Alert dialog box after game is over */
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);

    /**
     * Method where the program starts. This method pulls out logic and gui board
     * to make this game work
     *
     * @param Stage stage, Stage where the Board GUI for this game is placed
     */

    @Override
    public void start(Stage primaryStage) throws Exception{

        //Uncomment the code below to play the console game
        /*ConsoleGame consoleGame = new ConsoleGame();
        consoleGame.playGame();

        System.exit(0); */

        //Shows number of dominos left in boneyard
        numberOfBoneyard.setText("Boneyard contains " +
                boneyard.getNumberOfDominosInBoneyard() + " dominos");
        numberOfBoneyard.setFont(Font.font("Verdana", 20));

        //text that shows number of dominos computer holds
        numberOfComputerDominos.setText("Computer has " +
                p2.getTray().getComputerDominos().size() + " dominos");
        numberOfComputerDominos.setFont(Font.font("Verdana", 20));


        //mouse-click event handler for the game. If game is over
        //shows who won in the dialog box
        canvas.setOnMousePressed(new javafx.event.EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                e = new EventHandler(p1, p2, board,
                        event.getX(), event.getY(), boneyard,
                        numberOfBoneyard, numberOfComputerDominos);
                e.handleEvent();

                if(e.isGameOver()) {
                    if(p1.countScore() > p2.countScore()) {
                        alert.setTitle("Game Over");
                        alert.setContentText("Computer has won the game");
                        alert.showAndWait();
                        primaryStage.close();
                    }

                    if(p1.countScore() < p2.countScore()) {
                        alert.setTitle("Game Over");
                        alert.setContentText("Congratulations!!" +
                                " You have won the game");
                        alert.showAndWait();
                        primaryStage.close();
                    }

                    if(p1.countScore() == p2.countScore()) {
                        alert.setTitle("Game Over");
                        alert.setContentText("The game is a draw");
                        alert.showAndWait();
                        primaryStage.close();
                    }

                }
            }
        });

        //animation timer where GUI is refreshed periodically
        AnimationTimer animator = new AnimationTimer() {
            @Override
            public void handle(long now) {

                gui.updateCanvas();

            }
        };

        animator.start();

        //placement of canvas, and other texts
        bp.setCenter(canvas);

        bp.setTop(numberOfBoneyard);
        bp.setAlignment(numberOfBoneyard, Pos.CENTER);
        bp.setBottom(numberOfComputerDominos);
        bp.setAlignment(numberOfComputerDominos, Pos.CENTER);

        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
