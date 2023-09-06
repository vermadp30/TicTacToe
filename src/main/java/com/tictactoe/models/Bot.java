package com.tictactoe.models;

import com.tictactoe.enums.BotDifficultyLevel;
import com.tictactoe.enums.PlayerType;
import com.tictactoe.strategies.botplayingstrategies.BotPlayingStrategy;
import com.tictactoe.strategies.botplayingstrategies.BotPlayingStrategyFactory;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private final BotPlayingStrategy botPlayingStrategy;
    public Bot(Symbol symbol, String name,BotDifficultyLevel botDifficultyLevel) {
        super(symbol, name, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy= BotPlayingStrategyFactory.getBotPlayingStrategyDifficultyLevel(
                this.botDifficultyLevel);
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public BotPlayingStrategy getBotPlayingStrategy() {
        return botPlayingStrategy;
    }

    @Override
    public Cell makeMove(Board board){
        return botPlayingStrategy.makeMove(board);
    }
}
