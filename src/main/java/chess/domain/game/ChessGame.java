package chess.domain.game;

import java.util.Arrays;
import java.util.List;

import chess.domain.Board;
import chess.domain.BoardFactory;
import chess.domain.Position;
import chess.domain.game.state.GameState;
import chess.domain.game.state.Running;
import chess.domain.game.state.Waiting;
import chess.domain.piece.Color;

public class ChessGame {

    private GameState state;
    private Board board;

    public ChessGame() {
        state = new Waiting();
    }

    public void start() {
        state = new Running();
        board = new Board(BoardFactory.getInitialPieces());
    }

    public void movePiece(String movePositionInformation) {
        List<String> information = Arrays.asList(movePositionInformation.split(" "));
        state = state.movePiece(board, Position.valueOf(information.get(1)),
            Position.valueOf(information.get(2)));
    }

    public boolean isWaiting() {
        return state.isWaiting();
    }

    public double calculateScore(Color color) {
        return board.calculateScore(color);
    }

    public Color judgeWinner() {
        return board.getWinnerTeamColor();
    }

    public Board getBoard() {
        return board;
    }
}
