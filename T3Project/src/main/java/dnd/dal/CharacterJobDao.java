package dnd.dal;
import dnd.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CharacterJobDao{
	private CharacterJobDao() {}
	
	public static CharacterJob create(Connection cxn, Job job, int level, int exp, boolean unlocked) throws SQLException {
		return null;
		
	}
	
	public static CharacterJob getCharJobFromCharIDJobID(Connection cxn, GameCharacter character, Job job) throws SQLException {
		return null;
	}
}