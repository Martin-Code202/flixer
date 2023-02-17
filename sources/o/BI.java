package o;

import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
public final class BI {
    /* renamed from: ˎ  reason: contains not printable characters */
    public static Element m3864(Element element, String str) {
        NodeList childNodes = element.getChildNodes();
        int length = childNodes.getLength();
        for (int i = 0; i < length; i++) {
            if (childNodes.item(i).getNodeType() == 1 && str.equals(childNodes.item(i).getNodeName())) {
                return (Element) childNodes.item(i);
            }
        }
        return null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static Element m3865(Element element, String str) {
        NodeList elementsByTagName = element.getElementsByTagName(str);
        int length = elementsByTagName.getLength();
        for (int i = 0; i < length; i++) {
            if (elementsByTagName.item(i).getNodeType() == 1) {
                return (Element) elementsByTagName.item(i);
            }
        }
        return null;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static Document m3863(String str) {
        DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource inputSource = new InputSource();
        inputSource.setCharacterStream(new StringReader(str));
        return newDocumentBuilder.parse(inputSource);
    }
}
