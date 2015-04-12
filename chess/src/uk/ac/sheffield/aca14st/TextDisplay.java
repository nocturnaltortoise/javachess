package uk.ac.sheffield.aca14st;

/**@author Simon Turner (aca14st) */

public class TextDisplay implements Display {

	//Method to print out the board's contents, given an array of pieces.
	@Override
	public void showPiecesOnBoard(Piece[][] piecesOnBoard){
		System.out.println();
		int i;
		int j = 1;

		int gridRef = 0;

		System.out.println(" ABCDEFGH");

		for(i = 0; i < piecesOnBoard[j-1].length; i++){
			System.out.print(gridRef);
			gridRef++;
			for(j = 0; j < piecesOnBoard.length; j++){
				//If a square has nothing in it, it's null, so we print a dash.
				if(piecesOnBoard[j][i] == null){
					System.out.print("-");
				}else{
					//Otherwise we print the piece.
					System.out.print(piecesOnBoard[j][i]);
				}

			}
			System.out.println();
		}
	}
}
