package dominos;

public class ComputerPlayer {

    private ComputerTray tray;

    private Boneyard boneyard;

    private Board board;

    private String validDirection;

    private String rotation;


    public ComputerPlayer(Boneyard boneyard, Board board) {
        this.boneyard = boneyard;
        this.board = board;
        tray = new ComputerTray(boneyard);
        tray.askForDominos(7);
        validDirection = "";
        rotation = "";
    }



    public ComputerTray getTray() {
        return tray;
    }

    public boolean DominoExists(int leftNode, int rightNode) {
        for(int i = 0; i < tray.getComputerDominos().size(); i++) {
            if(tray.getComputerDominos().get(i).getRightNode() == rightNode &&
                    tray.getComputerDominos().get(i).getLeftNode() == leftNode) {
                return true;
            }
        }
        return false;
    }

    public void removeDominoFromTray(int leftNode, int rightNode) {
        tray.removeDomino(leftNode, rightNode);
    }

    public boolean hasValidMove() {

        if(board.isEmpty()) {
            return true;
        }
        for (int i = 0; i < tray.getComputerDominos().size(); i++) {
            if(tray.getComputerDominos().get(i).getRightNode() == board.getAllDominos().get(0).getLeftNode()
                    || tray.getComputerDominos().get(i).getLeftNode() == board.getAllDominos().get(0).getLeftNode()
                    || tray.getComputerDominos().get(i).getRightNode() == 0 || board.getAllDominos().get(0).getLeftNode() == 0
                    || tray.getComputerDominos().get(i).getLeftNode() == board.getAllDominos().get(board.totalDominos).getRightNode()
                    || tray.getComputerDominos().get(i).getRightNode() == board.getAllDominos().get(board.totalDominos).getRightNode()
                    || tray.getComputerDominos().get(i).getLeftNode() == 0
                    || board.getAllDominos().get(board.totalDominos).getRightNode() ==0) {
                return true;
            }
        }
        return false;
    }

    public int validMove() {
        int validMove = 0;

        if(board.isEmpty()) {
            return validMove;
        }

        for (int i = 0; i < tray.getComputerDominos().size(); i++) {
            if(tray.getComputerDominos().get(i).getRightNode() == board.getAllDominos().get(0).getLeftNode()){
                this.validDirection = "l";
                rotation = "n";
                return i;
            }

            if(tray.getComputerDominos().get(i).getLeftNode() == board.getAllDominos().get(0).getLeftNode()){
                this.validDirection = "l";
                rotation = "y";
                return i;
            }

            if(tray.getComputerDominos().get(i).getRightNode() == 0 ) {
                this.validDirection = "l";
                rotation = "n";
                return i;
            }

            if(board.getAllDominos().get(0).getLeftNode() == 0) {
                this.validDirection = "l";
                rotation = "n";
                return i;
            }

            if(tray.getComputerDominos().get(i).getLeftNode() == board.getAllDominos().get(board.totalDominos).getRightNode()) {
                this.validDirection = "r";
                rotation = "n";
                return i;
            }
            if(tray.getComputerDominos().get(i).getRightNode() == board.getAllDominos().get(board.totalDominos).getRightNode()) {
                this.validDirection = "r";
                rotation = "y";
                return i;
            }

            if(tray.getComputerDominos().get(i).getLeftNode() == 0) {
                this.validDirection = "r";
                rotation = "n";
                return i;
            }

            if(board.getAllDominos().get(board.totalDominos).getRightNode() ==0) {
                this.validDirection = "r";
                rotation = "n";
                return i;
            }
        }


        return  validMove;
    }

    public void getDomino() {
        tray.askForDomino();
    }

    public int countScore() {
        int score = 0;
        for (int i = 0; i < tray.getComputerDominos().size(); i++) {
            score += tray.getComputerDominos().get(i).getLeftNode();
            score += tray.getComputerDominos().get(i).getRightNode();
        }

        return score;
    }

    public String getValidDirection() {
        return validDirection;
    }

    public String getRotation() {
        return rotation;
    }
}
