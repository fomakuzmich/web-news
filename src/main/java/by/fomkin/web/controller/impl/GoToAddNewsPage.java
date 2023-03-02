package by.fomkin.web.controller.impl;

import static by.fomkin.web.util.constant.Parameters.*;
import static by.fomkin.web.util.constant.Atributes.*;
import java.io.IOException;

import by.fomkin.web.controller.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GoToAddNewsPage implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lastReuestUrl = request.getContextPath() + "/controller?command=go_to_add_news_page";
		request.getSession(true).setAttribute(URL, lastReuestUrl);

		request.setAttribute(PRESENTATION_ATTR, ADD_NEWS_VALUE);
		request.getRequestDispatcher("WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
	}

}
