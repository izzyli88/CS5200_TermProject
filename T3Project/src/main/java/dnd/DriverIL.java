package dnd;
import dnd.dal.CharacterDao;
import dnd.dal.ClanDao;
import dnd.dal.ConnectionManager;
import dnd.dal.ConsumableDao;
import dnd.dal.EquippableItemDao;
import dnd.dal.GearDao;
import dnd.dal.GearSlotDao;
import dnd.dal.ItemPrototypeDao;
import dnd.dal.JobDao;
import dnd.dal.PlayerDao;
import dnd.dal.RacesDao;
import dnd.dal.WeaponDao;
import dnd.model.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DriverIL{
	public static void main(String[] args) {
		try {
			 resetSchema();
			 insertRecords();
		} catch (SQLException e) {
		  System.out.print("SQL Exception: ");
	      System.out.println(e.getMessage());
	      e.printStackTrace();
	      System.exit(-1);
		}
		
	}
	
	private static void insertRecords() throws SQLException{
		try(Connection cxn = ConnectionManager.getConnection()) {
			
			
			// RECORD CREATION
			// Player creation
			Player doge = PlayerDao.create(cxn, "Doge Dog", "doge@email.com");
			PlayerDao.create(cxn, "Cat cat", "cat@email.com");
			
			// Races creation
			Races elf = RacesDao.create(cxn, "Elf");
			RacesDao.create(cxn, "Dwarf");
			RacesDao.create(cxn, "Human");
			
			
			// Clan creation
			Clan mirk = ClanDao.create(cxn, elf, "Mirkwood");
			
			// GearSlot creation
			GearSlot head = GearSlotDao.create(cxn, "Head");
			GearSlot body = GearSlotDao.create(cxn, "Body");
			GearSlot feet = GearSlotDao.create(cxn, "Feet");
			
			// Job creation
			
			Job rogue = JobDao.create(cxn, "Rogue");
			Job paladin = JobDao.create(cxn, "Paladin");
			Job ranger = JobDao.create(cxn, "Ranger");
			
			
			// Consumable Creation
			Consumable bob = ConsumableDao.create(cxn, "Bag of Beans", 100, 10000.0f, 10);
			Consumable gem = ConsumableDao.create(cxn, "Elemental Gem", 100, 10000.0f, 10);
			ConsumableDao.create(cxn, "Bag of Beans", 500, 50000.0f, 50);		// duplicate names okay
			
			
			// Gear Creation
			GearDao.create(cxn, "Valorous Mask", 15, 10000f, 10, 30, head);
			GearDao.create(cxn, "Valorous Plate", 15, 10000f, 10, 30, body);
			GearDao.create(cxn, "Valorous Greaves", 15, 10000f, 10, 30, feet);
			
			
			// Weapon Creation
			Weapon dagger = WeaponDao.create(cxn, "Dagger", 20, 2000f, 20, 20, rogue, 20);
			WeaponDao.create(cxn, "Glaive", 50, 5000f, 50, 50, paladin, 50);
			WeaponDao.create(cxn, "Longbow", 30, 3000f, 30, 30, ranger, 30);
			
			
			// Game Character Creation
			GameCharacter megumi = CharacterDao.create(cxn, doge, "Megumi", "Fushiguro", mirk, rogue, dagger);
			CharacterDao.create(cxn, doge, "Yuji", "Itadori", mirk, paladin, dagger);


			
			// RETRIEVAL
			System.out.println("RECORD RETRIEVAL");
			
			// Player from playerID
			Player player = PlayerDao.getPlayerFromPlayerID(cxn, 1);
			System.out.format("Reading Player: PlayerID: %d, Full Name: %s, Email: %s\n", player.getPlayerID(), player.getFullName(), player.getEmail());
			
			
			// Race from raceID
			Races race = RacesDao.getRaceFromRaceID(cxn, 1);
			System.out.format("Reading Race: RaceID: %d, Race Name: %s\n", race.getRaceID(), race.getRaceName());
			
			Clan clan = ClanDao.getClanFromClanID(cxn, 1);
			System.out.format("Reading Clan: ClanID: %d, RaceID: %d, Clan Name: %s\n", clan.getClanID(), clan.getRace().getRaceID(), clan.getClanName());
			
			
			// GearSlot from slotID
			GearSlot slot = GearSlotDao.getGearSlotFromSlotID(cxn, 1);
			System.out.format("Reading GearSlot: SlotID: %d, Slot Name: %s\n", slot.getSlotID(), slot.getSlotName());
			
			// Job from jobID
			Job job = JobDao.getJobFromJobID(cxn, 1);
			System.out.format("Reading Job: jobID: %d, Job Name: %s\n", job.getJobID(), job.getJobName());
			
			
			// Consumable from consumableID
			Consumable consumable = ConsumableDao.getConsumableByPrototypeID(cxn, 1);
			System.out.format("Reading Consumable: Consumable ID: %d, Name: %s, Level: %d, Price: %f, Max Stack Size: %d\n", consumable.getPrototypeID(), consumable.getItemName(),
					consumable.getItemLevel(), consumable.getItemPrice(), consumable.getItemMaxStackSize());
			
			
			// Gear from GearID
			Gear gear = GearDao.getGearFromGearID(cxn, 4);
			System.out.format("Reading Gear: Gear ID: %d, Name: %s, Level: %d, Price: %f, Max Stack Size: %d, RequiredLevel: %d, Slot: %d\n", gear.getPrototypeID(), gear.getItemName(),
					gear.getItemLevel(), gear.getItemPrice(), gear.getItemMaxStackSize(), gear.getRequiredLevel(), gear.getSlotID().getSlotID());
			
			// Weapon from WeaponID
			Weapon weapon = WeaponDao.getWeaponFromWeaponID(cxn, 7);
			System.out.format("Reading Weapon: Weapon ID: %d, Name: %s, Level: %d, Price: %f, Max Stack Size: %d, RequiredLevel: %d, Job: %d, Attack Damage: %d\n",
					weapon.getPrototypeID(), weapon.getItemName(),
					weapon.getItemLevel(), weapon.getItemPrice(), weapon.getItemMaxStackSize(), weapon.getRequiredLevel(), weapon.getJob().getJobID(), weapon.getAttackDamage());
			
			ItemPrototype ip = ItemPrototypeDao.getItemFromPrototypeID(cxn, 7);
			System.out.format("Reading Item Prototype: Prototype ID: %d, Name: %s, Level: %d, Price: %f, Max Stack Size: %d\n", ip.getPrototypeID(), ip.getItemName(),
					ip.getItemLevel(), ip.getItemPrice(), ip.getItemMaxStackSize());
			
			// EquippableItem from EquippableItemID
			EquippableItem ei = EquippableItemDao.getEquippableItemFromProtoypeID(cxn, 7);
			System.out.format("Reading Equippable Item: Equippable ID: %d, Name: %s, Level: %d, Price: %f, Max Stack Size: %d, RequiredLevel: %d\n", ei.getPrototypeID(), ei.getItemName(),
					ei.getItemLevel(), ei.getItemPrice(), ei.getItemMaxStackSize(), ei.getRequiredLevel());
			
			
			// Character from CharID
			GameCharacter mf = CharacterDao.getCharFromCharID(cxn, 1);
			System.out.format("Reading Character: CharID: %d, PlayerID: %d, First Name: %s, Last Name: %s, ClanID: %d, CurrJob: %d, EquippedWeapon: %d\n",
					mf.getCharacterID(), mf.getPlayer().getPlayerID(), mf.getFirstName(), mf.getLastName(), mf.getClan().getClanID(),
					mf.getCurrentJob().getJobID(), mf.getCurrWeapon().getPrototypeID());
			
			System.out.println();
			
		
			// EXTRA 3 METHODS: CONSUMABLE CLASS
			System.out.println("CONSUMABLE: UPDATE/NAME LIST/DELETE");
			
			// updateName
			Consumable elixir = ConsumableDao.updateName(cxn, gem, "Elixir of Life");
			System.out.format("Reading Updated Consumable: Consumable ID: %d, Name: %s, Level: %d, Price: %f, Max Stack Size: %d\n", elixir.getPrototypeID(), elixir.getItemName(),
					elixir.getItemLevel(), elixir.getItemPrice(), elixir.getItemMaxStackSize());
			
			
			// retrieve list by name
			List<Consumable> beans = ConsumableDao.getConsumablesByName(cxn, "Bag of Beans");
			
			for (Consumable c : beans) {
				System.out.format("Looping Consumables: Consumable ID: %d, Name: %s, Level: %d, Price: %f, Max Stack Size: %d\n", c.getPrototypeID(), c.getItemName(),
						c.getItemLevel(), c.getItemPrice(), c.getItemMaxStackSize());
			}
			
			
			// delete consumable
			ConsumableDao.delete(cxn, bob);
			System.out.format("Deleting Bag of Bones (id = %d)\n", bob.getPrototypeID());
			Consumable tryBob = ConsumableDao.getConsumableByPrototypeID(cxn, 1);
			if (tryBob == null) {
				System.out.println("Deletion Successful!");
			} else System.out.println("Deletion Not Successful");
			
			
			
			
		}
		
		
	}
	
	private static void resetSchema() throws SQLException{
		try (Connection cxn = ConnectionManager.getSchemalessConnection()) {
		     cxn.createStatement().executeUpdate("DROP SCHEMA IF EXISTS CS5200Project;");
		     cxn.createStatement().executeUpdate("create schema CS5200Project;"); 
		}
		
		try(Connection cxn = ConnectionManager.getConnection()) {
			cxn.createStatement().executeUpdate("""
					CREATE TABLE Currency (
					    currencyID INT AUTO_INCREMENT PRIMARY KEY,
					    currencyName VARCHAR(50) UNIQUE NOT NULL,
					    cap INT DEFAULT NULL,
					    weeklyCap INT DEFAULT NULL
					);
					""");
			
			cxn.createStatement().executeUpdate("""
					CREATE TABLE Player (
					    playerID INT AUTO_INCREMENT PRIMARY KEY,
					    fullName VARCHAR(50) NOT NULL,
					    emailAddress VARCHAR(100) UNIQUE NOT NULL
					);
					""");
			cxn.createStatement().executeUpdate("""
					CREATE TABLE Races (
					    raceID INT AUTO_INCREMENT PRIMARY KEY,
					    raceName VARCHAR(50) UNIQUE NOT NULL
					);
					""");
			cxn.createStatement().executeUpdate("""
					CREATE TABLE Clan (
					    clanID INT AUTO_INCREMENT PRIMARY KEY,
					    raceID INT NOT NULL,
					    clanName VARCHAR(50) UNIQUE NOT NULL,
					    CONSTRAINT fk_clan FOREIGN KEY (raceID) REFERENCES Races(raceID) ON DELETE CASCADE ON UPDATE CASCADE
					);
					""");
			cxn.createStatement().executeUpdate("""
					CREATE TABLE Statistic (
					    statisticID INT AUTO_INCREMENT PRIMARY KEY,
					    statisticsName VARCHAR(50) UNIQUE NOT NULL
					);
					""");
			cxn.createStatement().executeUpdate("""
					CREATE TABLE gearSlot (
					    slotID INT AUTO_INCREMENT PRIMARY KEY,
					    slotName VARCHAR(50) UNIQUE NOT NULL
					);
					""");
			
			cxn.createStatement().executeUpdate("""
					CREATE TABLE Job (
					    jobID INT AUTO_INCREMENT PRIMARY KEY,
					    jobName VARCHAR(50) UNIQUE NOT NULL
					);
					""");
			cxn.createStatement().executeUpdate("""
					CREATE TABLE `Character` (
					    characterID INT AUTO_INCREMENT PRIMARY KEY,
					    playerID INT NOT NULL,
					    firstName VARCHAR(50) NOT NULL,
					    lastName VARCHAR(50) NOT NULL,
					    clanID INT NOT NULL,
					    currentJob INT NOT NULL,
					    equippedWeapon INT,
					    CONSTRAINT unique_CharacterName UNIQUE (firstName, lastName),
					    CONSTRAINT fk_Character_playerID FOREIGN KEY (playerID) REFERENCES Player(playerID) ON DELETE CASCADE ON UPDATE CASCADE,
					    CONSTRAINT fk_Character_clanID FOREIGN KEY (clanID) REFERENCES Clan(clanID) ON DELETE RESTRICT ON UPDATE CASCADE,
					    CONSTRAINT fk_Character_currJob FOREIGN KEY (currentJob) REFERENCES Job(jobID) ON DELETE RESTRICT ON UPDATE CASCADE
					);
					""");
			cxn.createStatement().executeUpdate("""
					CREATE TABLE CharacterCurrency (
					    characterID INT NOT NULL,
					    currencyID INT NOT NULL,
					    amountHeld INT DEFAULT 0,
					    amountEarnedThisWeek INT DEFAULT 0,
					    CONSTRAINT pk_CharCurr PRIMARY KEY (characterID, currencyID),
					    CONSTRAINT fk_CharCurr_charID FOREIGN KEY (characterID) REFERENCES `Character`(characterID) ON DELETE CASCADE ON UPDATE CASCADE,
					    CONSTRAINT fk_CharCurr_currID FOREIGN KEY (currencyID) REFERENCES Currency(currencyID) ON DELETE CASCADE ON UPDATE CASCADE
					);
					""");
			cxn.createStatement().executeUpdate("""
					CREATE TABLE CharacterJob (
					    characterID INT NOT NULL,
					    jobID INT NOT NULL,
					    level INT DEFAULT 1,
					    experiencePoints INT DEFAULT 0,
					    unlocked BOOLEAN DEFAULT FALSE,
					    CONSTRAINT pk_CharJob PRIMARY KEY (characterID, jobID),
					    CONSTRAINT fk_CharJob_charID FOREIGN KEY (characterID) REFERENCES `Character`(characterID) ON DELETE CASCADE ON UPDATE CASCADE,
					    CONSTRAINT fk_CharJob_jobID FOREIGN KEY (jobID) REFERENCES Job(jobID) ON DELETE CASCADE ON UPDATE CASCADE
					);
					""");
			cxn.createStatement().executeUpdate("""
					CREATE TABLE CharacterStats (
					    characterID INT NOT NULL,
					    statisticID INT NOT NULL,
					    value INT NOT NULL,
					    CONSTRAINT pk_CharStats PRIMARY KEY (characterID, statisticID),
					    CONSTRAINT fk_CharStats_charID FOREIGN KEY (characterID) REFERENCES `Character`(characterID) ON DELETE CASCADE ON UPDATE CASCADE,
					    CONSTRAINT fk_CharStats_statID FOREIGN KEY (statisticID) REFERENCES Statistic(statisticID) ON DELETE CASCADE ON UPDATE CASCADE
					);
					""");
			cxn.createStatement().executeUpdate("""
					CREATE TABLE ItemPrototype (
					    prototypeID INT AUTO_INCREMENT PRIMARY KEY,
					    itemName VARCHAR(100) NOT NULL,
					    itemLevel INT NOT NULL,
					    itemPrice DECIMAL(10,2) DEFAULT 0,
					    itemMaxStackSize INT NOT NULL
					);
					""");
			cxn.createStatement().executeUpdate("""
					CREATE TABLE InventorySlot (
					    characterID INT NOT NULL,
					    slotNumber INT NOT NULL,
					    prototypeID INT NOT NULL,
					    stackSize INT NOT NULL,
					    PRIMARY KEY (characterID, slotNumber),
					    CONSTRAINT fk_Inventory_charID FOREIGN KEY (characterID) REFERENCES `Character`(characterID) ON DELETE CASCADE ON UPDATE CASCADE,
					    CONSTRAINT fk_Inventory_prototypeID FOREIGN KEY (prototypeID) REFERENCES ItemPrototype(prototypeID) ON DELETE CASCADE ON UPDATE CASCADE
					);
					""");
			cxn.createStatement().executeUpdate("""
					CREATE TABLE Consumable (
					    consumableID INT PRIMARY KEY,
					    CONSTRAINT fk_consumable_consumableID FOREIGN KEY (consumableID) REFERENCES ItemPrototype(prototypeID) ON DELETE CASCADE ON UPDATE CASCADE
					);
					""");
			cxn.createStatement().executeUpdate("""
					CREATE TABLE EquippableItem (
					    equippableItemID INT PRIMARY KEY,
					    requiredLevel INT DEFAULT 1,
					    CONSTRAINT fk_Equippable_equippableID FOREIGN KEY (equippableItemID) REFERENCES ItemPrototype(prototypeID) ON DELETE CASCADE ON UPDATE CASCADE
					);
					""");
			cxn.createStatement().executeUpdate("""
					CREATE TABLE Gear (
					    gearID INT PRIMARY KEY,
					    slotID INT NOT NULL,
					    CONSTRAINT fk_Gear_gearID FOREIGN KEY (gearID) REFERENCES EquippableItem(equippableItemID) ON DELETE CASCADE ON UPDATE CASCADE,
					    CONSTRAINT fk_Gear_slotID FOREIGN KEY (slotID) REFERENCES gearSlot(slotID) ON DELETE CASCADE ON UPDATE CASCADE
					);
					""");
			cxn.createStatement().executeUpdate("""
					CREATE TABLE Weapon (
					    weaponID INT PRIMARY KEY,
					    jobID INT NOT NULL,
					    attackDamage INT NOT NULL,
					    CONSTRAINT fk_weapon_weaponID FOREIGN KEY (weaponID) REFERENCES EquippableItem(equippableItemID) ON DELETE CASCADE ON UPDATE CASCADE,
					    CONSTRAINT fk_weapon_jobID FOREIGN KEY (jobID) REFERENCES Job(jobID) ON DELETE CASCADE ON UPDATE CASCADE
					);
					""");
			cxn.createStatement().executeUpdate("""
					CREATE TABLE EquippedGear (
					    characterID INT NOT NULL,
					    slotID INT NOT NULL,
					    gearID INT NULL,
					    CONSTRAINT pk_equippedGear PRIMARY KEY (characterID, slotID),
					    CONSTRAINT fk_EquippedGear_charID FOREIGN KEY (characterID) REFERENCES `Character`(characterID) ON DELETE CASCADE ON UPDATE CASCADE,
					    CONSTRAINT fk_EquippedGear_slotID FOREIGN KEY (slotID) REFERENCES gearSlot(slotID) ON DELETE CASCADE ON UPDATE CASCADE,
					    CONSTRAINT fk_EquippedGear_gearID FOREIGN KEY (gearID) REFERENCES Gear(gearID) ON DELETE SET NULL ON UPDATE CASCADE
					);
					""");
			cxn.createStatement().executeUpdate("""
					CREATE TABLE GearJobRequirement (
					    gearID INT NOT NULL,
					    jobID INT NOT NULL,
					    CONSTRAINT pk_GearJobRequirement PRIMARY KEY (gearID, jobID),
					    CONSTRAINT fk_GearJobRequirement_gearID FOREIGN KEY (gearID) REFERENCES Gear(gearID) ON DELETE CASCADE ON UPDATE CASCADE,
					    CONSTRAINT fk_GearJobRequirement_jobID FOREIGN KEY (jobID) REFERENCES Job(jobID) ON DELETE CASCADE ON UPDATE CASCADE
					);
					""");
			cxn.createStatement().executeUpdate("""
					CREATE TABLE EquippableBonus (
					    statisticID INT NOT NULL,
					    equippableItemID INT NOT NULL,
					    bonusValue INT NOT NULL,
					    CONSTRAINT pk_equippableBonus PRIMARY KEY (statisticID, equippableItemID),
					    CONSTRAINT fk_EquippableBonus_statID FOREIGN KEY (statisticID) REFERENCES Statistic(statisticID) ON DELETE CASCADE ON UPDATE CASCADE,
					    CONSTRAINT fk_EquippableBonus_equippableID FOREIGN KEY (equippableItemID) REFERENCES EquippableItem(equippableItemID) ON DELETE CASCADE ON UPDATE CASCADE
					);
					""");
			cxn.createStatement().executeUpdate("""
					CREATE TABLE ConsumableBonus (
					    statisticID INT NOT NULL,
					    consumableID INT NOT NULL,
					    bonusPercentage FLOAT NOT NULL,
					    bonusCap FLOAT DEFAULT NULL,
					    CONSTRAINT pk_consumableBonus PRIMARY KEY (statisticID, consumableID),
					    CONSTRAINT fk_consumableBonus_statID FOREIGN KEY (statisticID) REFERENCES Statistic(statisticID) ON DELETE CASCADE ON UPDATE CASCADE,
					    CONSTRAINT fk_consumableBonus_consumableID FOREIGN KEY (consumableID) REFERENCES Consumable(consumableID) ON DELETE CASCADE ON UPDATE CASCADE
					);
					""");
		}
		
	}
}