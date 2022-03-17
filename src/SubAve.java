public class SubAve {
    private double suball;
    private double subave;

    public SubAve() {

    }

    public SubAve(double suball, double subave) {
        this.suball = suball;
        this.subave = subave;
    }

    public double getsuball() {
        return suball;
    }

    public double getsubave() {
        return subave;
    }

    public void setSuball(double suball) {
        this.suball = suball;
    }

    public void setSubave(double subave) {
        this.subave = subave;
    }

    public void clear() {
        this.suball = 0;
        this.subave = 0;
    }
}
