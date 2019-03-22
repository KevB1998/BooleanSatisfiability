import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

@SuppressWarnings("Duplicates")
public class Bool {
    private static BoolTerm multiply(BoolVar product1, BoolVar product2){
        BoolTerm boolTerm = new BoolTerm();
        boolTerm.addProduct(product1);
        if(boolTerm.addProduct(product2)) {
            return boolTerm;
        }
        else {
            return null;
        }
    }

    private static BoolTerm multiply(BoolVar product1, BoolTerm product2) {
        return multiply(product2, product1);
    }

    private static BoolTerm multiply(BoolTerm product1, BoolVar product2) {
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

    private static BoolEquation multiply(BoolVar product1, BoolEquation product2) {
        return multiply(product2, product1);
    }

    private static BoolEquation multiply(BoolEquation product1, BoolVar product2) {
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

    private static BoolTerm multiply(BoolTerm product1, BoolTerm product2) {
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

    private static BoolEquation multiply(BoolTerm product1, BoolEquation product2) {
        return multiply(product2, product1);
    }

    private static BoolEquation multiply(BoolEquation product1, BoolTerm product2) {
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

    private static BoolEquation multiply(BoolEquation product1, BoolEquation product2) {
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

    private static BoolEquation add(BoolVar addend1, BoolVar addend2) {
        BoolEquation boolEquation = new BoolEquation();

        BoolTerm term1 = new BoolTerm(addend1);
        BoolTerm term2 = new BoolTerm(addend2);
        boolEquation.addTerm(term1);
        boolEquation.addTerm(term2);

        return boolEquation;
    }

    private static BoolEquation add(BoolVar addend1, BoolTerm addend2) {
        return add(addend2, addend1);
    }

    private static BoolEquation add(BoolTerm addend1, BoolVar addend2) {
        BoolEquation boolEquation = new BoolEquation();

        if(null != addend1) {
            boolEquation.addTerm(addend1);
        }

        BoolTerm boolTerm = new BoolTerm(addend2);
        boolEquation.addTerm(boolTerm);

        return boolEquation;
    }

    private static BoolEquation add(BoolVar addend1, BoolEquation addend2) {
        return add(addend2, addend1);
    }

    private static BoolEquation add(BoolEquation addend1, BoolVar addend2) {
        BoolEquation boolEquation = new BoolEquation();

        if(null != addend1) {
            for (int i = 0; i < addend1.getTerms().size(); i++) {
                boolEquation.addTerm(addend1.getTerms().get(i));
            }
        }

        BoolTerm boolTerm = new BoolTerm(addend2);
        boolEquation.addTerm(boolTerm);

        return boolEquation;
    }

    private static BoolEquation add(BoolTerm addend1, BoolTerm addend2) {
        BoolEquation boolEquation = new BoolEquation();

        if(null != addend1) {
            boolEquation.addTerm(addend1);
        }
        if(null != addend2) {
            boolEquation.addTerm(addend2);
        }

        if(boolEquation.getTerms().size() == 0) {
            return null;
        }

        return boolEquation;
    }

    private static BoolEquation add(BoolTerm addend1,  BoolEquation addend2) {
        return add(addend2, addend1);
    }

    private static BoolEquation add(BoolEquation addend1, BoolTerm addend2) {
        BoolEquation boolEquation = new BoolEquation();

        if(null != addend1) {
            for(int i = 0; i < addend1.getTerms().size(); i++) {
                boolEquation.addTerm(addend1.getTerms().get(i));
            }
        }

        if(null != addend2) {
            boolEquation.addTerm(addend2);
        }

        if(boolEquation.getTerms().size() == 0) {
            return null;
        }

        return boolEquation;
    }

    private static BoolEquation add(BoolEquation addend1, BoolEquation addend2) {
        BoolEquation boolEquation = new BoolEquation();

        if(null != addend1) {
            for (int i = 0; i < addend1.getTerms().size(); i++) {
                boolEquation.addTerm(addend1.getTerms().get(i));
            }
        }

        if(null != addend2) {
            for (int i = 0; i < addend2.getTerms().size(); i++) {
                boolEquation.addTerm(addend2.getTerms().get(i));
            }
        }

        if(boolEquation.getTerms().size() == 0) {
            return null;
        }

        return boolEquation;
    }

    private static BoolVar invert(BoolVar boolVar) {
        return new BoolVar(boolVar.getName(), !boolVar.getInverse());
    }

    private static BoolEquation invert(BoolTerm boolTerm) {
        BoolEquation boolEquation = new BoolEquation();

        for(int i = 0; i < boolTerm.getProducts().size(); i++) {
            boolEquation = add(boolEquation, invert(boolTerm.getProducts().get(i)));
        }

        return boolEquation;
    }

    private static BoolEquation invert(BoolEquation boolEquation) {
        BoolEquation outputEquation = new BoolEquation();

        for(int i = 0; i < boolEquation.getTerms().size(); i++) {
            if(i == 0) {
                outputEquation = invert(boolEquation.getTerms().get(0));
            } else {
                outputEquation = multiply(outputEquation, invert(boolEquation.getTerms().get(i)));
            }
        }

        return outputEquation;
    }

    private static BoolVar stringToVar(String varString) {
        BoolVar boolVar;
        if(varString.endsWith("'")) {
            boolVar = new BoolVar(varString.substring(0, varString.length() - 1), true);
        }
        else {
            boolVar = new BoolVar(varString);
        }

        return boolVar;
    }

    private static BoolTerm stringToTerm(String termString) {
        BoolTerm boolTerm = new BoolTerm();

        while(true) {
            if(boolTerm == null) {
                return null;
            }
            else if(! termString.contains("*")) {
                BoolVar tempVar = stringToVar(termString);
                boolTerm = multiply(tempVar, boolTerm);
                return boolTerm;
            }
            else {
                String varString = termString.substring(0, termString.indexOf("*"));
                boolTerm = multiply(boolTerm, stringToVar(varString));
                termString = termString.substring(termString.indexOf("*") + 1);
            }
        }
    }

    private static BoolEquation stringToEquation(String equationString) {
        BoolEquation boolEquation = new BoolEquation();

        while(true) {
            if(! equationString.contains("+")) {
                BoolTerm boolTerm = stringToTerm(equationString);
                boolEquation = add(boolEquation, boolTerm);
                return boolEquation;
            }
            else {
                String termString = equationString.substring(0, equationString.indexOf("+"));
                boolEquation = add(boolEquation, stringToTerm(termString));
                equationString = equationString.substring(equationString.indexOf("+") + 1);
            }
        }
    }

    public static BoolEquation stringToSOP(String inputString) {
        if(! inputString.contains("(")) {
            return stringToEquation(inputString);
        }
        BoolEquation boolEquation = new BoolEquation();

        while(inputString.length() > 0) {
            if ((inputString.contains("(") && inputString.contains("+")) && (inputString.indexOf('+') < inputString.indexOf('('))) {
                boolEquation = add(boolEquation, stringToTerm(inputString.substring(0, inputString.indexOf('+'))));
                inputString = inputString.substring(inputString.indexOf('+') + 1);
            } else if ((inputString.contains("(") && inputString.contains("+")) && (inputString.indexOf('+') > inputString.indexOf('('))) {
                int opens = 1;
                int i;
                for(i = 1; opens > 0; i++) {
                    if(inputString.charAt(i) == '(') {
                        opens++;
                    } else if(inputString.charAt(i) == ')') {
                        opens--;
                    }
                }
                String tempString = inputString.substring(0, i+1);
                BoolEquation tempEquation = new BoolEquation();
                while(tempString.length() > 0) {
                    if((tempString.contains("(") && tempString.contains("+")) && (tempString.indexOf('*') < tempString.indexOf('('))) {
                        tempEquation = multiply(tempEquation, stringToVar(tempString.substring(0, tempString.indexOf('*'))));
                        tempString = tempString.substring(tempString.indexOf('*') + 1);
                    } else if((tempString.contains("(") && tempString.contains("+")) && (tempString.indexOf('*') < tempString.indexOf('('))) {
                        opens = 1;
                        for(i = 0; opens > 0; i++) {
                            if(tempString.charAt(i) == '(') {
                                opens++;
                            } else if(tempString.charAt(i) == ')') {
                                opens--;
                            }
                        }
                        if(tempString.length() == i+1 || tempString.charAt(i+1) != '\'') {
                            tempEquation = multiply(tempEquation, stringToSOP(tempString.substring(1,i)));
                            tempString = tempString.substring(i+1);
                        } else {
                            tempEquation = multiply(tempEquation, invert(stringToSOP(tempString.substring(1, i))));
                            tempString = tempString.substring(i+2);
                        }
                    } else if(tempString.contains("*")) {
                        tempEquation = multiply(tempEquation, stringToTerm(tempString));
                        break;
                    } else if(tempString.contains("(")) {
                        opens = 1;
                        for(i = 1; opens > 0; i++) {
                            if(tempString.charAt(i) == '(') {
                                opens++;
                            } else if(tempString.charAt(i) == ')') {
                                opens--;
                            }
                        }
                        if(tempString.length() == i+1 || tempString.charAt(i+1) != '\'') {
                            tempEquation = multiply(tempEquation, stringToSOP(tempString.substring(1,i)));
                        } else {
                            tempEquation = multiply(tempEquation, invert(stringToSOP(tempString.substring(1, i))));
                        }
                        break;
                    } else {
                        tempEquation = multiply(tempEquation, stringToVar(tempString));
                        break;
                    }
                }
                boolEquation = add(boolEquation, tempEquation);
                inputString = inputString.substring(inputString.indexOf('+') + 1);
            } else if (inputString.contains("+")) {
                boolEquation = add(boolEquation, stringToEquation(inputString));
                break;
            } else if (inputString.contains("(")) {
                int opens = 1;
                int i;
                for(i = 0; opens > 0; i++) {
                    if(inputString.charAt(i) == '(') {
                        opens++;
                    } else if(inputString.charAt(i) == ')') {
                        opens--;
                    }
                }
                if(inputString.length() == i+1 || inputString.charAt(i+1) != '\'') {
                    boolEquation = add(boolEquation, stringToSOP(inputString.substring(1,i)));
                    break;
                } else {
                    boolEquation = add(boolEquation, invert(stringToSOP(inputString.substring(1, i))));
                    break;
                }
            } else {
                boolEquation = add(boolEquation, stringToTerm(inputString));
                break;
            }
        }

        return boolEquation;
    }

    public static String satisfy(String inputString) {
        return satisfy(stringToSOP(inputString));
    }

    private static String satisfy(BoolEquation boolEquation) {
        if(null == boolEquation || boolEquation.getTerms().size() == 0) {
            return "Equation not satisfiable...";
        }
        else {
            String outputString = "Equation is satisfiable...";
            for(int i = 0; i < boolEquation.getTerms().size(); i++) {
                outputString += "\n" + satisfy(boolEquation.getTerms().get(i));
            }
            return outputString;
        }
    }

    private static String satisfy(BoolTerm boolTerm) {
        String outputString = "";

        for(int i = 0; i < boolTerm.getProducts().size(); i++) {
            if(i ==0) {
                outputString += satisfy(boolTerm.getProducts().get(i));
            } else {
                outputString += "," + satisfy(boolTerm.getProducts().get(i));
            }
        }

        return outputString;
    }

    private static String satisfy(BoolVar boolVar) {
        String outputString = boolVar.getName() + " = ";

        if(boolVar.getInverse()) {
            outputString += 0;
        } else {
            outputString += 1;
        }

        return  outputString;
    }


}