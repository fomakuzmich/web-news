package by.fomkin.web.controller.impl;

import static by.fomkin.web.util.constant.Parameters.*;
import static by.fomkin.web.util.constant.Atributes.*;
import java.io.IOException;
import java.util.List;
import by.fomkin.web.bean.News;
import by.fomkin.web.controller.Command;
import by.fomkin.web.service.INewsService;
import by.fomkin.web.service.ServiceException;
import by.fomkin.web.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class GoToBasePage implements Command {

	private final INewsService newsService = ServiceProvider.getInstance().getNewsService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String lastReuestUrl = request.getContextPath()+"/controller?command=go_to_base_page";
		request.getSession(true).setAttribute(URL, lastReuestUrl);
		
		List<News> latestNews;
		try {
			latestNews = newsService.latestList(5);
			request.setAttribute(NEWS_ATTR, latestNews);
			request.getRequestDispatcher("WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
			
		} catch (ServiceException e) {
			response.sendRedirect("controller?command=go_to_error_page");
		}
		
		
	}
}
