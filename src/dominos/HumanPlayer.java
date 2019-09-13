/**
 * Project 2 - CS351, Fall 2019, Class for Human Player
 * @version Date 2019-09-13
 * @author Amun Kharel
 *
 *
 */

package dominos;
public class HumanPlayer {
    /** Tray Human is holding which has dominos*/
    private HumanTray tray;

    /** Boneyard from which Tray can draw dominos*/
    private Boneyard boneyard;

    /** Board where computer can make a move*/
    private Board board;

    /** Domino currently selected by player*/
    private int selectedDomino;

    /** Human has something in his hand*/
    private boolean clicked;


    /**
     * Constructor for Human Player
     *
     * @param Boneyard boneyard, boneyard from which tray can pick
     *                domino/dominos
     * @param Board board, Board where computer can make a move
     */
    public HumanPlayer(Boneyard boneyard, Board board) {
        this.boneyard = boneyard;
        this.board = board;
        tray = new HumanTray(boneyard);
        tray.askForDominos(7);
        clicked = false;
    }


    /**
     * Gets what's in the tray of human player
     *
     * @return HumanTray , gets tray of human player
     */
    public HumanTray getTray() {
        return tray;
    }

    /**
     * Checks if the given domino exists in the tray or not
     *
     * @param int leftNode, LeftNode of the domino
     * @param int rightNode, rightNode of the domino
     * @boolean, returns true if given domino exists in the tray
     */
    public boolean DominoExists(int leftNode, int rightNode) {
        for(int i = 0; i < tray.getHumanDominos().size(); i++) {
            if(tray.getHumanDominos().get(i).getRightNode() == rightNode &&
                    tray.getHumanDominos().get(i).getLeftNode() == leftNode) {
                return true;
            }
        }
        return false;
    }

    /**
     * Removes Domino From the Tray
     *
     * @param int leftNode, LeftNode of the domino
     * @param int rightNode, rightNode of the domino
     */
    public void removeDominoFromTray(int leftNode, int rightNode) {
        tray.removeDomino(leftNode, rightNode);
    }

    /**
     * Checks if Human has valid move in the board
     *
     * @return boolean, returns true if has valid move, else false
     *
     */
    public boolean hasValidMove() {

        if(board.isEmpty()) {
            return true;
        }
        for (int i = 0; i < tray.getHumanDominos().size(); i++) {
            if(tray.getHumanDominos().get(i).getRightNode()
                    == board.getAllDominos().get(0).getLeftNode()
            || tray.getHumanDominos().get(i).getLeftNode()
                    == board.getAllDominos().get(0).getLeftNode()
            || tray.getHumanDominos().get(i).getRightNode()
                    == 0
                    || board.getAllDominos().get(0).getLeftNode() == 0
            || tray.getHumanDominos().get(i).getLeftNode()
                    == board.getAllDominos().get(board.totalDominos).getRightNode()
                    || tray.getHumanDominos().get(i).getLeftNode() == 0
            || tray.getHumanDominos().get(i).getRightNode()
                    == board.getAllDominos().get(board.totalDominos).getRightNode()
            || board.getAllDominos().get(board.totalDominos).getRightNode() ==0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Asks tray to get domino from boneyard
     *
     */
    public void getDomino() {
        tray.askForDomino();
    }

    /**
     * Counts score and returns total score of the human player
     *
     * @return int, countscore for after game is over
     */
    public int countScore() {
        int score = 0;
        for (int i = 0; i < tray.getHumanDominos().size(); i++) {
            score += tray.getHumanDominos().get(i).getLeftNode();
            score += tray.getHumanDominos().get(i).getRightNode();
        }

        return score;
    }

    /**
     * Returns true if some domino is clicked
     *  by human on GUI
     *
     * @return boolean, returns true if some domino is clicked
     * by human on GUI
     */
    public boolean isClicked() {
        return clicked;
    }

    /**
     * Sets if domino is clicked or not
     *
     * @param boolean clicked, click is either true or false
     *
     */
    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    /**
     * Sets clicked domino number
     *
     * @param int selectedDomino, clicks certain domino
     *
     */
    public void setSelectedDomino(int selectedDomino) {
        this.selectedDomino = selectedDomino;
    }

    /**
     * Returns selected Domino
     *
     * @return int, returns selected Domino
     *
     */
    public int getSelectedDomino() {
        return selectedDomino;
    }

    /**
     * Adds domino in a certain index in tray
     *
     * @param int index, index of domino in tray
     * @param int leftNode, leftNode of the domino
     * @param int rightNode, rightNode of the domino
     */
    public void addDomino(int index, int leftNode, int righNode) {
        tray.addDomino(index, leftNode, righNode);
    }
}
