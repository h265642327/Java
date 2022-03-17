
public class Add {

    private double [] subjectNumber;

    public Add(){

    }
    public Add(double[] subjectNumber) {
        this.subjectNumber = subjectNumber;
    }

    public double getSubjectNumber(int i) {
        return subjectNumber[i];
    }

    public void setSubjectNumber(double[] subjectNumber) {
        this.subjectNumber = subjectNumber;
    }
}


