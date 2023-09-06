package com.tictactoe.strategies.winningstrategies;

import com.tictactoe.models.Board;
import com.tictactoe.models.Move;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move move);
    void handleUndo(Board board,Move move);
}
