package tw.edu.ncu.cc.appstore.controller.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tw.edu.ncu.cc.appstore.entity.Product;
import tw.edu.ncu.cc.appstore.util.FilePath;
import tw.edu.ncu.cc.appstore.util.PersonUtil;

import com.opensymphony.xwork2.ActionSupport;
@Controller
@Scope("prototype")
public class UploadTwoController extends ActionSupport{
    private static final long serialVersionUID = 1L;
    private static final String PATH = FilePath.PATH;
    private File pictureOne;  
    private File pictureTwo;
    private String pictureOneFileName;
    private String pictureTwoFileName;  
    @Override
    public String execute() throws Exception {
        if(PersonUtil.isLogined(ServletActionContext.getRequest())){
            HttpSession session=ServletActionContext.getRequest().getSession(true);
            Product product=(Product)session.getAttribute("tmpProduct");
            if(product==null || product.getChineseName()==null || product.getChineseName().length()<=0){
                return NONE;
            }
            return INPUT;
        }
        return LOGIN;
    }
    public String upload(){
        if(!PersonUtil.isLogined(ServletActionContext.getRequest())){
            return LOGIN;
        }
        HttpSession session=ServletActionContext.getRequest().getSession(true);
        Product product=(Product)session.getAttribute("tmpProduct");
        if(product==null || product.getChineseName()==null || product.getChineseName().length()<=0){
            return NONE;
        }
        
        try {
            String filesname1 = saveFile(pictureOne, pictureOneFileName.trim().split("\\.")[1]);
            String filesname2 = saveFile(pictureTwo, pictureTwoFileName.trim().split("\\.")[1]);
            product.setImagePath(filesname1);
            product.setImage2Path(filesname2);
        } catch (Exception e) {
            e.printStackTrace();
            return INPUT;
        }
        
        
        return SUCCESS;
    }
    
    private String saveFile(File file,String end) throws Exception{
        String md5;
        InputStream ins = null;
        OutputStream ous = null;
        try {
        md5 = getMD5Checksum(file);
//        File saved = new File(ServletActionContext.getServletContext().getRealPath("upload/images"),(md5+"."+end));    
        File saved = new File(PATH+"upload"+File.separator+"images"+File.separator+(md5+"."+end));    
        if(saved.exists()){
            return (md5+"."+end);
        }
            saved.getParentFile().mkdirs();
            ins = new FileInputStream(file);
            ous = new FileOutputStream(saved);
            
            byte [] b = new byte[1024];
            int len = 0;
            while((len=ins.read(b))!= -1){
                ous.write(b,0,len);
            }
        }finally {
            if (ous != null){
                ous.close();
            }
            if(ins!=null){
                ins.close();
            }
        }
        return (md5+"."+end);
    }
    
    public static byte[] createChecksum(File filename) throws Exception {
        InputStream fis =  new FileInputStream(filename);

        byte[] buffer = new byte[1024];
        MessageDigest complete = MessageDigest.getInstance("MD5");
        int numRead;

        do {
            numRead = fis.read(buffer);
            if (numRead > 0) {
                complete.update(buffer, 0, numRead);
            }
        } while (numRead != -1);

        fis.close();
        return complete.digest();
    }

    public static String getMD5Checksum(File filename) throws Exception {
        byte[] b = createChecksum(filename);
        String result = "";

        for (int i=0; i < b.length; i++) {
            result += Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
        }
        return result;
    }
    public File getPictureOne() {
        return pictureOne;
    }
    public void setPictureOne(File pictureOne) {
        this.pictureOne = pictureOne;
    }
    public File getPictureTwo() {
        return pictureTwo;
    }
    public void setPictureTwo(File pictureTwo) {
        this.pictureTwo = pictureTwo;
    }
    public String getPictureOneFileName() {
        return pictureOneFileName;
    }
    public void setPictureOneFileName(String pictureOneFileName) {
        this.pictureOneFileName = pictureOneFileName;
    }
    public String getPictureTwoFileName() {
        return pictureTwoFileName;
    }
    public void setPictureTwoFileName(String pictureTwoFileName) {
        this.pictureTwoFileName = pictureTwoFileName;
    }

    
}
