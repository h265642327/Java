
public class Student {
    private String ID;
    private String name;
    private double[] score = new double[6];
    private double ave_stu;
    private double all_stu;


    public Student() {
    }

    public Student(double[] score) {
        this.score = score;
    }

    public Student(double avestu, double allstu) {
        this.ave_stu = avestu;
        this.all_stu = allstu;

    }

    public Student(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAvestu() {
        return ave_stu;
    }

    public void setAvestu(double avestu) {
        this.ave_stu = avestu;
    }


    public double getAllstu() {
        return all_stu;
    }

    public void setAllstu(double allstu) {
        this.all_stu = allstu;
    }

    public double getScore(int x) {
        return score[x];
    }

    public void setScore(double score, int x) {
        this.score[x] = score;
    }


}
