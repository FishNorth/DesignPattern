package pre.fishnorth.domain;

/**
 * 观察者接口
 */
public interface Observer {

    /**
     * 当观察者观察到主题发生变化时，该方法将被回调
     * @param message
     */
    void update(String message);
}
