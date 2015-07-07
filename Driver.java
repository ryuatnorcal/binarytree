/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binarytree;

import java.util.Random;

/**
 *
 * @author ryutaromatsuda
 */
public class Driver {
  public static void main(String[] args) {
   final String PROMPT1 = "=== PRE-ORDER ===";
   final String PROMPT2 = "=== POST-ORDER ===";
   final String PROMPT3 = "=== IN-ORDER ===";
   final String PROMPT4 = "=== SEARCH ===";
   final String PROMPT5 = "=== DELETION ===";
   Random rand = new Random();
   int[] data;
   int[] search;
   int[] deletion;
   int array_size = 1000;
   int max = 1000;
   int search_size = 250;
   int delete_size = 300;
   data = new int[array_size];
   search = new int[search_size];
   deletion = new int[delete_size];
   /***************************************
    * Initialize the array 
    ***************************************/
   System.out.printf("data[] = {");
   for(int i = 0; i < array_size; i++){
     data[i] = rand.nextInt(max);
     if(i%20 == 0 ){
       System.out.println("'"+data[i]+"',");
     }else{
       System.out.printf("'%s',",data[i]);
     }
     
   }
   System.out.println('}');
   System.out.printf("search[] = {");
   for(int i = 0; i < search_size; i++){
     search[i] = rand.nextInt(max);
     if(i%20 == 0 ){
       System.out.println("'"+search[i]+"',");
     }else{
       System.out.printf("'%s',",search[i]);
     }
     
   }
   System.out.println('}');
   System.out.printf("deletion[] = {");
   for(int i = 0; i < delete_size; i++){
     deletion[i] = rand.nextInt(max);
     if(i%20 == 0 ){
       System.out.println("'"+deletion[i]+"',");
     }else{
       System.out.printf("'%s',",deletion[i]);
     }
     
   }
   System.out.println('}');
   
   
   /***************************************
    * Insert values in BinaryTree 
    ***************************************/
   int mid = data.length/2; 
   BinaryTree root = new BinaryTree(data[mid]);
   for(int i = 0; i< data.length; i ++){
     root.insert(data[i]);
   }
   System.out.println(PROMPT1);
   root.printPreOrder();
   
   System.out.println(PROMPT2);
   root.printPostOrder();
   
   System.out.println(PROMPT3);
   root.printInOrder();
   
   System.out.println(PROMPT4);
   boolean result = false;
   
   for(int i = 0; i < search_size; i++){
     result = root.search(root, search[i]);
     System.out.println("Searching For "+ search[i]+" : "+result);
   }
   
   System.out.println(PROMPT5);
   for(int i = 0; i < delete_size; i++){
     root = root.delete(deletion[i]);
     System.out.println("Deleting For "+ deletion[i] );
     root.printInOrder();
   }
   
  }
}
