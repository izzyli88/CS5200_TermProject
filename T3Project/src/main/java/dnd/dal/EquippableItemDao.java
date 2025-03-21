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
			int itemLevel, Float itemPrice, int maxStackSize, Integer requiredLevel) throws SQLException {
		
		String insertEquippable = """
				INSERT INTO EquippableItem (equippableItemID, requiredLevel) VALUES  (?, ?);
				""";
		
		try(PreparedStatement insertStmt = cxn.prepareStatement(insertEquippable)) {
			ItemPrototype item = ItemPrototypeDao.create(cxn, itemName, itemLevel, itemPrice, maxStackSize);
			
			insertStmt.setInt(1, requiredLevel);
			insertStmt.executeUpdate();
			
			return new EquippableItem(item.getPrototypeID(), itemName, itemLevel, itemPrice, maxStackSize, requiredLevel);
		}

		
	}
	
	
	public static EquippableItem getEquippableItemFromPrototypeID(Connection cxn, int prototypeID) throws SQLException{
		String selectEquippable = """
				SELECT equippableItemID, itemName, itemLevel, itemPrice, itemMaxStackSize, requiredLevel
					FROM EquippableItem INNER JOIN ItemPrototype ON EquippableItem.equippableItemID = ItemPrototype.itemPrototypeID
					WHERE equippableItemID = ?;
				""";
		
		try(PreparedStatement selectStmt = cxn.prepareStatement(selectEquippable)) {
			selectStmt.setInt(1, prototypeID);
			
			try(ResultSet results = selectStmt.executeQuery()) {
				if (results.next()) {
					return new EquippableItem(prototypeID,
							results.getString("itemName"),
							results.getInt("itemLevel"),
							results.getFloat("itemPrice"),
							results.getInt("itemMaxStackSize"),
							results.getInt("requiredLevel"));
				} else {
					return null;
				}
			}
		}
	}

}
