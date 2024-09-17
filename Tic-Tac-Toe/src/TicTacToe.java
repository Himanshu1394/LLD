import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class TicTacToe {
    Deque<Player> players;
    GameBoard board;

    TicTacToe(){
        initialize();
    }

    void initialize(){

        System.out.println("Enter the size of board");
        Scanner size = new Scanner(System.in);
        int boardSize = size.nextInt();

        board = new GameBoard(boardSize);

        players = new LinkedList<>();
        System.out.println("Enter the number of players");
        Scanner playerDetails = new Scanner(System.in);
        int numPlayers = playerDetails.nextInt();
        PlayingPieceFactory factory = new PlayingPieceFactory();

        while(numPlayers != 0){

            System.out.println("Enter Player details");
            Scanner playerDet = new Scanner(System.in);
            String details = playerDet.nextLine();
            //String sign = playerDetails.nextLine().toUpperCase();

            String[] pDet = details.split("\\s*,\\s*");
            String name = pDet[0];
            String sign = pDet[1];

            PlayingPiece piece = factory.getPlayingPiece(sign);

            Player p = new Player(name, piece);
            players.add(p);

            numPlayers--;
        }

    }

    void startGame(){

        boolean noWinner = true;
        Player playerTurn;
        while(noWinner){

            playerTurn = players.getFirst();
            players.removeFirst();

            board.print();

            boolean checkEmpty = board.checkEmptyCells();

            if(!checkEmpty){
                noWinner = false;
                continue;
            }

            System.out.println("Enter the co-ordinates where you want to input");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            String[] values = input.split("\\s*,\\s*");
            int row = Integer.parseInt(values[0]);
            int col = Integer.parseInt(values[1]);

            boolean check = board.checkSpace(row, col, playerTurn.piece);

            if(!check){
                System.out.println("Already filled please try again ");
                players.addFirst(playerTurn);
                continue;
            }

            players.addLast(playerTurn);

            boolean winner = checkWinner(row, col, playerTurn.piece);

            if(winner){

                System.out.println("Player "+playerTurn.name+" has won the game" );
                System.out.println("Do you want to play again (yes/no)?");
                Scanner newGame = new Scanner(System.in);
                String newGameInput = newGame.nextLine();

                if(newGameInput.equals("yes")){
                    board = new GameBoard(3);
                    startGame();
                }

                return;
            }

        }

        System.out.println("Tie Game");

        System.out.println("Do you want to play again (yes/no)?");
        Scanner newGame = new Scanner(System.in);
        String newGameInput = newGame.nextLine();

        if(newGameInput.equals("yes")){
            initialize();
        }


    }

    boolean checkWinner(int row, int col, PlayingPiece p){

        boolean rowMatch = true;
        boolean colMatch = true;
        boolean diagonal1 = true;
        boolean diagonal2 = true;
        //row wise
        for(int i=0; i<board.size; i++){

            if(board.board[row][i] == null || board.board[row][i].piece != p.piece){
                rowMatch = false;
                break;
            }

        }

        for(int i=0; i<board.size; i++){

            if(board.board[i][col] == null || board.board[i][col].piece != p.piece){
                colMatch = false;
                break;
            }

        }

        for(int i=0, j=0; i<board.size; i++, j++){

            if(board.board[i][j] == null || board.board[i][j].piece != p.piece){
                diagonal1 = false;
                break;
            }

        }

        for(int i= 0, j= board.size-1; i< board.size; i++, j--){

            if(board.board[i][j] == null || board.board[i][j].piece != p.piece){
                diagonal2 = false;
                break;
            }

        }

        return rowMatch || colMatch || diagonal1 || diagonal2;
    }
}
