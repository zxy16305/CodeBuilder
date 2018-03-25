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

    public BaseImfFilling setThisPackage(String thisPackage) {
        this.thisPackage = thisPackage;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public BaseImfFilling setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public BaseImfFilling setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getDatetime() {
        return datetime;
    }

    public BaseImfFilling setDatetime(String datetime) {
        this.datetime = datetime;
        return this;
    }
}
