package dnd.model;

import java.util.Objects;

public class InventorySlot {
	private int inventoryID;
	private Character character;
	private int slotNumber;
	private ItemPrototype prototypeID;
	private int stackSize;
	
	private static final int DEFAULT_STACK_SIZE = 1;

	
	public InventorySlot(int inventoryID, Character character, int slotNumber, ItemPrototype prototypeID,
			Integer stackSize) {
		this.inventoryID = inventoryID;
		this.character = character;
		this.slotNumber = slotNumber;
		this.prototypeID = prototypeID;
		this.stackSize = stackSize != null ? stackSize : DEFAULT_STACK_SIZE;
	}


	public int getInventoryID() {
		return inventoryID;
	}


	public void setInventoryID(int inventoryID) {
		this.inventoryID = inventoryID;
	}


	public Character getCharacter() {
		return character;
	}


	public void setCharacter(Character character) {
		this.character = character;
	}


	public int getSlotNumber() {
		return slotNumber;
	}


	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}


	public ItemPrototype getPrototypeID() {
		return prototypeID;
	}


	public void setPrototypeID(ItemPrototype prototypeID) {
		this.prototypeID = prototypeID;
	}


	public int getStackSize() {
		return stackSize;
	}


	public void setStackSize(int stackSize) {
		this.stackSize = stackSize;
	}


	@Override
	public int hashCode() {
		return Objects.hash(character, inventoryID, prototypeID, slotNumber, stackSize);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InventorySlot other = (InventorySlot) obj;
		return Objects.equals(character, other.character) && inventoryID == other.inventoryID
				&& Objects.equals(prototypeID, other.prototypeID) && slotNumber == other.slotNumber
				&& stackSize == other.stackSize;
	}


	@Override
	public String toString() {
		return "InventorySlot [inventoryID=" + inventoryID + ", character=" + character + ", slotNumber=" + slotNumber
				+ ", prototypeID=" + prototypeID + ", stackSize=" + stackSize + "]";
	}

}
