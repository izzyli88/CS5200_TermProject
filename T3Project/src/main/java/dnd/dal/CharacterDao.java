package dnd.dal;
import dnd.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class CharacterDao{
	private CharacterDao() {}
	
	public static GameCharacter create(Connection cxn,
			Player player,
			String firstName,
			String lastName,
			Clan clan,
			Job currentJob,
			Weapon currWeapon) throws SQLException {
		final String insertGameCharacter = """
			      INSERT INTO Character (player, firstName, lastName, clan, currentJob, currWeapon )
		        VALUES (?, ?, ?, ?, ?, ?);""";
		
		try(PreparedStatement insertStmt = cxn.prepareStatement(insertGameCharacter, Statement.RETURN_GENERATED_KEYS)) {
			insertStmt.setInt(0, 0);
			
			insertStmt.setInt(1, player.getPlayerID());
			insertStmt.setString(2, firstName);
			insertStmt.setString(3, lastName);
			insertStmt.setInt(4, clan.getClanID());
			insertStmt.setInt(5, currentJob.getJobID());
			insertStmt.setInt(6, currWeapon.getPrototypeID());
			insertStmt.executeUpdate();
			
			return new GameCharacter(Utils.getAutoIncrementKey(insertStmt), player, firstName, lastName, clan, currentJob, currWeapon);
		}
	}
		
}
	
	
//	private Player player;
//	private String firstName;
//	private String lastName;
//	private Clan clan;
//	private Job currentJob;
//	private Weapon currWeapon;
