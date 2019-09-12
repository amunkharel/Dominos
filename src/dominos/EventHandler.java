package dominos;

import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class EventHandler {
    private HumanPlayer p1;

    private ComputerPlayer p2;

    private Board board;

    private Boneyard boneyard;

    private double xCor;

    private double yCor;

    private Text numberOfComputerDominos;

    private Text numberOfBoneyard;

    private Boolean gameOver = false;

    Boolean p1TurnOver = false;

    Boolean p2TurnOver = false;

    public EventHandler(HumanPlayer p1, ComputerPlayer p2, Board board,
                        double xCor, double yCor, Boneyard boneyard, Text numberOfBoneyard, Text numberOfComputerDominos) {
        this.p1 = p1;
        this.p2 = p2;
        this.board = board;
        this.xCor = xCor;
        this.yCor = yCor;
        this.boneyard = boneyard;
        this.numberOfComputerDominos = numberOfComputerDominos;
        this.numberOfBoneyard = numberOfBoneyard;
    }

    public void handleEvent() {
        int leftNode;

        int rightNode;

        int dominoNumber = 0;

        Boolean computerTurn = false;

        if(!p1.hasValidMove() && !boneyard.isEmpty()) {
            p1.getDomino();
            p1.setClicked(false);
            System.out.println("You do not have a valid move. Drawing From Boneyard");
        }

        if(!p1.hasValidMove() && boneyard.isEmpty() ) {
            computerTurn = true;
            p1TurnOver = true;
            p1.setClicked(false);
            System.out.println("You do not have a valid move. Boneyard Empty. Switching turns");
        }

        if(xCor >= 20 && yCor >= 500  && yCor <= 530) {
            xCor = xCor - 20;

            dominoNumber = (int) xCor/ 40;

            if(p1.getTray().getHumanDominos().size() > dominoNumber) {

                if(board.isEmpty()) {
                    board.addDominos(p1.getTray().getHumanDominos().get(dominoNumber).getLeftNode(),
                            p1.getTray().getHumanDominos().get(dominoNumber).getRightNode(), "0");
                    computerTurn = true;
                    p1.removeDominoFromTray(p1.getTray().getHumanDominos().get(dominoNumber).getLeftNode(),
                            p1.getTray().getHumanDominos().get(dominoNumber).getRightNode());
                }
                else {

                    if(p1.isClicked()) {
                        if(p1.getSelectedDomino() == dominoNumber) {
                            leftNode = p1.getTray().getHumanDominos().get(dominoNumber).getLeftNode();
                            rightNode = p1.getTray().getHumanDominos().get(dominoNumber).getRightNode();
                            p1.addDomino(dominoNumber,rightNode, leftNode);
                            p1.removeDominoFromTray(leftNode, rightNode);

                        }
                    }
                    p1.setClicked(true);
                    p1.setSelectedDomino(dominoNumber);
                }
            }

        }

        if(p1.isClicked()) {
            if(!p1TurnOver) {


                if(xCor >= 20 && xCor <= 600 && yCor >= 280  && yCor <= 380) {
                    if(board.isValidMove(p1.getTray().getHumanDominos().get(p1.getSelectedDomino()).getLeftNode(),
                            p1.getTray().getHumanDominos().get(p1.getSelectedDomino()).getRightNode() , "l")) {

                        board.addDominos(p1.getTray().getHumanDominos().get(p1.getSelectedDomino()).getLeftNode(),
                                p1.getTray().getHumanDominos().get(p1.getSelectedDomino()).getRightNode(), "l");
                        p1.removeDominoFromTray(p1.getTray().getHumanDominos().get(p1.getSelectedDomino()).getLeftNode(),
                                p1.getTray().getHumanDominos().get(p1.getSelectedDomino()).getRightNode());
                        computerTurn = true;
                        p1.setClicked(false);
                        p2TurnOver = false;
                    }

                    else if(board.isValidMove(p1.getTray().getHumanDominos().get(p1.getSelectedDomino()).getRightNode(),
                            p1.getTray().getHumanDominos().get(p1.getSelectedDomino()).getLeftNode(), "l")) {
                        board.addDominos(p1.getTray().getHumanDominos().get(p1.getSelectedDomino()).getRightNode(),
                                p1.getTray().getHumanDominos().get(p1.getSelectedDomino()).getLeftNode(), "l");
                        p1.removeDominoFromTray(p1.getTray().getHumanDominos().get(p1.getSelectedDomino()).getLeftNode(),
                                p1.getTray().getHumanDominos().get(p1.getSelectedDomino()).getRightNode());
                        computerTurn = true;
                        p1.setClicked(false);
                        p2TurnOver = false;
                    }

                    else {
                        System.out.println("Not a valid move to the left");
                    }

                }

                if(xCor > 600 && xCor <= 1180 && yCor >= 280 && yCor <= 380) {
                    if(board.isValidMove(p1.getTray().getHumanDominos().get(p1.getSelectedDomino()).getLeftNode(),
                            p1.getTray().getHumanDominos().get(p1.getSelectedDomino()).getRightNode() , "r")) {
                        board.addDominos(p1.getTray().getHumanDominos().get(p1.getSelectedDomino()).getLeftNode(),
                                p1.getTray().getHumanDominos().get(p1.getSelectedDomino()).getRightNode(), "r");
                        p1.removeDominoFromTray(p1.getTray().getHumanDominos().get(p1.getSelectedDomino()).getLeftNode(),
                                p1.getTray().getHumanDominos().get(p1.getSelectedDomino()).getRightNode());
                        computerTurn = true;
                        p1.setClicked(false);
                        p2TurnOver = false;
                    }

                    else if(board.isValidMove(p1.getTray().getHumanDominos().get(p1.getSelectedDomino()).getRightNode(),
                            p1.getTray().getHumanDominos().get(p1.getSelectedDomino()).getLeftNode(), "r")) {
                        board.addDominos(p1.getTray().getHumanDominos().get(p1.getSelectedDomino()).getRightNode(),
                                p1.getTray().getHumanDominos().get(p1.getSelectedDomino()).getLeftNode(), "r");
                        p1.removeDominoFromTray(p1.getTray().getHumanDominos().get(p1.getSelectedDomino()).getLeftNode(),
                                p1.getTray().getHumanDominos().get(p1.getSelectedDomino()).getRightNode());
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

        if(computerTurn) {
            if(!p2.hasValidMove() && boneyard.isEmpty() ) {
                p2TurnOver = true;
            }

            else if(!p2.hasValidMove()) {
                while(!p2.hasValidMove() && !boneyard.isEmpty()) {
                    p2.getDomino();
                    System.out.println("Computer does not have a valid move. Drawing from Boneyard");
                }

                if(!p2.hasValidMove() && boneyard.isEmpty()) {
                    p2TurnOver = true;
                }

                else if(p2.hasValidMove()) {
                    leftNode = p2.getTray().getComputerDominos().get(p2.validMove()).getLeftNode();
                    rightNode = p2.getTray().getComputerDominos().get(p2.validMove()).getRightNode();

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
                leftNode = p2.getTray().getComputerDominos().get(p2.validMove()).getLeftNode();
                rightNode = p2.getTray().getComputerDominos().get(p2.validMove()).getRightNode();

                if(p2.getRotation().equals("n")) {
                    board.addDominos(leftNode, rightNode, p2.getValidDirection());
                    p2.removeDominoFromTray(leftNode, rightNode);
                }

                else if(p2.getRotation().equals("y")) {
                    board.addDominos(rightNode, leftNode, p2.getValidDirection());
                    p2.removeDominoFromTray(leftNode, rightNode);
                }
            }

        }

        numberOfBoneyard.setText("Boneyard contains " + boneyard.getNumberOfDominosInBoneyard() + " dominos");
        numberOfBoneyard.setFont(Font.font("Verdana", 20));

        numberOfComputerDominos.setText("Computer has " + p2.getTray().getComputerDominos().size() + " dominos");
        numberOfComputerDominos.setFont(Font.font("Verdana", 20));

        if(p1TurnOver && p2TurnOver) {
            gameOver = true;
        }

    }

    public Boolean isGameOver () {
        return gameOver;
    }

}
