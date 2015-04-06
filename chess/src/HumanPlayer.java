/**
 * Created by simon on 31/03/15.
 */
public class HumanPlayer extends Player{

    public HumanPlayer(String n, Pieces p, Board b, Player o){
        super(n,p,b,o);
    }

    public boolean makeMove(){
        //assumedly returns true when the move can be made - only has access to the things in humanplayer's constructor to check if a move is valid.

        return false;
    }
}
