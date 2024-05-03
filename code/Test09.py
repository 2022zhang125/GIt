def Func(x):
    if len(x) == 18:
        print("{} 年 {} 月 {} 日".format(x[6:10],x[10:12],x[12:14]))
    else:
        print("身份证号码错误！")

[Func(x) for x in input("请输入ID号用空格进行分割：").split()]

    