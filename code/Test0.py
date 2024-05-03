def Fats(x):
    if len(x)==18:
        print("{}年{}月{}日".format(x[6:10],x[10:12],x[12:14]))
    else:
        print("身份证格式错误")


[Fats(x) for x in input("请输入身份证号码（中间用空格隔开）").split()]