package by.fomkin.web.dao;

import java.util.List;

import by.fomkin.web.bean.News;

public interface INewsDAO {
	List<News> getList() throws DaoException;

	List<News> getLatestsList(int count) throws DaoException;

	News fetchById(int id) throws DaoException;

	void addNews(News news) throws DaoException;

	void updateNews(News news) throws DaoException;

	void deleteNewses(String[] idNewses) throws DaoException;

}
