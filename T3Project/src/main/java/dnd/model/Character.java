package dnd.model;

import java.util.Objects;

public class Character {
	private int characterID;
	private Player player;
	private String firstName;
	private String lastName;
	private Clan clan;
	private Job currentJob;
	private Weapon currWeapon;
	
	// constructor
	public Character(int characterID,
			Player player,
			String firstName,
			String lastName,
			Clan clan,
			Job currentJob,
			Weapon currWeapon) {
		this.characterID = characterID;
		this.player = player;
		this.firstName = firstName;
		this.lastName = lastName;
		this.clan = clan;
		this.currentJob = currentJob;
		this.currWeapon = currWeapon;
	}
	
	// getters/setters

	public int getCharacterID() {
		return characterID;
	}

	public void setCharacterID(int characterID) {
		this.characterID = characterID;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Clan getClan() {
		return clan;
	}

	public void setClan(Clan clan) {
		this.clan = clan;
	}

	public Job getCurrentJob() {
		return currentJob;
	}

	public void setCurrentJob(Job currentJob) {
		this.currentJob = currentJob;
	}
	
	
	public Weapon getCurrWeapon() {
		return currWeapon;
	}

	public void setCurrWeapon(Weapon currWeapon) {
		this.currWeapon = currWeapon;
	}
	
	// equals/hash/toString

	@Override
	public int hashCode() {
		return Objects.hash(characterID, clan, currWeapon, currentJob, firstName, lastName, player);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Character other = (Character) obj;
		return characterID == other.characterID && Objects.equals(clan, other.clan)
				&& Objects.equals(currWeapon, other.currWeapon) && Objects.equals(currentJob, other.currentJob)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(player, other.player);
	}

	@Override
	public String toString() {
		return "Character [characterID=" + characterID + ", player=" + player + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", clan=" + clan + ", currentJob=" + currentJob + ", currWeapon="
				+ currWeapon + "]";
	}
	
	
	
	
	
	
	
	
	

}
