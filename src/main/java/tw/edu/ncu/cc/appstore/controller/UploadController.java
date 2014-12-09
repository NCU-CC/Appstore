package tw.edu.ncu.cc.appstore.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
@Controller
@Scope("prototype")
public class UploadController extends ActionSupport{
    private static final long serialVersionUID = 1L;
    private File picture;
    private String pictureContentType;
    private String pictureFileName;
    
    public String execute(){
        System.out.println("file save in AAAAAAAAAAA ");
        return INPUT;
    }
    public String upload() throws Exception {
        System.out.println("file save in VVVVVVVVVV");
        File saved = new File(ServletActionContext.getServletContext().getRealPath("upload"),pictureFileName);       
        System.out.println("file save in "+saved.getAbsolutePath());
        InputStream ins = null;
        OutputStream ous = null;
        try{
            saved.getParentFile().mkdirs();
            ins = new FileInputStream(picture);
            ous = new FileOutputStream(saved);
            
            byte [] b = new byte[1024];
            int len = 0;
            while((len=ins.read(b))!= -1){
                ous.write(b,0,len);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (ous != null){
                ous.close();
            }
            if(ins!=null){
                ins.close();
            }
        }
        return "list";
    }
    public File getPicture() {
        return picture;
    }
    public void setPicture(File picture) {
        this.picture = picture;
    }
    public String getPictureContentType() {
        return pictureContentType;
    }
    public void setPictureContentType(String pictureContentType) {
        this.pictureContentType = pictureContentType;
    }
    public String getPictureFileName() {
        return pictureFileName;
    }
    public void setPictureFileName(String pictureFileName) {
        this.pictureFileName = pictureFileName;
    }
}
