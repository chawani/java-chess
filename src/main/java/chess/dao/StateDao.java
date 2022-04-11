package chess.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import chess.dto.StateDto;
import chess.exception.DataAccessException;

public class StateDao {

    private final DBConnection dbConnection = new DBConnection();

    public void updateState(final String gameState, final String color) {
        final String query = "UPDATE state SET game_state = ? , color = ?";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, gameState);
            statement.setString(2, color);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DataAccessException("[DATABASE_ERROR] 체스 상태 업데이트 실패");
        }
    }

    public StateDto getState() {
        final String query = "SELECT * FROM state LIMIT 1";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            resultSet.next();
            return new StateDto(
                resultSet.getString("game_state"),
                resultSet.getString("color")
            );
        } catch (SQLException e) {
            throw new DataAccessException("[DATABASE_ERROR] 체스 상태 가져오기 실패");
        }
    }
}