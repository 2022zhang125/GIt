#输入a,b,c的值
a=float(input("输入a:"))
b=float(input("输入b:"))
c=float(input("输入c:"))
#计算delta
delta=b**2-4*a*c
#判断解的个数
if delta>0:
    x1 = (b + delta ** 0.5) / (-2 * a)
    x2 = (b - delta ** 0.5) / (-2 * a)
    print("x1=", x1)
    print("x2=", x2)
elif delta==0:
       x=b/-2*a
       print("x1=x2=",x)
#计算x1，x2
elif delta<0:
    print("方程无解!")
