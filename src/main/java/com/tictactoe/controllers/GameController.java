package com.tictactoe.controllers;

import com.tictactoe.enums.GameStatus;
import com.tictactoe.models.Game;
import com.tictactoe.models.Player;
import com.tictactoe.strategies.winningstrategies.WinningStrategy;

import java.util.List;

public class GameController {
    public Game createGame(int dimension,
                           List<Player> players,
                           List<WinningStrategy> winningStrategies){
        return Game.getBuilder().
                setDimension(dimension).
                setPlayers(players).
                setWinningStrategies(winningStrategies)
                .build();
    }

    public void displayBoard(Game game){
        game.PrintBoard();
    }

    public GameStatus getGameStatus(Game game){
        return game.getGameStatus();
    }

    public void undo(Game game){
        game.undo();
    }

    public void makeMove(Game game){
        game.makeMove();
    }

    public void printResult(Game game){
        game.printResult();
    }

}
