package file;

import love.Student;
import java.util.Comparator;

public class SortStudentByGPA implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        if (student1.getScoreGPA() > student2.getScoreGPA()) {
            return 1;
        }
        return -1;
    }
}