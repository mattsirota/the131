package main.java.Backend;

import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.io.FileReader;
import java.io.IOException;

public class Test
{
    public static void main(String[] args) throws IOException, ParseException {
        Object obj = new JSONParser().parse(new FileReader("ezforms/test.json"));
        JSONObject json = (JSONObject) obj;
        ChangeEnrollment addDrop = new ChangeEnrollment(json);
        System.out.println(addDrop.toString());
    }
}