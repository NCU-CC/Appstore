package tw.edu.ncu.cc.appstore.controller;

import java.util.Map;

import org.apache.struts2.util.TokenHelper;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public abstract class TokenBasisController extends ActionSupport{
    private static final long serialVersionUID = 1L;
    private String token;
    
    public String getToken() {
        return token;
      }

      public void setToken(String token) {
        this.token = token;
      }

      protected void createTokenForGet() {
        Map<String, Object> context = ActionContext.getContext().getValueStack().getContext();
        Object myToken = context.get("token");
        if (myToken == null) {
            myToken = TokenHelper.setToken("token");
            context.put("token", myToken);
        }
        token = myToken.toString();
      }
}
