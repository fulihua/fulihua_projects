#!/bin/bash
echo "请输入您的姓名:"
read name
echo "您好，$name!欢迎来到游戏世界!"
number=$( jot -r 1 1 10)
echo $number
while true
do
echo "请输入一个1-10之间的数字"
read guess
if [[ $guess -eq $number ]]; then
echo "恭喜您猜对了！是否要继续？（y/n）:"
read choice
if [[ $choice = "y" ]] || [[ $choice = "Y" ]]; then
number=$((RANDOM % 10 + 1))
echo number
continue
else
break
fi
elif [[ $guess -lt $number ]]; then
echo "猜小了"
else 
echo "猜大了"
fi
done
