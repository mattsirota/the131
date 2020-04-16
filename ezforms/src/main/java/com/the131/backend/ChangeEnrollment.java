package com.the131.backend;

//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Entity
public class ChangeEnrollment {
    enum Semester {
        WINTER, SPRING, SUMMER_ONE, SUMMER_TWO, FALL
    }

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String lastName;
    @NotNull
    private String firstName;
    private String middleName;
    @NotNull
    private String campusWideID;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private boolean isUndergrad;
    private int anticipatedGraduation;
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
   /*
    public ChangeEnrollment(JSONObject json)
    {
        lastName = (String) json.get("lastName");
        firstName = (String) json.get("firstName");
        middleName = (String) json.get("middleName");
        campusWideID = (String) json.get("campusWideID");
        streetAddress = (String) json.get("streetAddress");
        city = (String) json.get("city");
        state = (String) json.get("state");
        zipCode = (String) json.get("zipCode");
        isUndergrad = (boolean) json.get("isUndergrad");
        anticipatedGraduation = ((Long) json.get("anticipatedGraduation")).intValue();

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

   /*
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
        b.append("ID: ").append(campusWideID).append('\n');
        b.append(streetAddress).append(", ").append(city).append(' ').append(state).append(' ').append(zipCode).append('\n');
        b.append("Undergrad? ").append(isUndergrad).append(" Graduating in ").append(anticipatedGraduation).append('\n');
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
    */
}
