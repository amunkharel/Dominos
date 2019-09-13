/**
 * Project 2 - CS351, Fall 2019, Class to play game from console
 * @version Date 2019-09-13
 * @author Amun Kharel
 *
 *
 */

package dominos;
import java.util.Scanner;

public class ConsoleGame {

    /** Human Player for game */
    private HumanPlayer p1;
    /** Computer player for game*/
    private ComputerPlayer p2;

    /** Board for the game*/
    private Board board;

    /** Boneyard from where dominos can be drawn */
    private Boneyard boneyard;

    /** Checks if game is Over*/
    private boolean gameOver;

    /** String to show either p1/p2 for the game*/
    private String currentTurn;

    /**
     * Constructor for console game to initialize all required objects
     * in the game
     */
    public ConsoleGame() {
        this.boneyard = new Boneyard(6);
        this.board = new Board();
        this.p1 = new HumanPlayer(boneyard, board);
        this.p2 = new ComputerPlayer(boneyard, board);
        gameOver = false;
        currentTurn = "p1";

    }

    /**
     * Plays the game in the console using all game objects
     *
     */
    public void playGame() {
        String left;
        String right;
        int leftNode;
        int rightNode;
        String direction;
        String rotation;
        Boolean playerOneTurnOver = false;
        Boolean playerTwoTurnOver = false;
        while(!gameOver) {


            Scanner input = new Scanner(System.in);

            if(currentTurn.equals("p1")) {

                //if p1 turn is over goes to p2
                if(playerOneTurnOver) {
                    currentTurn = "p2";
                }

                //if does not have valid move and boneyard is empty
                //sets player turn over to true and switches players
                else if(!p1.hasValidMove() && boneyard.isEmpty()) {
                    System.out.println("You do not have a valid move " +
                            "and boneyard is empty. Switching turns");
                    currentTurn = "p2";
                    playerOneTurnOver = true;
                }

                //if does not have a valid move draws from boneyard
                else if(!p1.hasValidMove()) {
                    System.out.println("You do not have a valid move and" +
                            " choosing randomly from boneyard");
                    p1.getDomino();
                    playerTwoTurnOver = false;
                }

                //else lets user make a move
                else {
                    playerTwoTurnOver = false;
                    System.out.println(" Human Player: Your Tray has following Dominos: ");
                    for(int i = 0; i < p1.getTray().getHumanDominos().size(); i++) {

                        System.out.print( "(" + p1.getTray().getHumanDominos().get(i).getLeftNode() + ", "
                                + p1.getTray().getHumanDominos().get(i).getRightNode() + ") ,");
                    }
                    System.out.println(" ");

                    System.out.println("Please make your move. ");
                    System.out.println("Please enter your left node number in the dominos :");
                    left = input.next();
                    leftNode = Integer.parseInt(left);
                    System.out.println("Please enter your right node number in the dominos :");
                    right = input.next();
                    rightNode = Integer.parseInt(right);
                    System.out.println("Do you want to rotate [y/n] :");
                    rotation = input.next();

                    if(rotation.equals("n")) {
                        if(p1.DominoExists(leftNode, rightNode)) {
                            if(board.isEmpty()) {
                                board.addDominos(leftNode, rightNode, "0");
                                currentTurn = "p2";
                                p1.removeDominoFromTray(leftNode, rightNode);
                                board.printBoard();
                            }
                            else {
                                System.out.println("Please type 'l' to" +
                                        " play left and 'r' to play right :");
                                direction = input.next();

                                if(direction.equals("l") || direction.equals("r")) {
                                    if(board.isValidMove(leftNode, rightNode, direction)) {
                                        board.addDominos(leftNode, rightNode, direction);
                                        board.printBoard();
                                        p1.removeDominoFromTray(leftNode, rightNode);
                                        currentTurn = "p2";
                                    }

                                    else {
                                        System.out.println("Please make a valid move. ");
                                    }
                                }

                                else
                                {
                                    System.out.println("Not a valid direction");
                                }

                            }
                        }

                        else {
                            System.out.println("Given domino does not" +
                                    " exit in your tray");
                        }
                    }

                    else if (rotation.equals("y")) {
                        if(p1.DominoExists(leftNode, rightNode)) {
                            if(board.isEmpty()) {
                                board.addDominos(rightNode, leftNode, "0");
                                currentTurn = "p2";
                                p1.removeDominoFromTray(leftNode, rightNode);
                                board.printBoard();
                            }
                            else {
                                System.out.println("Please type 'l' to " +
                                        "play left and 'r' to play right :");
                                direction = input.next();

                                if(direction.equals("l") || direction.equals("r")) {
                                    if(board.isValidMove(rightNode, leftNode, direction)) {
                                        board.addDominos(rightNode, leftNode, direction);
                                        board.printBoard();
                                        p1.removeDominoFromTray(leftNode, rightNode);
                                        currentTurn = "p2";
                                    }

                                    else {
                                        System.out.println("Please make a valid move. ");
                                    }
                                }

                                else
                                {
                                    System.out.println("Not a valid direction");
                                }

                            }
                        }

                        else {
                            System.out.println("Given domino does not exit in your tray");
                        }
                    }

                    else {
                        System.out.println("Please type y or n for rotation");
                    }

                }


            }

            //if it is computer's turn, same logic
            // except make moves randomly if has valid move
            if(currentTurn.equals("p2")) {

                if(playerTwoTurnOver) {
                    currentTurn = "p1";
                }

                else if(!p2.hasValidMove() && boneyard.isEmpty()) {
                    System.out.println("Computer does not have a valid " +
                            "move and boneyard is empty. Switching turns");
                    currentTurn = "p1";
                    playerTwoTurnOver = true;
                }

                else if(!p2.hasValidMove()) {
                    System.out.println("Computer does not have a valid move " +
                            "and choosing randomly from boneyard");
                    p2.getDomino();
                    playerOneTurnOver = false;
                }

                else {
                    playerOneTurnOver = false;
                    System.out.println("Computer Player: Your Tray has following Dominos: ");
                    for(int i = 0; i < p2.getTray().getComputerDominos().size();
                        i++) {

                        System.out.print( "(" +
                                p2.getTray().getComputerDominos().get(i).getLeftNode() + ", "
                                + p2.getTray().getComputerDominos().get(i).getRightNode()
                                + ") ,");
                    }
                    System.out.println(" ");

                    leftNode = p2.getTray().getComputerDominos().get(p2.validMove()).getLeftNode();
                    rightNode = p2.getTray().getComputerDominos().get(p2.validMove()).getRightNode();

                    if(p2.getRotation().equals("n")) {
                        board.addDominos(leftNode, rightNode, p2.getValidDirection());
                        board.printBoard();
                        p2.removeDominoFromTray(leftNode, rightNode);
                        currentTurn = "p1";
                    }

                    else if(p2.getRotation().equals("y")) {
                        board.addDominos(rightNode, leftNode, p2.getValidDirection());
                        board.printBoard();
                        p2.removeDominoFromTray(leftNode, rightNode);
                        currentTurn = "p1";
                    }


                }

            }

            //if both player lose turn, game is over
            if(playerOneTurnOver && playerTwoTurnOver) {
                gameOver = true;
            }

        }

        //checks score to declare winner
        //whoever has less score wins the game
        //or is draw
        if(p1.countScore() > p2.countScore()) {
            System.out.println("Computer has won the game");
        }

        if(p1.countScore() < p2.countScore()) {
            System.out.println("Congratulations!! You have won the game");
        }

        if(p1.countScore() == p2.countScore()) {
            System.out.println("The game is a draw");
        }
    }


}
