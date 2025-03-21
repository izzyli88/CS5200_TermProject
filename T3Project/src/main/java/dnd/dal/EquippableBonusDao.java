package dnd.dal;
import dnd.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EquippableBonusDao {
	private EquippableBonusDao() {}
	
	public static EquippableBonus create(Connection cxn, Statistic stat, EquippableItem equippableItem, int bonusValue) throws SQLException{
		return null;
	}
	
	public static EquippableBonus getEquippableBonusFromStatANDPrototypeID(Connection cxn, Statistic stat,
			EquippableItem equippableItem) throws SQLException{
		return null;
	}

}
