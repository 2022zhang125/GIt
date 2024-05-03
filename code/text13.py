x=int(input("请输入此次里程x="))
if x<6:
    print("票价为3元")
elif x<=12:
    print("票价为4元")
elif x<=32:
    print("票价为{0}元".format( 4+((x-12)//10)))
elif x>32:
    print("票价为{0}元".format( 6+((x-32)//20)))

