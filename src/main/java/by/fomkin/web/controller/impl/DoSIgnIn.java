package by.fomkin.web.controller.impl;

import static by.fomkin.web.util.constant.Parameters.*;
import static by.fomkin.web.util.constant.Atributes.*;
import static by.fomkin.web.util.constant.Pages.*;
import java.io.IOException;

import by.fomkin.web.controller.Command;
import by.fomkin.web.service.ServiceException;
import by.fomkin.web.service.ServiceProvider;
import by.fomkin.web.service.IUserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import by.fomkin.web.bean.NewUserInfo;
import by.fomkin.web.util.Security;
import jakarta.servlet.http.HttpSession;

public class DoSIgnIn implements Command {

	private final IUserService service = ServiceProvider.getInstance().getUserService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (Security.parametersAreEmpty(request)) {
			request.setAttribute(AUTHENTICATION_ERROR_ATTR, EMPTY_FIELDS_MESSAGE);
			request.getRequestDispatcher(BASE_LAYOUT_JSP).forward(request, response);
			return;
		}

		String email = request.getParameter(JSP_EMAIL_PARAM);
		String password = request.getParameter(JSP_PASSWORD_PARAM);
		HttpSession session = request.getSession(true);

		try {

			NewUserInfo user = service.signIn(email, password);

			if (user != null) {
				session.setAttribute(USER_ATTR, ACTIVE_VALUE);
				session.setAttribute(ROLE_ATTR, user.getRole());
				session.setAttribute("userId", user.getId());
				response.sendRedirect("controller?command=go_to_news_list");
			} else {
				session.setAttribute(USER_ATTR, NOT_ACTIVE_VALUE);
				request.setAttribute(AUTHENTICATION_ERROR_ATTR, WRONG_FIELDS_MESSAGE);
				request.getRequestDispatcher("/WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
			}

		} catch (ServiceException e) {
			response.sendRedirect("controller?command=go_to_error_page");
		}
	}
}
