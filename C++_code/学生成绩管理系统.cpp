#include <iostream>
#include <string>
#include <iomanip>
#include <vector>
#include <algorithm>
#include <fstream>
using namespace std;

class Student
{
private:
    string id, name;
    double chinese, math, english;
    double sum, ave;

public:

      Student(): id(""), name(""), chinese(0), math(0), english(0) {        calc();}
    Student(string i, string n, double c, double m, double e) : id(i), name(n), chinese(c), math(m), english(e)
    {
        calc();
    }

    friend ostream& operator<<(ostream& out,const Student& stu);
    friend istream& operator>>(istream& in,Student& stu);
    friend ofstream& operator<<(ofstream& ofs, const Student& stu);
    friend ifstream& operator>>(ifstream& ifs, Student& stu);
  
    string getId() const { return id; }
    string getName() const { return name; }
    double getChinese() const { return chinese; }
    double getMath() const { return math; }
    double getEnglish() const { return english; }
    double getSum() const { return sum; }
    double getAve() const { return ave; }

    
    void calc()
    {
        sum = chinese + math + english;
        ave = sum / 3.0;
    }
    bool setChinese(double c)
    {
        if (c < 0 || c > 100)
        {
            return false;
        }
        else
        {
            this->chinese = c;
            calc();
        }
        return true;
    }

    bool setMath(double m)
    {
        if (m < 0 || m > 100)
        {
            return false;
        }
        else
        {
            this->math = m;
            calc();
        }
         return true;
    }

    bool setEnglish(double e)
    {
        if (e < 0 || e > 100)
        {
            return false;
        }
        else
        {
            this->english = e;
            calc();
        }
         return true;
    }

     
};
    ostream& operator<<(ostream& out,const Student& stu){
        out<<left<<setw(12)<<stu.getId()<<setw(8)<<stu.getName()<<setw(6)<<stu.getChinese()<<setw(6)<<stu.getMath()<<setw(6)<<stu.getEnglish()<<setw(6)<<stu.getSum()
        <<fixed<<setprecision(2)<<setw(8)<<stu.getAve();
        return out;
}

    std::ofstream& operator<<(std::ofstream& ofs, const Student& s)
{
    ofs << s.id << " " << s.name << " " << s.chinese << " " << s.math << " " << s.english;
    return ofs;
}

    istream& operator>>(istream& in,Student& stu){
        in>>stu.id>>stu.name>>stu.chinese>>stu.math>>stu.english;
        stu.calc();
        return in;
    }

    std::ifstream& operator>>(std::ifstream& ifs, Student& s)
{
    ifs >> s.id >> s.name >> s.chinese >> s.math>>s.english;
    s.calc();
    return ifs;
}

    struct CmTotalScore{
        bool operator()(const Student& a,const Student& b)const{
            return a.getSum()>b.getSum();
        }
    };
    struct CmAveScore{
        bool operator()(const Student& a,const Student& b)const{
            return a.getAve()<b.getAve();
        }
    };
class repeatException
{
public:
    string what() const
    {
        return "禁止录入重复学号！";
    }

};

template<typename T>
class DataManager{
    private:
    std::vector<T> data;
    std::string filePath;  
    public:
     explicit DataManager(std::string path) : filePath(std::move(path)) {}

    void add(const T& elem){
       auto it = findElem([&elem](const T& s) {
            return s.getId() == elem.getId();
        });
        if (it != data.end())
        {
            throw repeatException();
        }
        data.push_back(elem);
    }
    void showAll()const{
        for(const auto& item:data){
            std::cout<<item<<endl;
        }
    }
    template<typename Pred>
    auto findElem(Pred pred)
    {
        return std::find_if(data.begin(), data.end(), pred);
    }
    template<typename Pred>
    void deleteElem(Pred pred)
    {
        auto newEnd = std::remove_if(data.begin(), data.end(), pred);
        data.erase(newEnd, data.end());
    }
     template<typename Cmp>
    void sortData(Cmp cmp)
    {
        std::sort(data.begin(), data.end(), cmp);
    }

