public class BoolVar {
    private String name;
    private boolean inverse;

    public BoolVar(String name) { //O(1)
        this.name = name;
        this.inverse = false;
    }

    public BoolVar(String name, boolean inverse) { //O(1)
        this.name = name;
        this.inverse = inverse;
    }

    public String getName() {
        return this.name;
    } //O(1)

    public boolean getInverse() {
        return this.inverse;
    } //O(1)

    public String toString() { //O(1)
        String output = name;
        if(inverse) {
            output += "\'";
        }
        return output;
    }

    public boolean equals(BoolVar var) { //O(1)
        boolean equal = (this.name.equals(var.getName())) && (this.inverse == var.getInverse());
        return equal;
    }

    public boolean isInverse(BoolVar var) { //O(1)
        boolean inv = (this.name.equals(var.getName())) && (this.inverse != var.getInverse());
        return inv;
    }
}
