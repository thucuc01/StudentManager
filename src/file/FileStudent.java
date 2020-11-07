package file;

import love.Student;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


public class FileStudent {

    private static final String STUDENT_FILE_NAME = "student.txt";


    public void write(List<Student> studentList) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(new File(STUDENT_FILE_NAME));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(studentList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(fos);
            closeStream(oos);
        }
    }


    public List<Student> read() {

        FileInputStream fis;
        try {
            fis = new FileInputStream(STUDENT_FILE_NAME);
            ObjectInputStream ois=new ObjectInputStream(fis);
            List<Student>list=(List<Student>) ois.readObject();
            if(list==null){
                list=new ArrayList<Student>();
            }
            return list;
        } catch (ClassNotFoundException | IOException e) {
            return null;
        }
    }


    private void closeStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void closeStream(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}