import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;

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

    private boolean winter;
    private boolean spring;
    private boolean summerI;
    private boolean summerII;
    private boolean fall;
    private int year;
    // make a list of these maybe??
    private Course addCourse;
    private Course dropCourse;

    public ChangeEnrollment(JSONObject json)
    {

    }
}
