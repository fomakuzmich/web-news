package by.fomkin.web.controller.impl;

import static by.fomkin.web.util.constant.Pages.*;
import java.io.IOException;

import by.fomkin.web.controller.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GoToErrorPage implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(ERROR_JSP).forward(request, response);
	}

}
