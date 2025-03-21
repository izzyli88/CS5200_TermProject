package dnd.dal;

import dnd.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class InventorySlotDao {
	private InventorySlotDao() {}
	
	
	public static InventorySlot create(Connection cxn, GameCharacter character, int slotNumber, ItemPrototypeDao prototype, int stackSize) throws SQLException{
		return null;
	}
	
	
	public static InventorySlot getInventorySlotByCharacterSlotNumber(Connection cxn, GameCharacter character, int slotNumber) throws SQLException{
		return null;
	}

}
