from math import *
a=int(input("请输入该三角形的第一条边："))
b=int(input("请输入该三角形的第二条边："))
c=int(input("请输入该三角形的第三条边："))
p=(a+b+c)/2
s=sqrt(p*(p-a)*(p-b)*(p-c))
print("该三角形的面积是：%.2f"%s)
