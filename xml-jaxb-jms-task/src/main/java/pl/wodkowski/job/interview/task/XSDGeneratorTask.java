package pl.wodkowski.job.interview.task;

import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

import pl.wodkowski.job.interview.model.Library;

public class XSDGeneratorTask {
	public static void main(String[] args) throws Exception {
		XSDGeneratorTask task = new XSDGeneratorTask();
		task.generateXSD(Library.class);
	}

	public void generateXSD(Class<?> clazz) throws Exception {
		JAXBContext jc = JAXBContext.newInstance(clazz);
		jc.generateSchema(new SchemaOutputResolver() {
			@Override
			public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
				return new StreamResult(getXSDLocation());
			}
		});
		System.out.println("XSD Generated!");
	}

	public String getXSDLocation() {
		return "library.xsd";
	}
}
