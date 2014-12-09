package tw.edu.ncu.cc.appstore.controller.upload;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tw.edu.ncu.cc.appstore.entity.Product;
import tw.edu.ncu.cc.appstore.entity.UserGroupEnum;
import tw.edu.ncu.cc.appstore.util.PersonUtil;

import com.opensymphony.xwork2.ActionSupport;
@Controller
@Scope("prototype")
public class UploadOneController extends ActionSupport{
    private static final long serialVersionUID = 1L;
    private String appName;
    private String simpleIntro;
    private boolean tour; 
    private boolean student;
    private boolean parent;
    private String introduction;
    private String authorName;
    private String authorPhone;
    private String authorEmail;    
    private String errorState="false";
    private String errorMessage;
    
    @Override
    public String execute() throws Exception {
        if(PersonUtil.isLogined(ServletActionContext.getRequest())){
            Product tmpProduct= new Product();
            HttpSession session=ServletActionContext.getRequest().getSession(true);
            session.setAttribute("tmpProduct", tmpProduct );
            return INPUT;
        }
        return LOGIN;
    }
    public String upload(){
        if(!PersonUtil.isLogined(ServletActionContext.getRequest())){
            return LOGIN;
        }
        Product tmpProduct= new Product();
        HttpSession session=ServletActionContext.getRequest().getSession(true);
        session.setAttribute("tmpProduct", tmpProduct );
        tmpProduct.setChineseName(appName);
        tmpProduct.setIntroSimple(simpleIntro);
        tmpProduct.setIntroduction(introduction);
        Set<String> list = new HashSet<String>();
        if(tour){
            list.add(UserGroupEnum.TOUR.toString());
        }
        if(student){
            list.add(UserGroupEnum.STUDENT.toString());
        }
        if(parent){
            list.add(UserGroupEnum.PARENT.toString());
        }
        tmpProduct.setUserGroup(list);
//        tmpProduct.setAuthor(author);
        tmpProduct.setAuthorName(authorName);
        tmpProduct.setAuthorPhone(authorPhone);
        tmpProduct.setAuthorEmail(authorEmail);
        if(appName==null || appName.length()>30 || appName.length()<=0){
            System.out.println("app is null");
            errorState="true";
            errorMessage="APP名稱需介於1~30個字元";
        }else if(simpleIntro==null || simpleIntro.length()>50 || simpleIntro.length()<=0){
            System.out.println("simpleIntro is null");
            errorState="true";
            errorMessage="APP簡介需介於1~50個字元";
        }else if(! (tour | student | parent)){
            System.out.println("checkbox is null");
            errorState="true";
            errorMessage="分類至少需點擊一個";
        }else if(introduction==null || introduction.length()>3000 || introduction.length()<=0){
            System.out.println("introduction is null");
            errorState="true";
            errorMessage="詳細介紹需介於1~3000個字元";
        }else if(authorName==null || authorName.length()>50 || authorName.length()<=0){
            System.out.println("authorName is null");
            errorState="true";
            errorMessage="authorName需介於1~50個字元";
        }else if(authorPhone==null || authorPhone.length()>50 || authorPhone.length()<=0){
            System.out.println("authorPhone is null");
            errorState="true";
            errorMessage="authorPhone需介於1~50個字元";
        }else if(authorEmail==null || authorEmail.length()>50 || authorEmail.length()<=0){
            System.out.println("authorEmail is null");
            errorState="true";
            errorMessage="authorEmail需介於1~50個字元";
        }else{
            return SUCCESS;
        }
        return INPUT;
    }
    public String getSimpleIntro() {
        return simpleIntro;
    }
    public void setSimpleIntro(String simpleIntro) {
        this.simpleIntro = StringEscapeUtils.escapeHtml4(simpleIntro.trim());
    }
    public boolean isTour() {
        return tour;
    }
    public void setTour(boolean tour) {
        this.tour = tour;
    }
    public boolean isStudent() {
        return student;
    }
    public void setStudent(boolean student) {
        this.student = student;
    }
    public boolean isParent() {
        return parent;
    }
    public void setParent(boolean parent) {
        this.parent = parent;
    }
    public String getIntroduction() {
        return introduction;
    }
    public void setIntroduction(String introduction) {
        this.introduction = StringEscapeUtils.escapeHtml4(introduction.trim());
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = StringEscapeUtils.escapeHtml4(authorName.trim());
    }
    public String getAuthorPhone() {
        return authorPhone;
    }
    public void setAuthorPhone(String authorPhone) {
        this.authorPhone = StringEscapeUtils.escapeHtml4(authorPhone.trim());
    }
    public String getAuthorEmail() {
        return authorEmail;
    }
    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = StringEscapeUtils.escapeHtml4(authorEmail.trim());
    }
    public String getAppName() {
        return appName;
    }
    public void setAppName(String appName) {
        this.appName = StringEscapeUtils.escapeHtml4(appName.trim());
    }
    public String getErrorState() {
        return errorState;
    }
    public void setErrorState(String errorState) {
        this.errorState = errorState;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
