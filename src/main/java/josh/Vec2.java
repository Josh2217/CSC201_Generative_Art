package josh;

public class Vec2 {
    double x;
    double y;

    //constructors
    Vec2() {
        x = y = 0;
    }

    Vec2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Computes the dot product between this vector and an other vector.
     * 
     * @param other the other vector 
     * @return the dot product of <em>this</em> and <em>other</em>
     */
    double dotP(Vec2 other) {
        return x * other.x + y * other.y;
    }

    /**
     * Subtracts this vector and an other vector
     * 
     * @param other the other vector
     * @return the difference of <em>this</em> and <em>other</em>
     */
    Vec2 sub(Vec2 other) {
        return new Vec2(this.x - other.x, this.y - other.y);
    }
    
    /**
     * Adds this vector and an other vector
     * 
     * @param other the other vector
     * @return the sum of <em>this</em> and <em>other</em>
     */
    Vec2 add(Vec2 other) {
        return new Vec2(this.x + other.x, this.y + other.y);
    }

    /**
     * Returns the magnitued of the vector
     * 
     * @return magnitued of the vector
     */
    double mag() {
        return Math.sqrt(x * x + y * y);
    }

    /**
     * 
     * @return normalized version of this vector
     */
    Vec2 normalize() {
        return new Vec2(x / mag(), y / mag());
    }
}
