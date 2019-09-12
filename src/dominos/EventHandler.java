package dominos;

public class EventHandler {
    private HumanPlayer p1;

    private ComputerPlayer p2;

    private Board board;

    private Boneyard boneyard;

    private double xCor;

    private double yCor;

    private Boolean gameOver = false;

    Boolean p1TurnOver = false;

    Boolean p2TurnOver = false;

    public EventHandler(HumanPlayer p1, ComputerPlayer p2, Board board, double xCor, double yCor, Boneyard boneyard) {
        this.p1 = p1;
        this.p2 = p2;
        this.board = board;
        this.xCor = xCor;
        this.yCor = yCor;
        this.boneyard = boneyard;
    }

    public void handleEvent() {
        int leftNode;

        int rightNode;

        int dominoNumber = 0;
        Boolean computerTurn = false;



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
                    p1.setClicked(true);
                    p1.setSelectedDomino(dominoNumber);
                }
            }

        }

        if(p1.isClicked()) {


            if(p1TurnOver) {
                computerTurn = true;
            }

            else if(!p1.hasValidMove() && boneyard.isEmpty() ) {
                computerTurn = true;
                p1TurnOver = true;
                p1.setClicked(false);
            }

            else if(!p1.hasValidMove()) {
                p1.getDomino();
                p1.setClicked(false);
            }

            else {
                p2TurnOver = false;

                if(xCor >= 20 && xCor <= 600 && yCor >= 280  && yCor <= 380) {
                    if(board.isValidMove(p1.getTray().getHumanDominos().get(dominoNumber).getLeftNode(),
                            p1.getTray().getHumanDominos().get(dominoNumber).getRightNode() , "l")) {
                        board.addDominos(p1.getTray().getHumanDominos().get(dominoNumber).getLeftNode(),
                                p1.getTray().getHumanDominos().get(dominoNumber).getRightNode(), "l");
                        p1.removeDominoFromTray(p1.getTray().getHumanDominos().get(dominoNumber).getLeftNode(),
                                p1.getTray().getHumanDominos().get(dominoNumber).getRightNode());
                        computerTurn = true;
                    }

                    if(board.isValidMove(p1.getTray().getHumanDominos().get(dominoNumber).getRightNode(),
                            p1.getTray().getHumanDominos().get(dominoNumber).getLeftNode(), "l")) {
                        board.addDominos(p1.getTray().getHumanDominos().get(dominoNumber).getRightNode(),
                                p1.getTray().getHumanDominos().get(dominoNumber).getLeftNode(), "l");
                        p1.removeDominoFromTray(p1.getTray().getHumanDominos().get(dominoNumber).getLeftNode(),
                                p1.getTray().getHumanDominos().get(dominoNumber).getRightNode());
                        computerTurn = true;
                    }

                }

                if(xCor > 600 && xCor <= 1180 && yCor >= 280 && yCor <= 380) {
                    if(board.isValidMove(p1.getTray().getHumanDominos().get(dominoNumber).getLeftNode(),
                            p1.getTray().getHumanDominos().get(dominoNumber).getRightNode() , "r")) {
                        board.addDominos(p1.getTray().getHumanDominos().get(dominoNumber).getLeftNode(),
                                p1.getTray().getHumanDominos().get(dominoNumber).getRightNode(), "r");
                        p1.removeDominoFromTray(p1.getTray().getHumanDominos().get(dominoNumber).getLeftNode(),
                                p1.getTray().getHumanDominos().get(dominoNumber).getRightNode());
                        computerTurn = true;
                    }

                    if(board.isValidMove(p1.getTray().getHumanDominos().get(dominoNumber).getRightNode(),
                            p1.getTray().getHumanDominos().get(dominoNumber).getLeftNode(), "r")) {
                        board.addDominos(p1.getTray().getHumanDominos().get(dominoNumber).getRightNode(),
                                p1.getTray().getHumanDominos().get(dominoNumber).getLeftNode(), "r");
                        p1.removeDominoFromTray(p1.getTray().getHumanDominos().get(dominoNumber).getLeftNode(),
                                p1.getTray().getHumanDominos().get(dominoNumber).getRightNode());
                        computerTurn = true;
                    }
                }

                p1.setClicked(false);
            }

        }

        if(computerTurn) {
            if(p2TurnOver) {
                return;
            }

            else if(!p2.hasValidMove() && boneyard.isEmpty() ) {
                p2TurnOver = true;
            }

            else if(!p2.hasValidMove()) {
                while(!p2.hasValidMove() && !boneyard.isEmpty()) {
                    p2.getDomino();
                    p1TurnOver = false;
                }

                if(!p2.hasValidMove() && boneyard.isEmpty()) {
                    p2TurnOver = true;
                }

                else {
                    leftNode = p2.getTray().getComputerDominos().get(p2.validMove()).getLeftNode();
                    rightNode = p2.getTray().getComputerDominos().get(p2.validMove()).getRightNode();

                    if(p2.getRotation().equals("n")) {
                        board.addDominos(leftNode, rightNode, p2.getValidDirection());
                        p2.removeDominoFromTray(leftNode, rightNode);
                    }

                    else if(p2.getRotation().equals("y")) {
                        board.addDominos(rightNode, rightNode, p2.getValidDirection());
                        p2.removeDominoFromTray(leftNode, rightNode);
                    }

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
                    board.addDominos(rightNode, rightNode, p2.getValidDirection());
                    p2.removeDominoFromTray(leftNode, rightNode);
                }
            }

        }

        if(p1TurnOver && p2TurnOver) {
            gameOver = true;
        }

    }

    public Boolean isGameOver () {
        return gameOver;
    }

}
