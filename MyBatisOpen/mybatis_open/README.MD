第一个MyBatis程序，Navicat表为mybatis/t_student

    第一步：打包方式为jar
    第二步：添加依赖，mysql依赖和mybatis依赖
    第三步：创建mybatis核心xml文件,并修改对应的信息
        mybatis-config.xml
    第四步：创建XxxxMapper.xml文件，用于处理sql语句的执行，且让mybatis的核心文件指向该文件
        在创建StudentMapper.xml中，需要给定SQL的ID，用于唯一标识该SQL语句
    第五步：编写mybatis程序，执行SQL语句
        需要先创建SqlSessionFactoryBuilder,然后通过其build方法创建SqlSessionFactory,最后通过openSession()去创建SqlSession对象1

小细节：

    * MyBatis的SQL语句，分号结尾可以不加。
    * Resources.getResourcesAsStream,以后凡是有Resource这个单词，大部分情况下都是从类的根路径上去查找。
    * 除了使用Resources.getResourceAsStream以外，也可以使用JVM自带的类加载器ClassLoader,让其在类加载的时候使用ClassLoader.getSystemClassLoader()
        去获取系统类加载器，然后再调用其getResourceAsStream去定位到mybatis-config.xml文件
    InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml");
    获取系统类加载器，然后通过getResourceAsStream()从类路径当中加载资源

由Resources工具类调用的getResourceAsStream()方法的底层就是包装了ClassLoader.getSystemClassLoader().getResourceAsStream()方法

关于MyBatis的事务管理机制：

    在mybatis-config.xml文件中 <transactionManager type="JDBC"/> 规定了事务的提交方式
    其中type后可以跟两个值，JDBC/MAMAGED(managed) 大小写都可。
        1.type = JDBC
            表示是用mybatis框架采用原生的JDBC事务管理机制
                conn.setAutoCommit(flase); 开启事务
                业务逻辑....
                conn.commit() 提交事务
        2.type = MANAGED
            表示mybatis框架不再去管理业务的提交逻辑，全权交给第三方容器去管理，如Spring
            如果项目中没有第三方容器的话，就表示没有人去管理事务了。
            在后期的SMM中是用MANAGED让spring去管理事务。
                注意：如果我们使用了MANAGED的类型，但是我们没有第三方容器去管理事务，就会导致没有事务，也就是说，setAutoCommit(true)
                那么此时的事务就是自动提交的，及时我们的openSession()没有加上true,他也自动提交。
    只要我们调用sqlSession.openSession()方法的时候，底层就自动开启事务了，conn.setAutoCommit(false);

MyBatis的自动事务提交机制

    在代码中我们调用sqlSession.openSession()时，可以传递一个boolean类型的参数，当我们不添加这个参数时，默认为false也就是开启了手动提交
    机制，因此我们在最后需要使用commit()方法进行提交操作。
    
    // 这种方式是不建议的，因为没有开启事务
    如果我们sqlSession.openSession(true)时，底层的判断 if(conn.getAutoCommit() != true) 为flase，那么此时的代码就进行自动提交机制
    我们也就不需要再进行手动提交了。

重点：
        
    只要我们的autoCommit为true时，就表示没有开启事务，也就是会自动提交
    只要我们的autoCommit为false时，就表示手动开启了事务，需要手动commit()

关于Mybatis集成日志组件，只有那个STDOUT_LOGGING

    在MyBatis的核心配置文件中使用<setting name="logImpl" value="STDOUT_LOGGING"/>的标签去开启MyBatis自己集成的日志。
        其中的value的选择有很多，name为logImpl

        value: SLF4J(酸辣粉4斤),LOG4J,LOG4J2,STDOUT_LOGGING
        其中的SLF4J是一个日志标准，其中有个矿建叫logback实现了SLF4J规范。
        
        注意：LOG4J,LOG4J2,和LOGBACK都是同一个作者。
    其中的STDOUT_LOGGING是标准日志，MyBatis已经实现了，只要开启即可。
    怎么开启？
        在settings标签中使用setting标签开启即可。

    <settings>
        <setting name="logImpl" value="STDOUT_LOGGING"/>
    </settings>
    这个标签应该在environments之前，不需要记忆，只需要遵循dtd文件的约束即可。

第三方log组件去代替MyBatis原有组件（logback）

    这个logback实现了slf4j标准。
    第一步：引入logback依赖

        <!--Logback依赖-->
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>1.2.11</version>
        </dependency>
    第二步：引入logback必须的xml文件
        其中这个文件名必须是：logback.xml或者是logback-test.xml，不能是其他的名字！！！！。
        这个配置文件必须放在类的根路径下，不能是其他的位置。
    如果没有指定MyBatis的setting，框架会自动查找使用第三方日志。

    注意：高版本的logback，在没有指定setting的时候，是不会起作用的，需要指定value值为SLF4J才可以
    我们这里使用的是1.2.11和1.4.14中，前者不需要指定setting格式，而后者则需要指定
    