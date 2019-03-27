import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

@SuppressWarnings("Duplicates")
public class Bool {
    private static BoolTerm multiply(BoolVar product1, BoolVar product2){
        if((product1 == null || product1.toString().equals("")) && (product2 == null || product2.toString().equals(""))) {
            return null;
        } else if(product1 == null || product1.toString().equals("")) {
            return new BoolTerm(product2);
        } else if(product2 == null || product2.toString().equals("")) {
            return new BoolTerm(product1);
        }
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
        if((product1 == null || product1.toString().equals("")) && (product2 == null || product2.toString().equals(""))) {
            return null;
        } else if(product1 == null || product1.toString().equals("")) {
            return new BoolTerm(product2);
        } else if(product2 == null || product2.toString().equals("")) {
            return product1;
        }
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
        if((product1 == null || product1.toString().equals("")) && (product2 == null || product2.toString().equals(""))) {
            return null;
        } else if(product1 == null || product1.toString().equals("")) {
            return new BoolEquation(new BoolTerm(product2));
        } else if(product2 == null || product2.toString().equals("")) {
            return product1;
        }
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
        if((product1 == null || product1.toString().equals("")) && (product2 == null || product2.toString().equals(""))) {
            return null;
        } else if(product1 == null || product1.toString().equals("")) {
            return product2;
        } else if(product2 == null || product2.toString().equals("")) {
            return product1;
        }
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
        if((product1 == null || product1.toString().equals("")) && (product2 == null || product2.toString().equals(""))) {
            return null;
        } else if(product1 == null || product1.toString().equals("")) {
            return new BoolEquation(product2);
        } else if(product2 == null || product2.toString().equals("")) {
            return product1;
        }
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
        if((product1 == null || product1.toString().equals("")) && (product2 == null || product2.toString().equals(""))) {
            return null;
        } else if(product1 == null || product1.toString().equals("")) {
            return product2;
        } else if(product2 == null || product2.toString().equals("")) {
            return product1;
        }
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
        if((addend1 == null || addend1.toString().equals("")) && (addend2 == null || addend2.toString().equals(""))) {
            return null;
        } else if(addend1 == null || addend1.toString().equals("")) {
            return new BoolEquation(new BoolTerm(addend2));
        } else if(addend2 == null || addend2.toString().equals("")) {
            return new BoolEquation(new BoolTerm(addend1));
        }
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
        if((addend1 == null || addend1.toString().equals("")) && (addend2 == null || addend2.toString().equals(""))) {
            return null;
        } else if(addend1 == null || addend1.toString().equals("")) {
            return new BoolEquation(new BoolTerm(addend2));
        } else if(addend2 == null || addend2.toString().equals("")) {
            return new BoolEquation(addend1);
        }
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
        if((addend1 == null || addend1.toString().equals("")) && (addend2 == null || addend2.toString().equals(""))) {
            return null;
        } else if(addend1 == null || addend1.toString().equals("")) {
            return new BoolEquation(new BoolTerm(addend2));
        } else if(addend2 == null || addend2.toString().equals("")) {
            return addend1;
        }
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
        if((addend1 == null || addend1.toString().equals("")) && (addend2 == null || addend2.toString().equals(""))) {
            return null;
        } else if(addend1 == null || addend1.toString().equals("")) {
            return new BoolEquation(addend2);
        } else if(addend2 == null || addend2.toString().equals("")) {
            return new BoolEquation(addend1);
        }
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
        if((addend1 == null || addend1.toString().equals("")) && (addend2 == null || addend2.toString().equals(""))) {
            return null;
        } else if(addend1 == null || addend1.toString().equals("")) {
            return new BoolEquation(addend2);
        } else if(addend2 == null || addend2.toString().equals("")) {
            return addend1;
        }
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
        if((addend1 == null || addend1.toString().equals("")) && (addend2 == null || addend2.toString().equals(""))) {
            return null;
        } else if(addend1 == null || addend1.toString().equals("")) {
            return addend2;
        } else if(addend2 == null || addend2.toString().equals("")) {
            return addend1;
        }
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
        if(boolVar == null || boolVar.toString().equals("")) {
            return null;
        }
        return new BoolVar(boolVar.getName(), !boolVar.getInverse());
    }

