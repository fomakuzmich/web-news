package by.fomkin.web.service;

import java.util.List;

import by.fomkin.web.bean.News;

public interface INewsService {
	void save(News news) throws ServiceException;

	void delete(String[] idNewses) throws ServiceException;

	void update(News news) throws ServiceException;

	List<News> latestList(int count) throws ServiceException;

	List<News> list() throws ServiceException;

	News findById(int id) throws ServiceException;

}
