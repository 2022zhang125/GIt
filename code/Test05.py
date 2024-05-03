from math import *
data=[int(x) for x in input("请输入x,y,z(中间用空格隔开)").split()]
m=sqrt((3*data[0]+data[1])/data[2])/pow((data[0]*data[1]),4)
print("计算结果为：%.2f"%m)