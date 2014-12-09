package tw.edu.ncu.cc.appstore.controller.upload.reupload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tw.edu.ncu.cc.appstore.entity.Person;
import tw.edu.ncu.cc.appstore.entity.Product;
import tw.edu.ncu.cc.appstore.entity.ProductCategory;
import tw.edu.ncu.cc.appstore.entity.ProductState;
import tw.edu.ncu.cc.appstore.entity.ProductStateEnum;
import tw.edu.ncu.cc.appstore.service.IPersonService;
import tw.edu.ncu.cc.appstore.service.IProductStateService;
import tw.edu.ncu.cc.appstore.service.IService;
import tw.edu.ncu.cc.appstore.util.FilePath;
import tw.edu.ncu.cc.appstore.util.PersonInfo;
import tw.edu.ncu.cc.appstore.util.PersonUtil;

import com.opensymphony.xwork2.ActionSupport;
@Controller
@Scope("prototype")
public class ReUploadThreeController extends ActionSupport{
    private static final long serialVersionUID = 1L;
    private static final String PATH = FilePath.PATH;
    private IProductStateService<ProductState> serivceP;
    @Inject
    public void setSerivce(IProductStateService<ProductState> serivce) {
        this.serivceP = serivce;
    }
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
    private int id;
    @Override
    public String execute() throws Exception {
        Product tProduct = getLastProductById(id);
        if(tProduct==null || !isSamePerson(tProduct)){
            return LOGIN;
        }
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
        ProductState productState= serivceP.find(ProductState.class, id);
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
        } catch (Exception e) {
            e.printStackTrace();            
        }
        try {            
            filesname2 = saveFile(sourceCode, sourceCodeFileName.trim().split("\\.")[1]);           
            product.setSourceCodePath(filesname2);
        } catch (Exception e) {
            e.printStackTrace();            
        }
                        
        product.setAppleStore(appleStore);
        product.setGooglePlay(googlePlay);
        
        
        HttpServletRequest request=ServletActionContext.getRequest();        
        String tmpId=PersonUtil.getStudentId(request);
        if(tmpId!=null && tmpId.length()>0){
            Person person=service.findPersonByAccount(tmpId);
            if(person!=null){
                product.setAuthor(person);
//                ProductState productState= serivceP.find(ProductState.class, id);
                ProductState productState=null;
                List<ProductState> list = person.getProducts();
                for(ProductState ps : list){
                    if(ps.getId()== id){
                        productState=ps;
                        break;
                    }
                }
                
                Date date = new Date();
                product.setDateCreated(date);
                product.setDateChanged(date);
                product.setState(ProductStateEnum.UNCHECKED.toString());
                product.getCategory().add(ProductCategory.NONOFFICIAL.toString());
                productState.setLastChanged(date);
                productState.getAllProducts().add(product);
                productState.setState(ProductStateEnum.UNCHECKED.toString());
//                person.getProducts().add(productState);
                service.save(person);
//                serivceP.save(productState);
                return SUCCESS;
            }
        }
        
        
        return INPUT;
    }
    
    
    private String saveFile(File file,String end) throws Exception{
        String md5;
        InputStream ins = null;
        OutputStream ous = null;
        try {
        md5 = getMD5Checksum(file);
//        File saved = new File(ServletActionContext.getServletContext().getRealPath("upload/code"),(md5+"."+end));  
        File saved = new File(PATH+"upload"+File.separator+"code"+File.separator+(md5+"."+end));    
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
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
}
