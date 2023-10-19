package it.academy.by.spring.model.bean;


import java.util.Objects;

public class NewsDataBeanGeneral {
	
	private int id;
	private String title;
	private String brief;
	private String createDate;
	
	
	public NewsDataBeanGeneral() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * @return the brief
	 */
	public String getBrief() {
		return brief;
	}


	/**
	 * @param brief the brief to set
	 */
	public void setBrief(String brief) {
		this.brief = brief;
	}


	/**
	 * @return the createDate
	 */
	public String getCreateDate() {
		return createDate;
	}


	/**
	 * @param calendar the createDate to set
	 */
	public void setCreateDate(String calendar) {
		this.createDate = calendar;
	}


	@Override
	public int hashCode() {
		return Objects.hash(brief, createDate, id, title);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof NewsDataBeanGeneral)) {
			return false;
		}
		NewsDataBeanGeneral other = (NewsDataBeanGeneral) obj;
		return Objects.equals(brief, other.brief) && Objects.equals(createDate, other.createDate) && id == other.id
				&& Objects.equals(title, other.title);
	}

	
	
	
}
