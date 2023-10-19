package it.academy.by.spring.model.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.Size;

@Entity
@Table(name = "USERS_DETAILS")
public class UserDetailsEntity implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private int userID;
	@NotEmpty(message = "not null")
	@Column(name = "NAME")
	private String name;
	
	@NotEmpty(message = "not null")
	@Size(min = 3, message = "required min = 3")
	@Column(name = "SURNAME")
	private String surname;
	
		
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "LOGIN")
	private User user;
	
	@Size(min = 3, message = "required min = 3")
	
	@Column(name = "EMAIL")
	private String email;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userDetailsEntity",
		cascade = {CascadeType.DETACH,CascadeType.MERGE, 
				CascadeType.PERSIST, CascadeType.REFRESH } )
	private List<NewsEntity> news;

	
	

	public UserDetailsEntity() {
		
	}


	
	public UserDetailsEntity(int userID, String name, String surname, User user, String email, List<NewsEntity> news) {
		super();
		this.userID = userID;
		this.name = name;
		this.surname = surname;
		this.user = user;
		this.email = email;
		this.news = news;
	}



	/**
	 * @return the userID
	 */
	public int getUserID() {
		return userID;
	}



	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}



	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}



	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}



	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}



	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}



	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}



	/**
	 * @return the news
	 */
	public List<NewsEntity> getNews() {
		return news;
	}



	/**
	 * @param news the news to set
	 */
	public void setNews(List<NewsEntity> news) {
		this.news = news;
	}



	@Override
	public int hashCode() {
		return Objects.hash(email, name, news, surname, user, userID);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof UserDetailsEntity)) {
			return false;
		}
		UserDetailsEntity other = (UserDetailsEntity) obj;
		return Objects.equals(email, other.email) && Objects.equals(name, other.name)
				&& Objects.equals(news, other.news) && Objects.equals(surname, other.surname)
				&& Objects.equals(user, other.user) && userID == other.userID;
	}



	@Override
	public String toString() {
		return "UserDetailsEntity [userID=" + userID + ", name=" + name + ", surname=" + surname + ", user=" + user
				+ ", email=" + email + ", news=" + news + "]";
	}
	
		
	
	
	
		
	
	
}
