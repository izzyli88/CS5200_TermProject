package dnd.dal;

import dnd.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CharacterCurrencyDao {

    private CharacterCurrencyDao() {}

    public static CharacterCurrency create(Connection cxn,
                                           GameCharacter character,
                                           Currency currency,
                                           int amountHeld,
                                           int amountEarnedThisWeek) throws SQLException {
        String sql = "INSERT INTO CharacterCurrency (characterID, currencyName, amountHeld, amountEarnedThisWeek) " +
                     "VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = cxn.prepareStatement(sql)) {
            stmt.setInt(1, character.getCharacterID());
            stmt.setString(2, currency.name());
            stmt.setInt(3, amountHeld);
            stmt.setInt(4, amountEarnedThisWeek);

            stmt.executeUpdate();
            return new CharacterCurrency(character, currency, amountHeld, amountEarnedThisWeek);
        }
    }

    public static CharacterCurrency getByCharacterAndCurrency(Connection cxn,
                                                              GameCharacter character,
                                                              Currency currency) throws SQLException {
        String sql = "SELECT amountHeld, amountEarnedThisWeek FROM CharacterCurrency " +
                     "WHERE characterID = ? AND currencyName = ?";

        try (PreparedStatement stmt = cxn.prepareStatement(sql)) {
            stmt.setInt(1, character.getCharacterID());
            stmt.setString(2, currency.name());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int held = rs.getInt("amountHeld");
                    int earned = rs.getInt("amountEarnedThisWeek");
                    return new CharacterCurrency(character, currency, held, earned);
                } else {
                    return null;
                }
            }
        }
    }

    public static List<CharacterCurrency> getAllCurrenciesForCharacter(Connection cxn,
                                                                       GameCharacter character) throws SQLException {
        String sql = "SELECT currencyName, amountHeld, amountEarnedThisWeek FROM CharacterCurrency " +
                     "WHERE characterID = ?";

        List<CharacterCurrency> result = new ArrayList<>();

        try (PreparedStatement stmt = cxn.prepareStatement(sql)) {
            stmt.setInt(1, character.getCharacterID());

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Currency currency = Currency.valueOf(rs.getString("currencyName"));
                    int held = rs.getInt("amountHeld");
                    int earned = rs.getInt("amountEarnedThisWeek");
                    result.add(new CharacterCurrency(character, currency, held, earned));
                }
            }
        }

        return result;
    }

    public static CharacterCurrency updateAmountHeld(Connection cxn,
                                                     GameCharacter character,
                                                     Currency currency,
                                                     int newAmountHeld) throws SQLException {
        String sql = "UPDATE CharacterCurrency SET amountHeld = ? WHERE characterID = ? AND currencyName = ?";

        try (PreparedStatement stmt = cxn.prepareStatement(sql)) {
            stmt.setInt(1, newAmountHeld);
            stmt.setInt(2, character.getCharacterID());
            stmt.setString(3, currency.name());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                return null;
            }

            CharacterCurrency updated = getByCharacterAndCurrency(cxn, character, currency);
            return updated;
        }
    }

    public static void delete(Connection cxn, GameCharacter character, Currency currency) throws SQLException {
        String sql = "DELETE FROM CharacterCurrency WHERE characterID = ? AND currencyName = ?";

        try (PreparedStatement stmt = cxn.prepareStatement(sql)) {
            stmt.setInt(1, character.getCharacterID());
            stmt.setString(2, currency.name());
            stmt.executeUpdate();
        }
    }
}
