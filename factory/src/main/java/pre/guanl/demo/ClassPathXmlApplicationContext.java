package pre.guanl.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ClassPathXmlApplicationContext implements ApplicationContext {
    private BeanFactory beanFactory;
    private BeanConfigParser beanConfigParser;

    public ClassPathXmlApplicationContext(String configLocation) {
        this.beanFactory = new BeanFactory();
        this.beanConfigParser = new XmlBeanConfigParser();
        loadBeanDefinitions(configLocation);
    }

    private void loadBeanDefinitions(String configLocation) {
        InputStream in = null;
        try {
            in = this.getClass().getResourceAsStream("/" + configLocation);
            if (in == null) {
                throw new RuntimeException("file is not exists");
            }
            List<BeanDefinition> beanDefinitionList = beanConfigParser.parse(in);
            beanFactory.addBeanDefinition(beanDefinitionList);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    // 获取bean
    public Object getBean(String beanId) {
        return beanFactory.getBean(beanId);
    }
}
