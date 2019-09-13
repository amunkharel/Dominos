/**
 * Project 2 - CS351, Fall 2019, Class that handles Event after each click
 * in the canvas
 * @version Date 2019-09-13
 * @author Amun Kharel
 *
 *
 */

package dominos;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class EventHandler {

    /** Human Player for the game*/
    private HumanPlayer p1;

    /** Computer Player for the game */
    private ComputerPlayer p2;

    /** Board where the game is played*/
    private Board board;

    /** Boneyard from where dominos are drawn*/
    private Boneyard boneyard;

    /** X cordinate of pixel clicked*/
    private double xCor;

    /** Y cordinate of pixel clicked */
    private double yCor;

    /** Text to show number of dominos computer has in GUI*/
    private Text numberOfComputerDominos;

    /** Text to show number of dominos in boneyard in GUI*/
    private Text numberOfBoneyard;

    /** Checks to see if game is over or not*/
    private Boolean gameOver = false;

    /** Checks if player one turn is over or not*/
    Boolean p1TurnOver = false;

    /** Checks to see if computer player's turn is over or not*/
    Boolean p2TurnOver = false;

    /**
     * Constructor for event handler
     *
     * @param HumanPlayer p1,Human Player for the game
     * @param ComputerPlayer p2,Computer Player for the game
     * @param Board board, Board where the game is played
     * @param double xCor, X cordinate of pixel clicked
     * @param double yCor, Y cordinate of pixel clicked
     * @param Boneyard boneyard, Boneyard from where dominos are drawn
     * @param Text numberOfBoneyard, Text to show number of dominos
     *             in boneyard in GUI
     * @param Text numberOfComputerDominos, Text to show number of
     *             dominos computer has in GUI
     */
    public EventHandler(HumanPlayer p1, ComputerPlayer p2, Board board,
                        double xCor, double yCor, Boneyard boneyard,
                        Text numberOfBoneyard, Text numberOfComputerDominos) {
        this.p1 = p1;
        this.p2 = p2;
        this.board = board;
        this.xCor = xCor;
        this.yCor = yCor;
        this.boneyard = boneyard;
        this.numberOfComputerDominos = numberOfComputerDominos;
        this.numberOfBoneyard = numberOfBoneyard;
    }

    /**
     *
     * Handles each click in the GUI's canvas
     */

    public void handleEvent() {
        int leftNode;

        int rightNode;

        int dominoNumber = 0;

        Boolean computerTurn = false;

        //if human does not have valid move
        // and boneyard is not empty gets domino
        if(!p1.hasValidMove() && !boneyard.isEmpty()) {
            p1.getDomino();
            p1.setClicked(false);
            System.out.println("You do not have a valid move. Drawing " +
                    "From Boneyard");
        }

        //if human does not have valid move and boneyard is empty
        //switches turn and unsets click
        if(!p1.hasValidMove() && boneyard.isEmpty() ) {
            computerTurn = true;
            p1TurnOver = true;
            p1.setClicked(false);
            System.out.println("You do not have a valid move." +
                    " Boneyard Empty. Switching turns");
        }

        //if we click in human tray
        if(xCor >= 20 && yCor >= 500  && yCor <= 530) {
            xCor = xCor - 20;

            dominoNumber = (int) xCor/ 40;

            if(p1.getTray().getHumanDominos().size() > dominoNumber) {

                if(board.isEmpty()) {
                    board.addDominos(p1.getTray().getHumanDominos().
                                    get(dominoNumber).getLeftNode(),
                            p1.getTray().getHumanDominos().get(dominoNumber)
                                    .getRightNode(), "0");
                    computerTurn = true;
                    p1.removeDominoFromTray(p1.getTray().getHumanDominos()
                                    .get(dominoNumber).getLeftNode(),
                            p1.getTray().getHumanDominos().
                                    get(dominoNumber).getRightNode());
                }
                else {

                    if(p1.isClicked()) {
                        if(p1.getSelectedDomino() == dominoNumber) {
                            leftNode = p1.getTray().getHumanDominos().
                                    get(dominoNumber).getLeftNode();
                            rightNode = p1.getTray().getHumanDominos().
                                    get(dominoNumber).getRightNode();
                            p1.addDomino(dominoNumber,rightNode, leftNode);
                            p1.removeDominoFromTray(leftNode, rightNode);

                        }
                    }
                    p1.setClicked(true);
                    p1.setSelectedDomino(dominoNumber);
                }
            }

        }

        //if domino is clicked, checks click on the board
        //if board is clicked checks if move can made and acts accordinly
        if(p1.isClicked()) {
            if(!p1TurnOver) {


                if(xCor >= 20 && xCor <= 600 && yCor >= 280  && yCor <= 380) {
                    if(board.isValidMove(p1.getTray().getHumanDominos().
                                    get(p1.getSelectedDomino()).getLeftNode(),
                            p1.getTray().getHumanDominos().get(p1.
                                    getSelectedDomino()).getRightNode() , "l")) {

                        board.addDominos(p1.getTray().getHumanDominos()
                                        .get(p1.getSelectedDomino()).getLeftNode(),
                                p1.getTray().getHumanDominos().
                                        get(p1.getSelectedDomino()).
                                        getRightNode(), "l");
                        p1.removeDominoFromTray(p1.getTray().getHumanDominos().
                                        get(p1.getSelectedDomino()).getLeftNode(),
                                p1.getTray().getHumanDominos().get(p1.
                                        getSelectedDomino()).getRightNode());
                        computerTurn = true;
                        p1.setClicked(false);
                        p2TurnOver = false;
                    }

                    else if(board.isValidMove(p1.getTray().getHumanDominos().
                                    get(p1.getSelectedDomino()).getRightNode(),
                            p1.getTray().getHumanDominos().get(p1.getSelectedDomino())
                                    .getLeftNode(), "l")) {
                        board.addDominos(p1.getTray().getHumanDominos().
                                        get(p1.getSelectedDomino()).getRightNode(),
                                p1.getTray().getHumanDominos().get(p1.getSelectedDomino())
                                        .getLeftNode(), "l");
                        p1.removeDominoFromTray(p1.getTray().getHumanDominos().
                                        get(p1.getSelectedDomino()).getLeftNode(),
                                p1.getTray().getHumanDominos().
                                        get(p1.getSelectedDomino()).getRightNode());
                        computerTurn = true;
                        p1.setClicked(false);
                        p2TurnOver = false;
                    }

                    else {
                        System.out.println("Not a valid move to the left");
                    }

                }

                if(xCor > 600 && xCor <= 1180 && yCor >= 280 && yCor <= 380) {
                    if(board.isValidMove(p1.getTray().getHumanDominos().
                                    get(p1.getSelectedDomino()).getLeftNode(),
                            p1.getTray().getHumanDominos().
                                    get(p1.getSelectedDomino()).
                                    getRightNode() , "r")) {
                        board.addDominos(p1.getTray().getHumanDominos()
                                        .get(p1.getSelectedDomino()).getLeftNode(),
                                p1.getTray().getHumanDominos()
                                        .get(p1.getSelectedDomino()).
                                        getRightNode(), "r");
                        p1.removeDominoFromTray(p1.getTray().
                                        getHumanDominos().
                                        get(p1.getSelectedDomino()).getLeftNode(),
                                p1.getTray().getHumanDominos()
                                        .get(p1.getSelectedDomino()).getRightNode());
                        computerTurn = true;
                        p1.setClicked(false);
                        p2TurnOver = false;
                    }

                    else if(board.isValidMove(p1.getTray()
                                    .getHumanDominos().get(p1.
                                            getSelectedDomino()).getRightNode(),
                            p1.getTray().getHumanDominos().get(p1.
                                    getSelectedDomino()).getLeftNode(), "r")) {
                        board.addDominos(p1.getTray().getHumanDominos()
                                        .get(p1.getSelectedDomino()).getRightNode(),
                                p1.getTray().getHumanDominos().get(p1.
                                        getSelectedDomino()).getLeftNode(), "r");
                        p1.removeDominoFromTray(p1.getTray().
                                        getHumanDominos().get(p1.
                                        getSelectedDomino()).getLeftNode(),
                                p1.getTray().getHumanDominos().get(p1
                                        .getSelectedDomino()).getRightNode());
                        computerTurn = true;
                        p1.setClicked(false);
                        p2TurnOver = false;
                    }

                    else {
                        System.out.println("Not a valid move to the right");
                    }
                }


            }

        }

        //computer's turn. Same logic but picks dominos randomly
        if(computerTurn) {
            if(!p2.hasValidMove() && boneyard.isEmpty() ) {
                p2TurnOver = true;
            }

            else if(!p2.hasValidMove()) {
                while(!p2.hasValidMove() && !boneyard.isEmpty()) {
                    p2.getDomino();
                    System.out.println("Computer does not have a" +
                            " valid move. Drawing from Boneyard");
                }

                if(!p2.hasValidMove() && boneyard.isEmpty()) {
                    p2TurnOver = true;
                }

                else if(p2.hasValidMove()) {
                    leftNode = p2.getTray().getComputerDominos()
                            .get(p2.validMove()).getLeftNode();
                    rightNode = p2.getTray().getComputerDominos()
                            .get(p2.validMove()).getRightNode();

                    if(p2.getRotation().equals("n")) {
                        board.addDominos(leftNode, rightNode, p2.getValidDirection());
                        p2.removeDominoFromTray(leftNode, rightNode);
                    }

                    else if(p2.getRotation().equals("y")) {
                        board.addDominos(rightNode, leftNode, p2.getValidDirection());
                        p2.removeDominoFromTray(leftNode, rightNode);
                    }
                    p1TurnOver = false;

                }

            }

            else {
                p1TurnOver = false;
                leftNode = p2.getTray().getComputerDominos().
                        get(p2.validMove()).getLeftNode();
                rightNode = p2.getTray().getComputerDominos()
                        .get(p2.validMove()).getRightNode();

                if(p2.getRotation().equals("n")) {
                    board.addDominos(leftNode, rightNode,
                            p2.getValidDirection());
                    p2.removeDominoFromTray(leftNode, rightNode);
                }

                else if(p2.getRotation().equals("y")) {
                    board.addDominos(rightNode, leftNode,
                            p2.getValidDirection());
                    p2.removeDominoFromTray(leftNode, rightNode);
                }
            }

        }

        numberOfBoneyard.setText("Boneyard contains "
                + boneyard.getNumberOfDominosInBoneyard() + " dominos");
        numberOfBoneyard.setFont(Font.font("Verdana", 20));

        numberOfComputerDominos.setText("Computer has " +
                p2.getTray().getComputerDominos().size() + " dominos");
        numberOfComputerDominos.setFont(Font.font("Verdana", 20));

        //if game is over sets gameOver equals true
        if(p1TurnOver && p2TurnOver) {
            gameOver = true;
        }

    }

    /**
     * Returns true if game is over
     *
     * @return Boolean, returns true if game is over and vice versa
     */
    public Boolean isGameOver () {
        return gameOver;
    }

}
