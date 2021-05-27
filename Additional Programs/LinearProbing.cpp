#include<stdlib.h>
#include<iostream>
using namespace std;
class HashTable
{
private:
    int size;
    int *H;

public:
    HashTable(int size){
        this->size  = size;
        H = (int *)calloc(size,sizeof(int));
    }
    int hashF(int key){
        return key % size;
    }
    void insert(int key){
        int i = hashF(key);
        for(int j=0;j<size;j++){
            int k = (i+j) % size;
            if(H[k]==0){
                H[k] = key;
                break;
            }
        }
        display();
    }
    void dele(int key){
        int i = search(key);
        if(i!=-1)
            H[i]=0;
        else
            cout<<"Element not present in Hash Table, cannot be deleted" << endl;
    }
    int search(int key){
        int i = hashF(key);
        for(int j=0;j<size;j++){
            int k = (i+j) % size;
            if(H[k]==key)
                return k;
        }
        return -1;
    }
    void display(){
        for(int i=0;i<size;i++){
            cout<< "[ "<< i <<" : "<< H[i] <<" ]"<<endl;
        }
    }
};
int main(int argc, char const *argv[])
{
    int size;
    cout<<"Enter the size of Hash Table" <<endl;
    cin>>size;
    HashTable myTable(size);
    cout << "1.Insert \n 2. Remove \n 3. Search \n 4. Any other to Quit" << endl;
    while (1)
    {
        int choice;
        
        cin >> choice;
        switch (choice)
        {
        case 1:
            int ele;
            cin >> ele;
            myTable.insert(ele);
            break;
        case 2:
            cin >> ele;
            myTable.dele(ele);
            break;
        case 3:
            cin >> ele;
            if (myTable.search(ele) != -1)
                cout << "Found" << endl;
            else
                cout << "Not Found <<endl";
            break;
        default:
            exit(0);
        }
    }
    return 0;
}