    private static BoolEquation invert(BoolTerm boolTerm) {
        if(boolTerm == null || boolTerm.toString().equals("")) {
            return null;
        }
        BoolEquation boolEquation = new BoolEquation();

        for(int i = 0; i < boolTerm.getProducts().size(); i++) {
            boolEquation = add(boolEquation, invert(boolTerm.getProducts().get(i)));
        }

        return boolEquation;
    }

    private static BoolEquation invert(BoolEquation boolEquation) {
        if(boolEquation == null || boolEquation.toString().equals("")) {
            return null;
        }
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
        if(varString.equals("")) {
            return null;
        }

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
        BoolEquation boolEquation = null;

        Stack<BoolEquationOperator> equationStack= new Stack<>();

        BoolEquation tempEquation = null;
        String tempVarString = "";
        for(int i = 0; i < inputString.length(); i++) {
            if(inputString.charAt(i) == '*') {
                tempEquation = multiply(tempEquation, stringToVar(tempVarString));
                tempVarString = "";
            } else if(inputString.charAt(i) == '+' && equationStack.size() == 0){
                equationStack.push(new BoolEquationOperator("multiply", multiply(tempEquation, stringToVar(tempVarString))));
                tempEquation = null;
                tempVarString = "";
            } else if(inputString.charAt(i) == '+' && equationStack.peek().operation.equals("add")) {
                equationStack.peek().boolEquation = add(multiply(tempEquation, stringToVar(tempVarString)), equationStack.peek().boolEquation);
                tempEquation = null;
                tempVarString = "";
            } else if(inputString.charAt(i) == '+' && equationStack.peek().operation.equals("multiply")) {
                equationStack.push(new BoolEquationOperator("add", multiply(tempEquation, stringToVar(tempVarString))));
                tempEquation = null;
                tempVarString = "";
            } else if(inputString.charAt(i) == '(' && i == 0) {
                equationStack.push(new BoolEquationOperator("add", null));
                equationStack.push(new BoolEquationOperator("multiply", null, true));
            } else if(inputString.charAt(i) == '(' && inputString.charAt(i-1) == '+') {
                equationStack.push(new BoolEquationOperator("add", tempEquation, true));
                tempEquation = null;
            } else if(inputString.charAt(i) == '(' && inputString.charAt(i-1) == '*') {
                equationStack.push(new BoolEquationOperator("multiply", tempEquation, true));
                tempEquation = null;
            } else if(inputString.charAt(i) == ')' && equationStack.peek().operation.equals("add")) {
                tempEquation = multiply(tempEquation, stringToVar(tempVarString));
                tempEquation = add(equationStack.peek().boolEquation, tempEquation);
                if(!equationStack.pop().opens) {
                    tempEquation = multiply(equationStack.pop().boolEquation, tempEquation);
                }
                tempVarString = "";
            } else if(inputString.charAt(i) == ')' && equationStack.peek().operation.equals("multiply")) {
                tempEquation = multiply(equationStack.pop().boolEquation, multiply(tempEquation, stringToVar(tempVarString)));
                tempVarString = "";
            } else {
                tempVarString += inputString.charAt(i);
            }
        }
        tempEquation = multiply(tempEquation, stringToVar(tempVarString));
        if (equationStack.peek().operation.equals("add")) {
            equationStack.peek().boolEquation = add(equationStack.peek().boolEquation, tempEquation);
        } else {
            equationStack.peek().boolEquation = multiply(equationStack.peek().boolEquation, tempEquation);
        }

        if(equationStack.size() == 1) {
            boolEquation = equationStack.pop().boolEquation;
        } else {
            throw new RuntimeException("Invalid Input");
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