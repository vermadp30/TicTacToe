package com.tictactoe;

import com.tictactoe.controllers.GameController;
import com.tictactoe.enums.BotDifficultyLevel;
import com.tictactoe.enums.GameStatus;
import com.tictactoe.enums.PlayerType;
import com.tictactoe.models.Bot;
import com.tictactoe.models.Game;
import com.tictactoe.models.Player;
import com.tictactoe.models.Symbol;
import com.tictactoe.strategies.winningstrategies.OrderOneColumnWinningStrategy;
import com.tictactoe.strategies.winningstrategies.OrderOneDiagonalWinningStrategy;
import com.tictactoe.strategies.winningstrategies.OrderOneRowWinningStrategy;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameController gameController=new GameController();
        Scanner scanner=new Scanner(System.in);

        Game game;

        List<Player> players =List.of(
                new Player(new Symbol('X'), "Deep", PlayerType.HUMAN),
                new Bot(new Symbol('O'), "Bot1", BotDifficultyLevel.EASY)
        );
        int dimension = 3;
        try {
            game = gameController.createGame(
                    dimension,
                    players,
                    List.of(
                            new OrderOneColumnWinningStrategy(dimension,players),
                            new OrderOneDiagonalWinningStrategy(dimension,players),
                            new OrderOneRowWinningStrategy(dimension,players)
                    ));
        } catch (Exception e){
            System.out.println("Something went wrong");
            return;
        }

        System.out.println("--------------Game is Starting--------------");

        while(gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS)){
            gameController.displayBoard(game);
            System.out.println("Do you want to undo? (y/n)");
            String input= scanner.next();
            if(input.equalsIgnoreCase("y")) {
                gameController.undo(game);
            } else {
                gameController.makeMove(game);
            }
        }
        gameController.printResult(game);
    }
}