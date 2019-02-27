package pre.fishnorth.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class ObserverImplTest {

    @Test
    public void receiptMessage() throws Exception {
        SubjectImpl subject = new SubjectImpl();

        Observer userZhang = new ObserverImpl("ZhangSan");
        Observer userLi = new ObserverImpl("LiSi");
        Observer userWang = new ObserverImpl("WangWu");

        subject.addObserver(userZhang);
        subject.addObserver(userLi);
        subject.addObserver(userWang);
        subject.publishMessage("PHP是世界上最好用的语言！");

        System.out.println("----------------------------------------------");
        subject.removeObserver(userZhang);
        subject.publishMessage("JAVA是世界上最好用的语言！");
    }

}