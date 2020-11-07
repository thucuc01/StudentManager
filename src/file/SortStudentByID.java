package file;

import love.Student;

import java.util.Comparator;

public class SortStudentByID implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        if (student1.getId() > student2.getId()) {
            return 1;
        }
        return -1;
    }
}
