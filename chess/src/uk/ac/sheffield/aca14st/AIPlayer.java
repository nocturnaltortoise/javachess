package uk.ac.sheffield.aca14st;

public class AIPlayer extends Player{

    public AIPlayer(String name, Pieces pieces, Board board, Player opponent){
        super(name, pieces, board, opponent);
    }

    @Override
    public boolean makeMove(){
        return false;
    }
}
