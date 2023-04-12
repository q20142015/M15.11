import java.util.ArrayList;

public class StName {

    String number;
    String name;
    ArrayList<String> namePeresadki = null;

    StName(String number, String name) {
        this.name = name;
        this.number = number;
    }

    StName(String number, String name, String[] namePeresadki) {
        this.name = name;
        this.number = number;
        for (int i = 0; i < namePeresadki.length; i++) {
            this.namePeresadki.add(namePeresadki[i]);
        }
    }
}
