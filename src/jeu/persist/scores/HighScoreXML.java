package jeu.persist.scores;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import jeu.persist.Score;
import jeu.persist.Scores;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class HighScoreXML extends HighScore {

    public void ecrire() {
        try {
            Scores lesScores = Scores.getInstance();
            DocumentBuilderFactory dbf;
            Document doc;
            Element element;
            
            
            File fXmlFile = new File("save.xml");
            
            
            if (fXmlFile.exists() && !fXmlFile.isDirectory()) {
                dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbf.newDocumentBuilder();
                doc = dBuilder.parse(fXmlFile);
                element = doc.getDocumentElement();
            } else {
                dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = dbf.newDocumentBuilder();
                doc = builder.newDocument();// create the root element node
                element = doc.createElement("lesScores");
                doc.appendChild(element);

            }

            // add element after the first child of the root element
            Score s = lesScores.getLastScore();
            Element itemElement = doc.createElement("score");
            element.appendChild(itemElement);
            itemElement.setAttribute("joueur", s.getJ().getNom());
            itemElement.setAttribute("date", s.getDateScore().toString());
            itemElement.insertBefore(doc.createTextNode(s.getScore().toString()), itemElement.getLastChild());

            try {
                Transformer tf = TransformerFactory.newInstance().newTransformer();
                tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                tf.setOutputProperty(OutputKeys.INDENT, "yes");
                Writer out = new StringWriter();
                tf.transform(new DOMSource(doc), new StreamResult(out));

                StreamResult result = new StreamResult(new File("save.xml"));
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                transformer.transform(source, result);

                System.out.println(out.toString());

            } catch (Exception ex) {
                Logger.getLogger(HighScoreXML.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(HighScoreXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(HighScoreXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HighScoreXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
