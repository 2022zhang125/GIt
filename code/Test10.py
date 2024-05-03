def verification(username,userpwd):
    if(username == "张三" and userpwd == "123"):
        return True;
    else:
        return False;


userList = [str(x) for x in input("请输入您的用户名和密码：").split()]
username = userList[0]
userpwd = userList[1]
successFlag = verification(username,userpwd)
print("登录成功" if successFlag else "登录失败")