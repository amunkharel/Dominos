package dominos;

import java.util.ArrayList;

public class Boneyard {

    ArrayList<Domino> dominos = new ArrayList<Domino>();

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

    public ArrayList<Domino> getDominos() {
        return dominos;
    }
}
