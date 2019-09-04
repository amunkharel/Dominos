package dominos;

public class Domino {
    private int leftNode;

    private int rightNode;

    public Domino(int leftNode, int rightNode) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public int getLeftNode() {
        return leftNode;
    }

    public int getRightNode() {
        return rightNode;
    }
}
