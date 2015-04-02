/**
 * Created by simon on 31/03/15.
 */
public class HumanPlayer extends Player{

    public HumanPlayer(String n, Pieces p, Board b, Player o){
        super(n,p,b,o);
    }

    public boolean makeMove(){
        return false;
    }
}
