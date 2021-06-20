package treeSet;

import java.util.Objects;

/**
 * An item with a description and a part number.
 */
public class Item implements Comparable<Item> {
    private String description;
    private int partNumber;

    /**
     * Construct an item.
     *
     * @param aDescription the item's description
     * @param aPartNumber  the item's part number
     */
    public Item(String aDescription, int aPartNumber) {
        description = aDescription;
        partNumber = aPartNumber;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Gets the description of this item.
     *
     * @return the description
     */
    @Override
    public String toString() {
        return "Item[" +
                "description='" + description +
                ", partNumber=" + partNumber +
                ']';
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;
        Item other = (Item) otherObject;
        return partNumber == other.partNumber &&
                description.equals(other.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, partNumber);
    }

    @Override
    public int compareTo(Item other) {
        int diff = Integer.compare(partNumber, other.partNumber);
        return diff != 0 ? diff : description.compareTo(other.description);
    }
}
