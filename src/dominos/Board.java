package dominos;

import java.util.ArrayList;

import java.util.List;

public class Board {
    public boolean topIsEmpty;
    public boolean bottomIsEmpty;

    private int topLeftIndex;

    private int bottomLeftIndex;

    private int maxLeftIndex;

    private List<Domino> allDominos;

    private List<Domino> topDominos;

    private List<Domino> bottomDominos;

    public boolean isTop;


    public Board() {

        allDominos =  new ArrayList<Domino>();

        topDominos  = new ArrayList<Domino>();

        bottomDominos  = new ArrayList<Domino>();

        topIsEmpty = true;

        bottomIsEmpty = true;

        maxLeftIndex = 0;

        topLeftIndex = 0;

        bottomLeftIndex = 0;

        isTop = false;


    }

    public boolean isBottomEmpty() {
        return bottomIsEmpty;
    }

    public boolean isTopEmpty() {
        return topIsEmpty;
    }

    public void addDominos(int leftNode, int rightNode, String direction) {
        Domino domino = new Domino(leftNode, rightNode);

        if(topIsEmpty || bottomIsEmpty) {
            if(isTop) {
                topDominos.add(domino);
                allDominos.add(0, domino);
            }
            else {
                bottomDominos.add(domino);
                allDominos.add(0, domino);
            }
        }

        else {
            if(isTop) {
                if(direction.equals('l')) {
                    topDominos.add(0, domino);
                    allDominos.add(0, domino);
                }

                else if(direction.equals('r')) {
                    topDominos.add(domino);
                    allDominos.add(domino);
                }
            }

            else {
                if(direction.equals('l')) {
                    bottomDominos.add(0, domino);
                    allDominos.add(0, domino);
                }

                else if(direction.equals('r')) {
                    bottomDominos.add(domino);
                    allDominos.add(domino);
                }
            }
        }


    }

    public boolean isValidMove(int leftNode, int rightNode, String direction) {
        if(direction.equals('l')) {
            if(rightNode == allDominos.get(0).getLeftNode() || allDominos.get(0).getLeftNode() == 0 || rightNode == 0) {
                return  true;
            }
        }

         else if(direction.equals('r')) {
            if(leftNode == allDominos.get(0).getRightNode() || allDominos.get(0).getRightNode() == 0 || leftNode == 0) {
                return  true;
            }
        }

         return false;

    }


    public void setMaxLeftIndex() {
        if(topLeftIndex > bottomLeftIndex) {
            maxLeftIndex = topLeftIndex;
        }

        if(bottomLeftIndex > topLeftIndex) {
            maxLeftIndex = bottomLeftIndex;
        }

        if(bottomLeftIndex == topLeftIndex) {
            maxLeftIndex = bottomLeftIndex;
        }
    }

    public void setTopLeftIndex() {
        this.topLeftIndex++;
        this.setMaxLeftIndex();

    }

    public void setBottomLeftIndex() {
        this.bottomLeftIndex++;
        this.setMaxLeftIndex();
    }

    public void printBoard() {

    }
}
