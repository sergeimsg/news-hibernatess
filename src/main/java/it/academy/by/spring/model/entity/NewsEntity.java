package it.academy.by.spring.model.entity;

import java.io.Serializable;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name = "NEWS")
public class NewsEntity implements Serializable{

	
	private static final long serialVersionUID = 1L;


	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "news_id")
	private int id;
		
	@NotEmpty(message = "not null")
	@Size(max = 30, message = "max 30")
	@Column(name = "title")
	private String title;
	
	
	@NotEmpty(message = "not null")
	@Size(max = 100, message = "max 30")
	@Lob
	@Column(name = "brief")
	private String briefNews;
	
	@NotEmpty(message = "not null")
	@Lob
	@Column(name = "content")
	private String content;

	
//	@Temporal(TemporalType.TIMESTAMP)
//	@Generated(GenerationTime.ALWAYS)
//	@Column(name = "create_date", insertable = false, updatable = false)
//	private Calendar createDate;
//	
	
	@Column(name = "create_date")
	@Generated(GenerationTime.ALWAYS)
	private String createDate;
	
	
	@Column(name = "image_path")
	private String imagePath;

	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	//@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private UserDetailsEntity userDetailsEntity;
	
	@Column(name = "status")
	private int status;

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
	 * @return the briefNews
	 */
	public String getBriefNews() {
		return briefNews;
	}

	/**
	 * @param briefNews the briefNews to set
	 */
	public void setBriefNews(String briefNews) {
		this.briefNews = briefNews;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the createDate
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * @param imagePath the imagePath to set
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	/**
	 * @return the userDetailsEntity
	 */
	public UserDetailsEntity getUserDetailsEntity() {
		return userDetailsEntity;
	}

	/**
	 * @param userDetailsEntity the userDetailsEntity to set
	 */
	public void setUserDetailsEntity(UserDetailsEntity userDetailsEntity) {
		this.userDetailsEntity = userDetailsEntity;
	}

	/**
	 * @return the status
	 */
	

	@Override
	public int hashCode() {
		return Objects.hash(briefNews, content, createDate, id, imagePath, status, title, userDetailsEntity);
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof NewsEntity)) {
			return false;
		}
		NewsEntity other = (NewsEntity) obj;
		return Objects.equals(briefNews, other.briefNews) && Objects.equals(content, other.content)
				&& Objects.equals(createDate, other.createDate) && id == other.id
				&& Objects.equals(imagePath, other.imagePath) && Objects.equals(status, other.status)
				&& Objects.equals(title, other.title) && Objects.equals(userDetailsEntity, other.userDetailsEntity);
	}

	@Override
	public String toString() {
		return "NewsEntity [id=" + id + ", title=" + title + ", briefNews=" + briefNews + ", content=" + content
				+ ", createDate=" + createDate + ", imagePath=" + imagePath + ", status=" + status + "]";
	}

	

	
	
		
	
	
}
