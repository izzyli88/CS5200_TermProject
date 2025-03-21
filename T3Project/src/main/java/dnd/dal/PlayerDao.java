package dnd.dal;
import dnd.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlayerDao {
	private PlayerDao() {}
	
	public static Player create(Connection cxn, String fullName, String email) throws SQLException {
		return null;
	}
	
	
	public static Player getPlayerFromPlayerID(Connection cxn, int id) throws SQLException {
		return null;
	}

}
