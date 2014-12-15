package tw.edu.ncu.cc.appstore.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tw.edu.ncu.cc.appstore.util.FilePath;

import com.opensymphony.xwork2.ActionSupport;

@Component
@Scope("prototype")
public class UploadFileController extends ActionSupport{
    private static final long serialVersionUID = 1L;
    private static final String PATH = FilePath.PATH;
    private InputStream inputStream;
    private String fileName;
    private long contentLength;    
    private String folder;    
    
    public String execute() throws FileNotFoundException {        
        String path =PATH+"upload"+File.separator+folder+File.separator+fileName;
        File fileToDownload = new File(path); 
        inputStream = new FileInputStream(fileToDownload);
        fileName = fileToDownload.getName();
        contentLength = fileToDownload.length();         
        return SUCCESS;
    }
    
    public InputStream getInputStream() {
        return inputStream;
    }
    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName=fileName.replace(File.separatorChar, ' ');
    }
    public long getContentLength() {
        return contentLength;
    }
    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }
    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }
}
