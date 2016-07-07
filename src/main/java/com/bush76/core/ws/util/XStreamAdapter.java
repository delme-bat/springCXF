package com.bush76.core.ws.util;

import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.bush76.core.entity.User;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XStreamAdapter extends XmlAdapter<String, Map<String, User>> {

	@Override
	@SuppressWarnings("unchecked")
	public Map<String, User> unmarshal(String v) throws Exception {
		XStream objXStream = new XStream(new DomDriver());
		return (Map<String, User>) objXStream.fromXML(v);
	}

	@Override
	public String marshal(Map<String, User> v) throws Exception {
		XStream objXStream = new XStream();
		return objXStream.toXML(v);
	}

}
