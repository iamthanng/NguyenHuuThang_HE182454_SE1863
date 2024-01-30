
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Manager {

    Validation v = new Validation();
    ArrayList<Student> list = new ArrayList<>();

    public void generateStudent() {
        list.add(new Student("HE170001", "NGUYEN VAN NGHIA", "1", "Java"));
        list.add(new Student("HE170002", "NGUYEN VAN AN", "2", "Java"));
        list.add(new Student("HE170003", "VU TIEN THINH", "2", "Java"));
        list.add(new Student("HE170523", "NGUYEN DUC MANH", "3", "Java"));
        list.add(new Student("HE170004", "NGUYEN CHI BAO", "3", "Java"));
        list.add(new Student("HE170005", "NGUYEN VAN YEN", "3", "Java"));
        list.add(new Student("HE170523", "NGUYEN DUC MANH", "8", "Java"));
        list.add(new Student("HE170004", "NGUYEN CHI BAO", "3", "C/C++"));
        list.add(new Student("HE170005", "NGUYEN VAN YEN", "3", "C/C++"));
    }

    //Create Student Method
    public void createStudent() {
        String id, course, semester, studentName = "";
        displayStudent(list);
        System.out.println("==========Create Student==============");
        //Nếu danh sách lớn hơn 10 sẽ hỏi muốn nhập nữa không
        while (true) {
            if (list.size() > 10) {
                //Nếu không sẽ quay về màn hình chính
                if (!v.checkInputYN("Do you want to continue (Y/N): ")) {
                    //in ra danh sách student có trong list
                    displayStudent(list);
                    return;
                }
            }
            //Nếu muốn nhập thì mời nhập sinh viên
            id = v.checkInputString("Enter ID(HExxxxxx): ", "^[A-Za-z]{2}[0-9]{6}+$");
            //Lấy thông tin ID trong list
            Student s = getStudentById(list, id);
            //Nếu có thông tin sẽ hỏi người dùng có muốn dùng tên của ID đó không
            while (s != null) {
                System.out.println("Student with id " + id + " existed");
                //Check xem người dùng có muốn dùng không
                if (!v.checkInputYN("Do you want to use this Student (Y/N): ")) {
                    //Nếu không sẽ mời nhập ID khác
                    id = v.checkInputString("Enter ID(HExxxxxx): ", "^[A-Za-z]{2}[0-9]{6}+$");
                    s = getStudentById(list, id);
                } else {
                    //Nếu dùng sẽ dùng name của ID đó
                    studentName = s.getStudentName();
                    break;
                }
            }
            //Nếu id không có thông tin tên sẽ mời nhập tên
            if (s == null) {
                studentName = v.checkInputString("Enter Name: ", "^[A-Za-z\\s]+$");
            }
            //Nhập thông tin còn lại
            semester = v.checkInputString("Enter Semester(0-9): ", "[0-9]");
            course = v.checkInputCourse("Enter course(Java, .NET, C/C++): ");
            //Check xem trong list đã có thông tin tương tự chưa
            if (!isDuplicate(list, id, studentName, semester, course)) {
                //Có sẽ in ra lỗi và nhập lại thông tin từ đầu
                System.err.println("Duplicated!! Records arealdy have in database");
            } else {
                //Chưa có sẽ add thêm vào list
                list.add(new Student(id, studentName, semester, course));
                System.out.println("Successfully create student");
            }
        }
    }
    //method in danh sách sinh viên

    public void displayStudent(ArrayList<Student> list) {
        System.out.println("==============Student List================");
        System.out.printf("%-20s%-20s%-15s%-15s\n", "ID", "studentName", "Semester", "Course");
        for (Student student : list) {
            student.displayAll();
        }
    }

    //method để sort Student ( ở đây là tên)
    public void sortListStudent(ArrayList<Student> list) {
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student t, Student t1) {
                return t.getStudentName().compareTo(t1.getStudentName());
            }
        });
    }

    //Tìm thông tin sinh viên theo tên và sort
    public void findAndSort() {
        //Nếu trống sẽ quay về màn hình chính yêu cầu nhập thông tin
        if (list.isEmpty()) {
            System.err.println("List is empty, must create student");
            return;
        }
        displayStudent(list);
        //Nhập tên sinh viên cần tìm
        String name;
        name = v.checkInputString("Enter the name to find: ", "^[A-Za-z\\s]+$");
        //Tạo một list mới để lưu thông tin những sinh viên tìm được theo tên
        ArrayList<Student> listStudentFindByName = new ArrayList<>();
        for (Student student : list) {
            //Nếu trong list có tên chứa tên sinh viên cần tìm sẽ add vào list mới tạo
            if (student.getStudentName().toUpperCase().contains(name.toUpperCase())) {
                listStudentFindByName.add(student);
            }
        }
        //Nếu trong danh sách có sinh viên thì in ra danh sách sinh viên sort theo tên
        if (!listStudentFindByName.isEmpty()) {
            System.out.println("--------List sorted by name----------");
            sortListStudent(listStudentFindByName);
            System.out.printf("%-20s%-15s%-15s\n", "StudentName", "Semester", "CourseName");
            for (Student student : listStudentFindByName) {
                student.displayFindAndSort();
            }
            //Không tìm thấy sinh viên có tên như vậy thì quay về màn hình chính
        } else {
            System.err.println("Not exist student");
        }
    }
    //In ra danh sách sinh viên tìm được với ID và gắn STT cho mỗi sinh viên

    public void displayStudentWithSearchID(ArrayList<Student> listStudentFindByID) {
        System.out.println("---------List student found by ID--------------");
        System.out.printf("%-10s%-20s%-15s%-15s\n", "STT", "studentName", "Semester", "Course");
        for (int i = 0; i < listStudentFindByID.size(); i++) 
        {
            
            System.out.printf("%-10s%-20s%-15s%-15s\n", i + 1, listStudentFindByID.get(i).getStudentName(),
                    listStudentFindByID.get(i).getSemester(), listStudentFindByID.get(i).getCourseName());
        }
    }

    //Method update hoặc delete sinh viên
    public void updateOrDeleteStudent() {
        String updateID, updateName, updateSemester, updateCourse, searchID;
        int searchIndex;
        displayStudent(list);
        //Nếu list trống quay về yêu cầu tạo sinh viên
        if (list.isEmpty()) {
            System.err.println("List is empty. Must create student ");
            return;
        }
        //Nhập ID sinh viên cần update hoặc delete
        searchID = v.checkInputString("Enter ID to update or delete: ", "^[A-Za-z]{2}[0-9]{6}+$");
        //Nếu trong list không có ID yêu cầu nhập lại
        while (!checkIDExist(list, searchID)) {
            System.err.println("Id not found, please enter again");
            searchID = v.checkInputString("Enter ID to update or delete: ", "^[A-Za-z]{2}[0-9]{6}+$");
        }
        //Tạo list mới để add sinh viên tìm được ID vào
        ArrayList<Student> listStudentFindByID = new ArrayList<>();
        for (Student student : list) {
            //Nếu ID cần tìm có trong database thì add vào list mới
            if (student.getId().equalsIgnoreCase(searchID)) {
                listStudentFindByID.add(student);
            }
        }
        //Nếu trong list tìm bởi ID có sẽ in ra những sinh viên có thể Update hoặc Delete
        if (listStudentFindByID.isEmpty()) {
            System.err.println("Not found student to update or delete");
        } else {
            displayStudentWithSearchID(listStudentFindByID);
        }
        //Choose to update or delete
        System.out.println("===== Update or Delete Student ======");
        if (v.checkInputUD("Do you want to update (U) or delete (D) student: ")) {
            //update student section
            System.out.println("=============Update================");
            searchIndex = v.getChoice("Enter number of student you want to update [1, " + listStudentFindByID.size() + "]: ", 1, listStudentFindByID.size());
            Student s = listStudentFindByID.get(searchIndex - 1);
            updateID = v.checkInputString("Enter ID to update: ", "^[A-Za-z0-9]+$");
            Student sUpdate = getStudentById(list, updateID);
            //Nếu ID có student sẽ dùng luôn tên của student đó để update
            if (sUpdate != null) {
                System.out.println("Student with id " + updateID + " existed");
                s.setStudentName(sUpdate.getStudentName());
                //Nếu ID chưa có thì sẽ tạo tên mới rồi update
            } else {
                updateName = v.checkInputString("Enter Name to update: ", "^[A-Za-z\\s]+$");
                s.setStudentName(updateName);
            }
            //Nhập semester và course
            updateSemester = v.checkInputString("Enter Semester(0-9): ", "[0-9]");
            updateCourse = v.checkInputCourse("Enter course(Java, .NET, C/C++): ");
            //Check xem trong list đã có thông tin như vậy chưa, nếu có rồi bắt nhập lại
            while (!isDuplicate(list, updateID, updateSemester, updateCourse)) {
                System.err.println("Duplicated!! Records arealdy have in database");
                updateSemester = v.checkInputString("Enter Semester(0-9): ", "[0-9]");
                updateCourse = v.checkInputCourse("Enter course(Java, .NET, C/C++): ");
            }
            //Nếu chưa có sẽ update
            s.setId(updateID);
            s.setSemester(updateSemester);
            s.setCourseName(updateCourse);
            System.out.println("Update successfully");
            //Delete student section
        } else {
            System.out.println("==============Delete=============");
            //Chọn sinh viên sẽ update khi chiếu ra list student tìm bởi ID
            searchIndex = v.getChoice("Enter number of student you want to delete [1, " + listStudentFindByID.size() + "]: ", 1, listStudentFindByID.size());
            //Lấy object vừa tìm được
            Student s = listStudentFindByID.get(searchIndex - 1);
            //Xoá object
            list.remove(s);
            System.out.println("Delete sucessfully");
        }
    }

    //display report method
    public void displayReport() {
        String name, course;
        int totalCourse;
        ArrayList<Student> searchList = new ArrayList<>();
        ArrayList<Report> reportList = new ArrayList<>();
        System.out.printf("%-20s%-15s%-15s\n", "studentName", "Course", "Total Course");
        //Một student array list tạm
        for (Student student : list) {
            searchList.add(student);
        }
        //So sánh 2 student list
        for (Student student : list) {
            totalCourse = 0;
            name = student.getStudentName();
            course = student.getCourseName();
            for (int i = 0; i < searchList.size(); i++) {
                //nếu tên và khóa học trùng thì tăng khóa học
                if (searchList.get(i).getStudentName().equalsIgnoreCase(name) && searchList.get(i).getCourseName().equalsIgnoreCase(course)) {
                    totalCourse++;
                    searchList.remove(i);
                    i--;
                }
            }
            //Sau khi chạy hết vòng lặp sẽ đếm được tổng course một môn mà sinh viên đăng ký
            //Add total course vừa đếm được vào report list
            reportList.add(new Report(name, course, totalCourse));
        }
        //Nếu report list có total course khác 0 in ra report
        for (Report report : reportList) {
            if (report.getTotalCourse() != 0) {
                report.displayReport();
            }
        }
    }

    //report
    public void report() {
        //nếu list trống sẽ thoát ra để nhập sinh viên
        if (list.isEmpty()) {
            System.err.println("List is empty, must create student");
            return;
        }
        //In ra report
        System.out.println("---------------Report---------------");
        displayReport();
    }

    //Check trong list có lặp lại record không
    public boolean isDuplicate(ArrayList<Student> list, String id, String studentName, String semester, String courseName) {
        for (Student student : list) {
            if (id.equalsIgnoreCase(student.getId())
                    && studentName.equalsIgnoreCase(student.getStudentName())
                    && semester.equalsIgnoreCase(student.getSemester())
                    && courseName.equalsIgnoreCase(student.getCourseName())) {
                return false;
            }
        }
        return true;
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

    //Check xem ID có tồn tại không
    public boolean checkIDExist(ArrayList<Student> list, String id) {
        for (Student student : list) {
            if (student.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    //Check xem sinh viên có bị lặp lại không dùng để update
    public boolean isDuplicate(ArrayList<Student> list, String updateID, String updateSemester, String updateCourse) {
        for (Student student : list) {
            if (updateID.equalsIgnoreCase(student.getId())
                    && updateSemester.equalsIgnoreCase(student.getSemester())
                    && updateCourse.equalsIgnoreCase(student.getCourseName())) {
                return false;
            }
        }
        return true;
    }

}
