package com.app.apsfl.Ekyc;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class SplitXML {

	
	public DeviceInfo SplitDeviceInfo(String strDeviceInfo){
		DeviceInfo deviceInfo = null;
		DocumentBuilderFactory dbBuilderFactory = null;
		DocumentBuilder documentBuilder = null;
		InputSource inputSource = null;
		Document document= null;
		Node nodedeviceInfo = null;
		Element deviceInfoElement = null;
		try{
			if(strDeviceInfo != null && !strDeviceInfo.isEmpty())
				strDeviceInfo = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>"+strDeviceInfo;
			
			dbBuilderFactory = DocumentBuilderFactory
					.newInstance();
			documentBuilder = dbBuilderFactory
					.newDocumentBuilder();
			
			inputSource = new InputSource(new StringReader(strDeviceInfo));
			document = documentBuilder
			.parse(inputSource);

			deviceInfo = new DeviceInfo();

			document.getDocumentElement().normalize();

			nodedeviceInfo = document.getElementsByTagName("DeviceInfo").item(0);

			deviceInfoElement = (Element) nodedeviceInfo;
			deviceInfo.dpId = deviceInfoElement.getAttribute("dpId");
			deviceInfo.rdsId = deviceInfoElement.getAttribute("rdsId");
			deviceInfo.rdsVer = deviceInfoElement.getAttribute("rdsVer");
			deviceInfo.dc = deviceInfoElement.getAttribute("dc");
			deviceInfo.mi = deviceInfoElement.getAttribute("mi");
			deviceInfo.mc = deviceInfoElement.getAttribute("mc");
		}catch(Exception e){
			deviceInfo = null;
		}finally{
			dbBuilderFactory = null;
			documentBuilder = null;
			inputSource = null;
			document= null;
			nodedeviceInfo = null;
			deviceInfoElement = null;
		}
		return deviceInfo;
	}

	public RDServiceInfo SplitRDServiceInfo(String strRDServiceInfo){
		RDServiceInfo rdServiceInfo = null;

		DocumentBuilderFactory dbBuilderFactory = null;
		DocumentBuilder documentBuilder = null;
		Node noderdServiceInfo = null;
		InputSource is = null;
		Element rdServiceInfoElement = null;
		NodeList noderdServiceInterfaceList  = null;
		Document document = null;
		Element interfaceElement = null;
		try{
			if(strRDServiceInfo != null && !strRDServiceInfo.isEmpty())
				strRDServiceInfo = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>"+strRDServiceInfo;
			dbBuilderFactory = DocumentBuilderFactory
					.newInstance();
			documentBuilder = dbBuilderFactory
					.newDocumentBuilder();
			
			is = new InputSource(new StringReader(strRDServiceInfo));
			document = documentBuilder.parse(is);

			rdServiceInfo = new RDServiceInfo();

			document.getDocumentElement().normalize();
			noderdServiceInfo = document.getElementsByTagName("RDService").item(0);

			rdServiceInfoElement = (Element) noderdServiceInfo;
			rdServiceInfo.status = rdServiceInfoElement.getAttribute("status");
			rdServiceInfo.info = rdServiceInfoElement.getAttribute("info");

			noderdServiceInterfaceList = document.getElementsByTagName("Interface");

			for(int i = 0 ;i<noderdServiceInterfaceList.getLength();i++){
				interfaceElement = (Element)noderdServiceInterfaceList.item(i);
				if(interfaceElement.getAttribute("id").equalsIgnoreCase("CAPTURE")){
					rdServiceInfo.CapturePath = interfaceElement.getAttribute("path");  
				}else if(interfaceElement.getAttribute("id").equalsIgnoreCase("DEVICEINFO")){
					rdServiceInfo.DeviceInfopath = interfaceElement.getAttribute("path");
				}
			}
		}catch(Exception e){
			rdServiceInfo = null;
		}finally{
			dbBuilderFactory = null;
			documentBuilder = null;
			noderdServiceInfo = null;
			is = null;
			rdServiceInfoElement = null;
			noderdServiceInterfaceList  = null;
			document = null;
			interfaceElement = null;
		}
		return rdServiceInfo;
	}

	public CaptureResponse SplitCaptureResponse(String strcaptureRespone){
		CaptureResponse captureResponse = null;
		DocumentBuilderFactory dbBuilderFactory = null;
		DocumentBuilder documentBuilder = null;
		InputSource is = null;
		Document document = null;
		Element elementsKey = null;
		Element elementResp = null;
		Element elementHmac = null;
		Element elementData = null;
		try{
			captureResponse = new CaptureResponse();
			if(strcaptureRespone != null && !strcaptureRespone.isEmpty())
				strcaptureRespone = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>"+strcaptureRespone;
			dbBuilderFactory = DocumentBuilderFactory
					.newInstance();
			documentBuilder = dbBuilderFactory
					.newDocumentBuilder();

			is = new InputSource(new StringReader(strcaptureRespone));
			document = documentBuilder.parse(is);

			document.getDocumentElement().normalize();
			elementResp = (Element)document.getElementsByTagName("Resp").item(0);
			captureResponse.errCode =  elementResp.getAttribute("errCode");
			captureResponse.errInfo =  elementResp.getAttribute("errInfo");
			captureResponse.fCount =  elementResp.getAttribute("fCount");
			captureResponse.fType =  elementResp.getAttribute("fType");
			captureResponse.iCount = elementResp.getAttribute("iCount");
			captureResponse.pCount = elementResp.getAttribute("pCount");
			captureResponse.pType = elementResp.getAttribute("pType");


			if(captureResponse.errCode.equalsIgnoreCase("0")){
				captureResponse.nmPoints = elementResp.getAttribute("nmPoints");
				captureResponse.qScore = elementResp.getAttribute("qScore");

				elementsKey = (Element)document.getElementsByTagName("Skey").item(0);
				captureResponse.ci = elementsKey.getAttribute("ci");
				captureResponse.sessionKey = elementsKey.getTextContent();

				elementHmac = (Element)document.getElementsByTagName("Hmac").item(0);
				captureResponse.hmac = elementHmac.getTextContent();

				elementData = (Element)document.getElementsByTagName("Data").item(0);
				captureResponse.PidDatatype = elementData.getAttribute("type"); 
				captureResponse.Piddata = elementData.getTextContent();
			}
		}catch(Exception e){
			captureResponse = null;
		}finally{
			dbBuilderFactory = null;
			documentBuilder = null;
			is = null;
			document = null;
			elementsKey = null;
			elementResp = null;
			elementHmac = null;
			elementData = null;
		}
		return captureResponse;
	}
}
