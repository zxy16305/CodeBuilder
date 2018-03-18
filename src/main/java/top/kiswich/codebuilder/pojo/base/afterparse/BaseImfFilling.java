package top.kiswich.codebuilder.pojo.base.afterparse;

/**
 * 基础信息
 */
public class BaseImfFilling {
    //包名
    private String thisPackage;
    //作者
    private String author;
    //邮箱
    private String email;
    //日期
    private String datetime;

    public String getThisPackage() {
        return thisPackage;
    }

    public void setThisPackage(String thisPackage) {
        this.thisPackage = thisPackage;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
