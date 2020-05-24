package com.tags;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CustomDateTag extends SimpleTagSupport {

	private String format;
	
	
	@Override
	public void doTag() throws IOException {
		JspWriter out=getJspContext().getOut();
		out.print(new SimpleDateFormat(format).format(new Date()));
	}


	public void setFormat(String format) {
		this.format = format;
	}

}
