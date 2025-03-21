package dnd.dal;
import dnd.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ConsumableDao {
	private ConsumableDao() {}
	
	
	public static Consumable create(Connection cxn, String itemName, int itemLevel, Float itemPrice, int itemMaxStackSize) throws SQLException{
		// make sure to create ItemPrototype object
		return null;
		
	}
	
	public static Consumable getConsumableByPrototypeID(Connection cxn, int prototypeID) throws SQLException{
		return null;
	}
}
