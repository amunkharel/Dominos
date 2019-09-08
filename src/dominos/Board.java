package dominos;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private boolean isEmpty;

    private int topLeftIndex;

    private int bottomLeftIndex;

    private Map<Character, Character> dominoPosition;

    private List<Domino> allDominos;

    private List<Domino> topDominos;

    private List<Domino> bottomDominos;

    int totalDominos = 0;


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

    public boolean isEmpty() {
        return isEmpty;
    }

    public void addDominos(int leftNode, int rightNode, String direction) {
        Domino domino = new Domino(leftNode, rightNode);

        if(isEmpty) {
            allDominos.add(domino);
            topDominos.add(domino);
            dominoPosition.put('l', 't');
            dominoPosition.put('r', 't');
            isEmpty = false;
        }
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

    public boolean isValidMove(int leftNode, int rightNode, String direction) {
        if(direction.equals("l")) {
            if(allDominos.get(0).getLeftNode() == rightNode ||
                    rightNode == 0 || allDominos.get(0).getLeftNode() == 0) {
                return true;
            }
        }

        if(direction.equals("r")) {
            if(allDominos.get(totalDominos).getRightNode() == leftNode
                    || leftNode == 0 || allDominos.get(totalDominos).getRightNode() == 0) {
                return true;
            }
        }
        return false;
    }


    public void printBoard() {

        System.out.println("------------Game Board-------------------------------------");
        if(bottomLeftIndex > topLeftIndex) {
            System.out.print("   ");
            for (int i = 0; i < topDominos.size(); i++) {
                System.out.print("(" + topDominos.get(i).getLeftNode() + ", " + topDominos.get(i).getRightNode()+ ")");
            }
            System.out.println(" ");

            for (int i = 0; i < bottomDominos.size(); i++) {
                System.out.print("(" + bottomDominos.get(i).getLeftNode() + ", " + bottomDominos.get(i).getRightNode()+ ")");
            }
            System.out.println(" ");

        }

        else {
            for (int i = 0; i < topDominos.size(); i++) {
                System.out.print("(" + topDominos.get(i).getLeftNode() + ", " + topDominos.get(i).getRightNode()+ ")");
            }
            System.out.println(" ");

            System.out.print("   ");
            for (int i = 0; i < bottomDominos.size(); i++) {
                System.out.print("(" + bottomDominos.get(i).getLeftNode() + ", " + bottomDominos.get(i).getRightNode()+ ")");
            }

            System.out.println(" ");
        }

        System.out.println("-----------------------------------------------------------");
    }

    public List<Domino> getAllDominos() {
        return allDominos;
    }

    public int getTotalDominos() {
        return totalDominos;
    }

}
