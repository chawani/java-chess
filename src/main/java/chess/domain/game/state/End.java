package chess.domain.game.state;

import java.util.Map;

import chess.domain.board.Board;
import chess.domain.game.Score;
import chess.domain.game.Winner;
import chess.domain.piece.Color;
import chess.domain.position.Position;

public class End implements GameState {

    private static final String GAME_IS_END_AND_NOT_MOVABLE_PIECE = "[ERROR] 게임이 끝나서 말을 옮길 수 없습니다.";
    private static final String GAME_IS_END_AND_NOT_GET_TURN = "[ERROR] 게임이 끝나서 턴을 불러올 수 없습니다.";

    private final Board board;

    public End(final Board board) {
        this.board = board;
    }

    @Override
    public GameState movePiece(Position source, Position target) {
        throw new UnsupportedOperationException(GAME_IS_END_AND_NOT_MOVABLE_PIECE);
    }

    @Override
    public boolean isFinish() {
        return true;
    }

    @Override
    public boolean isWaiting() {
        return false;
    }

    @Override
    public Map<Color, Double> calculateScore() {
        final Score score = new Score(board.getValue());
        return score.getAllTeamScore();
    }

    @Override
    public Color getWinTeamColor() {
        final Winner winner = new Winner(board.getValue());
        return winner.color();
    }

    @Override
    public Color getTurn() {
        throw new UnsupportedOperationException(GAME_IS_END_AND_NOT_GET_TURN);
    }

    @Override
    public Board board() {
        return board;
    }

    @Override
    public String representative() {
        return "End";
    }
}
