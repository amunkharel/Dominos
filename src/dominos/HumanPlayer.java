package dominos;

public class HumanPlayer {
    private HumanTray tray;

    private Boneyard boneyard;

    private Board board;


    public HumanPlayer(Boneyard boneyard, Board board) {
        this.boneyard = boneyard;
        this.board = board;
        tray = new HumanTray(boneyard);
        tray.askForDominos(7);
    }



    public HumanTray getTray() {
        return tray;
    }


    public boolean DominoExists(int leftNode, int rightNode) {
        for(int i = 0; i < tray.getHumanDominos().size(); i++) {
            if(tray.getHumanDominos().get(i).getRightNode() == rightNode &&
                    tray.getHumanDominos().get(i).getLeftNode() == leftNode) {
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
        for (int i = 0; i < tray.getHumanDominos().size(); i++) {
            if(tray.getHumanDominos().get(i).getRightNode() == board.getAllDominos().get(0).getLeftNode()
            || tray.getHumanDominos().get(i).getRightNode() == 0 || board.getAllDominos().get(0).getLeftNode() == 0
            || tray.getHumanDominos().get(i).getLeftNode() == board.getAllDominos().get(board.totalDominos).getRightNode()
                    || tray.getHumanDominos().get(i).getLeftNode() == 0
            || board.getAllDominos().get(board.totalDominos).getRightNode() ==0) {
                return true;
            }
        }
        return false;
    }

    public void getDomino() {
        tray.askForDomino();
    }

    public int countScore() {
        int score = 0;
        for (int i = 0; i < tray.getHumanDominos().size(); i++) {
            score += tray.getHumanDominos().get(i).getLeftNode();
            score += tray.getHumanDominos().get(i).getRightNode();
        }

        return score;
    }
}
