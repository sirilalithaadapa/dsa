#define MAX 20
#include<stdlib.h>
#include<iostream>
using namespace std;

struct Node
{
 int data;
 struct Node *left,*right;
};

class BST_NR
{
  public:
	  Node * insert(Node *,int);
	  void inorder_nr(Node *);
	  void preorder_nr(Node *);
	  void postorder_nr(Node *);
	  
};

  Node * BST_NR :: insert(Node *t,int x)
  {
    if(t==NULL)
    {
      t = (struct Node *) malloc (sizeof(struct Node));
      t->data = x;
      t->left= t->right = NULL;
      return t;
    }
    else
    if(x < t->data)
    {
      t->left = insert(t->left,x);
    }
    else
    if(x > t->data)
      t->right= insert(t->right,x);
    else
   	cout<<"\n Data already exists...!";
   
    return t;
  }

 void BST_NR :: inorder_nr(Node *t)
 {
	Node *stk[MAX];
	Node *temp;

	int top = 0;
	temp = t; // Assign root (t) to temp

	while(1)
	{
		while(temp!=NULL)
		{
		  stk[++top] = temp;
		  temp = temp->left;
		}
		if(top>0)
		{
			temp = stk[top--];
			
			cout<<temp->data<<"  ";
			temp = temp->right;
		}
		else
			return;	
	}
    
 }

 void BST_NR :: preorder_nr(Node *t)  
 {
 	Node *stk[MAX];
	int top = 0;
	Node *temp;

	temp = t; // assign root to temp

	while(1)
	{
		while(temp!=NULL) // wil be continued till no further left node.
		{
			cout<<temp->data<<"  ";
			stk[++top] = temp;
			temp = temp->left;
		}
		if(top>0)
		{
			temp = stk[top--];
			if(temp->right!=NULL)
				temp = temp->right;
			else	
			  temp = NULL;
		}
		else
			return;
	}
 }

 void BST_NR :: postorder_nr(Node *t)
 {
  Node *temp;
	Node *stk1[MAX], *stk2[MAX];
	int top1, top2;

	top1 = top2 = 0;

	temp = t;  //Assign root to temp;

	stk1[++top1] = temp;

	while(top1>0)
	{		
		temp = stk1[top1--];
		stk2[++top2] = temp;
		if(temp->left!=NULL)
			stk1[++top1] = temp->left;
		if(temp->right!=NULL)
			stk1[++top1] = temp->right;
	}

	while(top2>0)
	{
		temp = stk2[top2--];
		cout<<temp->data<<"  ";
	}
  }

  int main()
  {

	BST_NR obj;
	int a[8]= { 4,5,7,6,3,2,9,1};

	Node *root = NULL;
	
	for(int i=0;i<8;i++)
		root = obj.insert(root,a[i]);

	cout<<"\n The non recursive Inorder is...\n\n";		
	obj.inorder_nr(root);		
	   
	cout<<"\n\n The non recursive Preorder is...\n\n";		
	obj.preorder_nr(root);
	
	cout<<"\n\n The non recursive Postorder is...\n\n";		
	obj.postorder_nr(root);
        return 0;
 }
