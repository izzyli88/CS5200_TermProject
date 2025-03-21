package dnd.dal;
import dnd.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CharacterStatsDao {
	
	private CharacterStatsDao() {}
	
	public static CharacterStats create(Connection cxn, GameCharacter character, Statistic stat, int value) throws SQLException{
		return null;
	}
	
	public static CharacterStats getCharStat(Connection cxn, GameCharacter character, Statistic stat) throws SQLException{
		return null;
	}

}
