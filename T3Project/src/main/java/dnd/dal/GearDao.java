package dnd.dal;
import dnd.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GearDao {
	private GearDao() {}
	
	
	public static Gear create(Connection cxn, String itemName,
			int itemLevel, Float itemPrice, int maxStackSize,
			int requiredLevel,  GearSlot slot) throws SQLException {
//		EquippableItemDao.create(cxn, null, 0, null, 0, null)  creates equippableItem & ItemPrototype obj simultaneously
		
		return null;
	}
	
	public static Gear getGearFromPrototypeID(Connection cxn, int prototypeID) throws SQLException {
		return null;
	}

}
