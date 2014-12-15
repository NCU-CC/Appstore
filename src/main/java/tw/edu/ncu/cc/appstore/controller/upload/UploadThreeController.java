package tw.edu.ncu.cc.appstore.controller.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tw.edu.ncu.cc.appstore.entity.Person;
import tw.edu.ncu.cc.appstore.entity.Product;
import tw.edu.ncu.cc.appstore.entity.ProductCategory;
import tw.edu.ncu.cc.appstore.entity.ProductState;
import tw.edu.ncu.cc.appstore.entity.ProductStateEnum;
import tw.edu.ncu.cc.appstore.service.IPersonService;
import tw.edu.ncu.cc.appstore.util.FilePath;
import tw.edu.ncu.cc.appstore.util.PersonUtil;

import com.opensymphony.xwork2.ActionSupport;
@Component
@Scope("prototype")
public class UploadThreeController extends ActionSupport{
    private static final long serialVersionUID = 1L;
    private static final String PATH = FilePath.PATH;
    private File apk;
    private String apkFileName;
    private File sourceCode;
    private String sourceCodeFileName;
    private String googlePlay;
    private String appleStore;
    private boolean terms;
    private IPersonService<Person> service;
    @Inject
    public void setService(IPersonService<Person> service) {
        this.service = service;
    }
    @Override
    public String execute() throws Exception {
        if(PersonUtil.isLogined(ServletActionContext.getRequest())){
            HttpSession session=ServletActionContext.getRequest().getSession(true);
            Product product=(Product)session.getAttribute("tmpProduct");
            if(product==null || product.getImage2Path()==null || product.getImage2Path().length()<=0){
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
        if(product==null || product.getImage2Path()==null || product.getImage2Path().length()<=0){
            return NONE;
        }
        if(!terms){
            return INPUT;
        }
        
        if(apk==null && googlePlay==null && googlePlay.length()<=0 && appleStore==null && appleStore.length()<=0 ){
            return INPUT;
        }
        
        String filesname1;
        String filesname2;
        try {
            filesname1 = saveFile(apk, apkFileName.trim().split("\\.")[1]);
            product.setFilePath(filesname1);
        }catch (NoSuchAlgorithmException e1) {                        
            filesname1=null;
        }catch(IOException e2){
            filesname1=null;
        }
        try {            
            filesname2 = saveFile(sourceCode, sourceCodeFileName.trim().split("\\.")[1]);           
            product.setSourceCodePath(filesname2);
        }catch (NoSuchAlgorithmException e1) {                        
            filesname2=null;
        }catch(IOException e2){
            filesname2=null;
        }
                        
        product.setAppleStore(appleStore);
        product.setGooglePlay(googlePlay);
        
        
        HttpServletRequest request=ServletActionContext.getRequest();        
        String tmpId=PersonUtil.getStudentId(request);
        if(tmpId!=null && tmpId.length()>0){
            Person person=service.findPersonByAccount(tmpId);
            if(person!=null){
                product.setAuthor(person);
                ProductState productState =new ProductState();
                Date date = new Date();
                product.setDateCreated(date);
                product.setDateChanged(date);
                product.setState(ProductStateEnum.UNCHECKED.toString());
                product.getCategory().add(ProductCategory.NONOFFICIAL.toString());
                productState.setLastChanged(date);
                productState.getAllProducts().add(product);
                productState.setState(ProductStateEnum.UNCHECKED.toString());
                person.getProducts().add(productState);
                service.save(person);
                return SUCCESS;
            }
        }
        
        
        return INPUT;
    }
    
    
    private String saveFile(File file,String end) throws NoSuchAlgorithmException,IOException {
        String md5="";
        InputStream ins = null;
        OutputStream ous = null;
        md5 = getMD5Checksum(file);
//        File saved = new File(ServletActionContext.getServletContext().getRealPath("upload/code"),(md5+"."+end));    
        File saved = new File(PATH+"upload"+File.separator+"code"+File.separator+(md5+"."+end));  
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
    }}
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
    
    public File getApk() {
        return apk;
    }
    public void setApk(File apkFile) {
        this.apk = apkFile;
    }
    public String getApkFileName() {
        return apkFileName;
    }
    public void setApkFileName(String apkFileName) {
        this.apkFileName = apkFileName;
    }
    public File getSourceCode() {
        return sourceCode;
    }
    public void setSourceCode(File sourceCodeFile) {
        this.sourceCode = sourceCodeFile;
    }
    public String getSourceCodeFileName() {
        return sourceCodeFileName;
    }
    public void setSourceCodeFileName(String sourceCodeFileName) {
        this.sourceCodeFileName = sourceCodeFileName;
    }
    public String getGooglePlay() {
        return googlePlay;
    }
    public void setGooglePlay(String googlePlay) {
        this.googlePlay = googlePlay.trim();
    }
    public String getAppleStore() {
        return appleStore;
    }
    public void setAppleStore(String appleStore) {
        this.appleStore = appleStore.trim();
    }
    public boolean isTerms() {
        return terms;
    }
    public void setTerms(boolean terms) {
        this.terms = terms;
    }
    
}
