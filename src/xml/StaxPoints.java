package xml;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StaxPoints {
    public static void main(String[] args) throws XMLStreamException {
        List<Point> pointList = null;
        Point point = null;
        String tagContent = null;
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(
                ClassLoader.getSystemResourceAsStream("xml/task.xml"));


        while (reader.hasNext()) {
            int event = reader.next();
            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    if ("point".equals(reader.getLocalName())) {
                        point = new Point();
                    }
                    if ("pointsList".equals(reader.getLocalName())) {
                        pointList = new ArrayList<>();
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    tagContent = reader.getText().trim();
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    switch (reader.getLocalName()) {
                        case "point":
                            pointList.add(point);
                        case "x":
                            if (!tagContent.equals("")) {
                                point.x = tagContent;
                            }
                            break;
                        case "y":
                            if (!tagContent.equals("")) {
                                point.y = tagContent;
                            }
                            break;
                    }
                    break;
            }
        }
        for (Point p : pointList) {
            System.out.println(p);
        }
    }
}
