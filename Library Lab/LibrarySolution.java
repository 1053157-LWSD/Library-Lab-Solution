import java.util.*;
import java.io.*;
// Take out imports later
/* 
    Prompt:

Write a method, readBook, which prompts the user to enter a file name 
and then checks if the given file exists in the repository. 
If the file exists, the method should read the file by opening it and displaying the text. (read the file)
If the file does not exist, handle the error by informing the user and ask them to enter another 
file name until a valid file name is provided. 
Precondition: Assume user always adds file type at end of file name.

    Example Ouput Scenario:

Welcome to the Library!
Type the file name of the book you want to read: notHere.txt
The file you are looking for isn't found.
Type the file name of the book you want to read: isHere.txt
File Contents of Book:
Testing 1, 2, 3

*/

class Library {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Library!");
        System.out.print("Type in the file name of the book you want to read: ");
        File name = new File(scan.next());
        readBook(name, scan);
        scan.close();
    }

public static void readBook(File bookName, Scanner scan) throws FileNotFoundException {

    while (!bookName.exists()) {
        System.out.println("That book can not be found. Try again.");
        System.out.print("Type in the file name of the book you want to read: ");
        bookName = new File(scan.next());
    }

    Scanner fileScan = new Scanner(bookName);
    System.out.println("File Contents of Book:");
    while (fileScan.hasNextLine()) {
        System.out.println(fileScan.nextLine());
    }
    fileScan.close();

    }
}