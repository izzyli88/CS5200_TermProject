package dnd.dal;
import dnd.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class RacesDao {
	private RacesDao(){}
	
	public static Races create(Connection cxn, String raceName) throws SQLException {
		return null;
	}
	
	
	public static Races getRaceFromRaceID(Connection cxn, int raceID) throws SQLException {
		return null;
	}

}
