package dominos;

public class ComputerPlayer {

    private ComputerTray tray;

    private Boneyard boneyard;

    private Board board;


    public ComputerPlayer(Boneyard boneyard, Board board) {
        this.boneyard = boneyard;
        this.board = board;
        tray = new ComputerTray(boneyard);
        tray.askForDominos(7);
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
}
