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
    ArrayList<String> dropCourses = new ArrayList<>();

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
        isUndergrad = (boolean) json.get("undergrad");
        graduatingYear = (int) json.get("ungradClass");

        semester = (Semester)json.get("semester");
        year = (int) json.get("year");

        JSONArray addSubjectArray = (JSONArray) json.get("addSubject");
        JSONArray addNumberArray = (JSONArray) json.get("addNumber");
        JSONArray addSectionArray = (JSONArray) json.get("addSection");
        JSONArray addCreditsArray = (JSONArray) json.get("addCredits");

        JSONArray dropSubjectArray = (JSONArray) json.get("dropSubject");
        JSONArray dropNumberArray = (JSONArray) json.get("dropNumber");
        JSONArray dropSectionArray = (JSONArray) json.get("dropSection");
        JSONArray dropCreditsArray = (JSONArray) json.get("dropCredits");

        /*
        for(int i=0; i<addSubjectArray.size(); i++) {
            subjectsToAdd.add((String) addSubjectArray.get(i));
            numbersToAdd.add((String) addNumberArray.get(i));
            sectionsToAdd.add((String) addSectionArray.get(i));
            creditsToAdd.add((String) addCreditsArray.get(i));
        }

        for(int i=0; i<addSubjectArray.size(); i++) {
            subjectsToDrop.add((String) dropSubjectArray.get(i));
            numbersToDrop.add((String) dropNumberArray.get(i));
            sectionsToDrop.add((String) dropSectionArray.get(i));
            creditsToDrop.add((String) dropCreditsArray.get(i));
        }*/
    }

    /*public void signForm(){
        __signatureDate = new SimpleDateFormat("MM/dd/yyyy").format(new Date());

    }*/

    // public String toString() instead
    // strinbuilder is not thread safe
    // StringBuilder b = new StringBuilder(1024)  allocate appoximate size to speed up
    // b.append(lastName).append('\n').append(firstName).append()
    // return b.toString()

    public String toString() {
        StringBuilder b = new StringBuilder(1024);
        b.append(lastName).append(", ").append(firstName).append(' ').append(middleName).append('\n');
        b.append(studentId).append('\n');
        b.append(streetAddr).append(", ").append(cityAddr).append(' ').append(stateAddr).append(' ').append(zipCodeAddr).append('\n');
        b.append("Undergrad? ").append(isUndergrad).append(" Graduating in ").append(graduatingYear).append('\n');
        b.append("Current semester: ").append(semester).append(' ').append(year).append('\n');

        return b.toString();
    }
}

