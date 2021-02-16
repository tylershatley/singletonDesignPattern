package singletonDesignPattern;
import java.util.HashMap;
import java.util.Iterator;

/**
 * class library
 * made up of static libraries
 * check in
 * checkout 
 * display
 * made up of a hashHap
 */
public class Library {
    private HashMap < String, Integer > books = new HashMap < > ();
    private static Library library;

    /**
     * private library, essentially calling library, creates it. nothing else
     * used later for static purposes
     */
    private Library() {};


    /**
     * determines if library already exists, if one doesnt exists create it
     * else/ next, return the library
     * @return instance of library
     */
    public static Library getInstance() {
        if (library == null) {
            System.out.println("Creating our Library. Time to begin reading");
            library = new Library();
        }
        return library;
    }

    /**
     * 
     * @param bookName
     * @param numToAdd
     * function to check in book
     * checks to see if the bookName is already in hashmap, == true, 
     * write over existing value attatched to key with + numToAdd
     * else, adds to newly titled book to the hashMap
     */
    public void checkInBook(String bookName, int numToAdd) {
        //if book is already in hashmap, add numToAdd to value
        if (books.containsKey(bookName)) {
            books.put(bookName, (books.get(bookName) + numToAdd));
            System.out.println("A new copy of " + bookName + " was added to the library");
        }
        //book isn't present in hashmap, so add it
        else {
            books.put(bookName, numToAdd);
            System.out.println(bookName + " was added to the library");
        }
    }


    /**
     * 
     * @param bookName
     * @return true or false
     * checks to see if there exists a key bookName and if it exists the value must be greater than 
     * or equal to 1 in order to check the book out. Update value attached to key,
     * print that it was sduccessfully checked out. Return true
     * 
     * else, the book didnt exist or there wasnt any avaiable copies
     * print, sorry its not avaiable 
     * return false
     */
    public boolean checkoutBook(String bookName) {
        //check to see if the book is in the hashmap and value is greater than or equal to 1
        if (books.containsKey(bookName) && books.get(bookName) >= 1) {
            //this means they were able to checkout the book
            //find value of key and decrease it by 1
            books.put(bookName, (books.get(bookName) - 1));
            System.out.println(bookName + " was successfully checked out");
            return true;
        }
        //this means book wasnt found or they have no avaiable copies
        else {
            System.out.println("Sorry " + bookName + " is not in stock");
            return false;
        }
    }

    /**
     * void function displayBooks()
     * Created an iterator for strting and integer, which read
     * the next thing inside of the map based of key and value
     * set up a while loop to iterate through the key and value and print them accordingly
     */
    public void displayBooks() {
        Iterator < String > itr = books.keySet().iterator();
        Iterator < Integer > itrr = books.values().iterator();
        System.out.println("\nInventory: ");
        while (itr.hasNext()) {
            System.out.println(" -" + itr.next() + ", copies: " + itrr.next());
        }
    }
}