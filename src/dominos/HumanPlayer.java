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
}
