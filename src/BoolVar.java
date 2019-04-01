//A class to represent a boolean literal
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

    public String getName() { //O(1)
        return this.name;
    }

    public boolean getInverse() { //O(1)
        return this.inverse;
    }

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
