import java.util.ArrayList;

public class BoolTerm {
    public ArrayList<BoolVar> products;

    public BoolTerm() { //O(1)
        this.products = new ArrayList<>();
    }

    public BoolTerm(BoolVar var) { //O(1)
        this.products = new ArrayList<>();
        products.add(var);

    }

    public ArrayList<BoolVar> getProducts() {
        return this.products;
    } //O(1)

    public boolean addProduct(BoolVar product) { //O(n)
        boolean found = false;
        for(int i = 0; i < this.products.size(); i++) {
            if(this.products.get(i).equals(product)) {
                found = true;
            }
            else if (this.products.get(i).isInverse(product)) {
                return false;
            }
        }
        if(!found) {
            this.products.add(product);
        }
        return true;
    }

    public String toString() { //O(n)
        String output = "";
        if(this == null) {
            return output;
        }
        for(int i = 0; i < this.products.size(); i++) {
            if(i == this.products.size()-1) {
                output += this.products.get(i).toString();
            }
            else {
                output += this.products.get(i).toString() + "*";
            }
        }
        return output;
    }

    public boolean equals(BoolTerm term) { //O(n^2)
        for(int i = 0; i < this.products.size(); i++) {
            boolean found = false;
            for(int j = 0; j < term.getProducts().size(); j++) {
                if(this.products.get(i).equals(term.getProducts().get(j))) {
                    found = true;
                }
            }
            if(!found) return false;
        }
        return true;
    }

    public boolean contains(BoolVar boolVar) { //O(n)
        for(int i = 0; i < this.products.size(); i++) {
            if(this.products.get(i).equals(boolVar)) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(BoolTerm boolTerm) { //O(n^2)
        for(int i = 0; i < boolTerm.getProducts().size(); i++) {
            if(! contains(boolTerm.getProducts().get(i))) {
                return false;
            }
        }
        return true;
    }
}
