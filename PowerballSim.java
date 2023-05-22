package sampleProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Statistics and prize numbers are taken from Powerball.com
public class PowerballSim {
	static int MIN = 1;
	static int WHITE_BALL_MAX = 69;
	static int RED_BALL_MAX = 26;

	public static void main(String[] args) {
		//while(true) {
		List<Integer> win = pickWinningNums();
		List<Integer> play = pickPlayerNums();
		compareLists(win, play);
		System.out.println();	
		}
		
	//}

	private static void compareLists(List<Integer> win, List<Integer> play) {
		int counter = 0;
		//winning powerball(last) number
		int winPB = win.get(win.size()-1);
		//player powerball number
		int playPB = play.get(play.size()-1);
		
		//compares lists
		if(win.get(0).equals(play.get(0))) {
			counter++;
		}
		if(win.get(1).equals(play.get(1))) {
			counter++;
		}
		if(win.get(2).equals(play.get(2))) {
			counter++;
		}
		if(win.get(3).equals(play.get(3))) {
			counter++;
		}
		if(win.get(4).equals(play.get(4))) {
			counter++;
		}
		if(winPB == playPB) {
			counter++;
		}
		
		returnWinnings(counter, winPB, playPB);
	}

	private static void returnWinnings(int counter, int winPB, int playPB) {
		//returns winnings and statistics, if applicable
		if(counter == 1 && winPB == playPB) {
			System.out.println("You have won $4. Your odds of winning were 1 in 38.32");
		} else if (counter == 2 && winPB == playPB) {
			System.out.println("You have won $4. Your odds of winning were 1 in 91.98");
		} else if(counter == 3 && winPB == playPB) {
			System.out.println("You have won $7. Your odds of winning were 1 in 701.33");
		} else if(counter == 3 && winPB != playPB) {
			System.out.println("You have won $7. Your odds of winning were 1 in 579.76");
		} else if(counter == 4 && winPB == playPB) {
			System.out.println("You have won $100. Your odds of winning were 1 in 14,494.11");
		} else if(counter == 4 && winPB != playPB) {
			System.out.println("You have won $100. Your odds of winning were 1 in 36,525.17");
		} else if(counter == 5 && winPB == playPB) {
			System.out.println("You have won $50,000. Your odds of winning were 1 in 913,129.18");
		} else if(counter == 5 && winPB != playPB) {
			System.out.println("You have won $1,000,000. Your odds of winning were 1 in 11,688,053.52");
		} else if(counter == 6) {
			System.out.println("You have won the GRAND PRIZE! Your odds of winning were 1 in 292,201,338");
		} else {
			System.out.println("You are not a winner. Please try again.");
		}
	}
	//picks the player's lottery ticket
	private static List<Integer> pickPlayerNums() {
		List<Integer> playerList = new ArrayList<>();
	
		while (playerList.size() < 5) {	
			int whiteNum = randomNumberGenerator(WHITE_BALL_MAX);
			//prevents duplicates
			if (!playerList.contains(whiteNum)) {
				playerList.add(whiteNum);
			}
		}
		
		Collections.sort(playerList);
		playerList.add(randomNumberGenerator(RED_BALL_MAX));
		
		System.out.println("Your numbers are " + playerList);
		return playerList;
	}
		
	//picks the winning lottery numbers
	private static List<Integer> pickWinningNums() {
		List<Integer> winningList = new ArrayList<>();
		
		while (winningList.size() < 5) {	
			int whiteNum = randomNumberGenerator(WHITE_BALL_MAX);
			if (!winningList.contains(whiteNum)) {
				winningList.add(whiteNum);
			}
		}
		
		Collections.sort(winningList);
		winningList.add(randomNumberGenerator(RED_BALL_MAX));
		
		System.out.println("The winning numbers are " + winningList);
		return winningList;
		
	}
	
	//generates random integers
	private static int randomNumberGenerator(int max) {
		return (int)Math.ceil(Math.random() * max);
	}
}

