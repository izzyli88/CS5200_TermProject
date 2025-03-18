package dnd.model;

import java.util.Objects;

public class CharacterStats {
	private Character character;
	private Statistic statistic;
	private int value;
	
	
	public CharacterStats(Character character, Statistic statistic, int value) {
		this.character = character;
		this.statistic = statistic;
		this.value = value;
	}


	@Override
	public int hashCode() {
		return Objects.hash(character, statistic, value);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CharacterStats other = (CharacterStats) obj;
		return Objects.equals(character, other.character) && Objects.equals(statistic, other.statistic)
				&& value == other.value;
	}


	@Override
	public String toString() {
		return "CharacterStats [character=" + character + ", statistic=" + statistic + ", value=" + value + "]";
	}
}
