package dnd.dal;
import dnd.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EquippableItemDao {
	private EquippableItemDao() {}
	
	
	public static EquippableItem create(Connection cxn, String itemName,
			int itemLevel, Float itemPrice, int maxStackSize, Integer requriedLevel) throws SQLException {
		// create ItemPrototype obj w/ DAO class
		return null;
	}
	
	
	public static EquippableItem getEquippableItemFromPrototypeID(Connection cxn, int prototypeID) throws SQLException{
		return null;
	}

}
