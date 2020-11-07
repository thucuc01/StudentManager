package love;


import java.io.Serializable;

public class Student extends Person implements Serializable {
    private float scoreMath=0;
    private float scoreLiter=0;
    private float scoreGPA=0;

    public Student () {
    }


    public Student(int id, String name, byte age, String address, float scoreMath, float scoreLiter, float scoreGPA) {
        this.id=id;
        this.name=name;
        this.age=age;
        this.address=address;
        this.scoreMath = scoreMath;
        this.scoreLiter = scoreLiter;
        this. scoreGPA = scoreGPA;
    }

    public float getScoreMath() {
        return scoreMath;
    }

    public void setScoreMath(float scoreMath) {
        this.scoreMath = scoreMath;
    }

    public float getScoreLiter() {
        return scoreLiter;
    }

    public void setScoreLiter(float scoreLiter) {
        this.scoreLiter = scoreLiter;
    }

    public float getScoreGPA() {
        return scoreGPA;
    }

    public void setScoreGPA(float scoreGPA) {
        this.scoreGPA = scoreGPA;
    }
}
