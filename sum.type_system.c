#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <direct.h>
#include <windows.h>  // 添加Windows头文件

// ==================== 文件管理模块 ====================

// 使用你原始代码中的练习文本内容
char *practiceContents[] = {
    // 英文短语1
    "Success is not final, failure is not fatal. "
    "It is the courage to continue that counts.",
    
    // 英文短语2
    "The only way to do great work is to love what you do. "
    "If you haven't found it yet, keep looking.",
    
    // 英文短语3
    "Life is like riding a bicycle. To keep your balance, "
    "you must keep moving forward.",
    
    // 英文短语4
    "The future belongs to those who believe in the "
    "beauty of their dreams.",
    
    // 英文短语5
    "Programming is not about typing, it's about thinking. "
    "Practice makes perfect."
};

// 练习文件的描述信息（根据你原始代码中的描述）
char *practiceTitles[] = {
    "励志名言",
    "工作哲学", 
    "生活哲理",
    "梦想格言",
    "编程箴言"
};

int practiceCount = 5;  // 练习文件总数

// 1. 检查并创建练习文件（修改版，实际创建文件）
void createPracticeFiles() {
    FILE *fp;
    char filename[20];
    
    printf("\n正在检查练习文件...\n");
    
    for (int i = 0; i < practiceCount; i++) {
        // 生成文件名：1.txt, 2.txt, 3.txt...
        sprintf(filename, "%d.txt", i + 1);
        
        // 尝试打开文件，如果不存在则创建
        fp = fopen(filename, "r");
        if (fp == NULL) {
            // 文件不存在，创建它
            fp = fopen(filename, "w");
            if (fp != NULL) {
                fprintf(fp, "%s", practiceContents[i]);
                fclose(fp);
                printf(" 创建文件: %s - %s\n", filename, practiceTitles[i]);
            } else {
                printf(" 创建文件失败: %s\n", filename);
            }
        } else {
            fclose(fp);
            printf(" 文件已存在: %s - %s\n", filename, practiceTitles[i]);
        }
    }
    
    printf("\n所有练习文件都已准备就绪！\n");
}

// 2. 显示所有练习文件列表
void showFileList() {
    printf("\n========== 练习文件列表 ==========\n");
    for (int i = 0; i < practiceCount; i++) {
        printf("%d. %s.txt - %s\n", i + 1, practiceTitles[i], practiceTitles[i]);
        
        // 显示文件内容预览（前60个字符）
        char preview[70];
        strncpy(preview, practiceContents[i], 60);
        preview[60] = '\0';
        if (strlen(practiceContents[i]) > 60) {
            strcat(preview, "...");
        }
        printf("   内容: %s\n", preview);
        
        // 显示字符数
        printf("   字符数: %d\n\n", (int)strlen(practiceContents[i]));
    }
    printf("===================================\n");
}

// 3. 读取练习文件内容
char* getPracticeContent(int fileNum) {
    static char content[500];  // 使用静态变量，确保内容在函数返回后仍然有效
    
    // 检查文件编号是否有效
    if (fileNum < 1 || fileNum > practiceCount) {
        printf("错误：文件编号 %d 无效！\n", fileNum);
        return NULL;
    }
    
    // 方法1：从预置内容直接获取（简单方式）
    strcpy(content, practiceContents[fileNum - 1]);
    
    return content;
}

