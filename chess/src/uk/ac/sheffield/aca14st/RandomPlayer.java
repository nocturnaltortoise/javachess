package uk.ac.sheffield.aca14st;

public class RandomPlayer extends Player{

    public RandomPlayer(String name, Pieces pieces, Board board, Player opponent){
        super(name, pieces, board, opponent);
    }

    @Override
    public boolean makeMove(){
        boolean kingTaken = false;

        //Is there a way of finding all the positions of all the pieces of a particular colour?
        //If so, pick a random square from that list of positions - this would make things a lot more efficient.

        //Pick a random square
        //If it has a piece on it, that's the right colour for this player,
            //pick a random target square
                //if the move (init square, target square) is legal, move the piece
                //else continue picking random target squares for that piece
        //else continue picking random squares

        return kingTaken;
    }
}
