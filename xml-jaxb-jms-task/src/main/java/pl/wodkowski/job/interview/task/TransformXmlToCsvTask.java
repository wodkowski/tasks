package pl.wodkowski.job.interview.task;

public class TransformXmlToCsvTask implements TransformTask {
	public static void main(String[] args) throws Exception {
		TransformTask transformToCSV = new TransformXmlToCsvTask();
		transformToCSV.transform();
	}

	@Override
	public String getXSLTSource() {
		return "xslt/xmlToCsv.xsl";
	}

	@Override
	public String resultFileLocation() {
		return "excercise-1_xml_to_csv.csv";
	}
	
}
