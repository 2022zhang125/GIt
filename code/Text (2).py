# 提醒用户输入三个整数，通过int()方法将str类型转换成int类型  
number_one = int(input("请输入一个整数"))  
number_two = int(input("请输入一个整数"))  
number_three = int(input("请输入一个整数"))  
# 判断第一个数字是否大于第二个数字  
if number_one > number_two:  
    # 条件成立判断第二个数字是否大于第三个数字  
    if number_two > number_three:  
        print("{}>{}>{}".format(number_one, number_two, number_three))  
    elif number_two < number_three:  
        if number_one > number_three:  
            print("{}>{}>{}".format(number_one, number_three, number_two))  
        elif number_one < number_three:  
            print("{}>{}>{}".format(number_three, number_one, number_two))  
elif number_one < number_two:  
    if number_one > number_three:  
        print("{}>{}>{}".format(number_two, number_one, number_three))  
    elif number_one < number_three:  
        if number_three > number_two:  
            print("{}>{}>{}".format(number_three, number_two, number_one))  
        elif number_three < number_two:  
            print("{}>{}>{}".format(number_two, number_three, number_one))  
# 利用列表的max()函数来比较大小
numbers = []
for i in range(3):
    number = int(input("请输入第{}个整数".format(i+1)))
    numbers.append(number)
print(numbers)
for i in range(len(numbers)):
    max_number = max(numbers)
    print("{}>".format(max_number), end="")
    numbers.remove(max_number)
# 利用sort排序来进行比较
numbers = []
for i in range(3):
    number = int(input("请输入第{}个整数".format(i+1)))
    numbers.append(number)
print(numbers)
numbers.sort(reverse=True)
print("{}>{}>{}".format(numbers[0], numbers[1], numbers[2]))
