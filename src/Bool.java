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
        BoolTerm boolTerm = new BoolTerm();
        for(int i = 0; i < product1.getProducts().size(); i++) {
            boolTerm.addProduct(product1.getProducts().get(i));
        }
        if(boolTerm.addProduct(product2)) {
            return boolTerm;
        }
        else{
            return null;
        }
    }

    public static BoolEquation multiply(BoolVar product1, BoolEquation product2) {
        return multiply(product2, product1);
    }

    public static BoolEquation multiply(BoolEquation product1, BoolVar product2) {
        BoolEquation boolEquation = new BoolEquation();
        ArrayList<BoolTerm> terms = product1.getTerms();
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
        BoolTerm boolTerm = new BoolTerm();
        for(int i = 0; i < product2.getProducts().size(); i++) {
            boolTerm.addProduct(product2.getProducts().get(i));
        }
        ArrayList<BoolVar> vars = product1.getProducts();
        for(int i = 0; i < vars.size(); i++) {
            boolTerm = multiply(boolTerm, vars.get(i));
            if(boolTerm == null) {
                return null;
            }
        }
        return boolTerm;
    }

    public static BoolEquation multiply(BoolTerm product1, BoolEquation product2) {
        return multiply(product2, product1);
    }

    public static BoolEquation multiply(BoolEquation product1, BoolTerm product2) {
        BoolEquation boolEquation = new BoolEquation();
        ArrayList<BoolTerm> terms = product1.getTerms();
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
        BoolEquation boolEquation = new BoolEquation();
        ArrayList<BoolTerm> terms = product1.getTerms();
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

    public static BoolEquation add(BoolVar addend1, BoolVar addend2) {
        BoolEquation boolEquation = new BoolEquation();

        BoolTerm term1 = new BoolTerm(addend1);
        BoolTerm term2 = new BoolTerm(addend2);
        boolEquation.addTerm(term1);
        boolEquation.addTerm(term2);

        return boolEquation;
    }

    public static BoolEquation add(BoolVar addend1, BoolTerm addend2) {
        return add(addend2, addend1);
    }

    public static BoolEquation add(BoolTerm addend1, BoolVar addend2) {
        BoolEquation boolEquation = new BoolEquation();

        BoolTerm boolTerm = new BoolTerm(addend2);
        boolEquation.addTerm(addend1);
        boolEquation.addTerm(boolTerm);

        return boolEquation;
    }

    public static BoolEquation add(BoolVar addend1, BoolEquation addend2) {
        return add(addend2, addend1);
    }

    public static BoolEquation add(BoolEquation addend1, BoolVar addend2) {
        BoolEquation boolEquation = addend1;

        BoolTerm boolTerm = new BoolTerm(addend2);
        boolEquation.addTerm(boolTerm);

        return boolEquation;
    }

    public static BoolEquation add(BoolTerm addend1, BoolTerm addend2) {
        BoolEquation boolEquation = new BoolEquation();

        boolEquation.addTerm(addend1);
        boolEquation.addTerm(addend2);

        return boolEquation;
    }

    public static BoolEquation add(BoolTerm addend1,  BoolEquation addend2) {
        return add(addend2, addend1);
    }

    public static BoolEquation add(BoolEquation addend1, BoolTerm addend2) {
        BoolEquation boolEquation = addend1;

        boolEquation.addTerm(addend2);

        return boolEquation;
    }

    public static BoolEquation add(BoolEquation addend1, BoolEquation addend2) {
        BoolEquation boolEquation = addend1;

        ArrayList<BoolTerm> terms = addend2.getTerms();
        for(int i = 0; i < terms.size(); i++) {
            boolEquation = Bool.add(boolEquation, terms.get(i));
        }

        return boolEquation;
    }

    public static BoolVar stringToVar(String varString) {
        BoolVar boolVar;
        if(varString.endsWith("'")) {
            boolVar = new BoolVar(varString.substring(0, varString.length() - 1), true);
        }
        else {
            boolVar = new BoolVar(varString);
        }

        System.out.println(boolVar.details());
        return boolVar;
    }

    public static BoolTerm stringToTerm(String termString) {
        BoolTerm boolTerm = new BoolTerm();
        while(true) {
            if(boolTerm == null) {
                return null;
            }
            else if(! termString.contains("*")) {
                BoolVar tempVar = stringToVar(termString);
                boolTerm = Bool.multiply(tempVar, boolTerm);
                return boolTerm;
            }
            else {
                String varString = termString.substring(0, termString.indexOf("*"));
                boolTerm = Bool.multiply(boolTerm, stringToVar(varString));
                termString = termString.substring(termString.indexOf("*") + 1);
            }
        }
    }
}