/**
 * Project 2 - CS351, Fall 2019, Class for Computer Player's Tray
 * @version Date 2019-09-13
 * @author Amun Kharel
 *
 *
 */
package dominos;
import java.util.ArrayList;
import java.util.List;

public class ComputerTray {

    /** List of all computer Dominos */
    private List<Domino> computerDominos;

    /** Boneyard from where player can get dominos */
    private Boneyard boneyard;

    /**
     * Constructor for Computer's Tray
     *
     * @param Boneyard boneyard, boneyard from which tray can pick domino/dominos
     */
    public ComputerTray(Boneyard boneyard) {
        this.boneyard = boneyard;
    }

    /**
     * Asks some number of dominos from Boneyard
     *
     * @param int number, asks number number of dominos from boneyard
     */
    public void askForDominos(int number) {
        computerDominos = new ArrayList<Domino>();
        computerDominos = boneyard.giveNDominos(number);
    }

    /**
     * Returns list of all computer Dominos
     *
     * @return List<Domino>, returns all computer Dominos
     */
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

    /**
     * Asks Boneyard for one Domino
     *
     */
    public void askForDomino() {
        computerDominos.add(boneyard.giveDomino());
    }
}
