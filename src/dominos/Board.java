/**
 * Project 2 - CS351, Fall 2019, Class for board where dominos are placed
 * @version Date 2019-09-13
 * @author Amun Kharel
 *
 *
 */

package dominos;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    /** Checks if nothing is placed in the dominos*/
    private boolean isEmpty;

    /** Checks how many dominos are placed in top left*/
    private int topLeftIndex;

    /**Checks how many dominos are placed in bottom left */
    private int bottomLeftIndex;

    /** Maps if left is at top/bottom and right is at top/bottom */
    private Map<Character, Character> dominoPosition;

    /**List of all dominos placed in the board */
    private List<Domino> allDominos;

    /**List of dominos placed in the top */
    private List<Domino> topDominos;

    /**List of dominos placed at the bottom */
    private List<Domino> bottomDominos;

    /** Total number of dominos placed in the board*/
    int totalDominos = 0;

    /**
     * Constructor to initialize Board for the game
     *
     */
    public Board() {

        allDominos =  new ArrayList<Domino>();

        topDominos  = new ArrayList<Domino>();

        bottomDominos  = new ArrayList<Domino>();

        dominoPosition = new HashMap<>();

        topLeftIndex = 0;

        bottomLeftIndex = 0;

        isEmpty = true;

        totalDominos = 0;

    }

    /**
     * Checks if the board is empty and returns true or false values
     *
     * @return Boolean, returns true if empty and vice versa
     */

    public boolean isEmpty() {
        return isEmpty;
    }

    /**
     * Adds dominos in the board, top/ bottom depending on the algorithm
     *
     * @param int leftNode, leftNode of the domino to be added
     * @param int rightNode, rightNode of the domino to be added
     * @param String direction, direction where to add "l"/"r"
     */
    public void addDominos(int leftNode, int rightNode, String direction) {
        Domino domino = new Domino(leftNode, rightNode);

        //if the board is empty adds it at top center
        if(isEmpty) {
            allDominos.add(domino);
            topDominos.add(domino);
            dominoPosition.put('l', 't');
            dominoPosition.put('r', 't');
            isEmpty = false;
        }

        //if direction is left and board is not empty,
        //if current left position is bottom, adds to top
        // and vice versa
        else {
            if(direction.equals("l")) {
                if(dominoPosition.get('l') == 't'){

                    allDominos.add(0,domino);
                    bottomDominos.add(0, domino);
                    dominoPosition.put('l', 'b');
                    bottomLeftIndex++;
                    totalDominos++;
                }

                else if(dominoPosition.get('l') == 'b') {
                    allDominos.add(0,domino);
                    topDominos.add(0, domino);
                    dominoPosition.put('l', 't');
                    topLeftIndex++;
                    totalDominos++;
                }
            }
            //same logic for the right
            if(direction.equals("r")) {
                if(dominoPosition.get('r') == 't') {
                    allDominos.add(domino);
                    bottomDominos.add(domino);
                    dominoPosition.put('r', 'b');
                    totalDominos++;
                }

                else if(dominoPosition.get('r') == 'b') {
                    allDominos.add(domino);
                    topDominos.add(domino);
                    dominoPosition.put('r', 't');
                    totalDominos++;
                }
            }
        }

    }

    /**
     * Returns true if move is valid, else returns false
     *
     * @param int leftNode, leftNode of the domino to be added
     * @param int rightNode, rightNode of the domino to be added
     * @param String direction, direction where to add "l"/"r"
     * @return boolean , returns true if move is valid, else returns false
     */
    public boolean isValidMove(int leftNode, int rightNode, String direction) {
        if(direction.equals("l")) {
            if(allDominos.get(0).getLeftNode() == rightNode ||
                    rightNode == 0 || allDominos.get(0).getLeftNode() == 0) {
                return true;
            }
        }

        if(direction.equals("r")) {
            if(allDominos.get(totalDominos).getRightNode() == leftNode
                    || leftNode == 0 ||
                    allDominos.get(totalDominos).getRightNode() == 0) {
                return true;
            }
        }
        return false;
    }


    /**
     * Prints Console board of the game
     *
     */
    public void printBoard() {

        System.out.println("------------Game Board------------" +
                "---------------------------------------------");
        if(bottomLeftIndex > topLeftIndex) {
            System.out.print("   ");
            for (int i = 0; i < topDominos.size(); i++) {
                System.out.print("(" + topDominos.get(i).getLeftNode() +
                        ", " + topDominos.get(i).getRightNode()+ ")");
            }
            System.out.println(" ");

            for (int i = 0; i < bottomDominos.size(); i++) {
                System.out.print("(" + bottomDominos.get(i).getLeftNode() +
                        ", " + bottomDominos.get(i).getRightNode()+ ")");
            }
            System.out.println(" ");

        }

        else {
            for (int i = 0; i < topDominos.size(); i++) {
                System.out.print("(" + topDominos.get(i).getLeftNode() +
                        ", " + topDominos.get(i).getRightNode()+ ")");
            }
            System.out.println(" ");

            System.out.print("   ");
            for (int i = 0; i < bottomDominos.size(); i++) {
                System.out.print("(" + bottomDominos.get(i).getLeftNode() +
                        ", " + bottomDominos.get(i).getRightNode()+ ")");
            }

            System.out.println(" ");
        }

        System.out.println("------------------------------" +
                "-------------------------------------------------");
    }

    /**
     * Returns all dominos in the board
     *
     * @return List<Domino> , returns all dominos present in the board
     */

    public List<Domino> getAllDominos() {
        return allDominos;
    }

    /**
     * Returns total dominos in the board
     * @return int , returns total number of dominos in the board
     */
    public int getTotalDominos() {
        return totalDominos;
    }

    /**
     * Returns index of bottom left
     * @return int , returns index of bottom left
     */
    public int getBottomLeftIndex() {
        return bottomLeftIndex;
    }

    /**
     * Returns index of top left
     * @return int , returns index of top left
     */
    public int getTopLeftIndex() {
        return topLeftIndex;
    }

    /**
     * Returns list of bottom Dominos
     * @return int , returns list of bottom dominos
     */
    public List<Domino> getBottomDominos() {
        return bottomDominos;
    }

    /**
     * Returns list of top dominos
     * @return int , returns list of top dominos
     */
    public List<Domino> getTopDominos() {
        return topDominos;
    }
}
