package dominos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Boneyard {

    List<Domino> dominos = new ArrayList<Domino>();

    int numberOfDominosInBoneyard;


    public Boneyard(int largestNumber) {
        if(largestNumber > 7) {
            System.out.println("Cannot have higher than number 7 in dominos because of spacing issues");
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

    public int getNumberOfDominosInBoneyard() {
        return numberOfDominosInBoneyard;
    }

    public List<Domino> getDominos() {
        return dominos;
    }

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
}
