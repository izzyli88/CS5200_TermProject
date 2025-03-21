package dnd.dal;
import dnd.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CurrencyDao {
	private CurrencyDao() {}
	
	public static Currency create(Connection cxn, String currencyName, Integer cap, Integer weeklyCap) throws SQLException {
		return null;
	}
	
	public static Currency getCurrencyFromCurrencyID(Connection cxn, int id) throws SQLException {
		return null;
	}

}
