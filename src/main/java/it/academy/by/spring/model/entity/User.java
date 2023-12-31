package it.academy.by.spring.model.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User implements Serializable{
	
	
	
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "USERNAME")
  private String username;

  @Column(name = "PASSWORD", nullable = false)
  private String password;

  @Column(name = "ENABLED", nullable = false)
  private boolean enabled;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
  private Set<Authorities> authorities = new HashSet<>();

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public Set<Authorities> getAuthorities() {
    return authorities;
  }

  public void setAuthorities(Set<Authorities> authorities) {
    this.authorities = authorities;
  }

@Override
public int hashCode() {
	return Objects.hash(authorities, enabled, password, username);
}

@Override
public boolean equals(Object obj) {
	if (this == obj) {
		return true;
	}
	if (!(obj instanceof User)) {
		return false;
	}
	User other = (User) obj;
	return Objects.equals(authorities, other.authorities) && enabled == other.enabled
			&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
}

@Override
public String toString() {
	return "User [username=" + username + ", password=" + password + ", enabled=" + enabled + ", authorities="
			+ authorities + "]";
}
  
  
  
  
}
