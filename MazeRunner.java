package A1;
import java.util.*;
import A1.timer;
public class MazeRunner {

//static variables so that they could be accessed by all classes and modified in run time
static int HighScore;
static char currentMaze[][];
static int endpointI;
static int endpointJ;
//time variables as timerclass not working properly
static long starttime;
static long endtime;
static long storeTime;

//	public MazeRunner(long startTime, long endTime) {
//		this.startTimer=startTime;
//		this.endTimer=endTime;
//	}
	public static void main(String[] args) {
		
		
		
		
		
		//variable declaration to store user input
		Scanner input = new Scanner(System.in);
		String option;
		
		//while loop until user presses e to Exit
		do {
			//Main Menu
			System.out.println("Choose a through e to select");
			System.out.println("a. Play Game");
			System.out.println("b. Instructions");
			System.out.println("c. Credits");
			System.out.println("d. High Score");
			System.out.println("e. Exit");
			//initializing input variable "option"
			option = input.nextLine();
			//performs respective functions through switch considering option chosen by user
			//uses toLowerCase method to eliminate miscommunication from user
			switch(option.toLowerCase()) {
			case "a":
				//game
				playGame(input);
				break;
			case "b":
				showInstructions();
				break;
			case "c":
				showCredits();
				break;
			case "d":
				showHighScore();
			case "e":
				exitGame();
				break;
			default:
				System.out.println("Invalid response. Try again!");
				break;
				
			
		}
		}while (!option.equals("e"));
		
		input.close();
		
	}
	
	
	
	//Method: creates Maze with beginner level difficulty
	public static char[][] beginnerMaze() {
			
			//Declares array
			char beginnerMaze[][] = new char[11][11];
					
			//Initializing and declaring array as all spaces to move for player'.'
			for(int i = 0; i<11;i++) {
				for(int j = 0; j<11;j++) {
					beginnerMaze[i][j]='.';
				}
			}
			
			//declaring walls on all four sides of the maze
			//row 1
			for(int j = 0; j<11;j++) {
				beginnerMaze[0][j]='#';
			}
			//row 11
			for(int j = 0; j<11;j++) {
				beginnerMaze[10][j]='#';
			}
			//column1
			for(int i = 1; i<10;i++) {
				beginnerMaze[i][0]='#';
			}
			//column11
					for(int i = 1; i<10;i++) {
						beginnerMaze[i][10]='#';
					}
					
			//creating 2 walls manually
			//wall 1
			beginnerMaze[3][1]='#';
			beginnerMaze[3][2]='#';
			beginnerMaze[3][3]='#';
			beginnerMaze[3][4]='#';
			beginnerMaze[3][5]='#';
			//wall 2
			beginnerMaze[7][9]='#';
			beginnerMaze[7][8]='#';
			beginnerMaze[7][7]='#';
			beginnerMaze[7][6]='#';
			beginnerMaze[7][5]='#';
			
			//starting point
			beginnerMaze[1][1]='P';
			beginnerMaze[9][9]='E';
			
			endpointI=9;
			endpointJ=9;
			
			return beginnerMaze;
		}
	
	//Method: creates Maze with intermediate level difficulty
	public static char[][] intermediateMaze() {
			
			//Declares array
			char intermediateMaze[][] = new char[11][11];
					
			//Initializing and declaring array as all spaces to move for player'.'
			for(int i = 0; i<11;i++) {
				for(int j = 0; j<11;j++) {
					intermediateMaze[i][j]='.';
				}
			}
			
			//declaring walls on all four sides of the maze
			//row 1
			for(int j = 0; j<11;j++) {
				intermediateMaze[0][j]='#';
			}
			//row 11
			for(int j = 0; j<11;j++) {
				intermediateMaze[10][j]='#';
			}
			//column1
			for(int i = 1; i<10;i++) {
				intermediateMaze[i][0]='#';
			}
			//column11
			for(int i = 1; i<10;i++) {
			intermediateMaze[i][10]='#';
			}
			//wall1
			intermediateMaze[2][1]='#';
			intermediateMaze[2][2]='#';
			intermediateMaze[2][3]='#';
			intermediateMaze[2][4]='#';
			intermediateMaze[2][5]='#';
			//wall2
			intermediateMaze[4][5]='#';
			intermediateMaze[4][6]='#';
			intermediateMaze[4][7]='#';
			intermediateMaze[4][8]='#';
			intermediateMaze[4][9]='#';
			//wall3
			intermediateMaze[6][1]='#';
			intermediateMaze[6][2]='#';
			intermediateMaze[6][3]='#';
			intermediateMaze[6][4]='#';
			intermediateMaze[6][5]='#';
			//wall4
			intermediateMaze[8][5]='#';
			intermediateMaze[8][6]='#';
			intermediateMaze[8][7]='#';
			intermediateMaze[8][8]='#';
			intermediateMaze[8][9]='#';
			
			//appointing starting and ending points
			intermediateMaze[1][1]='P';
			intermediateMaze[9][9]='E';
			//end point coordinates to be used by hasPlayerWon()
			endpointI=9;
			endpointJ=9;
			
			return intermediateMaze;
					
	}
	
