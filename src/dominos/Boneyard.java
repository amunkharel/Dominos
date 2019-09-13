/**
 * Project 2 - CS351, Fall 2019, Class for boneyard from where dominos
 * can be drawn
 * @version Date 2019-09-13
 * @author Amun Kharel
 *
 *
 */

package dominos;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Boneyard {

    /** List of all dominos in boneyard */
    private List<Domino> dominos = new ArrayList<Domino>();

    /** Number of Dominos in the Boneyard*/
    private int numberOfDominosInBoneyard;


    /**
     * Constructor for Boneyard, largest number refer to
     * largest number to exist in domino
     *
     * @param int largestNumber, largest number present in dominos' node
     */
    public Boneyard(int largestNumber) {
        if(largestNumber > 7) {
            System.out.println("Cannot have higher than number " +
                    "7 in dominos because of spacing issues");
            System.exit(0);
        }

        this.numberOfDominosInBoneyard = 0;
        for(int i = 0; i <= largestNumber; i++) {
            for(int j = i; j <= largestNumber; j++ ) {
                Domino domino = new Domino(i, j);
                dominos.add(domino);
                numberOfDominosInBoneyard++;

            }
        }
    }

    /**
     * Gets number of dominos remaining in boneyard
     *
     * @return int , number of dominos remaining in boneyard
     */
    public int getNumberOfDominosInBoneyard() {
        return numberOfDominosInBoneyard;
    }


    /**
     * Gets all dominos in the boneyard
     *
     * @return List<Domino>, List of dominos in Boneyard
     */
    public List<Domino> getDominos() {
        return dominos;
    }


    /**
     * Gives n number of dominos when asked by user
     *
     * @param int number, gives number number of Dominos
     * @return List<Domino>, returns number list of dominos
     * randomly from the list
     *
     */
    public List<Domino> giveNDominos(int number) {

        List<Domino> dominos = new ArrayList<Domino>();
        if(number > this.numberOfDominosInBoneyard/2) {
            System.out.println("Sorry cannot take that many boneyards at once");
            System.exit(0);
        }

        Random rand = new Random();
        int randomNumber = 0;

        for (int i = 0; i < number ; i++) {
            randomNumber = rand.nextInt(this.numberOfDominosInBoneyard - 1);
            dominos.add(this.dominos.get(randomNumber));
            this.dominos.remove(randomNumber);
            this.numberOfDominosInBoneyard--;
        }

        return dominos;
    }

    /**
     * Gives one domino to the player
     *
     * @return Domino, returns Domino to the player's tray
     */
    public Domino giveDomino() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(this.numberOfDominosInBoneyard);
        Domino domino = new Domino(this.dominos.get(randomNumber).getLeftNode(),
                this.dominos.get(randomNumber).getRightNode());
        this.dominos.remove(randomNumber);
        this.numberOfDominosInBoneyard--;
        return  domino;
    }

    /**
     * Returns true if Boneyard is empty
     *
     * @return boolean, returns true if the boneyard is empty
     */
    public boolean isEmpty() {
        if(numberOfDominosInBoneyard == 0){
            return true;
        }
        else {
            return  false;
        }
    }
}
