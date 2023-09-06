package com.tictactoe.strategies.winningstrategies;

import com.tictactoe.models.Board;
import com.tictactoe.models.Move;
import com.tictactoe.models.Player;
import com.tictactoe.models.Symbol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderOneColumnWinningStrategy implements WinningStrategy{
    private List<Map<Symbol,Integer>> colMaps;

    public OrderOneColumnWinningStrategy(int size, List<Player> players){
        colMaps=new ArrayList<>();
        for(int i=0;i<size; ++i){
            colMaps.add(new HashMap<>());
            for(Player player: players){
                colMaps.get(i).put(player.getSymbol(),0);
            }
        }
    }
    @Override
    public boolean checkWinner(Board board, Move move) {

        int col = move.getCell().getRow();
        Symbol symbol=move.getPlayer().getSymbol();

        colMaps.get(col).put(
                symbol, 1 + colMaps.get(col).get(symbol)
        );

        if(colMaps.get(col).get(symbol) == board.getSize()){
            return true;
        }
        return false;
    }

    @Override
    public void handleUndo(Board board, Move move) {
        int col=move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();
        colMaps.get(col).put(
                symbol,
                colMaps.get(col).get(symbol)-1
        );
    }
}
