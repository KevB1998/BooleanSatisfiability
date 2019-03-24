
@SuppressWarnings("Duplicates")
public class Main {

    public static void main(String[] args) {
        String equationString = "(a+b)*(a'+b')*(a'+b)*(b'+a)";

        System.out.println(Bool.satisfy(equationString));
    }


}
