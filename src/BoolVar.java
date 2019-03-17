public class BoolVar {
    private String name;
    private boolean inverse;

    public BoolVar(String name) {
        this.name = name;
        this.inverse = false;
    }

    public BoolVar(String name, boolean inverse) {
        this.name = name;
        this.inverse = inverse;
    }

    public String getName() {
        return this.name;
    }

    public boolean getInverse() {
        return this.inverse;
    }

    public String toString() {
        String output = name;
        if(inverse) {
            output += "\'";
        }
        return output;
    }

    public boolean equals(BoolVar var) {
        boolean equal = (this.name == var.getName()) && (this.inverse == var.getInverse());
        return equal;
    }

    public boolean isInverse(BoolVar var) {
        boolean inv = (this.name == var.getName()) && (this.inverse != var.getInverse());
        return inv;
    }
}
