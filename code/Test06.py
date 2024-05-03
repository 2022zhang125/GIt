from math import *
data=input("请输入x,y:").split()
data=[ int(x) for x in data]
m=sin(radians(45))+(((exp(10)+log(10)))/sqrt(data[0]+data[1]+1))
print("m= %.2f"%m)