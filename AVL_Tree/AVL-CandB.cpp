/******************************************************************************

                              Online C++ Compiler.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/
#include<stdlib.h>
#include <iostream>
using namespace std;

/*  In C, everything in a structure is by default, public.
    In Java, everything in a class is by default, default.
    In C++, everything in a class is by default, private

 class Node  // Like 'C', we can make use of structures (struct Node)
{
	public:		
		int data;
		int height;
		Node *left, *right;
		Node(int data)
		{		
			this->data = data;
			left = right = NULL;
		}
}; 

*/


struct Node // Self referential structure.
{
	int data;
	int height;
	struct 	Node *left, *right;
};



class AVLTreeADT
{
	public:
		struct Node * insert(struct Node *, int);	// to insert one node at a time into AVL Tree
		struct Node * remove(struct Node *, int); 	// to remove one node at a time from AVL tree
		struct Node * search(struct Node *, int);	// to find whether a specific data is present or not
		struct Node * LL(struct Node *);		// Single rotation (left to the left)
		struct Node * RR(struct Node *);		// Single rotation(right to the right)
		struct Node * LR(struct Node *);		// Double rotation(Right to the left)
		struct Node * RL(struct Node *);		// Double rotation(Left to the right)
		int height(struct Node *);		// to find the height of the node given
		void printTree(struct Node *,int);		// to display the tree structure
		void inorder(struct Node *);		// Tree traversals
		void preorder(struct Node *);
		void postOrder(struct Node *);
		int big(int,int);
};

int AVLTreeADT :: big(int x, int y)
{
  return (x>y) ?x:y;
}

struct Node * AVLTreeADT :: insert(struct Node *root, int value)
{
	if(root == NULL)
	{
		root = (struct Node *) malloc(sizeof(struct Node)); // to create a new node
		root->data = value;
		root->height = 0;
		root->left = NULL;
		root->right = NULL;
	
		return root;
	}
	else
	if(root->data > value)
	{
		root->left = insert(root->left,value);	
		if( (height(root->left) - height(root->right)) >= 2 )
		{
			if(value < root->left->data)
				root = LL(root);
			else
				root = LR(root);
		}
	}
	else
	if(root->data < value)
	{
		root->right = insert(root->right, value);
		if((height(root->right) - height(root->left)) >= 2)
		{
			if(value > root->right->data)
				root = RR(root);
			else
				root = RL(root);
		}
	}
	else
	{
     		cout<<"\n Data already exists...So discard it !";
	    	return root;
	}
	
	root->height = 1+ big(height(root->left), height(root->right));

	return root;
}

struct Node * AVLTreeADT :: LL(struct Node *t)
{
	struct Node *temp;

	temp = t->left;
	t->left = temp->right;
	temp->right = t;

	t->height = 1+ big(height(t->left), height(t->right));
	temp->height = 1+ big(height(temp->left), height(temp->right));

	return temp;

}

struct Node * AVLTreeADT :: RR(struct Node *t)
{
	struct Node *temp;

	temp = t->right;
	t->right = temp->left;
	temp->left = t;
	
	t->height = 1+ big(height(t->left), height(t->right));
	temp->height = 1+ big(height(temp->left), height(temp->right));

	return temp;
	
}

struct Node * AVLTreeADT :: LR(struct Node *t)
{
	t->left = RR(t->left);
	return LL(t);
}

struct Node * AVLTreeADT :: RL(struct Node *t)
{
		t->right = LL(t->right);
		return RR(t);
}

int AVLTreeADT :: height(struct Node *t) // here t is root node
{
	if(t==NULL)
		return -1;
	else
	if(t->left == NULL && t->right == NULL)
		return 0;
	else
	if(t->left == NULL)
		return 1 + height(t->right);
	else
	if(t->right == NULL)
		return 1+ height(t->left);
	else
		return 1+ big(height(t->left), height(t->right));
		
}

void AVLTreeADT :: printTree(struct Node *t,int level)
{
		if(t!=NULL)
		{
			printTree(t->right, level+1);
			for(int i=0;i<level;i++)
				cout<<"  ";
			cout<<t->data<<"\n";
			printTree(t->left, level+1);
		}			
}

void AVLTreeADT :: inorder(struct Node *t)
{
        if(t!=NULL)    
        {
            inorder(t->left);
            cout<<t->data<<"  ";
            inorder(t->right);
        }
}

int main()
{
	struct Node *root = NULL; // Assume that there is no tree

	AVLTreeADT obj;	int v;
	//int a[8] = {7,2,4,3,9,8,6,5};

	for(int i=0;i<8;i++)
	{
	    cout<<"enter value";
	    cin>>v;
		root = obj.insert(root, v);
		obj.printTree(root,1);
	}

	cout<<"\n The inorder is\n";
	obj.inorder(root);

	cout<<"\n The AVL tree structure is....\n\n";
	obj.printTree(root,1);


	return 0;
}



