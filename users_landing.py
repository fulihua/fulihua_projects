import random
print("先注册：")
account = input("请输入要注册的用户名")
password = input("请输入要注册的密码")
print("注册成功，接下来登录")
acc = input("请输入用户名")
pwd = input("请输入密码")
if account == acc and password == pwd:
	security_code = str(random.randint(1000,9999))
	print("您收到的验证码为：%s"%security_code)
	input_code = input("请输入你收到的验证码")
	if security_code == input_code:
		print("登录成功")
	else:
		print("，验证码有误，请一分钟后再试")
else:
	print("用户名或密码有误")
 
