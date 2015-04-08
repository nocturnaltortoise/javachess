/**
 * Created by simon on 08/04/15.
 */
public class TextDisplay implements Display {

	@Override
	public void showPiecesOnBoard(Piece[][] piecesOnBoard){
		System.out.println();
		int i = 0;
		int j = 1;

		int gridRef = 0;

		System.out.println(" ABCDEFGH");

		for(i = 0; i < piecesOnBoard[j-1].length; i++){
			System.out.print(gridRef);
			gridRef++;
			for(j = 0; j < piecesOnBoard.length; j++){

				if(piecesOnBoard[j][i] == null){
					System.out.print("-");
				}else{
					System.out.print(piecesOnBoard[j][i]);
				}

			}
			System.out.println();
		}
	}
}
