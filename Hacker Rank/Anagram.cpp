#include <cctype>
#include <iostream>
#include <cstring>
#include <string>
#include <sstream>
#include <vector>
#include <unordered_set>
#include <unordered_map>
#include <algorithm>
 
using namespace std;
 
// Time complexity: O(n * mlogm), where n = no of words, m = len of longest word
 
int main() {
    string s;
    getline(cin, s);
 
    // step - 1: anagrams are not case sensitive, so make the string lowercase
    transform(s.begin(), s.end(), s.begin(), ::tolower);
    
    // step - 2: tokenize the string
    stringstream ss(s);
 
    string word;
    vector<string> words;
    while(getline(ss, word, ' ')) {
        // removes punctuations
        if (!isalpha(word.back())) {
            words.push_back(word.substr(0, word.size()-1));
        } else {
            words.push_back(word);
        }
    }
 
    // step-3:
    // if 2 words are anagrams, if we sort both of them they look same
    // so, store sorted word, its anagrams in hashmap
    unordered_map<string, unordered_set<string> > anagrams;
    for (string word : words) {
        // get sorted word of the cur word
        string sorted_word = word;
        sort(sorted_word.begin(), sorted_word.end());
 
        // check whether it is already in dict, if yes add this word orelse create new
        if (anagrams.find(sorted_word) == anagrams.end()) {
            anagrams[sorted_word] = {word};
        } else {
            anagrams[sorted_word].insert(word);
        }
    }
 
    // step - 4: print anagrams
    for (auto i = anagrams.begin(); i != anagrams.end(); i++) {
        if((i->second).size() == 1) {
            continue;
        }
        for(auto ana : i->second) {
            cout << ana << " ";
        }
        cout << endl;
    }
 
}
