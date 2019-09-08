package dominos;

import java.util.Scanner;

public class ConsoleGame {

    private HumanPlayer p1;

    private ComputerPlayer p2;

    private Board board;

    private Boneyard boneyard;

    private boolean gameOver;

    private String currentTurn;

    public ConsoleGame() {
        this.boneyard = new Boneyard(6);
        this.board = new Board();
        this.p1 = new HumanPlayer(boneyard, board);
        this.p2 = new ComputerPlayer(boneyard, board);
        gameOver = false;
        currentTurn = "p1";

    }


    public void playGame() {
        String left;
        String right;
        int leftNode;
        int rightNode;
        String direction;
        while(!gameOver) {

            Scanner input = new Scanner(System.in);

            if(currentTurn.equals("p1")) {
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

                if(p1.DominoExists(leftNode, rightNode)) {
                    if(board.isEmpty()) {
                        board.addDominos(leftNode, rightNode, "0");
                        currentTurn = "p2";
                        p1.removeDominoFromTray(leftNode, rightNode);
                        board.printBoard();
                    }
                    else {
                        System.out.println("Please type 'l' to play left and 'r' to play right :");
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

            }
            if(currentTurn.equals("p2")) {
                System.out.println("Computer Player: Your Tray has following Dominos: ");
                for(int i = 0; i < p2.getTray().getComputerDominos().size(); i++) {

                    System.out.print( "(" + p2.getTray().getComputerDominos().get(i).getLeftNode() + ", "
                            + p2.getTray().getComputerDominos().get(i).getRightNode() + ") ,");
                }
                System.out.println(" ");

                System.out.println("Please make your move. ");
                System.out.println("Please enter your left node number in the dominos :");
                left = input.next();
                leftNode = Integer.parseInt(left);
                System.out.println("Please enter your right node number in the dominos :");
                right = input.next();
                rightNode = Integer.parseInt(right);

                if(p2.DominoExists(leftNode, rightNode)) {

                    System.out.println("Please type 'l' to play left and 'r' to play right :");
                    direction = input.next();

                    if(direction.equals("l") || direction.equals("r")) {
                        if(board.isValidMove(leftNode, rightNode, direction)) {
                            board.addDominos(leftNode, rightNode, direction);
                            board.printBoard();
                            p2.removeDominoFromTray(leftNode, rightNode);
                            currentTurn = "p1";
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

        }
    }


}
