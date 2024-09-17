public class PlayingPieceFactory {

    PlayingPiece piece;

    PlayingPiece getPlayingPiece(String val){

        if(val.equals(PieceType.X.name())){
            this.piece = new PlayingPieceX();
        }

        else if(val.equals(PieceType.O.name())){
            this.piece = new PlayingPieceO();
        }

        return piece;
    }
}
