
sum=int(input("请输入一个三位数："))
c=sum%10
b=int(sum/10)%10
a=int(sum/100)
sum=a+b*10+c*100
print(sum)
