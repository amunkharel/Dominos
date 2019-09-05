package dominos;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        ConsoleGame consoleGame = new ConsoleGame();
        consoleGame.playGame();
        /*Boneyard boneyard = new Boneyard(7);
        //System.out.println(boneyard.numberOfDominosInBoneyard);
        ArrayList<Domino> dominos = new ArrayList<Domino>();
        dominos = boneyard.getDominos();

        /*for (int i = 0; i < boneyard.numberOfDominosInBoneyard; i++) {
            System.out.println("(" + dominos.get(i).getLeftNode() +", " + dominos.get(i).getRightNode() + ")");
        }

        String spaces = "      ";

        String top = "";
        String bottom = "   ";

        int topLeftIndex = 3;

        int bottomLeftIndex = 2;

        int center = 5;

        int topDifference = center-topLeftIndex;

        int bottomDifference = center - bottomLeftIndex;
        Map<Integer, String> topLeftDominos = new HashMap<>();

        topLeftDominos.put(4, "(4, 6)");
        topLeftDominos.put(2, "(5, 6)");
        for (int i = 0; i < center; i++){

            if(i >= topDifference)
            {
                if(topLeftDominos.containsKey(i)) {
                    top = top + topLeftDominos.get(i);
                }

                else {
                    top = top + spaces;
                }
            }
            else {
                top = top + spaces;
            }

            if(i >= bottomDifference)
            {
                bottom = bottom + "(2, 6)";
            }
            else {
                bottom = bottom + spaces;
            }

        }

        top = top + "(1, 2)";
        bottom = bottom + "(2, 6)";

        int topRightIndex = 3;
        for(int j = 0; j < topRightIndex; j++)
        {
            top = top + "(3, 4)";
        }

        System.out.println(top);
        System.out.println(bottom);*/

        System.exit(0);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
