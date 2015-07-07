/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binarytree;

/**
 *
 * @author ryutaromatsuda
 */
public class BinaryTree {
  int num;
  BinaryTree left;
  BinaryTree right; 
  
  public BinaryTree(){
    this.num = -1;
    this.left = null;
    this.right = null;
  }
  
  public BinaryTree(int num){
    this.num = num;
    this.left = null;
    this.right = null;
  }
  
  public void insert(int num){
    if(num < this.num){
      if(left != null){
        left.insert(num);
      }
      else{
        left = new BinaryTree(num);
      }
    }
    else{
      if(right != null){
        right.insert(num);
      }
      else{
        right = new BinaryTree(num);
      }
    }
  }

  public void printPreOrder(){
    System.out.println(num);
    if(left != null){
      left.printPreOrder();
    }
    if(right != null){
      right.printPreOrder();
    }
  }
  
  public void printInOrder(){
    if(left != null){
      left.printInOrder();
    }
    System.out.println(num);
    if(right != null){
      right.printInOrder();
    }
  }
  
  public void printPostOrder(){
    if(left != null){
      left.printPostOrder();
    }
    if(right != null){
      right.printPostOrder();
    }
    System.out.println(num);
  }
  
  public boolean search(BinaryTree root, int num){
    if(root == null){
      return false;
    }
    else if(num == root.num){
      return true;
    }
    else if (num < root.num){
      if(root.left != null){
        return search(root.left, num);
      }
    }
    else{
      if(root.right != null){
        return search(root.right,num);
      }
    }
    return false;
  }
  
  public BinaryTree delete(int num){
    BinaryTree root = this; 
    root = delete(root,num);
    return root; 
  }
  
  public BinaryTree delete(BinaryTree root, int num){
    if(root == null){
      return null; 
    }
    if(num == root.num){
      if(root.left == null && root.right ==null){
        return null;
      }
      if(root.left == null ){
        return root.right;
      }
      if(root.right == null){
        return root.left;
      }
      int small = root.smaller(root.right);
      root.right = delete(root.right,small);
      return root;
    }
    else if(num < root.num){
      root.left = delete(root.left, num);
      return root;
    }
    else{
      root.right = delete(root.right,num);
      return root;
    }
  }
  
  public int smaller(BinaryTree root){
    if(root.left == null ){
      return root.num;
    }
    else{
      return root.smaller(root.left);
    }
  }
}
