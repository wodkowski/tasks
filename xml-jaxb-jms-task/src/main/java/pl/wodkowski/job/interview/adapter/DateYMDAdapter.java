package pl.wodkowski.job.interview.adapter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateYMDAdapter extends XmlAdapter<String, Date> {
	public static final DateFormat Y_M_D_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public String marshal(Date v) throws Exception {
		return Y_M_D_FORMATTER.format(v);
	}

	@Override
	public Date unmarshal(String v) throws Exception {
		return Y_M_D_FORMATTER.parse(v);
	}

}
