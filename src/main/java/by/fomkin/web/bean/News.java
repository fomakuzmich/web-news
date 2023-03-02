package by.fomkin.web.bean;

import java.io.Serializable;
import java.util.Objects;

public class News implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idNews;
	private String title;
	private String briefNews;
	private String content;
	private String newsDate;
	private int idUser;

	public News() {
	}

	public News(int idNews, String title, String briefNews, String content, String newsDate) {
		super();
		this.idNews = idNews;
		this.title = title;
		this.briefNews = briefNews;
		this.content = content;
		this.newsDate = newsDate;

	}

	public News(String title, String briefNews, String content, int idUser) {
		super();

		this.title = title;
		this.briefNews = briefNews;
		this.content = content;
		this.idUser = idUser;
	}

	public News(int idNews, String title, String briefNews, String content, String newsDate, int idUser) {
		super();
		this.idNews = idNews;
		this.title = title;
		this.briefNews = briefNews;
		this.content = content;
		this.newsDate = newsDate;
		this.idUser = idUser;
	}

	public Integer getIdNews() {
		return idNews;
	}

	public void setIdNews(Integer idNews) {
		this.idNews = idNews;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBriefNews() {
		return briefNews;
	}

	public void setBriefNews(String briefNews) {
		this.briefNews = briefNews;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;

	}

	public String getNewsDate() {
		return newsDate;
	}

	public void setNewsDate(String newsDate) {
		this.newsDate = newsDate;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	@Override
	public int hashCode() {
		return Objects.hash(briefNews, content, idNews, idUser, newsDate, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		News other = (News) obj;
		return Objects.equals(briefNews, other.briefNews) && Objects.equals(content, other.content)
				&& idNews == other.idNews && idUser == other.idUser && Objects.equals(newsDate, other.newsDate)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [idNews=" + idNews + ", title=" + title + ", briefNews=" + briefNews
				+ ", content=" + content + ", newsDate=" + newsDate + ", idUser=" + idUser + "]";
	}

}
