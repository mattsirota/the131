package main.java.Backend;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class ChangeEnrollment {
    private int id;

    private String lastName;
    private String firstName;
    private String middleName;
    private String studentId;
    private String streetAddr;
    private String cityAddr;
    private String stateAddr;
    private String zipCodeAddr;
    private boolean undergrad;
    private String ungradClass;
    private boolean graduate;
    private String __studentSignature;
    private String __signatureDate;

    private boolean winter;
    private boolean spring;
    private boolean summerI;
    private boolean summerII;
    private boolean fall;
    private String year;
    // make a list of these maybe??
    private String addCourse;
    private String dropCourse;

    ArrayList subjectsToAdd = new ArrayList();
    ArrayList numbersToAdd = new ArrayList();
    ArrayList sectionsToAdd = new ArrayList();
    ArrayList creditsToAdd = new ArrayList();

    ArrayList subjectsToDrop = new ArrayList();
    ArrayList numbersToDrop = new ArrayList();
    ArrayList sectionsToDrop = new ArrayList();
    ArrayList creditsToDrop = new ArrayList();


    public ChangeEnrollment(JSONObject json)
    {
        // test to make sure this works
        // otherwise use JSONObject methods
        // Object info = new JSONParser().parse(json);

        lastName = (String) json.get("lastName");
        firstName = (String) json.get("firstName");
        middleName = (String) json.get("middleName");
        studentId = (String) json.get("studentId");
        streetAddr = (String) json.get("streetAddr");
        cityAddr = (String) json.get("cityAddr");
        stateAddr = (String) json.get("stateAddr");
        zipCodeAddr = (String) json.get("zipCodeAddr");
        undergrad = (boolean) json.get("undergrad");
        ungradClass = (String) json.get("ungradClass");
        graduate = (boolean) json.get("graduate");

        winter = (boolean) json.get("winter");
        spring = (boolean) json.get("spring");
        summerI = (boolean) json.get("summerI");
        summerII = (boolean) json.get("summerII");
        fall = (boolean) json.get("fall");
        year = (String) json.get("year");

        JSONArray addSubjectArray = (JSONArray) json.get("addSubject");

        for(int i=0; i<addSubjectArray.size(); i++) {
            subjectsToAdd.add((String) addSubjectArray.get(i));
            numbersToAdd.add(json.get("addNumber"));
            sectionsToAdd.add(json.get("addSection"));
            creditsToAdd.add(json.get("addCredits"));
        }


        //addCourse;
        //dropCourse;
    }
}

