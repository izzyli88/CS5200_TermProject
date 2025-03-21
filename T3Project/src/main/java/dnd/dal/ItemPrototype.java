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


public class ItemPrototype {
	private ItemPrototype() {}
	
	
	public static ItemPrototype create(Connection cxn, String itemName, int itemLevel, Float itemPrice, int itemMaxStackSize) throws SQLException {
		return null;
	}
	
	public static ItemPrototype getItemFromPrototypeID(Connection cxn, int prototypeID) throws SQLException {
		return null;
	}

}
