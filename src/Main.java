
@SuppressWarnings("Duplicates")
public class Main {

    public static void main(String[] args) {
        String equationString = "(a+b+c)*(a'+b'+c)*(a+b'+c')*(a'+b+c')";

        String termString = "a'*b*c'*a";
        BoolTerm boolTerm = Bool.stringToTerm(termString);
        System.out.println(boolTerm);

        //BoolEquation equation = stringToEquation(equationString);
        //System.out.println(equation);

        /* BoolEquation equation1 = new BoolEquation();
        BoolEquation equation2 = new BoolEquation();

        BoolVar a = new BoolVar("a");
        BoolVar aNot = new BoolVar("a", true);
        BoolVar b = new BoolVar("b");
        BoolVar bNot = new BoolVar("b", true);
        BoolVar c = new BoolVar("c");
        BoolVar cNot = new BoolVar("c", true);

        BoolTerm term1 = new BoolTerm();
        term1.addProduct(a);
        term1.addProduct(bNot);
        term1.addProduct(c);

        BoolTerm term2 = new BoolTerm();
        term2.addProduct(a);
        term2.addProduct(cNot);

        BoolTerm term3 = new BoolTerm();
        term3.addProduct(a);
        term3.addProduct(b);

        BoolTerm term4 = new BoolTerm();
        term4.addProduct(a);
        term4.addProduct(c);

        equation1.addTerm(term1);
        equation1.addTerm(term2);

        equation2.addTerm(term3);
        equation2.addTerm(term4);

        System.out.println("E1: " + equation1);
        System.out.println("E2: " + equation2);

        BoolEquation product = Bool.multiply(equation1, equation2);

        System.out.println("E1*E2: " + product);*/
    }


}
