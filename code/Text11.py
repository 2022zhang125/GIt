from math import*
Q=[int(x) for x in input("输入a,b,c的值").spilt()]
deta=pow(Q[1],2)-4*Q[0]*Q[2]
if deta<0:
    print("无实数根")
elif deta==0:
    x=(-1*Q[1]-sqrt(deta))/(2*Q[0])
    print("有两个相同的实数,x="x)
elif deta>0:
    x1=(-1*Q[1]-sqrt(deta))/(2*Q[0]) 
    x2=(Q[1]-sqrt(deta))/(2*Q[0])
print("有两个不同的实数根，x1=%f,x2=%f"%(x1,x2))
 


 


    
