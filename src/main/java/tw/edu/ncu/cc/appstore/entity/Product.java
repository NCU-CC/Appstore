package tw.edu.ncu.cc.appstore.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Product extends BaseBean{
    private static final long serialVersionUID = 1L;
    private String chineseName;
    private String englishName;
    private String introSimple;
    @Column(length=3000)
    private String introduction;
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> category=new HashSet<String>();
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> userGroup=new HashSet<String>();
    @ManyToOne(cascade = CascadeType.MERGE)
    private Person author;
    private String authorName;
    private String authorPhone;
    private String authorEmail;
    private String state;
    @Temporal(value=TemporalType.TIMESTAMP)
    private Date dateChanged;
    private String googlePlay;
    private String appleStore;
    private String filePath;
    private String imagePath;
    private String image2Path;
    private String sourceCodePath;
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public String getAuthorPhone() {
        return authorPhone;
    }
    public void setAuthorPhone(String authorPhone) {
        this.authorPhone = authorPhone;
    }
    public String getAuthorEmail() {
        return authorEmail;
    }
    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }
    public String getImage2Path() {
        return image2Path;
    }
    public void setImage2Path(String image2Path) {
        this.image2Path = image2Path;
    }
    public String getChineseName() {
        return chineseName;
    }
    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }
    public String getEnglishName() {
        return englishName;
    }
    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }
    public String getIntroSimple() {
        return introSimple;
    }
    public void setIntroSimple(String introSimple) {
        this.introSimple = introSimple;
    }
    public String getIntroduction() {
        return introduction;
    }
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
    public Set<String> getCategory() {
        return category;
    }
    public void setCategory(Set<String> category) {
        this.category = category;
    }
    public Set<String> getUserGroup() {
        return userGroup;
    }
    public void setUserGroup(Set<String> userGroup) {
        this.userGroup = userGroup;
    }
    public Person getAuthor() {
        return author;
    }
    public void setAuthor(Person author) {
        this.author = author;
    }
    public Date getDateChanged() {
        return dateChanged;
    }
    public void setDateChanged(Date dateChanged) {
        this.dateChanged = dateChanged;
    }
    public String getGooglePlay() {
        return googlePlay;
    }
    public void setGooglePlay(String googlePlay) {
        this.googlePlay = googlePlay;
    }
    public String getAppleStore() {
        return appleStore;
    }
    public void setAppleStore(String appleStore) {
        this.appleStore = appleStore;
    }
    public String getFilePath() {
        return filePath;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    public String getImagePath() {
        return imagePath;
    }
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    public String getSourceCodePath() {
        return sourceCodePath;
    }
    public void setSourceCodePath(String sourceCodePath) {
        this.sourceCodePath = sourceCodePath;
    }    
}
