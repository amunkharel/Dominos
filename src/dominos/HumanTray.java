/**
 * Project 2 - CS351, Fall 2019, Class for Human Player's Tray
 * @version Date 2019-09-13
 * @author Amun Kharel
 *
 *
 */
package dominos;
import java.util.ArrayList;
import java.util.List;

public class HumanTray {

    /** List of all human Dominos */
    private List<Domino> humanDominos;

    /** Boneyard from where player can get dominos */
    private Boneyard boneyard;

    /**
     * Constructor for Human's Tray
     *
     * @param Boneyard boneyard, boneyard from which tray can pick domino/dominos
     */
    public HumanTray(Boneyard boneyard) {
        this.boneyard = boneyard;
    }

    /**
     * Asks some number of dominos from Boneyard
     *
     * @param int number, asks number number of dominos from boneyard
     */
    public void askForDominos(int number) {
        humanDominos = new ArrayList<Domino>();
        humanDominos = boneyard.giveNDominos(number);
    }

    /**
     * Asks Boneyard for one Domino
     *
     */
    public void askForDomino() {
        humanDominos.add(boneyard.giveDomino());
    }

    /**
     * Returns list of all human Dominos
     *
     * @return List<Domino>, returns all human Dominos
     */
    public List<Domino> getHumanDominos() {
        return humanDominos;
    }

    /**
     * Removes domino from the tray
     *
     * @param int leftNode, leftNode of the domino
     * @param int righNode, rightNode of the domino
     */
    public void removeDomino(int leftNode, int rightNode) {
        for (int i = 0; i < humanDominos.size(); i++) {
            if(humanDominos.get(i).getRightNode() == rightNode
                    && humanDominos.get(i).getLeftNode() == leftNode) {
                humanDominos.remove(i);
            }
        }
    }

    /**
     * Adds domino to certain index in the tray
     *
     * @param int index, index of the list of dominos
     * @param int leftNode, leftNode of the domino
     * @param int righNode, rightNode of the domino
     */
    public void addDomino(int index, int leftNode, int rightNode) {
        humanDominos.add(index, new Domino(leftNode, rightNode));
    }
}
