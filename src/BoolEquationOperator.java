public class BoolEquationOperator {
    public BoolEquation boolEquation;
    public String operation;
    public boolean opens;
    public BoolEquationOperator(String operation, BoolEquation boolEquation) {
        this.boolEquation = boolEquation;
        this.operation = operation;
        this.opens = false;
    }
    public BoolEquationOperator(String operation, BoolEquation boolEquation, boolean opens) {
        this.boolEquation = boolEquation;
        this.operation = operation;
        this.opens = opens;
    }

    public String toString() {
        String boolEquationString;
        if(boolEquation == null) {
            boolEquationString = "null";
        } else {
            boolEquationString = boolEquation.toString();
        }
        return boolEquationString + " \"" + operation + "\" " + opens;
    }
}
