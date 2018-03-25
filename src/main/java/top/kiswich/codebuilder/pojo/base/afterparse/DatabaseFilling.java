package top.kiswich.codebuilder.pojo.base.afterparse;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import top.kiswich.codebuilder.pojo.base.afterparse.table.EntityFilling;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于模板填装
 * 最高层的封装
 */
@Component
@SessionScope
public class DatabaseFilling {
    private BaseImfFilling base;
    private List<EntityFilling> entityFillings;
    private List<ServiceImplFilling> serviceImplFillings;
    private List<ServiceFilling> serviceFillings;
    private List<ControllerFilling> controllerFillings;
    private List<RepositoryFilling> repositoryFillings;
    private List<HtmlFilling> htmlFillings;
    private List<JsFilling> jsFillings;

    private List<String> errorMessage;

    public DatabaseFilling() {
        entityFillings = new ArrayList<>();
        serviceFillings = new ArrayList<>();
        serviceImplFillings = new ArrayList<>();
        controllerFillings = new ArrayList<>();
        repositoryFillings = new ArrayList<>();
        htmlFillings = new ArrayList<>();
        jsFillings = new ArrayList<>();
        errorMessage = new ArrayList<>();
    }

    public BaseImfFilling getBase() {
        return base;
    }

    public void setBase(BaseImfFilling base) {
        this.base = base;
    }

    public List<EntityFilling> getEntityFillings() {
        return entityFillings;
    }

    public void setEntityFillings(List<EntityFilling> entityFillings) {
        this.entityFillings = entityFillings;
    }

    public List<ServiceImplFilling> getServiceImplFillings() {
        return serviceImplFillings;
    }

    public void setServiceImplFillings(List<ServiceImplFilling> serviceImplFillings) {
        this.serviceImplFillings = serviceImplFillings;
    }

    public List<ServiceFilling> getServiceFillings() {
        return serviceFillings;
    }

    public void setServiceFillings(List<ServiceFilling> serviceFillings) {
        this.serviceFillings = serviceFillings;
    }

    public List<ControllerFilling> getControllerFillings() {
        return controllerFillings;
    }

    public void setControllerFillings(List<ControllerFilling> controllerFillings) {
        this.controllerFillings = controllerFillings;
    }

    public List<RepositoryFilling> getRepositoryFillings() {
        return repositoryFillings;
    }

    public void setRepositoryFillings(List<RepositoryFilling> repositoryFillings) {
        this.repositoryFillings = repositoryFillings;
    }


    public List<String> getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(List<String> errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<HtmlFilling> getHtmlFillings() {
        return htmlFillings;
    }

    public void setHtmlFillings(List<HtmlFilling> htmlFillings) {
        this.htmlFillings = htmlFillings;
    }

    public List<JsFilling> getJsFillings() {
        return jsFillings;
    }

    public void setJsFillings(List<JsFilling> jsFillings) {
        this.jsFillings = jsFillings;
    }
}
