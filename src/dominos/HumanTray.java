package dominos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HumanTray {
    List<Domino> humanDominos;
    Boneyard boneyard;

    public HumanTray(Boneyard boneyard) {
        this.boneyard = boneyard;
    }

    public void askForDominos(int number) {
        humanDominos = new ArrayList<Domino>();
        humanDominos = boneyard.giveNDominos(number);
    }

    public List<Domino> getHumanDominos() {
        return humanDominos;
    }
}
