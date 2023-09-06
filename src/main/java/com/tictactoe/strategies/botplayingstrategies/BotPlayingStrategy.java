package com.tictactoe.strategies.botplayingstrategies;

import com.tictactoe.models.Board;
import com.tictactoe.models.Cell;

public interface BotPlayingStrategy {

    Cell makeMove(Board board);
}
