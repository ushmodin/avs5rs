package com.artmark.avs5rs.model;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Ushmodin N.
 * @since 07.07.2016 14:36
 */

public class TimestampAdapter extends XmlAdapter<String,Date> {

	private static final String FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

	@Override
	public Date unmarshal(String s) throws Exception {
		return new SimpleDateFormat(FORMAT).parse(s);
	}

	@Override
	public String marshal(Date date) throws Exception {
		return new SimpleDateFormat(FORMAT).format(date);
	}
}

