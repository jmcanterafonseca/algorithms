'use strict';

/* jshint -W097 */
/* jshint browser: true */
/* global console */
/* exported test */

function Tree(root) {
    this.root = root;
}

Tree.prototype = {
    visit: function() {
        console.log('Visit called!!!');
        
        this.root.visit();
    },
    
    visit2: function() {
        console.log('Visit 2 called!');
        this.visitDepth(this.root);
    },
    
    visitDepth: function(node) {
        if (!node) {
            return;
        }
        
        var currentNode = node;
        
        var stack = [];
        while(currentNode) {
           stack.push(currentNode);
           currentNode = currentNode.leftChild;
        }
        
        for (var j = stack.length - 1; j>=0; j--) {
            console.log(stack[j].value);
            this.visitDepth(stack[j].rightChild); 
        }
    },
    
    get root() {
        return this._rootNode;
    },
    
    set root(node) {
        this._rootNode = node;
    }
};

function Node(leftChild, rightChild) {
    this.leftChild = leftChild;
    this.rightChild = rightChild;
}

Node.prototype = {
  get rightChild() {
    return this._rightChild;
  },
  
  get leftChild() {
    return this._leftChild;
  },
  
  get value() {
    return this._value;
  },
  
  set value(value) {
    this._value = value;
  },
  
  set rightChild(node) {
    this._rightChild = node;
  },
  
  set leftChild(node) {
    this._leftChild = node;
  },
  
  visit() {
    console.log(this.value);
    
    if (this.leftChild) {
       this.leftChild.visit();
    }
    
    if (this.rightChild) {
        this.rightChild.visit();
    }
  }
};

function test() {
    var rootNode = new Node();
    rootNode.value = 'rootNode';
    rootNode.leftChild = new Node();
    rootNode.leftChild.value = 'L1';
    
    rootNode.leftChild.leftChild = new Node();
    rootNode.leftChild.leftChild.value = 'L1L2';
    rootNode.leftChild.rightChild = new Node();
    rootNode.leftChild.rightChild.value = 'L1R2';
    
    rootNode.rightChild = new Node();
    rootNode.rightChild.value = 'R1';
    rootNode.rightChild.leftChild = new Node();
    rootNode.rightChild.leftChild.value = 'R1L2';
    rootNode.rightChild.rightChild = new Node();
    rootNode.rightChild.rightChild.value = 'R1R2';

    var tree = new Tree(rootNode);
    
    tree.visit();
    tree.visit2();
}
