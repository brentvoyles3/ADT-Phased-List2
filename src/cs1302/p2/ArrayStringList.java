package cs1302.p2;

import cs1302.adt.StringList;
import cs1302.adt.FancyStringList;

/**
 * This class represents an instance of an ArrayStringList object.
 * An ArrayStringList is a certain type of list that stores items.
 * ArrayStringList allows the user to display the items and modify
 * the associated items that are in the list.
 */
public class ArrayStringList extends BaseStringList {

    private int arraySize = 10;
    private String[] items;

    /**
     * Default constructor for an ArrayStringList. Creates an
     * empty list with default storage size.
     */
    public ArrayStringList() {
        this.items = new String[arraySize];
    } // ArrayStringList

    /**
     * Constructs an instance of an Array String List that
     * copies over the elements of the specified list.
     *
     * @param other The String List object that is copied.
     */
    public ArrayStringList(StringList other) {
        if (other == null) {
            throw new NullPointerException("String List to be copied can't be null");
        }
        int getSize = other.size();
        this.items = new String[getSize];
        for (int i = 0; i < getSize; i++) {
            items[i] = other.get(i);
            size++;
        } // for
    } // ArrayStringList

    /**
     * Adds an item to the specified position of a list.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean add(int index, String item) {
        if (item == null) {
            throw new NullPointerException("add: item is null");
        }        else if (item.length() == 0) {
            throw new IllegalArgumentException("add: item is empty");
        }        else if (index < 0 || index > this.size()) {
            throw new IndexOutOfBoundsException("add: index is out of range (" + index + ")" );
        }
        //if list is going to be full, increase size of array by 3.
        if (index == size) {
            String[] addItems = new String[items.length + 3];
            for (int k = 0; k < index; k++) {
                addItems[k] = items[k];
            }
            this.items = addItems;
        }
        //if no current item at index
        if (items[index] == null) {
            items[index] = item;
            this.size++;
        }        else {
            //copy existing elements to new array
            String[] addedItems = new String[items.length + 3];
            for (int i = 0; i < index; i++) {
                addedItems[i] = items[i];
            }
            //add the item to index
            addedItems[index] = item;
            //add remaining items to new array
            for (int j = index + 1; j < items.length + 1; j++) {
                addedItems[j] = items[index];
                index++;
            }
            this.items = addedItems;
            this.size++;
        }
        return true;
    } // add

/**
 * Removes all items from the list.
 *
 * <p>
 * {@inheritDoc}
 */
    @Override
    public void clear() {
        //set all elements of array to null
        for (int i = 0; i < items.length; i++) {
            items[i] = " " + i;
        }
        this.size = 0;
    } // clear

/**
 * Returns the item on the list that's located at the specified position.
 *
 * <p>
 * {@inheritDoc}
 */
    @Override
        public String get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("get: index is out of range (" + index + ")");
        }
        return items[index];
    } // get

/**
 * Removes the item from the specified position on the list.
 *
 * <p>
 * {@inheritDoc}
 */
    @Override
    public String remove(int index) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException("remove: index is out of range (" + index + ")");
        }
        //save item to remove
        String removedItem = items[index];
        //shift next item left one position.
        items[index] = items[index + 1];
        //shift remaining items left one position.
        for (int j = index + 1; j < items.length - 1; j++) {
            items[j] = items[j + 1];
        }
        this.size--;
        return removedItem;
    } // remove

/**
 * Returns a new string list containing only the items within the
 * specified positions of the list.
 *
 * <p>
 * {@inheritDoc}
 */
    @Override
    public StringList slice(int start, int stop) {
        if (start < 0 || stop > size() || start > stop) {
            throw new IndexOutOfBoundsException("slice: index out of range");
        }
        StringList slicedList = new ArrayStringList();
        for (int i = start; i < stop; i++) {
            slicedList.append(this.get(i));
        }
        return slicedList;
    } // slice

    /**
     * Returns a new fancy string list that contains the items from the
     * specified list in reverse order.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public FancyStringList reverse() {
        FancyStringList reversedList = new ArrayStringList();
        int last = this.size();
        do {
            reversedList.append(this.get(last - 1));
            last--;
        } while (last > 0);
        return reversedList;
    } // reverse

/**
 * Returns a new fancy string list that contains the items located between the
 * specified start and stop indices.
 *
 *
 * <p>
 * {@inheritDoc}
 */
    public FancyStringList slice(int start, int stop, int step) {
        if (start < 0 || stop > size() || start > stop || step < 1) {
            throw new IndexOutOfBoundsException("slice: endpoint or step index out of range.");
        }
        FancyStringList slicedList = new ArrayStringList();
        if (step == 1) {
            for (int i = start; i < stop; i++) {
                slicedList.append(this.get(i));
            }
        } else {
            slicedList.append(this.get(start));
            int tracker = start;
            while (tracker < stop) {
                tracker += step;
                if (tracker >= stop) {
                    break;
                }
                slicedList.append(this.get(tracker));
            }
        }
        return slicedList;
    } // slice

} // ArrayStringList
