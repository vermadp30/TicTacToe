package com.tictactoe.strategies.botplayingstrategies;

import com.tictactoe.models.Board;
import com.tictactoe.models.Cell;

import java.util.List;

public class HardBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Cell makeMove(Board board) {

        for(List<Cell> row: board.getBoard()){
            for(Cell cell: row){
                return cell;
            }
        }
        return null;
    }
}
