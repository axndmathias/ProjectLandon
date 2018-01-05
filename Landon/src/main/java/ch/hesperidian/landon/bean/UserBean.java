package ch.hesperidian.landon.bean;

import javax.faces.bean.ManagedBean;

import org.primefaces.context.RequestContext;

@ManagedBean
public class UserBean {

	private String username;
	private String password;
	
	
	
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



	public void login(){
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("swal('Login sucess!','Congratulation! you are logged in', 'success')");
				
		
	}
}
