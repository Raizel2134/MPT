package lab1;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lab1.model.Studio;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class XPathTask {
    private DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
    private static XmlMapper xmlMapper;

    static {
        try {
            assert false;
            xmlMapper = new XmlMapper();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readXPathExpression(String inputFileName, String expression, String outputFileName) {
        builderFactory.setNamespaceAware(true);
        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document doc = builder.parse(inputFileName);

            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();

            writeGroupsInXml(getGroupsWithExpression(doc, xpath, expression), outputFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeGroupsInXml(Studio studio, String outputFileName) {
        File file = new File(outputFileName);
        try {
            if (file.exists()) {
                writeFile(studio, file);
            } else {
                file.createNewFile();
                writeFile(studio, file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeFile(Studio studio, File file) throws IOException {
        xmlMapper.writeValue(file, studio);
    }

    private Studio getGroupsWithExpression(Document doc, XPath xpath, String expression) {
        ArrayList<Studio.Group> output = new ArrayList<Studio.Group>();
        try {
            NodeList album = getAlbumList(doc, xpath, expression, "/album/text()");
            NodeList date = getAlbumList(doc, xpath, expression, "/date/text()");
            NodeList studioName = getAlbumList(doc, xpath, expression, "/studioName/text()");

            if (album.getLength() == date.getLength() && album.getLength() == studioName.getLength()) {
                for (int i = 0; i < album.getLength(); i++) {
                    output.add(
                            new Studio.Group(
                                    album.item(i).getNodeValue(),
                                    date.item(i).getNodeValue(),
                                    studioName.item(i).getNodeValue()
                            )
                    );
                }
            } else throw new Exception("Size is not equals!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Studio(output);
    }

    private NodeList getAlbumList(Document doc, XPath xpath, String expression, String s) throws XPathExpressionException {
        return (NodeList) xpath.compile(expression + s).evaluate(doc, XPathConstants.NODESET);
    }
}
