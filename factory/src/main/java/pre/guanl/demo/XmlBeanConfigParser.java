package pre.guanl.demo;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XmlBeanConfigParser implements BeanConfigParser {

    public List<BeanDefinition> parse(InputStream in) {
        String content = null;
        // todo: 解析in，赋值给content
        return parse(content);
    }

    public List<BeanDefinition> parse(String content) {
        List<BeanDefinition> beanDefinitions = new ArrayList<>();
        // todo:解析content，生成beanDefinitions
        return beanDefinitions;
    }
}
