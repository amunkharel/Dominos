package dominos;

import java.util.ArrayList;
import java.util.List;

public class ComputerTray {

    private List<Domino> computerDominos;
    private Boneyard boneyard;

    public ComputerTray(Boneyard boneyard) {
        this.boneyard = boneyard;
    }

    public void askForDominos(int number) {
        computerDominos = new ArrayList<Domino>();
        computerDominos = boneyard.giveNDominos(number);
    }

    public List<Domino> getComputerDominos() {
        return computerDominos;
    }

    public void removeDomino(int leftNode, int rightNode) {
        for (int i = 0; i < computerDominos.size(); i++) {
            if(computerDominos.get(i).getRightNode() == rightNode
                    && computerDominos.get(i).getLeftNode() == leftNode) {
                computerDominos.remove(i);
            }
        }
    }
}
