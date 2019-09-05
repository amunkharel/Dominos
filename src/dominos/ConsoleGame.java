package dominos;

import java.util.ArrayList;
import java.util.List;

public class ConsoleGame {

    private HumanPlayer p1;

    private Boneyard boneyard;

    public ConsoleGame() {
        this.boneyard = new Boneyard(7);
        System.out.println(boneyard.numberOfDominosInBoneyard);
        this.p1 = new HumanPlayer(boneyard);

    }


    public void playGame() {


        List<Domino> humanTrayDominos = new ArrayList<Domino>();
        humanTrayDominos = p1.getTray().getHumanDominos();



        System.out.println(humanTrayDominos.size());

        System.out.println(boneyard.numberOfDominosInBoneyard);
    }
}
