项目前提：
    该项目是用Servlet+Jsp+Mybatis通过MVC架构实现的部门管理系统项目。
包结构：

java
    com
        hbsfdxwlxy
            managed
                mapper ---- M（Mapping）对象映射接口
                pojo   ---- O（Object）对象，普通的Java容器
                utils  ---- MyBatis工具类，用于控制项目的SqlSession的创建和销毁
resources
    DeptMapper.xml ---- Dept 部门关系映射
    UserMapper.xml ---- User 用户关系映射
    logback.xml ---- logback日志的配置文件
    mybatis-config.xml ---- R（Rational）mybatis的核心配置文件，关系映射

注意：
    当我们在select username,password from t_user where username=#{username} and password=#{password};
    的时候，由于我们的mapper接口中使用的是
    Boolean selectUser(String username, String password);
    会导致，Mybatis实际上不能接受到我们的username和password
    所以在此时，需要我们手动指定
    Boolean selectUser(@Param("username") String username, @Param("password") String password);
    这样就可以解决BindException异常。