	//Method: creates Maze with professional level difficulty
	public static char[][] proMaze() {
			
			//Declares array
			char proMaze[][] = new char[11][11];
					
			//Initializing and declaring array as all spaces to move for player'.'
			for(int i = 0; i<11;i++) {
				for(int j = 0; j<11;j++) {
					proMaze[i][j]='.';
				}
			}
			
			//declaring walls on all four sides of the maze
			//row 1
			for(int j = 0; j<11;j++) {
				proMaze[0][j]='#';
			}
			//row 11
			for(int j = 0; j<11;j++) {
				proMaze[10][j]='#';
			}
			//column1
			for(int i = 1; i<10;i++) {
				proMaze[i][0]='#';
			}
			//column11
			for(int i = 1; i<10;i++) {
				proMaze[i][10]='#';
			}
			//wall1
			for(int i = 1;i<9;i++) {
				proMaze[i][2]='#';
						
			}
			//wall2
			for(int i = 2;i<10;i++) {
				proMaze[i][4]='#';		
			}
			//wall3
			for(int i = 1;i<9;i++) {
				proMaze[i][6]='#';
								
			}
			//wall4
			for(int i = 2;i<10;i++) {
				proMaze[i][8]='#';	
			}
			
			//appointing starting and ending points
			proMaze[1][1]='P';
			proMaze[9][9]='E';
			//end point coordinates to be used by hasPlayerWon()
			endpointI=9;
			endpointJ=9;
					
			return proMaze;
			
		}
	
	
	
