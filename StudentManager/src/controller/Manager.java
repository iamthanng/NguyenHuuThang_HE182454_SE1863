/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import model.Student;
import util.Validation;

/**
 *
 * @author ADMIN
 */
public class Manager {

    Validation validation = new Validation();

    public void createStudent(ArrayList<Student> listS) {
        String id = validation.checkInputString("Enter ID: ", "^[A-Za-z]{2}[0-9]{6}+$");
        String studentName = validation.checkInputString("Enter name: ", "^[A-Za-z\\s]+$");
        String courseName = validation.checkInputCourse("Enter course: ");
        int semester = validation.getChoice("Enter semester: ", 1, 9);
        listS.add(new Student(id, studentName, courseName, semester));
    }

    public void findAndSort(ArrayList<Student> listS) {
        if (listS.isEmpty()) {
            System.err.println("List emtpy! Must create student");
        } else {
            String nameSearch = validation.checkInputString("Enter name to search: ", "^[A-Za-z\\s]+$");
            ArrayList<Student> listByName = listByName(listS, nameSearch);
            if (listByName.isEmpty()) {
                System.err.println("Not exist");
            } else {
                System.out.println("======LIST SORTED BY NAME======");
                sortListStudent(listByName);
                displayStudent(listByName);
            }
        }
    }

    public void updateAndDelete(ArrayList<Student> listS) {
        int searchIndex;
        String idUpdate, nameUpdate, courseUpdate;
        int semesterUpdate;
        if (listS.isEmpty()) {
            System.err.println("List emtpy! Must create student");
            return;
        }
        String idSearch = validation.checkInputString("Enter ID to update or delete: ", "^[A-Za-z0-9\\s]+$");
        ArrayList<Student> listById = listById(listS, idSearch);

        if (listById.isEmpty()) {
            System.err.println("Not exist");
        } else {
            displayStudent(listById);
            if (validation.checkInputUD("Do you want Update or Delete?")) {
                // Update section
                System.out.println("======== UPDATING ========");
                searchIndex = validation.getChoice("Enter number of student you want to update [1-" + listById.size() + "]: ", 1, listById.size());
                Student sUpdate = listById.get(searchIndex - 1);
                idUpdate = validation.checkInputString("Enter ID to update", "^[A-Za-z]{2}[0-9]{6}+$");
                //ID chua ton tai 
//                if () {
////                    nameUpdate = validation.checkInputString("Enter name to update", "^[A-Za-z\\s]+$");
//                    courseUpdate = validation.checkInputCourse("Enter course to update: ");
//                    semesterUpdate = validation.getChoice("Enter semester to update: ", 1, 9);
//                } else {
//                    //ID ton tai
//                }
//// Delete section
//            } else {
//                System.out.println("======== DELETING ========");
//                searchIndex = validation.getChoice("Enter number of student you want to update [1-" + listById.size() + "]: ", 1, listById.size());
//                Student sDelete = listById.get(searchIndex - 1);
//                listS.remove(sDelete);
//                System.out.println("Delete sucessfully");

            }
        }

    }
    
    //Hiển thị danh sách sinh viên
    public void displayStudent(ArrayList<Student> listS) {
        for (Student s : listS) {
            System.out.println("ID: " + s.getId() + " - Name: " + s.getStudentName() + " - Course: " + s.getCourseName() + " - Semester: " + s.getSemester());
//            System.out.printf("%-20s%-20s%-15s%-15s\n", s.getId(), s.getStudentName(), s.getCourseName(), s.getSemester());
        }
    }

    //Sắp xếp sinh viên (byName)
    public void sortListStudent(ArrayList<Student> listS) {
        Collections.sort(listS, new Comparator<Student>() {
            @Override
            public int compare(Student t, Student t1) {
                return t.getStudentName().compareTo(t1.getStudentName());
            }
        });
    }

    //Tìm kiếm theo tên
    public ArrayList<Student> listByName(ArrayList<Student> listS, String nameSearch) {
        ArrayList<Student> listFound = new ArrayList<>();
//        String name = validation.checkInputString("Enter name to search: ", "^[A-Za-z\\s]+$");
        for (Student studentFound : listS) {
            if (studentFound.getStudentName().contains(nameSearch)) {
                listFound.add(studentFound);
            }
        }
        return listFound;
    }

    //Tìm kiếm theo ID
    public ArrayList<Student> listById(ArrayList<Student> listS, String idSearch) {
        ArrayList<Student> listFound = new ArrayList<>();
//        String id = UserInput.getString();
        for (Student studentFound : listS) {
            if (studentFound.getId().contains(idSearch)) {
                listFound.add(studentFound);
            }
        }
        return listFound;
    }

    //Lấy thông tin sinh viên nếu có id
    public Student getStudentById(ArrayList<Student> list, String id) {
        for (Student student : list) {
            if (student.getId().equalsIgnoreCase(id)) {
                return student;
            }
        }
        return null;
    }
}
