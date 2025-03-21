package dnd.dal;
import dnd.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CharacterCurrencyDao {
	private CharacterCurrencyDao() {}
	
	private static CharacterCurrency create(Connection cxn,
			GameCharacter character, Currency currency,
			int amountHeld, int amountEarnedThisWeek) throws SQLException {
		return null;
	}
	
	private static CharacterCurrency getCharCurrencyFromCharCurrency(Connection cxn,
			GameCharacter character, Currency currency) throws SQLException {
		return null;
	}

}