    bool saveToFile()
    {
        std::ofstream ofs(filePath);
        if (!ofs.is_open())
        {
            std::cout << "保存失败：无法打开写入文件 " << filePath << "\n";
            return false;
        }
        for (const auto& item : data)
        {
            ofs << item << "\n";
        }
        ofs.close();
        std::cout << "手动保存成功！\n";
        return true;
    }

    bool loadFromFile()
    {
        std::ifstream ifs(filePath);
        if (!ifs.is_open())
        {
            
            std::cout << "提示：文件" << filePath << "不存在，未加载任何数据\n";
            return false;
        }

        data.clear();
        T tmp;
        while (ifs >> tmp)
        {
            data.push_back(tmp);
        }
        ifs.close();
        std::cout << "手动加载成功！\n";
        return true;
    }

    ~DataManager()
    {
        std::cout << "\n程序即将退出，执行自动保存...\n";
        saveToFile();
    }


     auto begin() { return data.begin(); }
    auto end() { return data.end(); }
    bool empty() const { return data.empty(); }

};

int main(){
    const std::string filename = "stu.txt"; // 文件名同步改成stu.txt
    DataManager<Student> stuMgr(filename);

    char op;
    while (true)
    {
        cout << "\n=======学生成绩管理系统=======\n";
        cout << "1. 单个新增学生\n";
        cout << "2. 批量录入学生\n";
        cout << "3. 浏览全部学生信息\n";
        cout << "4. 按学号查询学生\n";
        cout << "5. 修改学生单科成绩\n";
        cout << "6. 按学号删除学生\n";
        cout << "7. 总分降序排序\n";
        cout << "8. 平均分升序排序\n";
        cout << "9. 班级成绩综合统计\n";
        cout << "A. 手动保存数据(stu.txt)\n";
        cout << "B. 手动加载数据(stu.txt)\n";
        cout << "0. 退出系统(自动保存)\n";
        cout << "==============================\n";
        cout << "请输入操作选项：";
        cin >> op;

        if(op == '0')
        {
            cout << "准备退出系统，触发自动保存\n";
            break;
        }
        else if(op == '1')
        {
            // 1 单个新增
            Student s;
            cout << "输入学号 姓名 语文 数学 英语：";
            cin >> s;
            try
            {
                stuMgr.add(s);
                cout << "单个学生新增完成！\n";
            }
            catch (const repeatException& e)
            {
                cout << e.what() << endl;
            }
        }
        else if(op == '2')
        {
            // 2 批量录入
            int n;
            cout << "请输入批量录入人数：";
            cin >> n;
            for(int i = 0; i < n; ++i)
            {
                cout << "第" << i+1 << "个学生：学号 姓名 语文 数学 英语：";
                Student s;
                cin >> s;
                try
                {
                    stuMgr.add(s);
                    cout << "录入成功\n";
                }
                catch (const repeatException& e)
                {
                    cout << e.what() << "，本条跳过\n";
                }
            }
        }
        else if(op == '3')
        {
            // 3 浏览全部
            cout << left
                 << setw(12) << "学号"
                 << setw(8)  << "姓名"
                 << setw(6)  << "语文"
                 << setw(6)  << "数学"
                 << setw(6)  << "英语"
                 << setw(6)  << "总分"
                 << setw(8)  << "平均分"
                 << endl;
            stuMgr.showAll();
        }
        else if(op == '4')
        {
            // 4 按学号查询
            string tarId;
            cout << "请输入要查询的学号：";
            cin >> tarId;
            auto it = stuMgr.findElem([&tarId](const Student& s){
                return s.getId() == tarId;
            });
            if(it != stuMgr.end())
            {
                cout << left
                     << setw(12) << "学号"
                     << setw(8)  << "姓名"
                     << setw(6)  << "语文"
                     << setw(6)  << "数学"
                     << setw(6)  << "英语"
                     << setw(6)  << "总分"
                     << setw(8)  << "平均分"
                     << endl;
                cout << *it << endl;
            }
            else
            {
                cout << "未找到该学号学生！\n";
            }
        }
        else if(op == '5')
        {
            // 5 修改单科成绩
            string tarId;
            cout << "输入待修改学生学号：";
            cin >> tarId;
            auto it = stuMgr.findElem([&tarId](const Student& s){
                return s.getId() == tarId;
            });
            if(it == stuMgr.end())
            {
                cout << "无此学生！\n";
                continue;
            }
            int subOpt;
            double score;
            cout << "1-语文  2-数学  3-英语\n请选择要修改的科目：";
            cin >> subOpt;
            cout << "输入新成绩：";
            cin >> score;
            bool ok = false;
            if(subOpt == 1) ok = it->setChinese(score);
            else if(subOpt == 2) ok = it->setMath(score);
            else if(subOpt == 3) ok = it->setEnglish(score);
            else
            {
                cout << "科目选择错误！\n";
                continue;
            }
            if(ok) cout << "成绩修改成功！\n";
            else cout << "成绩非法(0~100)，修改失败！\n";
        }
        else if(op == '6')
        {
            // 6 按学号删除
            string tarId;
            cout << "输入要删除的学生学号：";
            cin >> tarId;
            stuMgr.deleteElem([&tarId](const Student& s){
                return s.getId() == tarId;
            });
            cout << "删除操作执行完毕\n";
        }
        else if(op == '7')
        {
            //7 总分降序
            stuMgr.sortData(CmTotalScore());
            cout << "已按总分降序排序完成\n";
        }
        else if(op == '8')
        {
            //8 平均分升序
            stuMgr.sortData(CmAveScore());
            cout << "已按平均分升序排序完成\n";
        }
         else if (op == '9')
        {
            if (stuMgr.empty())
            {
                cout << "暂无学生数据，无法统计！\n";
                continue;
            }
            int totalCnt = 0;

            // 语文统计变量
            double chSum = 0, chMax = 0, chMin = 100;
            int chFail = 0;
            // 数学统计变量
            double mtSum = 0, mtMax = 0, mtMin = 100;
            int mtFail = 0;
            // 英语统计变量
            double enSum = 0, enMax = 0, enMin = 100;
            int enFail = 0;

            for (auto it = stuMgr.begin(); it != stuMgr.end(); ++it)
            {
                totalCnt++;
                double c = it->getChinese();
                double m = it->getMath();
                double e = it->getEnglish();

                // 语文
                chSum += c;
                if (c > chMax) chMax = c;
                if (c < chMin) chMin = c;
                if (c < 60) chFail++;

                // 数学
                mtSum += m;
                if (m > mtMax) mtMax = m;
                if (m < mtMin) mtMin = m;
                if (m < 60) mtFail++;

                // 英语
                enSum += e;
                if (e > enMax) enMax = e;
                if (e < enMin) enMin = e;
                if (e < 60) enFail++;
            }

            cout << "\n==========班级单科成绩统计汇总==========\n";
            cout << fixed << setprecision(2);
            cout << "总人数：" << totalCnt << "\n\n";

            cout << "【语文】\n";
            cout << "平均分：" << chSum / totalCnt << "  最高分：" << chMax
                 << "  最低分：" << chMin << "  不及格人数：" << chFail << "\n\n";

            cout << "【数学】\n";
            cout << "平均分：" << mtSum / totalCnt << "  最高分：" << mtMax
                 << "  最低分：" << mtMin << "  不及格人数：" << mtFail << "\n\n";

            cout << "【英语】\n";
            cout << "平均分：" << enSum / totalCnt << "  最高分：" << enMax
                 << "  最低分：" << enMin << "  不及格人数：" << enFail << "\n";
        }
        else if(op == 'A' || op == 'a')
        {
            //A 手动保存
            stuMgr.saveToFile();
        }
        else if(op == 'B' || op == 'b')
        {
            //B 手动加载
            stuMgr.loadFromFile();
        }
        else
        {
            cout << "输入选项无效，请重新选择！\n";
        }
    }

    cout << "主函数执行结束\n";
    return 0;
}