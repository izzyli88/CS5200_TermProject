package dnd.dal;
import dnd.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WeaponDao {
	private WeaponDao() {}
	
	public static Weapon create(Connection cxn, String itemName,
			int itemLevel, Float itemPrice, int maxStackSize,
			int requiredLevel,  Job job, int attackDmg) throws SQLException{
		
//		EquippableItemDao.create(cxn, itemName, itemLevel, itemPrice, maxStackSize, null);
		return null;
		
	}
	
	public static Weapon getWeaponFromPrototypeID(Connection cxn, int prototypeID) throws SQLException{
		return null;
	}

}
