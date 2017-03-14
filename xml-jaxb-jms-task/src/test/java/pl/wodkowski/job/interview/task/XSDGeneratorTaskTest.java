package pl.wodkowski.job.interview.task;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pl.wodkowski.job.interview.model.Library;

public class XSDGeneratorTaskTest {

	private XSDGeneratorTask generator;

	@Before
	public void init() {
		generator = new XSDGeneratorTask() {
			@Override
			public String getXSDLocation() {
				return "library-test.xsd";
			}
		};
	}

	@Test
	public void shouldGenerateXSDFile() throws Exception {
		// given
		Class<?> type = Library.class;
		ClassLoader classLoader = UnmarshallingTask.class.getClassLoader();
		File file = new File(classLoader.getResource("input/library.xsd").getFile());
		String xsdSource = getFileContent(file);
		// when
		generator.generateXSD(type);
		// then
		String xsdResult = getFileContent(new File("library-test.xsd"));
		Assert.assertEquals(xsdResult, xsdSource);

	}

	@After
	public void cleanAfterTest() {
		new File("library-test.xsd").delete();
	}

	private String getFileContent(File fileName) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		String line = null;
		while ((line = in.readLine()) != null) {
			sb.append(line).append("\n");
		}
		in.close();
		return sb.toString();
	}
}
