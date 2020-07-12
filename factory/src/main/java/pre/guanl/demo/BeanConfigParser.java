package pre.guanl.demo;

import java.io.InputStream;
import java.util.List;

public interface BeanConfigParser {

    List<BeanDefinition> parse(InputStream in);

    List<BeanDefinition> parse(String content);
}
