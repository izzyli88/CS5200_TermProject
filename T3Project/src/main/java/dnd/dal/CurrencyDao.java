package dnd.dal;

import dnd.model.Currency;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CurrencyDao {
    private CurrencyDao() {}

    public static Currency create(Connection cxn, String currencyName, Integer cap, Integer weeklyCap) throws SQLException {
        String sql = "INSERT INTO Currency (currencyName, cap, weeklyCap) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = cxn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, currencyName);
            if (cap != null) {
                stmt.setInt(2, cap);
            } else {
                stmt.setNull(2, Types.INTEGER);
            }

            if (weeklyCap != null) {
                stmt.setInt(3, weeklyCap);
            } else {
                stmt.setNull(3, Types.INTEGER);
            }

            stmt.executeUpdate();

            try (ResultSet keys = stmt.getGeneratedKeys()) {
                if (keys.next()) {
                    int currencyID = keys.getInt(1);
                    return new Currency(currencyID, currencyName, cap, weeklyCap);
                } else {
                    throw new SQLException("Currency creation failed: no ID returned.");
                }
            }
        }
    }

    public static Currency getCurrencyFromCurrencyID(Connection cxn, int id) throws SQLException {
        String sql = "SELECT currencyName, cap, weeklyCap FROM Currency WHERE currencyID = ?";

        try (PreparedStatement stmt = cxn.prepareStatement(sql)) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("currencyName");
                    Integer cap = rs.getObject("cap", Integer.class);
                    Integer weeklyCap = rs.getObject("weeklyCap", Integer.class);
                    return new Currency(id, name, cap, weeklyCap);
                } else {
                    return null;
                }
            }
        }
    }

    public static Currency getCurrencyByName(Connection cxn, String currencyName) throws SQLException {
        String sql = "SELECT currencyID, cap, weeklyCap FROM Currency WHERE currencyName = ?";

        try (PreparedStatement stmt = cxn.prepareStatement(sql)) {
            stmt.setString(1, currencyName);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("currencyID");
                    Integer cap = rs.getObject("cap", Integer.class);
                    Integer weeklyCap = rs.getObject("weeklyCap", Integer.class);
                    return new Currency(id, currencyName, cap, weeklyCap);
                } else {
                    return null;
                }
            }
        }
    }

    public static Currency updateCap(Connection cxn, Currency currency, Integer newCap) throws SQLException {
        String sql = "UPDATE Currency SET cap = ? WHERE currencyID = ?";

        try (PreparedStatement stmt = cxn.prepareStatement(sql)) {
            if (newCap != null) {
                stmt.setInt(1, newCap);
            } else {
                stmt.setNull(1, Types.INTEGER);
            }
            stmt.setInt(2, currency.getCurrencyID());

            int updated = stmt.executeUpdate();
            if (updated == 0) return null;

            currency.setCap(newCap);
            return currency;
        }
    }

    public static void delete(Connection cxn, Currency currency) throws SQLException {
        String sql = "DELETE FROM Currency WHERE currencyID = ?";

        try (PreparedStatement stmt = cxn.prepareStatement(sql)) {
            stmt.setInt(1, currency.getCurrencyID());
            stmt.executeUpdate();
        }
    }

}

