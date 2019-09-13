/**
 * Project 2 - CS351, Fall 2019, Dynamic GUI class for the game
 * @version Date 2019-09-13
 * @author Amun Kharel
 *
 *
 */

package dominos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GameGui {

    /** Human Player for the game*/
    private HumanPlayer humanPlayer;
    /** Board where the move is made*/
    private Board board;

    /** Used to draw in the canvas */
    private GraphicsContext gc;

    /** Canvas of the GUI*/
    private Canvas canvas;

    /** starting location of human's domino in the tray*/
    private int dominoStartY;

    /**
     * Constructor for GUI class
     *
     * @param HumanPlayer p1,Human Player for the game
     * @param Board board, Board where the game is played
     * @param Canvas canvas, canvas where can be drawn
     * @param int dominoStartY, starting location of human tray
     */
    public GameGui(HumanPlayer humanPlayer, Board board, Canvas canvas,
                   int dominoStartY) {
        this.humanPlayer = humanPlayer;

        this.board = board;

        this.canvas = canvas;


        this.dominoStartY = dominoStartY;
    }

    /**
     *
     * Updates the whole canvas
     */
    public void updateCanvas() {
        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.KHAKI);
        gc.fillRect(0, 0, 1200, 600);

        //draws each domino in human tray
        for(int i = 0; i < humanPlayer.getTray().getHumanDominos().size(); i++) {

            //if domino is clicked, adds a border around it
            if(humanPlayer.isClicked()) {
                if(humanPlayer.getSelectedDomino() == i) {
                    gc.setStroke(Color.RED);
                    gc.setLineWidth(5);
                    gc.strokeRect(20 + 40*i, 500, 39, 30 );
                }
            }
            drawDomino(humanPlayer.getTray().getHumanDominos().get(i).getLeftNode(),
                    humanPlayer.getTray().getHumanDominos().get(i).getRightNode(), i,
                    20, dominoStartY);
        }

        //draws board of the game
        drawBoard();
    }

    /**
     *
     * Draw board with left blue and right pink color
     */
    public void drawBoard() {
        gc.setFill(Color.LIGHTBLUE);
        gc.fillRect(20, 280, 580, 100);

        gc.setFill(Color.LIGHTPINK);
        gc.fillRect(600, 280, 580, 100);

        //draws top board dominos
        drawTopBoardDominos();
        //draws bottom board dominos
        drawBottomBoardDominos();

    }

    /**
     *
     * Draws top board dominos
     */
    public void drawTopBoardDominos() {
        int startingXPixel = 580 - 40 * board.getTopLeftIndex();

        int startingYPixel = 300;

        for (int i = 0; i < board.getTopDominos().size(); i++) {
            drawDomino(board.getTopDominos().get(i).getLeftNode(),
                    board.getTopDominos().get(i).getRightNode(), i, startingXPixel, startingYPixel);
        }
    }

    /**
     *
     * Draws bottom board dominos
     */
    public void drawBottomBoardDominos() {
        int startingXPixel = 600 - 40 * board.getBottomLeftIndex();
        int startingYPixel = 330;

        for (int i = 0; i < board.getBottomDominos().size(); i++) {
            drawDomino(board.getBottomDominos().get(i).getLeftNode(),
                    board.getBottomDominos().get(i).getRightNode(), i, startingXPixel, startingYPixel);
        }

    }

    /**
     *
     * Draw individual dominos of the game
     *
     * @param int leftNode, LeftNode of the domino
     * @param int rightNode, RighNode of the domino
     * @param int i, index of domino
     * @param int startingXPixel, Starting x pixel of domino
     * @param int startingYPixel, Starting y pixel of domino
     */
    public void drawDomino(int leftNode, int rightNode, int i, int startingXPixel, int startingYpixel) {
        gc.setFill(Color.BLANCHEDALMOND);
        gc.fillRect(startingXPixel + 40*i, startingYpixel, 20, 30 );

        gc.setFill(Color.BISQUE);
        gc.fillRect(startingXPixel + 40*i +20, startingYpixel, 20, 30 );

        gc.setFill(Color.BLACK);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);
        gc.strokeRect(startingXPixel + 40*i, startingYpixel, 40, 30 );




        if(leftNode == 1) {
            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 10, startingYpixel + 15, 2, 2);
        }

        else if(leftNode == 2) {
            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 10, startingYpixel + 10, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 10, startingYpixel + 15, 2, 2);

        }

        else if(leftNode == 3) {
            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 10, startingYpixel + 10, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 10, startingYpixel + 15, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 10, startingYpixel + 20, 2, 2);
        }

        else if(leftNode == 4) {
            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 5, startingYpixel + 10, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 5, startingYpixel + 15, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 15, startingYpixel + 10, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 15, startingYpixel + 15, 2, 2);


        }

        else if(leftNode == 5) {
            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 5, startingYpixel + 10, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 5, startingYpixel + 15, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 15, startingYpixel + 10, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 15, startingYpixel + 15, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 10, startingYpixel + 20, 2, 2);


        }

        else if(leftNode == 6) {
            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 5, startingYpixel + 10, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 5, startingYpixel + 15, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 15, startingYpixel + 10, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 15, startingYpixel + 15, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 5, startingYpixel + 20, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 15, startingYpixel + 20, 2, 2);


        }

        else if(leftNode == 7) {
            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 5, startingYpixel + 10, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 5, startingYpixel + 15, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 15, startingYpixel + 10, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 15, startingYpixel + 15, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 5, startingYpixel + 20, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 15, startingYpixel + 20, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 10, startingYpixel + 25, 2, 2);


        }

        if(rightNode == 1) {
            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 30, startingYpixel + 15, 2, 2);
        }

        else if(rightNode == 2) {

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 30, startingYpixel + 10, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 30, startingYpixel + 15, 2, 2);
        }

        else if(rightNode == 3) {
            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 30, startingYpixel + 10, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 30, startingYpixel + 15, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 30, startingYpixel + 20, 2, 2);
        }

        else if(rightNode == 4) {
            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 25, startingYpixel + 10, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 25, startingYpixel + 15, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 35, startingYpixel + 10, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 35, startingYpixel + 15, 2, 2);
        }

        else if(rightNode == 5) {

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 25, startingYpixel + 10, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 25, startingYpixel + 15, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 35, startingYpixel + 10, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 35, startingYpixel + 15, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 30, startingYpixel + 20, 2, 2);
        }

        else if(rightNode == 6) {

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 25, startingYpixel + 10, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 25, startingYpixel + 15, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 35, startingYpixel + 10, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 35, startingYpixel + 15, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 25, startingYpixel + 20, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 35, startingYpixel + 20, 2, 2);


        }

        else if(rightNode == 7) {
            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 25, startingYpixel + 10, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 25, startingYpixel + 15, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 35, startingYpixel + 10, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 35, startingYpixel + 15, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 25, startingYpixel + 20, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 35, startingYpixel + 20, 2, 2);

            gc.setFill(Color.BLACK);
            gc.fillOval(startingXPixel + 40*i + 30, startingYpixel + 25, 2, 2);
        }

    }

}
