import java.util.ArrayList;

public class BoolEquation {
    private ArrayList<BoolTerm> terms;

    public BoolEquation() {
        this.terms = new ArrayList<>();
    }

    public BoolEquation(BoolTerm term) {
        this.terms = new ArrayList<>();
        this.terms.add(term);
    }

    public BoolEquation(BoolVar var) {
        this.terms = new ArrayList<>();
        this.terms.add(new BoolTerm(var));
    }

    public ArrayList<BoolTerm> getTerms() {
        return this.terms;
    }

    public void addTerm(BoolTerm term) {
        boolean found = false;
        for(int i = 0; i < this.terms.size(); i++) {
            if(this.terms.get(i).equals(term)) {
                found = true;
            }
        }
        if(!found) {
            this.terms.add(term);
        }
    }

    public String toString() {
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

    public boolean equals(BoolEquation equation) {
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
