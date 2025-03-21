package dnd.dal;
import dnd.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GearSlotDao {
	private GearSlotDao() {}
	
	public static GearSlot create(Connection cxn, String slotName) throws SQLException {
		return null;
	}
	
	
	public static GearSlot getGearSlotFromSlotID(Connection cxn, int slotID) throws SQLException {
		return null;
	}
	
	

}
