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
        int counter = 0;
        Scanner input = new Scanner(System.in);
        int leftNode;
        int rightNode;
        String direction;
        while(!gameOver) {

            if(currentTurn.equals("p1")) {
                System.out.println("Your Tray has following Dominos: ");
                for(int i = 0; i < p1.getTray().getHumanDominos().size(); i++) {

                    System.out.print( "(" + p1.getTray().getHumanDominos().get(i).getLeftNode() + ", "
                            + p1.getTray().getHumanDominos().get(i).getRightNode() + ") ,");
                }
                System.out.println(" ");

                System.out.println("Please make your move. ");
                System.out.println("Please enter your left node number in the dominos :");
                leftNode = input.nextInt();
                System.out.println("Please enter your right node number in the dominos :");
                rightNode = input.nextInt();

                if(p1.DominoExists(leftNode, rightNode)) {
                    if(board.isBottomEmpty()) {
                        board.addDominos(leftNode, rightNode, "0");
                        board.bottomIsEmpty = false;
                        board.isTop = true;
                        currentTurn = "p2";
                    }
                    else {
                        System.out.println("Please type 'l' to play left and 'r' to play right :");
                        direction = input.next();

                        if(direction.equals('l')) {
                            if(board.isValidMove(leftNode, rightNode, direction)) {
                                board.addDominos(leftNode, rightNode, direction);
                                if(board.isTop) {
                                    board.setTopLeftIndex();
                                    board.isTop = false;
                                }
                                else {
                                    board.setBottomLeftIndex();
                                    board.isTop = true;
                                }
                                currentTurn = "p2";
                            }

                            else {
                                System.out.println("Please make a valid move. ");
                            }
                        }

                    }
                }
                counter++;




            }

            if(counter > 3) {
                gameOver = true;
            }

        }
    }


}
