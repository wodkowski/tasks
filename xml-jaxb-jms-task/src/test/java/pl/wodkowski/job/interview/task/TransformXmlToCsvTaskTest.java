package pl.wodkowski.job.interview.task;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TransformXmlToCsvTaskTest {
	private TransformTask transformTask;

	@Before
	public void init() {
		transformTask = new TransformXmlToCsvTask() {
			@Override
			public String xmlInputFileLocation() {
				return "input/excercise-1.xml";
			}

			@Override
			public String getXSLTSource() {
				return "input/xmlToCsv.xsl";
			}

			@Override
			public String resultFileLocation() {
				return "result-test.csv";
			}
		};
	}
	
	
	@Test
	public void shouldTransfromXmlToCsv() throws Exception{
		//given
		ClassLoader classLoader = UnmarshallingTask.class.getClassLoader();
		File file = new File(classLoader.getResource("excercise-1b.csv").getFile());
		String csvExample = getFileContent(file);
		//when
		transformTask.transform();
		String resultContent = getFileContent(new File("result-test.csv"));
		//then
		Assert.assertEquals(csvExample, resultContent);
		
	}
	
	@After
	public void cleanAfterTest(){
		new File("result-test.csv").delete();
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
