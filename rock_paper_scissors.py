import random
i=0
while i <= 10:
	cmp_num = random.randint(0,2)
	print("计算机准备完毕")
	your_num = int(input("该你了 0：石头 1：剪刀 2：布\n"))
	if your_num == cmp_num:
		print("势均力敌")
	elif (your_num == 0 and cmp_num == 1) or (your_num == 1 and cmp_num ==2)or (your_num ==2 and cmp_num == 0):
		print("你赢了")
	else:
		print("你输了")
	i += 1
