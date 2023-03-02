package by.fomkin.web.service.impl;

import by.fomkin.web.bean.NewUserInfo;
import by.fomkin.web.dao.DaoException;
import by.fomkin.web.dao.DaoProvider;
import by.fomkin.web.dao.IUserDAO;
import by.fomkin.web.service.ServiceException;
import by.fomkin.web.util.validation.UserDataValidation;
import by.fomkin.web.util.validation.ValidationException;
import by.fomkin.web.util.validation.ValidationProvider;
import by.fomkin.web.service.IUserService;

public class UserServiceImpl implements IUserService {

	private final IUserDAO userDAO = DaoProvider.getInstance().getUserDao();
	private final UserDataValidation validator = ValidationProvider.getInstance().getUserDataValidator();

	@Override
	public NewUserInfo signIn(String email, String password) throws ServiceException {

		NewUserInfo user = null;

		try {
			user = userDAO.logination(email, password);

		} catch (DaoException e) {
			throw new ServiceException(e);
		}

		return user;
	}

	@Override
	public boolean registration(NewUserInfo userInfo) throws ServiceException {

		String email = userInfo.getEmail();
		String password = userInfo.getPassword();

		try {
			validator.checkUserData(email, password);
		} catch (ValidationException e) {
			throw new ServiceException("validation exception", e);
		}

		try {
			userDAO.registration(userInfo);
		} catch (DaoException e) {
			throw new ServiceException("dao exception", e);
		}
		return true;
	}

}
