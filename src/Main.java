import java.util.Scanner;

//A class used for client interaction
@SuppressWarnings("Duplicates")
public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a valid boolean equation");
        String equationString = scanner.nextLine(); //Insert input string here

        System.out.println("\n" + Bool.satisfy(equationString));
        scanner.close();
    }


}
