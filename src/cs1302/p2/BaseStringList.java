package cs1302.p2;

import cs1302.adt.StringList;
import cs1302.adt.FancyStringList;

/**
 * This class represents an instance of a BaseStringList Object and
 * implements {@code Stringlist}. Provides methods that aid in the
 * facilitation of adding and removing items to/from a list.
 */
public abstract class BaseStringList implements FancyStringList {

    protected int size;

    /**
     * Default constructor for a {@code BaseStringList}. Creates
     * an empty list, that is a list with {@code size} 0.
     */
    public BaseStringList() {
        this.size = 0;
    } //BaseStringList

    /**
     * Adds an item to the end of a list.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean append(String item) {
        add(size,item);
        return true;
    } // append

/**
 * Returns true if the calling list object is empty, and false otherwise.
 *
 * <p>
 * {@inheritDoc}
 */
    @Override
    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }        else {
            return false;
        }
    } // isEmpty

    /**
     * Creates and returns a String containing all of the
     * objects in the list, equally separated.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public String makeString(String start, String sep, String end) {
        String result = "";
        result += start;
        for (int i = 0; i < this.size(); i++) {
            result += this.get(i);
            if (i < this.size - 1) {
                result += sep;
            }
        }
        result += end;
        return result;
    } // makeString

    /**
     * Adds an item to beginning of the list. If the item
     * was successfully added, returns true. Otherwise, returns
     * false.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean prepend(String item) {
        add(0,item);
        return true;
    } // prepend

    /**
     * Returns the number of items in the list.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return size;
    } // size

/**
 * Returns the each item in the list, separated by commas.
 *
 * <p>
 * {@inheritDoc}
 */
    @Override
    public String toString() {
        String result = "";
        result = this. makeString("[",", ","]");
        return result;
    } // toString

/**
 * Inserts specified items into the string list at the specified index.
 *
 * <p>
 * {@inheritDoc}
 */
    @Override
    public boolean add(int index, StringList items) {
        if (items == null) {
            throw new NullPointerException("add: StringList object cannot be null.");

        } else if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("add: Index is out of range (" + index + ")");
        }

        String[] addedItems = new String[items.size()];
        for (int j = 0; j < addedItems.length; j++) {
            addedItems[j] = items.get(j);
        }
        for (int k = 0; k < addedItems.length; k++) {
            add(index, addedItems[k]);
            index++;
        }

        //add to our last
        /* for (int i = 0; i < items.size(); i++) {
            add(index, items.get(i));
            index++;
        }
        */
        return !items.isEmpty();
    } // add

    /**
     * Insers the specified items to the end of the string list.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean append(StringList items) {
        if (items == null) {
            throw new NullPointerException("append: StringList object cannot be null");
        }
        String[] addItems = new String[items.size()];
        for (int i = 0; i < addItems.length; i++) {
            addItems[i] = items.get(i);
        }
        for (int j = 0; j < addItems.length; j++) {
            add(this.size, addItems[j]);
        }
        return !items.isEmpty();
    } // append

    /**
     * Checks if there is an item at the specified start index or after the index
     * that equals the target string. Returns true if there is and false otherwise.
     *
     * <p>
     * {@inheritDoc}
     */
    public boolean contains(int start, String target) {
        boolean doesContain = false;
        for (int i = start; i < size(); i++) {
            if (this.get(i).equals(target)) {
                doesContain = true;
                break;
            }
        }
        return doesContain;
    } // contains

    /**
     * Returns the index of the first item at or after the specified start index
     * within the specified fancy string list that equals the target string.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public int indexOf(int start, String target) {
        int foundAt = -1;
        for (int i = start; i < size(); i++) {
            if (this.get(i).equals(target)) {
                foundAt = i;
                break;
            }
        }
        return foundAt;
    } // indexOf

    /**
     * Adds specified items to the beginning of the string list.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean prepend(StringList items) {
        if (items == null) {
            throw new NullPointerException("prepend: items cannot be null.");
        }
        int index = 0;
        String[] addItems = new String[items.size()];
        for (int i = 0; i < addItems.length; i++) {
            addItems[i] = items.get(i);
        }
        for (int j = 0; j < addItems.length; j++) {
            add(index, addItems[j]);
            index++;
        }
        return !items.isEmpty();
    } // prepend

} //BaseStringList
