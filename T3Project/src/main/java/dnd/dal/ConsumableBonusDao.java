package dnd.dal;
import dnd.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConsumableBonusDao {
	private ConsumableBonusDao() {}
	
	public static ConsumableBonus create(Connection cxn, Statistic stat, Consumable consumable, float bonusPercentage, float bonusCap) throws SQLException{
		String insertConsumableBonus = "INSERT INTO ConsumableBonus (statisticID, consumableID, bonusPercentage, bonusCap) VALUES (?, ?, ?, ?);";
				
				try (PreparedStatement insertStmt = cxn.prepareStatement(insertConsumableBonus)) {
					
					insertStmt.setInt(1, stat.getStatisticID());
					insertStmt.setInt(2, consumable.getPrototypeID());
					insertStmt.setFloat(3, bonusPercentage);
					insertStmt.setFloat(4, bonusCap);
					insertStmt.executeUpdate();
					
					return new ConsumableBonus( stat, consumable, bonusPercentage, bonusCap);
				}
	}
	
	public static ConsumableBonus getConsumableBonusFromStatANDConsumable(Connection cxn, Statistic stat, Consumable consumable) throws SQLException{
		return null;
	}

}
