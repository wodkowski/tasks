package pl.wodkowski.job.interview.task;

public class TransformXmlToXmlTask implements TransformTask {
	public static void main(String[] args) throws Exception {
		TransformTask transfromToXML = new TransformXmlToXmlTask();
		transfromToXML.transform();
	}

	@Override
	public String getXSLTSource() {
		return "xslt/xmlToXml.xsl";
	}

	@Override
	public String resultFileLocation() {
		return "excercise-1_xml_to_xml.xml";
	}
}
