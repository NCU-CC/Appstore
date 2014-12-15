package tw.edu.ncu.cc.appstore.controller.upload.reupload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tw.edu.ncu.cc.appstore.entity.Product;
import tw.edu.ncu.cc.appstore.entity.ProductState;
import tw.edu.ncu.cc.appstore.service.IProductStateService;
import tw.edu.ncu.cc.appstore.util.FilePath;
import tw.edu.ncu.cc.appstore.util.PersonInfo;
import tw.edu.ncu.cc.appstore.util.PersonUtil;

import com.opensymphony.xwork2.ActionSupport;
@Controller
@Scope("prototype")
public class ReUploadTwoController extends ActionSupport{
    private static final long serialVersionUID = 1L;
    private static final String PATH = FilePath.PATH;
    private IProductStateService<ProductState> serivce;
    @Inject
    public void setSerivce(IProductStateService<ProductState> serivce) {
        this.serivce = serivce;
    }
    private File pictureOne;  
    private File pictureTwo;
    private String pictureOneFileName;
    private String pictureTwoFileName;
    private int id;
    @Override
    public String execute() throws Exception {
        Product tProduct = getLastProductById(id);
        if(tProduct==null || !isSamePerson(tProduct)){
            return LOGIN;
        }
            HttpSession session=ServletActionContext.getRequest().getSession(true);
            Product product=(Product)session.getAttribute("tmpProduct");
            if(product==null || product.getChineseName()==null || product.getChineseName().length()<=0){
                return NONE;
            }
            return INPUT;        
    }
    private boolean isSamePerson(Product tmpProduct){
        if(PersonUtil.isLogined(ServletActionContext.getRequest())){
            PersonInfo info=PersonUtil.getPersonInfo(ServletActionContext.getRequest());
            if(tmpProduct.getAuthor().getAccount().equals(info.getAccount())){
                return true;
            }
        }
        return false;
    }
    private Product getLastProductById(int id){        
        ProductState productState= serivce.find(ProductState.class, id);
        if(productState!=null){
            List<Product> list =productState.getAllProducts();
            Product tmpProduct= list.get(list.size()-1);
            return tmpProduct;
        }
        return null;
    }
    public String upload(){
        if(!PersonUtil.isLogined(ServletActionContext.getRequest())){
            return LOGIN;
        }
        Product tProduct = getLastProductById(id);
        if(tProduct==null || !isSamePerson(tProduct)){
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
        }catch (NoSuchAlgorithmException e1) {                        
            return INPUT;
        }catch(IOException e2){
            return INPUT;
        }
        
        
        return SUCCESS;
    }
    
    private String saveFile(File file,String end) throws NoSuchAlgorithmException, IOException {
        String md5;
        InputStream ins = null;
        OutputStream ous = null;
        md5 = getMD5Checksum(file);
//        File saved = new File(ServletActionContext.getServletContext().getRealPath("upload/images"),(md5+"."+end));  
        File saved = new File(PATH+"upload"+File.separator+"images"+File.separator+(md5+"."+end));    
        if(saved.exists()){
            return (md5+"."+end);
        }
            saved.getParentFile().mkdirs();
                if(saved.getParentFile().exists()){
            try{
            ins = new FileInputStream(file);
            try{
            ous = new FileOutputStream(saved);
            
            byte [] b = new byte[1024];
            int len = 0;
            while((len=ins.read(b))!= -1){
                ous.write(b,0,len);
            }
        }finally{
            if (ous != null){
                try{
                    ous.close();
                }catch(IOException e){
                    md5="";
                }
            }
        }
    }finally {                
            if(ins!=null){
                try{
                    ins.close();
                }catch(IOException e){
                    md5="";
                }
            }
    }
            }
        return (md5+"."+end);
    }
    
    public static byte[] createChecksum(File filename) throws NoSuchAlgorithmException, IOException  {
        InputStream fis =  null;
        byte[] buffer22=null;
        try{
            fis =  new FileInputStream(filename);
        byte[] buffer = new byte[1024];
        MessageDigest complete = MessageDigest.getInstance("SHA-256");
        int numRead;

        do {
            numRead = fis.read(buffer);
            if (numRead > 0) {
                complete.update(buffer, 0, numRead);
            }
        } while (numRead != -1);
        buffer22=complete.digest();
        
        }finally{
            if(fis!=null){
                try{
                    fis.close();
                }catch(IOException e){
                    buffer22=null;
                }
            }
        }
        return buffer22;
    }

    public static String getMD5Checksum(File filename) throws NoSuchAlgorithmException, IOException  {
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
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    
}
