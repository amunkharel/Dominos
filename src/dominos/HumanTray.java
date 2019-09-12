package dominos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HumanTray {
    private List<Domino> humanDominos;
    private Boneyard boneyard;

    public HumanTray(Boneyard boneyard) {
        this.boneyard = boneyard;
    }

    public void askForDominos(int number) {
        humanDominos = new ArrayList<Domino>();
        humanDominos = boneyard.giveNDominos(number);
    }

    public void askForDomino() {
        humanDominos.add(boneyard.giveDomino());
    }

    public List<Domino> getHumanDominos() {
        return humanDominos;
    }

    public void removeDomino(int leftNode, int rightNode) {
        for (int i = 0; i < humanDominos.size(); i++) {
            if(humanDominos.get(i).getRightNode() == rightNode
                    && humanDominos.get(i).getLeftNode() == leftNode) {
                humanDominos.remove(i);
            }
        }
    }

    public void addDomino(int index, int leftNode, int rightNode) {
        humanDominos.add(index, new Domino(leftNode, rightNode));
    }
}
