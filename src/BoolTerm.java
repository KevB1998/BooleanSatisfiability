import java.util.ArrayList;

public class BoolTerm {
    public ArrayList<BoolVar> products;

    public BoolTerm() {
        this.products = new ArrayList<>();
    }

    public BoolTerm(BoolVar var) {
        this.products = new ArrayList<>();
        products.add(var);

    }

    public ArrayList<BoolVar> getProducts() {
        return this.products;
    }

    public boolean addProduct(BoolVar product) {
        boolean found = false;
        for(int i = 0; i < this.products.size(); i++) {
            if(this.products.get(i).equals(product)) {
                found = true;
            }
            else if (this.products.get(i).isInverse(product)) {
                System.out.println("hi");
                return false;
            }
        }
        if(!found) {
            this.products.add(product);
        }
        return true;
    }

    public String toString() {
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

    public boolean equals(BoolTerm term) {
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
}
