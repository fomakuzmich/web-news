package by.fomkin.web.service.impl;

import java.util.List;

import by.fomkin.web.bean.News;
import by.fomkin.web.dao.DaoException;
import by.fomkin.web.dao.DaoProvider;
import by.fomkin.web.dao.INewsDAO;
import by.fomkin.web.service.INewsService;
import by.fomkin.web.service.ServiceException;

public class NewsServiceImpl implements INewsService {

	private final INewsDAO newsDAO = DaoProvider.getInstance().getNewsDAO();

	@Override
	public void save(News news) throws ServiceException {

		try {
			newsDAO.addNews(news);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void delete(String[] idNewses) throws ServiceException {

		try {
			newsDAO.deleteNewses(idNewses);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void update(News news) throws ServiceException {

		try {
			newsDAO.updateNews(news);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public List<News> latestList(int count) throws ServiceException {

		try {
			return newsDAO.getLatestsList(count);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<News> list() throws ServiceException {
		try {
			return newsDAO.getList();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public News findById(int id) throws ServiceException {
		try {
			return newsDAO.fetchById(id);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}
}