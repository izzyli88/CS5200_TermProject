package dnd.dal;

import dnd.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CharacterStatsDao {

    private CharacterStatsDao() {}

    /**
     * Inserts a new CharacterStats record into the database.
     */
    public static CharacterStats create(Connection cxn, GameCharacter character, Statistic stat, int value) throws SQLException {
        String sql = "INSERT INTO CharacterStats (characterID, statisticID, value) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = cxn.prepareStatement(sql)) {
            stmt.setInt(1, character.getCharacterID());
            stmt.setInt(2, stat.getStatisticID());
            stmt.setInt(3, value);

            stmt.executeUpdate();
            return new CharacterStats(character, stat, value);
        }
    }

    /**
     * Retrieves a CharacterStats record by character and statistic.
     */
    public static CharacterStats getCharStat(Connection cxn, GameCharacter character, Statistic stat) throws SQLException {
        String sql = "SELECT value FROM CharacterStats WHERE characterID = ? AND statisticID = ?";

        try (PreparedStatement stmt = cxn.prepareStatement(sql)) {
            stmt.setInt(1, character.getCharacterID());
            stmt.setInt(2, stat.getStatisticID());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int value = rs.getInt("value");
                    return new CharacterStats(character, stat, value);
                } else {
                    return null;
                }
            }
        }
    }

    /**
     * Update the value of a specific CharacterStat.
     */
    public static CharacterStats updateValue(Connection cxn, GameCharacter character, Statistic stat, int newValue) throws SQLException {
        String sql = "UPDATE CharacterStats SET value = ? WHERE characterID = ? AND statisticID = ?";

        try (PreparedStatement stmt = cxn.prepareStatement(sql)) {
            stmt.setInt(1, newValue);
            stmt.setInt(2, character.getCharacterID());
            stmt.setInt(3, stat.getStatisticID());

            int updated = stmt.executeUpdate();
            if (updated == 0) return null;

            return new CharacterStats(character, stat, newValue);
        }
    }

    /**
     * Deletes a CharacterStats entry from the database.
     */
    public static void delete(Connection cxn, GameCharacter character, Statistic stat) throws SQLException {
        String sql = "DELETE FROM CharacterStats WHERE characterID = ? AND statisticID = ?";

        try (PreparedStatement stmt = cxn.prepareStatement(sql)) {
            stmt.setInt(1, character.getCharacterID());
            stmt.setInt(2, stat.getStatisticID());
            stmt.executeUpdate();
        }
    }
}
