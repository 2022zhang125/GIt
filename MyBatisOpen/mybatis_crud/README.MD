1.使用MyBatis去完成CRUD

    C:Create    增
    R:Retrieve  查
    U:Update    改
    D:Delete    删

2.先实现Insert
    
    <insert id="insertStu">
        insert into t_student (id,name,xh,sex) values (null,"赵六","3003",'F');
    </insert>
    
    在JDBC中我们使用SQL语句是：
        String sql = "insert into t_student (id,name,xh,sex) values (null,?,？,?);";
        ps.setString()
        ....
    那么我们在MyBatis中怎么去使用占位符?
        这里我们的占位符为 #{} 等效于JDBC中的 ？

    创建一个pojo类，其中包含了表内各字段，在需要进行SQL语句的时候，将其创建并传值
    再创建一个Map类，用于存放pojo对象，让key去指向我们的实例化的类
    当我们在配置文件中，使用#{}其中跟着我们openSession(String ID,Object obj)传进来的Map集合，用我们的key去定位到我们的pojo实例化类
    再通过 . 去访问其实例化的属性，最后将其commit到数据库表中。