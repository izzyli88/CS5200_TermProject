package dnd.model;

public class Consumable extends ItemPrototype{
		
	
	// constructor
	// always input all 5 args, to use default vals, set as null
	public Consumable(int prototypeID, String itemName, Integer itemLevel, Float itemPrice, Integer itemMaxStackSize) {
        super(prototypeID, itemName,
        		itemLevel != null ? itemLevel : DEFAULT_ITEM_LEVEL, 
	            itemPrice != null ? itemPrice : DEFAULT_ITEM_PRICE, 
	            itemMaxStackSize != null ? itemMaxStackSize : DEFAULT_ITEM_MAX_STACK_SIZE);
    }

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public String toString() {
	    return String.format("Consumable(%s)", super.fieldsToString());
	}
}
