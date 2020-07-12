package pre.guanl.demo;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Data
public class BeanDefinition {
    private String id;
    private String className;
    private List<ConstructorArg> constructorArgList = new ArrayList<>();
    private Scope scope = Scope.SINGLETON;
    private boolean lazyInit = false;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<ConstructorArg> getConstructorArgList() {
        return constructorArgList;
    }

    public void setConstructorArgList(List<ConstructorArg> constructorArgList) {
        this.constructorArgList = constructorArgList;
    }

    public Scope getScope() {
        return scope;
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }

    public boolean isLazyInit() {
        return lazyInit;
    }

    public void setLazyInit(boolean lazyInit) {
        this.lazyInit = lazyInit;
    }

    public boolean isSingleton() {
        return scope.equals(Scope.SINGLETON);
    }


    @Data
    public static class ConstructorArg {
        /* 当isRef为true时，type为空，arg为String类型的beanId,
         * 当isRef为false时，type为参数的类型，arg为参数值
         */
        private boolean isRef;
        private Class type;
        private Object arg;

        public boolean isRef() {
            return isRef;
        }

        public void setRef(boolean ref) {
            isRef = ref;
        }

        public Class getType() {
            return type;
        }

        public void setType(Class type) {
            this.type = type;
        }

        public Object getArg() {
            return arg;
        }

        public void setArg(Object arg) {
            this.arg = arg;
        }

        public ConstructorArg(Builder builder) {
            this.isRef = builder.isRef;
            this.type = builder.type;
            this.arg = builder.arg;
        }

        public static class Builder {
            private boolean isRef;
            private Class type;
            private Object arg;

            public ConstructorArg build() {
                if (!isRef && type == null) {
                    throw new RuntimeException("arg type error");
                }
                return new ConstructorArg(this);
            }

            public Builder setRef(boolean isRef) {
                this.isRef = isRef;
                return this;
            }

            public Builder setType(Class type) {
                this.type = type;
                return this;
            }

            public Builder setArg(Object arg) {
                this.arg = arg;
                return this;
            }
        }


    }

    public static enum Scope {
        SINGLETON,
        PROTOTYPE;
    }
}
