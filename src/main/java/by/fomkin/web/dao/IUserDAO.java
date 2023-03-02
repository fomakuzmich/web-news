package by.fomkin.web.dao;

import by.fomkin.web.bean.NewUserInfo;

public interface IUserDAO {

	NewUserInfo logination(String email, String password) throws DaoException;

	boolean registration(NewUserInfo user) throws DaoException;

	public String getRole(int id) throws DaoException;

}
