x=int(input("输入消费金额x:"))
if x<1000:
   y=x
   print("付款金额y=",y)  
elif x<2000:
   y=0.9*x
   print("付款金额y=",y)
elif x<3000:
   y=0.8*x
   print("付款金额y=",y)
elif x>=3000:
    y=0.7*x
    print("付款金额y=",y)