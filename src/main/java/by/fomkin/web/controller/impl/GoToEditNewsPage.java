package by.fomkin.web.controller.impl;

import static by.fomkin.web.util.constant.Parameters.*;
import static by.fomkin.web.util.constant.Atributes.*;
import java.io.IOException;

import by.fomkin.web.bean.News;
import by.fomkin.web.controller.Command;
import by.fomkin.web.service.INewsService;
import by.fomkin.web.service.ServiceException;
import by.fomkin.web.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GoToEditNewsPage implements Command {

	private final INewsService newsService = ServiceProvider.getInstance().getNewsService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String lastReuestUrl = request.getContextPath() + "/controller?command=go_to_edit_news_page";
		request.getSession(true).setAttribute(URL, lastReuestUrl);

		News news;

		String id;

		id = request.getParameter(ID);

		try {
			news = newsService.findById(Integer.parseInt(id));
			request.setAttribute(NEWS_ATTR, news);
			request.setAttribute(PRESENTATION_ATTR, EDIT_NEWS_VALUE);
			request.getRequestDispatcher("WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);

		} catch (ServiceException e) {
			response.sendRedirect("controller?command=go_to_error_page");
		}

	}
}
