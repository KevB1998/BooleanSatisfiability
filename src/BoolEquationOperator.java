//A class to represent a grouping data object
public class BoolEquationOperator {
    public BoolEquation boolEquation;
    public String operation;
    public boolean opens;
    public BoolEquationOperator(String operation, BoolEquation boolEquation) { //O(1)
        this.boolEquation = boolEquation;
        this.operation = operation;
        this.opens = false;
    }
    public BoolEquationOperator(String operation, BoolEquation boolEquation, boolean opens) { //O(1)
        this.boolEquation = boolEquation;
        this.operation = operation;
        this.opens = opens;
    }

    public String toString() { //O(1)
        String boolEquationString;
        if(boolEquation == null) {
            boolEquationString = "null";
        } else {
            boolEquationString = boolEquation.toString();
        }
        return boolEquationString + " \"" + operation + "\" " + opens;
    }
}
