package uk.ac.sheffield.aca14st;

public class RandomPlayer extends AIPlayer{

    public RandomPlayer(String name, Pieces pieces, Board board, Player opponent){
        super(name, pieces, board, opponent);
    }

    @Override
    public boolean makeMove(){
        return false;
    }
}
