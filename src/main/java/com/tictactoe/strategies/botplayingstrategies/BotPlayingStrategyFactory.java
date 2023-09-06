package com.tictactoe.strategies.botplayingstrategies;

import com.tictactoe.enums.BotDifficultyLevel;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategyDifficultyLevel(BotDifficultyLevel difficultyLevel){
        return switch (difficultyLevel){
            case EASY -> new EasyBotPlayingStrategy();
            case MEDIUM -> new MediumBotPlayingStrategy();
            case HARD -> new HardBotPlayingStrategy();
        };
    }
}
