package pl.wodkowski.job.interview.task;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;

public interface TransformTask {
	default void transform() throws Exception {
		ClassLoader classLoader = TransformXmlToCsvTask.class.getClassLoader();
		File xmlLocation = new File(classLoader.getResource(xmlInputFileLocation()).getFile());
		File xslLocation = new File(classLoader.getResource(getXSLTSource()).getFile());

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(xmlLocation);

		StreamSource styleSource = new StreamSource(xslLocation);
		Transformer transformer = TransformerFactory.newInstance().newTransformer(styleSource);
		Source source = new DOMSource(document);
		Result outputTarget = new StreamResult(new File(resultFileLocation()));
		transformer.transform(source, outputTarget);

		System.out.println("XSLT: " + getXSLTSource() + " ->" + resultFileLocation() + ": completed");
	}

	default String xmlInputFileLocation() {
		return "excercise/excercise-1.xml";
	}

	String getXSLTSource();

	String resultFileLocation();
}
