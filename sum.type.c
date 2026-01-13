

#include <stdio.h>
#include <time.h>

int main() {
    char text[] = "Many people today rely on mobile devices for typing.";
    char input[100];
    int i, correct = 0;
    
    printf("Type this text:\n");
    printf("%s\n", text);
    printf("Press Enter to start...");
    getchar();
    
    time_t start = time(NULL);
    printf("Start typing: ");
    scanf("%99[^\n]", input);
    time_t end = time(NULL);
    
    float timeUsed = difftime(end, start);
    
    for(i = 0; text[i] != '\0' && input[i] != '\0'; i++) {
        if(text[i] == input[i]) {
            correct++;
        }
    }
    
    printf("\nResults:\n");
    printf("Time: %.1f seconds\n", timeUsed);
    printf("Correct: %d/%d\n", correct, i);
    printf("Accuracy: %.1f%%\n", (float)correct/i*100);
    
    return 0;
}

