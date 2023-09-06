package com.tictactoe.strategies.botplayingstrategies;

import com.tictactoe.enums.CellState;
import com.tictactoe.models.Board;
import com.tictactoe.models.Cell;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{

    @Override
    public Cell makeMove(Board board) {
        for(List<Cell> row: board.getBoard()){
            for(Cell cell: row){
                if(cell.getCellState().equals(CellState.EMPTY))
                    return cell;
            }
        }
        return null;
    }
}
