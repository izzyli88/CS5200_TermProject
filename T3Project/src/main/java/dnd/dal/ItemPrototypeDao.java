package dnd.dal;

import dnd.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import dnd.model.CharacterStats;
import dnd.model.GameCharacter;
import dnd.model.Statistic;


public class ItemPrototypeDao {
	private ItemPrototypeDao() {}
	
	
	public static ItemPrototype create(Connection cxn, String itemName, int itemLevel, Float itemPrice, int itemMaxStackSize) throws SQLException {
		String insertItemPrototype = "INSERT INTO ItemPrototype (itemName, itemLevel, itemPrice, itemMaxStackSize) VALUES (?, ?, ?, ?);";
		
		try(PreparedStatement insertStmt = cxn.prepareStatement(insertItemPrototype, Statement.RETURN_GENERATED_KEYS)) {
			insertStmt.setString(1, itemName);
			insertStmt.setInt(2, itemLevel);
			insertStmt.setFloat(3, itemPrice);
			insertStmt.setInt(4, itemMaxStackSize);
			
			insertStmt.executeUpdate();
			
			return new ItemPrototype(Utils.getAutoIncrementKey(insertStmt), itemName, itemLevel, itemPrice, itemMaxStackSize);
		}
	}
	
	public static ItemPrototype getItemFromPrototypeID(Connection cxn, int prototypeID) throws SQLException {
		final String selectItemPrototype = """
				SELECT prototypeID, itemName, itemLevel, itemPrice, itemMaxStackSize
					FROM ItemPrototype
					WHERE prototypeID = ?;
				""";
		
		try (PreparedStatement selectStmt = cxn.prepareStatement(selectItemPrototype)) {
			selectStmt.setInt(1, prototypeID);
			
			try(ResultSet results = selectStmt.executeQuery()) {
				if (results.next()) {
					return new ItemPrototype(prototypeID,
							results.getString("itemName"),
							results.getInt("itemLevel"),
							results.getFloat("itemPrice"),
							results.getInt("itemMaxStackSize"));
				} else return null;
			}
		}
	}

}
