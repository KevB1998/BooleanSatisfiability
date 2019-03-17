import java.util.ArrayList;

@SuppressWarnings("Duplicates")
public class Bool {
    public static BoolTerm multiply(BoolVar product1, BoolVar product2){
        BoolTerm boolTerm = new BoolTerm();
        boolTerm.addProduct(product1);
        if(boolTerm.addProduct(product2)) {
            return boolTerm;
        }
        else {
            return null;
        }
    }

    public static BoolTerm multiply(BoolVar product1, BoolTerm product2) {
        return multiply(product2, product1);
    }

    public static BoolTerm multiply(BoolTerm product1, BoolVar product2) {
        if(product1.addProduct(product2)) {
            System.out.println("CHECK: " + product1);
            return product1;
        }
        else{
            return null;
        }
    }

    public static BoolEquation multiply(BoolVar product1, BoolEquation product2) {
        return multiply(product2, product1);
    }

    public static BoolEquation multiply(BoolEquation product1, BoolVar product2) {
        ArrayList<BoolTerm> terms = product1.getTerms();
        BoolEquation boolEquation = new BoolEquation();
        for(int i = 0; i < terms.size(); i++) {
            BoolTerm tempTerm = multiply(terms.get(i), product2);
            if(tempTerm != null) {
                boolEquation.addTerm(tempTerm);
            }
        }
        if(boolEquation.getTerms().size() > 0) {
            return boolEquation;
        }
        else {
            return null;
        }
    }

    public static BoolTerm multiply(BoolTerm product1, BoolTerm product2) {
        ArrayList<BoolVar> vars = product1.getProducts();
        for(int i = 0; i < vars.size(); i++) {
            product2 = multiply(product2, vars.get(i));
            if(product2 == null) {
                return null;
            }
        }
        return product2;
    }

    public static BoolEquation multiply(BoolTerm product1, BoolEquation product2) {
        return multiply(product2, product1);
    }

    public static BoolEquation multiply(BoolEquation product1, BoolTerm product2) {
        ArrayList<BoolTerm> terms = product1.getTerms();
        BoolEquation boolEquation = new BoolEquation();
        for(int i = 0; i < terms.size(); i++) {
            BoolTerm tempTerm = multiply(terms.get(i), product2);
            if(tempTerm != null) {
                boolEquation.addTerm(tempTerm);
            }
        }
        if(boolEquation.getTerms().size() > 0) {
            return  boolEquation;
        }
        else {
            return null;
        }
    }

    public static BoolEquation multiply(BoolEquation product1, BoolEquation product2) {
        ArrayList<BoolTerm> terms = product1.getTerms();
        BoolEquation boolEquation = new BoolEquation();
        for(int i = 0; i < terms.size(); i++) {
            BoolEquation tempEquation = multiply(terms.get(i), product2);
            if(tempEquation != null) {
                ArrayList<BoolTerm> tempTerms = tempEquation.getTerms();
                for(int j = 0; j < tempTerms.size(); j++) {
                    boolEquation.addTerm(tempTerms.get(j));
                }
            }
        }
        if(boolEquation.getTerms().size() > 0) {
            return boolEquation;
        }
        else {
            return null;
        }
    }

    public static BoolVar stringToVar(String varString) {
        BoolVar boolVar;
        if(varString.endsWith("'")) {
            boolVar = new BoolVar(varString.substring(0, varString.length() - 1), true);
        }
        else {
            boolVar = new BoolVar(varString);
        }

        return boolVar;
    }

    public static BoolTerm stringToTerm(String termString) {
        BoolTerm boolTerm = new BoolTerm();
        while(true) {
            if(boolTerm == null) {
                break;
            }
            else if(! termString.contains("*")) {
                BoolVar tempVar = stringToVar(termString);
                boolTerm = Bool.multiply(tempVar, boolTerm);
                break;
            }
            else {
                String varString = termString.substring(0, termString.indexOf("*"));
                boolTerm = Bool.multiply(boolTerm, stringToVar(varString));
                termString = termString.substring(termString.indexOf("*") + 1);
            }
        }

        return boolTerm;
    }
}
