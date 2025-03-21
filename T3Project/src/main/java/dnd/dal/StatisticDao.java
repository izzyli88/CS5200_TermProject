package dnd.dal;
import dnd.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StatisticDao {
	private StatisticDao() {}
	
	public static Statistic create(Connection cxn, String statName) throws SQLException {
		return null;
	}
	
	
	public static Statistic getStatisticFromStatID(Connection cxn, int statID) throws SQLException {
		return null;
	}

}
