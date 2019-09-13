/**
 * Project 2 - CS351, Fall 2019, Domino of the game
 * @version Date 2019-09-13
 * @author Amun Kharel
 *
 *
 */
package dominos;
public class Domino {

    /** Left Node of Domino */
    private int leftNode;

    /** Right Node of Domino */
    private int rightNode;

    /**
     * Constructor for Domino
     *
     * @param int leftNode, left Node of Domino
     * @param int rightNode, right Node of Domino
     */
    public Domino(int leftNode, int rightNode) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    /**
     * Returns left Node for Domino
     *
     * @return int, left Node of Domino
     */
    public int getLeftNode() {
        return leftNode;
    }

    /**
     * Returns right node for Domino
     *
     * @return int, right Node of Domino
     */
    public int getRightNode() {
        return rightNode;
    }
}
