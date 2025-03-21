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
		return null;
	}
	
	public static ConsumableBonus getConsumableBonusFromStatANDConsumable(Connection cxn, Statistic stat, Consumable consumable) throws SQLException{
		return null;
	}

}
