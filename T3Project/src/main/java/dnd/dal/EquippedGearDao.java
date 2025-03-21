package dnd.dal;
import dnd.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EquippedGearDao {
	private EquippedGearDao() {}
	
	public static EquippedGear create(Connection cxn, GameCharacter character, GearSlot slot, Gear gear) throws SQLException {
		return null;
	}
	
	public static EquippedGear getEquippedGearFromCharacterGearSlot(Connection cxn, GameCharacter character, GearSlot slot) {
		return null;
	}

}
