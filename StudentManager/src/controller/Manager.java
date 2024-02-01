/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Collections;
import model.Student;
import util.Validation;

/**
 *
 * @author ADMIN
 */
public class Manager {

    Validation validation = new Validation();

    public void createStudent(ArrayList<Student> listS) {
        String id, studentName = "", courseName;
        int semester;
        while (true) {
            if (listS.size() >= 10) {
                if (!validation.checkInputYN("Do you want to continue?")) {
                    displayStudent(listS);
                    return;
                }
            }
            id = validation.checkInputString("Enter ID: ", "^[A-Za-z]{2}[0-9]{6}+$");
            // Lay ID trong danh sasch
            Student student = getStudentById(listS, id);
            // Neu da co thong tin thi hoi xem co su dung khong?
            while (student != null) {
                System.out.println("Student with id " + id + " existed");
                // Kiem tra nguoi dung co muon su dung khong
                if (!validation.checkInputYN("Do you want use this student?")) {
                    id = validation.checkInputString("Enter ID: ", "^[A-Za-z]{2}[0-9]{6}+$");
                    student = getStudentById(listS, id);
                } else {
                    // Neu dung se su dung ten cua ID do
                    studentName = student.getStudentName();
                    break;
                }
            }
            //Neu chua ton tai thi nhap tiep 
            if (student == null) {
                studentName = validation.checkInputString("Enter name: ", "^[A-Za-z\\s]+$");
            }
            //Nhap tiep thong tin con lai
            courseName = validation.checkInputCourse("Enter course: ");
            semester = validation.getChoice("Enter semester: ", 1, 9);
            // Kiem tra xem co thong tin tuong tu chua
            if (!isDuplicate(listS, id, studentName, courseName, semester)) {
                //Co se in ra loi va nhap lai
                System.err.println("Duplicated!! Records arealdy have in database");
            } else {
                //Chua co se add vao listS
                listS.add(new Student(id, studentName, courseName, semester));
                System.out.println("Succesfully create student");
            }
        }
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
        String idUpdate, nameUpdate = null, courseUpdate;
        int semesterUpdate;
        if (listS.isEmpty()) {
            System.err.println("List emtpy! Must create student");
            return;
        }
        String idSearch = validation.checkInputString("Enter ID to update or delete: ", "^[A-Za-z0-9\\s]+$");
        ArrayList<Student> listById = listById(listS, idSearch);
        //Kiem tra co ton tai ID khong
        if (listById.isEmpty()) {
            System.err.println("Not exist");
        } else {
            //Neu co hien thi danh sach
            displayStudent(listById);
            if (validation.checkInputUD("Do you want Update or Delete? ")) {
                // Update section
                System.out.println("======== UPDATING ========");
                //Chon student muon update
                searchIndex = validation.getChoice("Enter number of student you want to update [1-" + listById.size() + "]: ", 1, listById.size());
                Student sUpdate = listById.get(searchIndex - 1);
                idUpdate = validation.checkInputString("Enter ID to update: ", "^[A-Za-z]{2}[0-9]{6}+$");
                //Kiem tra da co ID chua
                Student student = getStudentById(listS, idUpdate);
                //ID ton tai dung lai ten
                if (student != null) {
                    System.out.println("Student with id " + idUpdate + " existed");
                    student.setStudentName(sUpdate.getStudentName());
                } else {
                    //ID chua ton tai
                    nameUpdate = validation.checkInputString("Enter name to update: ", "^[A-Za-z\\s]+$");
                    student.setStudentName(nameUpdate);
                }
                courseUpdate = validation.checkInputCourse("Enter course to update: ");
                semesterUpdate = validation.getChoice("Enter semester to update: ", 1, 9);
                while (!isDuplicate(listS, idUpdate, nameUpdate, courseUpdate, semesterUpdate)) {
                    System.err.println("Duplicated!! Records arealdy have in database");
                    semesterUpdate = validation.getChoice("Enter semester: ", 1, 9);
                    courseUpdate = validation.checkInputCourse("Enter course: ");
                }
                student.setId(idUpdate);
                student.setCourseName(courseUpdate);
                student.setSemester(semesterUpdate);
                System.out.println("Update successfully");
// Delete section
            } else {
                System.out.println("======== DELETING ========");
                searchIndex = validation.getChoice("Enter number of student you want to delete [1-" + listById.size() + "]: ", 1, listById.size());
                Student sDelete = listById.get(searchIndex - 1);
                listS.remove(sDelete);
                System.out.println("Delete sucessfully");
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
        Collections.sort(listS, (Student t, Student t1) -> t.getStudentName().compareTo(t1.getStudentName()));
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
    public Student getStudentById(ArrayList<Student> listS, String id) {
        for (Student student : listS) {
            if (student.getId().equalsIgnoreCase(id)) {
                return student;
            }
        }
        return null;
    }

    //Check trung lap
    public boolean isDuplicate(ArrayList<Student> listS, String newID, String newName, String newCourse, int newSemester) {
        boolean flag = false;
        for (Student student : listS) {
            if (newID.equalsIgnoreCase(student.getId())
                    && newCourse.equalsIgnoreCase(student.getCourseName())
                    && newSemester == student.getSemester()) {
                return flag;
            }
        }
        flag = true;
        return flag;
    }
}
