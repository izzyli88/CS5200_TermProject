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
		String insertConsumable = "INSERT INTO Consumable (consumableID) VALUES (?);";
		
		try (PreparedStatement insertStmt = cxn.prepareStatement(insertConsumable)) {
			ItemPrototype item = ItemPrototypeDao.create(cxn, itemName, itemLevel, itemPrice, itemMaxStackSize);
			
			insertStmt.setInt(1, item.getPrototypeID());
			insertStmt.executeUpdate();
			
			return new Consumable(item.getPrototypeID(), itemName, itemLevel, itemPrice, itemMaxStackSize);
		}
	}
	
	public static Consumable getConsumableByPrototypeID(Connection cxn, int prototypeID) throws SQLException{
		String selectConsumable = """
				SELECT consumableID, itemName, itemLevel, itemPrice, itemMaxStackSize
					FROM Consumable INNER JOIN ItemPrototype ON ItemPrototype.prototypeID = Consumable.consumableID
					WHERE consumableID = ?;
				""";
		
		try(PreparedStatement selectStmt = cxn.prepareStatement(selectConsumable)) {
			selectStmt.setInt(1, prototypeID);
			
			try(ResultSet results = selectStmt.executeQuery()) {
				if (results.next()) {
					return new Consumable(prototypeID,
							results.getString("itemName"),
							results.getInt("itemLevel"),
							results.getFloat("itemPrice"),
							results.getInt("maxStackSize"));
				} else {
					return null;
				}
			}
		}
	}
}
