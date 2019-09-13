# Domino Game

## Game Play

### Starting the file

Two versions of the game can be played. The first version is the console game and 
the second one is the GUI version of the game. <br>
Two jar files are added to play both the version. <br>
To start the console version of the game. There are two ways: <br>
1) Go to the terminal in the directory where game is saved and type java -jar domino1.0_akharel.jar
<br>
2) Go to the Main.java file and uncomment console code and comment rest of the code

<br>
To start the GUI version of the game. There are two ways too: <br>
1) Go to the terminal in the directory where game is saved and type java -jar domino2.0_akharel.jar <br>
2) Go to Main.java and run the main class

### How to Play - Console Version

1) To play the console version. We will given a tray of dominos as follows- Example: <br>
(0, 4) ,(5, 6) ,(1, 4) ,(0, 6) ,(1, 2) ,(0, 3) ,(5, 5) , <br>

2) Then, it will ask us to pick leftNode of our domino. Suppose, I want to pick (0,3). <br>
Then I will have to type 0 first hit enter and type 3 for right node and hit enter <br>
3) Then, it will ask if I want to rotate. If I type "y" then it will make our domino (3,0) ,
else if we type "n", it will leave domino as is (0,3) <br>
4) For the first move, we do not get to choose left or right with "l"/"r". However, after first move, we 
get to play either left or right <br>
5) After we make a move, computer makes a move. To be a valid move, computer/human has
to look at the leftmost/rightmost domino and either play the same number or a wild card 0 number. 
If we do not have a valid move then we will automatically draw from the boneyard. <br>

6) We keep on playing and drawing from boneyard until both player do not have a valid move and
boneyard is empty.  <br>
7) One with the lowest score in their tray wins the game <br>


### How to Play - GUI version

To play the GUI game, we have to follow the following steps: <br>
1) To start, we need to click on a domino. The domino will go to the center right away. <br>
2) Then, computer will have its first move. Then after that, we can click on the domino we want to play.
The selected domino will be surrounded red border. To rotate the domino, we can click twice on the
same domino. To change domino, we can simply click another domino. <br>
3) After we select a domino, we can make a move to the left by click on the canvas that is colored
light blue. To play right, we can select canvas which is colored light pink. <br>
4) Then computer makes a move again. This goes until, game is over. <br>
5) In the meantime, if we don't have a valid move, we can get a new domino by simply clicking
anywhere in the canvas. <br>
6) If we don't have a move , boneyard is empty, and computer still has a move, we need to click
on the canvas for computer to make a move. <br>
7) This goes on until game is over. <br>
8) Main thing to remember is clicking anywhere on canvas if we do not have a valid move, 
light blue for left and light pink for right, double click on domino to rotate and clicking
on canvas even if you do not have a move and boneyard is empty because you might eventually have
a move.  <br>


## Description of Program Internals

### Description of Classes

