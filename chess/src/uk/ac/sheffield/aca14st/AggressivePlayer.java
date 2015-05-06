package uk.ac.sheffield.aca14st;

public class AggressivePlayer extends Player{

    public AggressivePlayer(String name, Pieces pieces, Board board, Player opponent){
        super(name, pieces, board, opponent);
    }

    @Override
    public boolean makeMove(){
        boolean kingTaken = false;
        //Iterate through all the pieces owned by this player.
            //for each of those pieces, check every valid move
                //if any of the valid moves are occupied by an enemy piece, check the value of that piece
                    //move the piece that can take the most valuable piece

        return kingTaken;
    }
}
