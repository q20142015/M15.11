import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.*;
import javax.swing.text.html.parser.Parser;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import org.jsoup.select.Elements;

public class ParseMetro {
    String path="https://skillbox-java.github.io/";

   ArrayList <StName> stName=new ArrayList<StName>();;
    ArrayList <LineName> lineName=new ArrayList<LineName>();
    ParseMetro() {
        {
            //Document htmlFile;
            String htmlCode;
            try {
              htmlCode = Jsoup.connect(path).get().html();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Document doc= Jsoup.parse(htmlCode);
            Elements elements =doc.select("span.name,span.num,span.js-metro-line");
            String numL="0";
            for(int i=0;i<elements.size();i++)
            {
            if(elements.get(i).attr("data-line")!="")
            {
                numL=elements.get(i).attr("data-line");
                String nameL=elements.get(i).text();
               lineName.add(new LineName(numL,nameL));
            }
            else
            {
                String nameSt=elements.get(i+1).text();
                stName.add(new StName(numL,nameSt));
                i=i+1;
                int j=0;
            }
            }
        }
    }
}
