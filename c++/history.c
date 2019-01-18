// Solution to the problem of history-based filtering of a string
// O(n)
// Problem: Filtering a string according to the history i.e. when a char has been seen before in that string
// The size of the history can vary but we want to have O(n) complexity
// There is also a brute force solution with a time complexitity of O(size*history_size) and space complexity O(history_size)

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char* argv[]) {
  if (argc < 2) {
    printf("Please provide a source string\n");
    return -1;
  }
  
  size_t size = 128;
  
  char* source = malloc(size);
  char* destination = malloc(size);
  
  memset(source, 0, size);
  memset(destination, 0, size);
  
  strcpy(source, argv[1]);
  
  filter(source, destination, strlen(source), 3);
}

struct history_entry {
  int count;
};

int filter(const void* source, void* dest, size_t size, size_t history_size) {
  char* s = (char*)source;
  char* d = (char*)dest;

  // 128 ASCII Chars, although the real size of the array could be less
  struct history_entry* char_history = (struct history_entry*)malloc(128 * sizeof(struct history_entry));
  
  int dest_index = 0;
  int copied_chars = 0;
  
  char* next_to_eject = NULL;
  
  int current_hist_size = 0;
  
  for (int j = 0; j < size; j++) {
    if ( (s[j] >= 'a' && s[j] <= 'z') ||
         (s[j] >= 'A' && s[j] <= 'Z') ||
         (s[j] >= '0' && s[j] <= '9') ) {
      
      if (history_size == 0) {
         d[dest_index++] = s[j];
         copied_chars++;
      }
      else {
       
       if (next_to_eject == NULL) {
        // Pointer to the next char to eject
        next_to_eject = s + j;        
       }
       
       // Only if the char is not in history is copied
       if (char_history[s[j]].count == 0) {
         d[dest_index++] = s[j];
         copied_chars++;
       }
       
       // Increase the corresponding char presence
       char_history[s[j]].count++;
       current_hist_size++;
        
       if (current_hist_size > history_size) {
         // We need to eject the current one (decreasing)
         char_history[*next_to_eject].count--;
         next_to_eject++;
       } 
      }
    }
  }

  printf("%s\n", d);
  
  return copied_chars;
}
