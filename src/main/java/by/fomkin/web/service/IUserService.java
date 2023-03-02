package by.fomkin.web.service;

import by.fomkin.web.bean.NewUserInfo;

public interface IUserService {

	NewUserInfo signIn(String email, String password) throws ServiceException;

	boolean registration(NewUserInfo user) throws ServiceException;

}
