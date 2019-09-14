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

1) Board - Board is where the game is played. The board has element on top of the board 
and bottom of the board. What is on the top and bottom help us figure what can be played on
the board <br>

2) Boneyard - Boneyard is where we can get our dominos from. Boneyard will start with 
max number of dominos. If 6 is the largest number, we will have 28 dominos in boneyard. 
However, 7 and 7 dominos each will be given by boneyard to player's tray. Boneyard will be
used later in the game to draw dominos if needed <br>

3) Computer Player- Computer player has a tray where it stores dominos. It can select a
valid move and play itself. <br>

4) Computer Tray- Computer Tray has dominos for computer and it can draw from boneyard if needed <br>

5) ConsoleGame- Console Game class is where console game is played from start to finish. It uses
all other classes to play the game and take it to completion <br>

6) Domino- Domino has a left and a right node. <br>

7) EventHandler- Event Handler class handles a click from the user on the canvas and 
does the bookkeeping for the backend for the game. <br>

8) GameGUI- It is a dynamic GUI which will be refreshed by animation timer. It detects
change in data structure and maintains the GUI likewise <br>

9) Human Player- Human Player like computer player has a tray. But it cannot make it's own
move. Player has to make it. <br>

10) Human Tray- Human Tray holds dominos for human and asks boneyard for domino when 
necessary

11) Main- Main class is where game is initialized and played <br>


### Algorithm and Data Structure

I used Arraylist for most of this game. ArrayList was used by both computer and humans to hold
dominos, which helps to  add, delete and update a domino easily <br>
For the board, to store the dominos at top and bottom, I used ArrayList. Those 
variables were later used to print dominos in both GUI and console game. <br>
To keep track of  where the domino is currently residing in leftmost and rightmost part, I used a map.
Map holds either top or bottom to inform me what the next move can be in the game. I think
this could have been made efficient with other simple data structures. <br>
Simple conditionals and loops were used other for running console and GUI. 

## Known Bugs and feature Requests

I don't know any bugs that explicitly stop the game or make invalid moves. However many improvements 
can be made in this game, which are as follows: <br>

1) Algorithm can be improved by replacing complex data structures like map <br>

2) Game is dynamic but I wish I could stored all my hardcoded variables for GUI in a 
environment file to update game easily <br>

3) AI for the game is pretty simple. User experience can be improved through improved AI <br>

4) Game cannot be restarted and it simply stops after game is over. Game can be fully
developed in the future. <br>

## References
I wrote the game start to finish without any external references. I used my previous 
Tile game as a reference to write my GUI. 

## Author - Amun Kharel

## Date - 2019/09/13