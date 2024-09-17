public class PlayingPiece {

    PieceType piece;

    PlayingPiece(PieceType piece){
        this.piece = piece;
    }

    @Override
    public String toString() {
        return  piece.toString();
    }
}
