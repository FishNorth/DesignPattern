package pre.fishnorth.domain;

import java.util.ArrayList;
import java.util.List;

public class SubjectImpl implements Subject {

    /**
     * 存放所有的观察者信息
     */
    private List<Observer> observerList = new ArrayList<Observer>();
    /**
     * 存放消息
     */
    private String message;

    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    public void removeObserver(Observer observer) {
        if (!observerList.isEmpty()) {
            observerList.remove(observer);
        }
    }

    public void notifyAllObserver() {
        // 通知所有关注该主题的观察者
        for (Observer observer : observerList) {
            observer.update(message);
        }
    }

    public void publishMessage(String message) {
        this.message = message;
        System.out.println("发布消息： " + message);
        notifyAllObserver();
    }
}
