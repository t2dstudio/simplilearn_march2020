package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Reusable {

	public static HttpSession createSession(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		return session;
	}
}
