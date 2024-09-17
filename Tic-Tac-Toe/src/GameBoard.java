public class GameBoard {
    int size;
    public PlayingPiece[][] board;

    GameBoard(int size){
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public void print(){

        for(int i=0; i<size; i++){

            //System.out.println("| ");
            for(int j=0; j<size; j++){

                if(board[i][j] != null) {
                    System.out.print("  "+board[i][j]);
                    System.out.print("   |");
                }
                else
                    System.out.print("      |");


            }
            System.out.print("\n");
        }
    }

    boolean checkEmptyCells(){

        boolean check = false;

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){

                if(board[i][j] == null){
                    check = true;
                    break;
                }
            }
        }

        return check;
    }

    public boolean checkSpace(int row, int col, PlayingPiece p){

        if(board[row][col] != null){
            return false;
        }

        board[row][col] = p;
        return true;
    }
}
