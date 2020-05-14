package view;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.LoggedInUser;
import dto.LoginCredentials;
import util.Utilities;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class LoginView implements Serializable {
    private String username;
    private String password;

    @PostConstruct
    public void init() {
    }

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

    public String login(){
        LoginCredentials loginCredentials = new LoginCredentials();
        loginCredentials.setUsername(this.getUsername());
        loginCredentials.setPassword(this.getPassword());

        Client client = ClientBuilder.newClient();
        WebTarget clientTraget = client.target("http://localhost:8080").path("login");
        ObjectMapper mapper = new ObjectMapper();
        //Converting the Object to JSONString
        String jsonString = null;
        try {
            jsonString = mapper.writeValueAsString(loginCredentials);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        Response response =  clientTraget.request(MediaType.APPLICATION_JSON).post(Entity.json(jsonString));
        LoggedInUser loggedInUser = response.readEntity(LoggedInUser.class);
        if(loggedInUser!=null){
            HttpSession session = Utilities.getSession();
            session.setAttribute("userid", loggedInUser.getUserId());
            session.setAttribute("username", loggedInUser.getUserName());
            return "home";
        }else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Invalid Login!",
                    "Please Try Again!"));

            // invalidate session, and redirect to other pages
            //message = "Invalid Login. Please Try Again!";
            return "index";
        }
    }

    public String logout() {
        HttpSession session = Utilities.getSession();
        session.invalidate();
        return "login";
    }
}
