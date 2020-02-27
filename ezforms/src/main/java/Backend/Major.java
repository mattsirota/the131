package main.java.Backend;

public class Major{
    private String majorName;
    // required courses
    private int numRequired;
    // list of courses that the student MUST take. All of them are required

    // courses of different subjects that are needed for the major i.e. core, concentration, math, etc.
    private int numCore;
    // list of core classes
    private int numMath;
    private int numConcentration;
}