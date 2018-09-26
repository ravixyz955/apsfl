package com.app.apsfl.Ekyc;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class FormXML {

    public static String PIDOptionversion = "2.0";
    public static String env = "P";
    public static String fCount = "1";
    public static String fType = "0";
    public static String iCount = "";
    public static String iType = "";
    public static String pType = "";
    public static String pCount = "";
    public static String format = "";
    public static String pidVer = "2.0";
    public static String timeout = "";
    public static String otp = "";
    //public static String wadh = "rhVuL7SnJi2W2UmsyukVqY7c93JWyL9O/kVKgdNMfv8=";
    public static String wadh = "RZ+k4w9ySTzOibQdDHPzCFqrKScZ74b3EibKYy1WyGw=";

    public static String posh = "";
    public static boolean isUIRequired = false;
    public static String key = "";


    public String FormAuthenticationXML(String strAadhaarNumber,
                                        CaptureResponse captureResponse, DeviceInfo deviceInfo) {
        String authXML = null;
        try {
            StringWriter stringWriter = new StringWriter();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            document.setXmlStandalone(true);

            Element rootElement = document.createElement("PBAuthInfo");
            document.appendChild(rootElement);
            rootElement.setAttribute("uid", strAadhaarNumber);

            Element usesElement = document.createElement("Uses");
            rootElement.appendChild(usesElement);

            usesElement.setAttribute("pi", "n");
            usesElement.setAttribute("pa", "n");
            usesElement.setAttribute("pfa", "n");
            usesElement.setAttribute("bio", "y");
            usesElement.setAttribute("bt", "FMR");
            usesElement.setAttribute("pin", "n");
            usesElement.setAttribute("otp", "n");

            Element metaElement = document.createElement("Meta");
            rootElement.appendChild(metaElement);
            String udc = deviceInfo.dc.substring(0, 19);
            metaElement.setAttribute("udc", udc);
            metaElement.setAttribute("rdsId", deviceInfo.rdsId);
            metaElement.setAttribute("rdsVer", deviceInfo.rdsVer);
            metaElement.setAttribute("dpId", deviceInfo.dpId);
            metaElement.setAttribute("dc", deviceInfo.dc);
            metaElement.setAttribute("mi", deviceInfo.mi);
            metaElement.setAttribute("mc", deviceInfo.mc);
            Element skeyElement = document.createElement("Skey");
            rootElement.appendChild(skeyElement);

            skeyElement.setAttribute("ci", captureResponse.ci);
            skeyElement.setTextContent(captureResponse.sessionKey);

            Element dataElement = document.createElement("Data");
            rootElement.appendChild(dataElement);

            dataElement.setAttribute("type", "X");
            dataElement.setTextContent(captureResponse.Piddata);

            Element hmacElement = document.createElement("Hmac");
            rootElement.appendChild(hmacElement);

            hmacElement.setTextContent(captureResponse.hmac);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(
                    "{http://xml.apache.org/xslt}indent-amount", "2"); // to

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
            DOMSource source = new DOMSource(document);

            StreamResult result = new StreamResult(stringWriter);
            transformer.transform(source, result);

            authXML = stringWriter.toString();
            System.out.println("Auth XML : " + authXML.toString());
        } catch (Exception e) {
            authXML = null;
        } finally {

        }
        return authXML;
    }

    public String formCaptureRequestXML() {
        String captureRequestXML = null;
        StringWriter writer = null;
        DocumentBuilderFactory docFactory = null;
        DocumentBuilder docBuilder = null;
        Document doc = null;
        Element rootElement = null;
        Element optsElement = null;
        Attr ver = null;
        try {
            writer = new StringWriter();
            docFactory = DocumentBuilderFactory
                    .newInstance();
            docBuilder = docFactory.newDocumentBuilder();

            doc = docBuilder.newDocument();
            doc.setXmlStandalone(true);

            rootElement = doc.createElement("PidOptions");
            doc.appendChild(rootElement);

            ver = doc.createAttribute("ver");
            ver.setValue(PIDOptionversion);
            rootElement.setAttributeNode(ver);

            optsElement = doc.createElement("Opts");
            rootElement.appendChild(optsElement);

            optsElement.setAttribute("env", env);
            optsElement.setAttribute("fCount", fCount);
            optsElement.setAttribute("fType", fType);
            optsElement.setAttribute("iCount", iCount);
            optsElement.setAttribute("iType", iType);
            optsElement.setAttribute("pCount", pCount);
            optsElement.setAttribute("pType", pType);
            optsElement.setAttribute("format", format);
            optsElement.setAttribute("pidVer", pidVer);
            optsElement.setAttribute("timeout", timeout);
            optsElement.setAttribute("otp", otp);
            optsElement.setAttribute("wadh", wadh);
            optsElement.setAttribute("posh", posh);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty("omit-xml-declaration", "yes");
            DOMSource source = new DOMSource(doc);

            StreamResult result = new StreamResult(writer);

            transformer.transform(source, result);

            captureRequestXML = writer.toString();


            System.out.println("Capture XML:" + captureRequestXML);

        } catch (Exception e) {
            captureRequestXML = null;
        } finally {
            writer = null;
            docFactory = null;
            docBuilder = null;
            doc = null;
            rootElement = null;
            optsElement = null;
            ver = null;
        }
        return captureRequestXML;
    }

}
