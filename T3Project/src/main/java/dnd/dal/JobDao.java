package dnd.dal;
import dnd.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class JobDao {
	private JobDao() {}
	
	public static Job create(Connection cxn, String jobName) throws SQLException {
		return null;
	}
	
	
	public static Job getJobFromJobID(Connection cxn, int id) throws SQLException {
		return null;
	}

}
