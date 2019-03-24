
@SuppressWarnings("Duplicates")
public class Main {

    public static void main(String[] args) {
        String equationString = "(a+b+c)*(a'+b'+c)*(a+b'+c')*(a'+b+c')";

        System.out.println(Bool.satisfy(equationString));
    }


}
