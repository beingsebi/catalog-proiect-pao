import models.Catalogue;
import models.Course;
import models.Student;
import models.Teacher;
import services.ManagerService;
import shared.Constants;
import shared.DbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) throws Exception{

        Connection connection = DbUtils.getConnection();
        String sql = "select * from courses";
        assert connection != null;
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            System.out.println(rs.getString(1));
        }

        exit(0);
        ManagerService managerService = new ManagerService();
        int it1 = managerService.insertTeacher("John", "Doe", LocalDate.now(), "123 Street", "john.doe@example", Constants.Gender.FEMALE, "123", 3, "Computer Science", "Java");
        Teacher t1 = managerService.getTeacherById(it1);

        int is1 = managerService.insertStudent("Jane", "Doe", LocalDate.now(), "123 Street", "jane.doe@example", Constants.Gender.MALE, "0987654321", 1);
        Student s1 = managerService.getStudentById(is1);

        int ic1 = managerService.insertCourse("Java Programming", "A course about Java programming");
        Course c1 = managerService.getCourseById(ic1);

        int ica1 = managerService.insertCatalogue("My Catalogue", "This is a catalogue for my school", 2, "A");

        managerService.assignTeacherAsSupervisorToCatalogue(t1, ica1);

        managerService.assignStudentToCatalogue(s1, ica1);

        managerService.insertCourseInstance(ica1, Constants.Days.FRIDAY, ic1, null, LocalTime.now(), 2);

        Catalogue cc = managerService.getCatalogueById(ica1);
        int is2=managerService.insertStudent("Jane", "Doe", LocalDate.now(), "123 Street", "jane.doe@example", Constants.Gender.MALE, "0987654321", 1);
        managerService.assignStudentToCatalogue(is2, ica1);
        System.out.println(cc);
    }
}
