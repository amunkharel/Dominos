/**
 * Project 2 - CS351, Fall 2019, Class for Computer Player
 * @version Date 2019-09-13
 * @author Amun Kharel
 *
 *
 */

package dominos;
public class ComputerPlayer {

    /** Tray Computer is holding which has dominos*/
    private ComputerTray tray;

    /** Boneyard from which Tray can draw dominos*/
    private Boneyard boneyard;

    /** Board where computer can make a move*/
    private Board board;

    /** Direction where computer wants to go in the next move*/
    private String validDirection;

    /** Checks whether computer wants to rotate or not in each move*/
    private String rotation;

    /**
     * Constructor for Computer Player
     *
     * @param Boneyard boneyard, boneyard from which tray can pick domino/dominos
     * @param Board board, Board where computer can make a move
     */
    public ComputerPlayer(Boneyard boneyard, Board board) {
        this.boneyard = boneyard;
        this.board = board;
        tray = new ComputerTray(boneyard);
        tray.askForDominos(7);
        validDirection = "";
        rotation = "";
    }

    /**
     * Gets what's in the tray of computer player
     *
     * @return ComputerTray , gets tray of computer player
     */
    public ComputerTray getTray() {
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
        for(int i = 0; i < tray.getComputerDominos().size(); i++) {
            if(tray.getComputerDominos().get(i).getRightNode() == rightNode &&
                    tray.getComputerDominos().get(i).getLeftNode() == leftNode) {
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
     * Checks if Domino has valid move in the board
     *
     * @return boolean, returns true if has valid move, else false
     *
     */
    public boolean hasValidMove() {

        if(board.isEmpty()) {
            return true;
        }
        for (int i = 0; i < tray.getComputerDominos().size(); i++) {
            if(tray.getComputerDominos().get(i).getRightNode()
                    == board.getAllDominos().get(0).getLeftNode()
                    || tray.getComputerDominos().get(i).getLeftNode()
                    == board.getAllDominos().get(0).getLeftNode()
                    || tray.getComputerDominos().get(i).getRightNode()
                    == 0 || board.getAllDominos().get(0).getLeftNode() == 0
                    || tray.getComputerDominos().get(i).getLeftNode()
                    == board.getAllDominos().get(board.totalDominos).getRightNode()
                    || tray.getComputerDominos().get(i).getRightNode()
                    == board.getAllDominos().get(board.totalDominos).getRightNode()
                    || tray.getComputerDominos().get(i).getLeftNode() == 0
                    || board.getAllDominos().get(board.totalDominos).getRightNode() ==0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns valid move for the game, direction and rotation is set
     *
     * @return  int, returns valid move for the game
     */
    public int validMove() {
        int validMove = 0;

        if(board.isEmpty()) {
            return validMove;
        }

        for (int i = 0; i < tray.getComputerDominos().size(); i++) {
            if(tray.getComputerDominos().get(i).getRightNode()
                    == board.getAllDominos().get(0).getLeftNode()){
                this.validDirection = "l";
                rotation = "n";
                return i;
            }

            if(tray.getComputerDominos().get(i).getLeftNode()
                    == board.getAllDominos().get(0).getLeftNode()){
                this.validDirection = "l";
                rotation = "y";
                return i;
            }

            if(tray.getComputerDominos().get(i).getRightNode() == 0 ) {
                this.validDirection = "l";
                rotation = "n";
                return i;
            }

            if(board.getAllDominos().get(0).getLeftNode() == 0) {
                this.validDirection = "l";
                rotation = "n";
                return i;
            }

            if(tray.getComputerDominos().get(i).getLeftNode()
                    == board.getAllDominos().get(board.totalDominos).getRightNode()) {
                this.validDirection = "r";
                rotation = "n";
                return i;
            }
            if(tray.getComputerDominos().get(i).getRightNode()
                    == board.getAllDominos().get(board.totalDominos).getRightNode()) {
                this.validDirection = "r";
                rotation = "y";
                return i;
            }

            if(tray.getComputerDominos().get(i).getLeftNode() == 0) {
                this.validDirection = "r";
                rotation = "n";
                return i;
            }

            if(board.getAllDominos().get(board.totalDominos).getRightNode() ==0) {
                this.validDirection = "r";
                rotation = "n";
                return i;
            }
        }


        return  validMove;
    }

    /**
     * Asks tray to get domino from boneyard
     *
     */
    public void getDomino() {
        tray.askForDomino();
    }

    /**
     * Counts score and returns total score of the computer player
     *
     * @return int, countscore for after game is over
     */
    public int countScore() {
        int score = 0;
        for (int i = 0; i < tray.getComputerDominos().size(); i++) {
            score += tray.getComputerDominos().get(i).getLeftNode();
            score += tray.getComputerDominos().get(i).getRightNode();
        }

        return score;
    }

    /**
     * Gets valid direction for the move
     *
     * @param String, valid direction for computer move, either "l"/"r"
     */
    public String getValidDirection() {
        return validDirection;
    }

    /**
     * Gets string to check if computer wants to rotate domino or not
     *
     * @param String, rotation is either "y"/"n"
     */
    public String getRotation() {
        return rotation;
    }
}
