package pre.fishnorth.domain;

/**
 * 主题接口，一个主题被多个观察者关注，若主题发生变化，需要通知所有关注的观察者
 */
public interface Subject {

    /**
     * 增加一个观察者
     * @param observer
     */
    void addObserver(Observer observer);

    /**
     * 移除一个观察者
     * @param observer
     */
    void removeObserver(Observer observer);

    /**
     * 通知所有的观察者
     */
    void notifyAllObserver();

}
