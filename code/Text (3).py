s=int(input("请输入鸡兔总数:"))
t=int(input("请输入腿的个数:"))
tu=int((t-s*2)/2)
ji=int(s-tu)
if ((t-s*2)%2)==0 and tu>0:               #腿总数不能为奇数,腿的个数大于0
    print('鸡有'+str(ji)+'个','兔有'+str(tu)+'个')
else:
    print("输入数据不正确")
