import java.util.ArrayList;

//THESE TIME'S ARE WRONG... terms.size() is not necessarily < n

//A class to represent an ORed group of BoolTerms
public class BoolEquation {
    private ArrayList<BoolTerm> terms;

    public BoolEquation() { //O(1)
        this.terms = new ArrayList<>();
    }

    public BoolEquation(BoolTerm term) { //O(1)
        this.terms = new ArrayList<>();
        this.terms.add(term);
    }

    public BoolEquation(BoolVar var) { //O(1)
        this.terms = new ArrayList<>();
        this.terms.add(new BoolTerm(var));
    }

    public ArrayList<BoolTerm> getTerms() { //O(1)
        return this.terms;
    }

    public void addTerm(BoolTerm boolTerm) { //O(n^3)
        for(int i = 0; i < this.terms.size(); i++) {
            if(this.terms.get(i).contains(boolTerm)) {
                this.terms.remove(i);
                i--;
            }
            else if(boolTerm.contains(this.terms.get(i))) {
                return;
            }
        }
        this.terms.add(boolTerm);
    }

    public String toString() { //O(n^2)
        String output = "";
        for(int i = 0; i < this.terms.size(); i++) {
            if(i == this.terms.size()-1) {
                output += this.terms.get(i).toString();
            }
            else {
                output += this.terms.get(i).toString() + "+";
            }
        }
        return output;
    }

    public boolean equals(BoolEquation equation) { //O(n^4)
        for(int i = 0; i < this.terms.size(); i++) {
            boolean found = false;
            for(int j = 0; j < equation.getTerms().size(); j++) {
                if(this.terms.get(i).equals(equation.getTerms().get(j))) {
                    found = true;
                }
            }
            if(!found) return false;
        }
        return true;
    }
}
