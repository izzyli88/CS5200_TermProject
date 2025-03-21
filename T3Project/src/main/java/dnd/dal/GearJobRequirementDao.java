package dnd.dal;
import dnd.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GearJobRequirementDao {
	private GearJobRequirementDao() {}
	
	
	public static GearJobRequirement create(Connection cxn, Gear gear, Job job) throws SQLException{
		return null;
	}
	
	public static GearJobRequirement getGearJobRequirementByGearANDJob(Connection cxn, Gear gear, Job job) throws SQLException{
		return null;
	}
	
	

}
