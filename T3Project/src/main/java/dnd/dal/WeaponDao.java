package dnd.dal;
import dnd.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WeaponDao {
	private WeaponDao() {}
	
	public static Weapon create(Connection cxn, String itemName,
			int itemLevel, Float itemPrice, int maxStackSize,
			int requiredLevel,  Job job, int attackDmg) throws SQLException{
		
		
		String insertWeapon = """
				INSERT INTO Weapon (weaponID, jobID, attackDamage)
					VALUES (?, ?, ?);""";
		
		try(PreparedStatement insertStmt = cxn.prepareStatement(insertWeapon)) {
			int weaponID = EquippableItemDao.create(cxn, itemName, itemLevel, itemPrice, maxStackSize, requiredLevel);
			
			insertStmt.setInt(1, weaponID);
			insertStmt.setInt(2, job.getJobID());
			insertStmt.setInt(3, attackDmg);
			
			insertStmt.executeUpdate();
			
			return new Weapon(weaponID, itemName, itemLevel, itemPrice, maxStackSize, requiredLevel, job, attackDmg);
		}
		
	}
	
	public static Weapon getWeaponFromWeaponID(Connection cxn, int weaponID) throws SQLException{
		String selectWeapon = """
				SELECT weaponID, itemName, itemLevel, itemPrice, itemMaxStackSize, requiredLevel, jobID, attackDamage
					FROM Weapon
						INNER JOIN EquippableItem ON EquippableItem.equippableItemID = Weapon.weaponID
						INNER JOIN ItemPrototype ON ItemPrototype.prototypeID = Weapon.weaponID
					WHERE weaponID = ?;
				""";
		
		try (PreparedStatement selectStmt = cxn.prepareStatement(selectWeapon)) {
			selectStmt.setInt(1, weaponID);
			
			try(ResultSet results = selectStmt.executeQuery()) {
				if (results.next()) {
					Job job = JobDao.getJobFromJobID(cxn, results.getInt("jobID"));
					return new Weapon(
							weaponID,
							results.getString("itemName"),
							results.getInt("itemLevel"),
							results.getFloat("itemPrice"),
							results.getInt("itemMaxStackSize"),
							results.getInt("requiredLevel"),
							job,
							results.getInt("attackDamage"));
				} else return null;
			}
		}
	}
	
	
	
	

}
