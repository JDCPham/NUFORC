package requirementXv2.model;

import java.util.Observable;

public class EscapeChatModel extends Observable {
	
	// Game state
	public static final int GAME_ACTIVE = 1;
	public static final int GAME_WIN = 2;
	public static final int GAME_LOSS = 3;
	
	// Field to hold gamestate
	private int gameState;
	// Field to hold player score.
	private int score;

	public EscapeChatModel() {
		
		gameState = GAME_ACTIVE;
		score = 0;
	}
	
	public void checkGameState() {
		
		if ( score >= 0 && score < 4) {
			
			gameState = GAME_LOSS;
		}
		else {
			
			gameState = GAME_WIN;
		}
	}
}
