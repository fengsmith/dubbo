Spring 在解析 xml 文件的时候会发现陌生的 dubbo <dubbo/> 标签,在 xml 文件中 spring 会找到引入的 dubbo xmlns:dubbo="http://code.alibabatech.com/schema/dubbo" 文件,然后META-INF下的spring.handlers文件中指定了dubbo的xml解析类：DubboNamespaceHandler。像前面的被解析成ServiceConfig，被解析成ReferenceConfig等等。

当 DubboNamespaceHandler 会指定哪个标签由哪个解析类最终解析成哪种 Java 对象。所有的标签都是由 DubboBeanDefinitionParser 去解析,把所有的 dubbo xml 标签解析完毕以后,