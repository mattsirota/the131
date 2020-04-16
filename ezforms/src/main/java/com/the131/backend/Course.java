package com.the131.backend;


public class Course {
    private String subject;
    private String number;
    private String section;
    private int credits;

    public Course(String subject, String number, String section, int credits)
    {
        this.subject = subject;
        this.number = number;
        this.section = section;
        this.credits = credits;
    }

    public void setSubject()
    {

    }

    public String toString()
    {
        StringBuilder b = new StringBuilder(1024);
        b.append(subject).append(number).append(" ").append(section).append(": ").append(credits).append(" credits\n");
        return b.toString();
    }
}
