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
}
