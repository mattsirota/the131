package main.java.Backend;

import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;
import java.time.LocalDateTime;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class ChangeEnrollment {
   enum Semester {
       WINTER, SPRING, SUMMER_ONE, SUMMER_TWO, FALL
   }

    private int id;

    private String lastName;
    private String firstName;
    private String middleName;
    private String studentId;
    private String streetAddr;
    private String cityAddr;
    private String stateAddr;
    private String zipCodeAddr;
    private boolean isUndergrad;
    private int graduatingYear;
    private Semester semester;
    private int year;
    private String studentSignature;
    private String signatureDate;

    // course object. make list of that instead
    ArrayList<Course> addCourses = new ArrayList<>();
    ArrayList<Course> dropCourses = new ArrayList<>();

    // define exceptions and throw for form failing
    // if form is bad just say what field is bad if possible
    // generic exception for a form
    public ChangeEnrollment(JSONObject json)
    {
        lastName = (String) json.get("lastName");
        firstName = (String) json.get("firstName");
        middleName = (String) json.get("middleName");
        studentId = (String) json.get("studentId");
        streetAddr = (String) json.get("streetAddr");
        cityAddr = (String) json.get("cityAddr");
        stateAddr = (String) json.get("stateAddr");
        zipCodeAddr = (String) json.get("zipCodeAddr");
        isUndergrad = (boolean) json.get("isUndergrad");
        graduatingYear = ((Long) json.get("graduatingYear")).intValue();

        semester = Semester.valueOf((String)json.get("semester"));
        year = ((Long) json.get("year")).intValue();

        JSONArray addJSONCourses = (JSONArray) json.get("addCourse");
        JSONArray dropJSONCourses = (JSONArray) json.get("dropCourse");

        for(int i=0; i<addJSONCourses.size(); i++) {
            JSONObject curCourse = (JSONObject)addJSONCourses.get(i);
            addCourses.add(parseCourse(curCourse));
        }

        for(int i=0; i<dropJSONCourses.size(); i++)
        {
            JSONObject curCourse = (JSONObject)dropJSONCourses.get(i);
            dropCourses.add(parseCourse(curCourse));
        }
    }

    /*public void signForm(){
        __signatureDate = new SimpleDateFormat("MM/dd/yyyy").format(new Date());

    }*/

    public Course parseCourse(JSONObject course) {
        String subject, number, section;
        int credits;

        subject = (String)course.get("subject");
        number = (String)course.get("number");
        section = (String)course.get("section");
        credits = ((Long)course.get("credits")).intValue();

        return new Course(subject,number,section,credits);
    }

    public String toString() {
        StringBuilder b = new StringBuilder(1024);
        b.append(lastName).append(", ").append(firstName).append(' ').append(middleName).append('\n');
        b.append("ID: ").append(studentId).append('\n');
        b.append(streetAddr).append(", ").append(cityAddr).append(' ').append(stateAddr).append(' ').append(zipCodeAddr).append('\n');
        b.append("Undergrad? ").append(isUndergrad).append(" Graduating in ").append(graduatingYear).append('\n');
        b.append("Current semester: ").append(semester).append(' ').append(year).append('\n');

        b.append("\nAdding courses:\n");
        for(int i=0; i<addCourses.size(); i++)
        {
            b.append(addCourses.get(i).toString());
        }

        b.append("\nDropping courses:\n");
        for(int i=0; i<dropCourses.size(); i++)
        {
            b.append(dropCourses.get(i).toString());
        }

        return b.toString();
    }
}

