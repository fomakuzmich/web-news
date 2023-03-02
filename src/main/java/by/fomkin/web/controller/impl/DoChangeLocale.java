package by.fomkin.web.controller.impl;

import static by.fomkin.web.util.constant.Parameters.*;
import java.io.IOException;
import by.fomkin.web.controller.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DoChangeLocale implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newLocale = request.getParameter(LOCALE);

		HttpSession session = request.getSession(true);
		session.setAttribute(LOCALE, newLocale);

		String lastRequestUrl = (String) session.getAttribute(URL);
		response.sendRedirect(lastRequestUrl);

	}

}