	//Method: Displays the Current Maze
	public static void printMaze() {
		for(int i=0;i<currentMaze.length;i++) {
			for(int j=0;j<currentMaze[i].length;j++) {
				System.out.print(currentMaze[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	
	//Method: Checks validity of the move
	public static boolean isValid(int newX, int newY) {
		// checks if the move is within the maze (matrix), and also not hitting any wall/obstacle ('#')
		if (newX < 0 || newX >= currentMaze.length || newY < 0 || newY >= currentMaze[0].length || currentMaze[newX][newY] == '#') {
		    return false;
		} else {
		    return true;
		}
	}
	
	//Method: Moves the character and updates the maze
	public static char [][] movePlayer(String move) {
		// First finds the character's current position i.e. 'P'
		// initializing rowPosition and colPosition as -1(default position)
		int rowPosition = 0;
		int colPosition = 0;
		for(int i=0;i<currentMaze.length;i++) {
			for(int j=0;j<currentMaze[i].length;j++) {
				if(currentMaze[i][j]=='P') {
					rowPosition = i;
					colPosition = j;
					break;
				}
			}
		}
		
		//updates character position using switch after checking validity of the move
		switch(move) {
		case "w":
			if(isValid(rowPosition-1,colPosition)==true) {
				currentMaze[rowPosition][colPosition]='.';
				currentMaze[rowPosition-1][colPosition]='P';
			}
			else {
				System.out.println("Invalid move! try again");
			}
			break;
			
		case "a":
			if(isValid(rowPosition,colPosition-1)==true) {
				currentMaze[rowPosition][colPosition]='.';
				currentMaze[rowPosition][colPosition-1]='P';
			}
			else {
				System.out.println("Invalid move! try again");
			}
			break;
		case "s":
			if(isValid(rowPosition+1,colPosition)==true) {
				currentMaze[rowPosition][colPosition]='.';
				currentMaze[rowPosition+1][colPosition]='P';
			}
			else {
				System.out.println("Invalid move! try again");
			}
			break;
		case "d":
			if(isValid(rowPosition,colPosition+1)==true) {
				currentMaze[rowPosition][colPosition]='.';
				currentMaze[rowPosition][colPosition+1]='P';
			}
			else {
				System.out.println("Invalid move! try again");
			}
			break;
		default:
			System.out.println("Invalid input. Try Again");
			break;
		}
		// returns updated maze
		return currentMaze;
	
	}
	
	//Method: checks if player has won
	public static boolean hasPlayerWon() {

	    //finds current position of player
	    int rowPosition = 0;
	    int colPosition = 0;
	    for (int i = 0; i < currentMaze.length; i++) {
	        for (int j = 0; j < currentMaze[i].length; j++) {
	            if (currentMaze[i][j] == 'P') {
	                rowPosition = i;
	                colPosition = j;
	                break;
	            }
	        }
	    }

	    
	    //compares with endPoints
	    if (rowPosition == endpointI && colPosition == endpointJ) {
	        System.out.println("Congratulations! You have won");
	        return true;
	    } else {
	        return false;
	    }
	}

	
	
	//this method contains the game and returns score
	public static void playGame(Scanner input) {
		 storeTime=0;
		//variable to give input for startNewGame method
		boolean x=false;
		//keeps track of number of steps taken
		int steps=0;
		//do while loop to startNewGame. asks user choice/input at the end of the game
		do {
		
			
			System.out.println("Select difficulty level: ");
			System.out.println("1. Beginner");
			System.out.println("2. Intermediate");
			System.out.println("3. Pro");
			System.out.println("4. Main Menu");
			int choice;
			
			do {
				choice = input.nextInt();
				//consumes '/n' from previous input in buffer
				input.nextLine();
				switch(choice) {
				
				case 1:
					currentMaze = beginnerMaze();
					break;
				case 2:
					currentMaze = intermediateMaze();
					break;
				case 3:
					currentMaze=proMaze();
					break;
				case 4:
					// returns to main menu if input is 4
					System.out.println("Returning to main menu");
					
					return;
					
				default:
					System.out.println("Invalid input! Enter 1, 2, 3 or 4.");
					break;
						
				}
			}while(choice!=4&&choice!=1&&choice!=2&&choice!=3);
			
			
			
			
			
			
			System.out.println("Game started. Finish the game within 90 seconds");
			System.out.println("Enter r to return to main menu at any time");
			//timer started local mehod
			starttime = System.currentTimeMillis();
			//timer started (through timer class
			timer.main(null);
			//Game starts here
			String move;
			
			do {
				//Displays current state of maze
				printMaze();	
				
				//User input for move
				move = input.nextLine();
				
				//checks if user wants to exit the game
				if(move.equals("r") ){
					System.out.println("Returning to main menu");
					//stops timer
					timer.stopTimer();
					return ;
				}
				
				//moves the player by updating current maze
				movePlayer(move);
				steps+=1;
				
				
				
			}while(hasPlayerWon()==false);
			//stops timer when player has won (trough class method)
			timer.stopTimer();
			//through local method
			endtime = System.currentTimeMillis();
			storeTime = (endtime-starttime)/1000;
			int newTime = (int)storeTime;
			//updates score and stores it in variable score
			int time = (int) timer.timeTaken;				//converting timetaken(long) to int data typea
			
			int score = updateScore(steps, newTime);
			//displays result
			displayScore(score, steps, newTime);
			
			//input prompt if player wants to start a new game
			System.out.println("Would you like to start a new game?");
			System.out.println("Press 1 for Yes");
			System.out.println("Press 2 for No");
			int c = input.nextInt();

			if (c == 2) {
			    x= false;
			} else if (c == 1) {
				x=true;
			}
			else if(c!=1&&c!=2){
				System.out.println("Sorry, invalid response!");
				x=false;
			}
		}while(x==true);		
			
		
			
	}
	
	
	
	//Method: displays result of the game
	public static void displayScore(int score, int steps, int time) {
		
		
		
		//get moves made to finish the game
		//10 points per move
		System.out.println("You made "+steps+" number of moves");
		System.out.println("You took "+time+ " seconds to reach the endpoint");
		System.out.println("Your score is "+score);
		
	}
	
	
	//Method: updates score and highscore
	public static int updateScore(int steps, int timeTaken) {
		
		int score;
		//(maxscore-(50*time taken to finish the game))+(maxscore-(moves made * 100))
		//20 points deduction per second spent				10 points deduction per move made
		score = (1800-(20*timeTaken))+(1800-(steps*10));
		
		if(score>HighScore) {
			HighScore=score;
		}
		
		return score;
	}
	
	
	//Method: resets currentMaze and makes it ready for newGame. 
	public static void startNewGame(boolean x) {
		if (x==true) {
			//resets current Maze, endpointI, endpointJ
			for (int i = 0; i < currentMaze.length; i++) {
		        for (int j = 0; j < currentMaze[i].length; j++) {
		            currentMaze[i][j]=' ';
		            
		        }
		    }
			 endpointI = 0;
			 endpointJ = 0;
		}
	}
	
	//Method: displays instructions
	public static void showInstructions() {
		System.out.println("Use 'w','a','s','d' to move up, left, down and right respectively");
		System.out.println("Avoid walls and reach E (end point) in as little time and moves as");
		System.out.println("possible to win the game");
	}
	
	//Method: display credits
	public static void showCredits() {
		System.out.println("This game is created by FC College undergraduate student");
	}
	
	//Method: displays HighScore
	public static void showHighScore() {
		System.out.println("Your High Score is "+ HighScore);
	}
	
	//Method: Exits the game
	public static void exitGame() {
		System.out.println("Exiting game");
		
	}
		
	
}
