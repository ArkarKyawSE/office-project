package com.solt.beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String loginId;
	private String name;
	private String password;

	public String login() {
		try {
			ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
			HttpServletRequest request = (HttpServletRequest) ctx.getRequest();
			request.login(loginId, password);
			if (request.isUserInRole("Office")) {
				return "/views/home?faces-redirect=true";
			}
			return "/login?faces-redirect=true";
		} catch (Exception e) {
			FacesMessage message = new FacesMessage("Login Error", "Please check your login Id and password.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return "/login?faces-redirect=true";
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
