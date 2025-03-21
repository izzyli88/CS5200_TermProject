package dnd.dal;
import dnd.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClanDao {
	
	private ClanDao() {}
	
	public static Clan create(Connection cxn, Races race, String clanName) throws SQLException {
		return null;
	}
	
	public static Clan getClanFromClanID(Connection cxn, int clanID) throws SQLException {
		return null;
	}

}
