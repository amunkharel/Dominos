package dominos;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GameGui {

    private HumanPlayer humanPlayer;

    private Board board;

    private GraphicsContext gc;

    private Canvas canvas;


    private int dominoStartY;

    public GameGui(HumanPlayer humanPlayer, Board board, Canvas canvas, int dominoStartY) {
        this.humanPlayer = humanPlayer;

        this.board = board;

        this.canvas = canvas;


        this.dominoStartY = dominoStartY;
    }

    public void updateCanvas() {
        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.KHAKI);
        gc.fillRect(0, 0, 1200, 600);

        for(int i = 0; i < humanPlayer.getTray().getHumanDominos().size(); i++) {
            drawDomino(humanPlayer.getTray().getHumanDominos().get(i).getLeftNode(),
                    humanPlayer.getTray().getHumanDominos().get(i).getRightNode(), i, 20, dominoStartY);
        }

        drawBoard();
    }

    public void drawBoard() {
        gc.setFill(Color.LIGHTBLUE);
        gc.fillRect(20, 280, 580, 100);

        gc.setFill(Color.LIGHTPINK);
        gc.fillRect(600, 280, 580, 100);

        drawTopBoardDominos();
        drawBottomBoardDominos();

    }

    public void drawTopBoardDominos() {
        int startingXPixel = 580 - 40 * board.getTopLeftIndex();

        int startingYPixel = 300;

        for (int i = 0; i < board.getTopDominos().size(); i++) {
            drawDomino(board.getTopDominos().get(i).getLeftNode(),
                    board.getTopDominos().get(i).getRightNode(), i, startingXPixel, startingYPixel);
        }
    }

    public void drawBottomBoardDominos() {
        int startingXPixel = 600 - 40 * board.getBottomLeftIndex();
        int startingYPixel = 330;

        for (int i = 0; i < board.getBottomDominos().size(); i++) {
            drawDomino(board.getBottomDominos().get(i).getLeftNode(),
                    board.getBottomDominos().get(i).getRightNode(), i, startingXPixel, startingYPixel);
        }

    }

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
