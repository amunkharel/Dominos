package dominos;

import java.util.ArrayList;
import java.util.List;

public class HumanPlayer {
    private HumanTray tray;

    private Boneyard boneyard;


    public HumanPlayer(Boneyard boneyard) {
        this.boneyard = boneyard;
        tray = new HumanTray(boneyard);
        tray.askForDominos(7);
    }



    public HumanTray getTray() {
        return tray;
    }
}
