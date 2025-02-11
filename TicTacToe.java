package com.bnpp.kata;

public class TicTacToe {
	
	private char[] gameBoard = new char[9];
	private char currPlayer = 'X';
	private boolean gameOver = false;
	private String gameResult = "Game is still going on";
	
	public TicTacToe() {
        for (int i = 0; i < 9; i++) {
        	gameBoard[i] = ' ';
        }
    }
	
	public boolean positionAvailable (int i) {
		return gameBoard[i] == ' ';
	}
	
	public String play (int position) throws Exception {
		if(!gameOver) {
			if(position < 0 || position >= 9 || !positionAvailable(position))
				throw new Exception("Position is not available or not allowed");
			
			gameBoard[position] = currPlayer;
			
			if (win()) {
				gameResult = currPlayer+" won the game";
				gameOver = true;
			} else if (draw()) {
				gameResult = "Game is draw";
				gameOver = true;
			}
			
			currPlayer = currPlayer == 'X' ? 'O' : 'X';
		}
		
		return gameResult;
	}
	
	public boolean win() {
		int[][] winningCondition = {
	            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
	            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
	            {0, 4, 8}, {2, 4, 6}
	        };

	        for (int[] condition : winningCondition) {
	            if (gameBoard[condition[0]] == currPlayer && 
	            	gameBoard[condition[1]] == currPlayer && 
	            	gameBoard[condition[2]] == currPlayer) {
	                return true;
	            }
	        }
		return false;
	}
	
	public boolean draw() {
		for(char space : gameBoard) {
			if(space == ' ')
				return false;
		}
			return true;
	}

}
