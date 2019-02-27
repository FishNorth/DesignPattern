package pre.fishnorth.domain;

public class ObserverImpl implements Observer {

    private String name;

    public ObserverImpl(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + "收到推送消息" + message);
    }
}
