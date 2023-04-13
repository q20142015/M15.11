import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class JSonParse {

    void jsonParse(String path){
        StringBuilder build=new StringBuilder();
        List<String> lines= null;
        try {
            lines = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        lines.forEach(line->build.append(line));
        ArrayList<StName> stN = new ArrayList<StName>();
        try {
        JSONParser parser=new JSONParser();
        JSONArray jsonData=(JSONArray) parser.parse(build.toString());
        jsonData.forEach(obj->{
            JSONObject lineobj=(JSONObject) obj;
            String name=(String)lineobj.get("station_name");
           String deap=(String) lineobj.get("depth");
           stN.add(new StName(name,deap));
        });
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
