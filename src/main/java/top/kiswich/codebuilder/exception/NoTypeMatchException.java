package top.kiswich.codebuilder.exception;

/**
 * 从数据库取出的数据不能被解析
 */
public class NoTypeMatchException extends Exception {

    public NoTypeMatchException() {
        super("No Type Matched");
    }

    public NoTypeMatchException(String message) {
        super(message);
    }
}
