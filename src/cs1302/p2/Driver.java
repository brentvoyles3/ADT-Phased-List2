package cs1302.p2;

import cs1302.adt.StringList;
import cs1302.oracle.FancyOracleStringList;
import cs1302.adt.FancyStringList;

/**
 * Class containing the main method for the {@code StringList} implementations. Used
 * for testing purposes only.
 */
public class Driver {

    public static void main(String[] args) {
        FancyStringList fosl = new FancyOracleStringList();
        FancyStringList asl = new ArrayStringList();
        FancyStringList lsl = new LinkedStringList();
        asl.add(0, "Coke");
        asl.add(1, "Sprite");
        asl.add(2, "Tea");
        lsl.add(0, "Doritos");
        lsl.add(1, "Oreos");
        lsl.add(2, "Gum");
        lsl.add(3, "SunChips");
        System.out.print("AFSL: ");
        FancyStringList myFsl = new ArrayStringList(asl);
        System.out.println(myFsl);
        System.out.println("Add an element to first index of list");
        myFsl.add(0, "Cherry");
        System.out.println(myFsl);
        myFsl = myFsl.reverse();
        System.out.print("Reverse: ");
        System.out.println(myFsl);
        myFsl.add(0,myFsl);
        System.out.print("Adding the list to itself");
        System.out.println(" " + myFsl);
    } // main

} // Driver
