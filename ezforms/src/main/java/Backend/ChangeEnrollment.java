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
    private int ungradClass;
    private boolean graduate;
    private String __studentSignature;
    private String __signatureDate;

    // enumerate. not individual booleans
    private boolean winter;
    private boolean spring;
    private boolean summerI;
    private boolean summerII;
    private boolean fall;
    // int
    private String year;
    // make a list of these maybe??
    //private String addCourse;
    //private String dropCourse;

    // course object. make list of that instead
    ArrayList<String> subjectsToAdd = new ArrayList<>();
    ArrayList<String> numbersToAdd = new ArrayList<>();
    ArrayList<String> sectionsToAdd = new ArrayList<>();
    ArrayList<String> creditsToAdd = new ArrayList<>();

    ArrayList<String> subjectsToDrop = new ArrayList<>();
    ArrayList<String> numbersToDrop = new ArrayList<>();
    ArrayList<String> sectionsToDrop = new ArrayList<>();
    ArrayList<String> creditsToDrop = new ArrayList<>();


    // define exceptions and throw for form failing
    // if form is bad just say what field is bad if possible
    // generic exception for a form
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
        ungradClass = (int) json.get("ungradClass");
        graduate = (boolean) json.get("graduate");

        //
        winter = (boolean) json.get("winter");
        spring = (boolean) json.get("spring");
        summerI = (boolean) json.get("summerI");
        summerII = (boolean) json.get("summerII");
        fall = (boolean) json.get("fall");
        year = (String) json.get("year");

        JSONArray addSubjectArray = (JSONArray) json.get("addSubject");
        JSONArray addNumberArray = (JSONArray) json.get("addNumber");
        JSONArray addSectionArray = (JSONArray) json.get("addSection");
        JSONArray addCreditsArray = (JSONArray) json.get("addCredits");

        JSONArray dropSubjectArray = (JSONArray) json.get("dropSubject");
        JSONArray dropNumberArray = (JSONArray) json.get("dropNumber");
        JSONArray dropSectionArray = (JSONArray) json.get("dropSection");
        JSONArray dropCreditsArray = (JSONArray) json.get("dropCredits");

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
        }
    }

    public void signForm(){
        __signatureDate = new SimpleDateFormat("MM/dd/yyyy").format(new Date());

    }

    // public String toString() instead
    // strinbuilder is not thread safe
    // StringBuilder b = new StringBuilder(1024)  allocate appoximate size to speed up
    // b.append(lastName).append('\n').append(firstName).append()
    // return b.toString()

    // get rid of this
    public void printInfo() {
        System.out.println(lastName);
        System.out.println(firstName);
        System.out.println(middleName);
        System.out.println(studentId);
        System.out.println(streetAddr);
        System.out.println(cityAddr);
        System.out.println(stateAddr);
        System.out.println(zipCodeAddr);
        System.out.println(undergrad);
        System.out.println(ungradClass);
        System.out.println(graduate);
        System.out.println(winter);
        System.out.println(spring);
        System.out.println(summerI);
        System.out.println(summerII);
        System.out.println(fall);
        System.out.println(year);

        for(int i=0; i<subjectsToAdd.size(); i++) {
            System.out.print(subjectsToAdd.get(i));
            System.out.print(numbersToAdd.get(i) + "-");
            System.out.print(sectionsToAdd.get(i) + " ");
            System.out.println(creditsToAdd.get(i));
        }

        for(int i=0; i<subjectsToDrop.size(); i++) {
            System.out.print(subjectsToDrop.get(i));
            System.out.print(numbersToDrop.get(i) + "-");
            System.out.print(sectionsToDrop.get(i) + " ");
            System.out.println(creditsToDrop.get(i));
        }
    }
}

