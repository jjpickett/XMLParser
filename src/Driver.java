import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import exceptions.EmptyQueueException;
import utilities.EmptyStackException;

public class Driver {
	/**
	 * This is the main method that will read in the data from the given
	 * filename
	 * @param args the arguments the user will put in
	 */
	public static <E> void main(String[] args) {
		String  thisLine = null;
		BufferedReader br = null;
		MyQueue<E> errorQ = new MyQueue<E>();
		MyQueue<E> extrasQ = new MyQueue<E>();
		MyStack<E> mainStack = new MyStack<E>();
		
		try {
			if((!(args[0].equals("sample1")) && !(args[0].equals("sample2")) && !(args[0].equals("xmlSample"))) || args[0].equals(null)){
				System.out.println("Please use an appropraite filename.");
				System.exit(0);
			}
				
			br = new BufferedReader(new FileReader("res/"+ args[0].trim()+".xml"));
		
			while ((thisLine = br.readLine()) != null) {
				thisLine = thisLine.trim();
				if((thisLine.charAt(0) == '<') && (thisLine.trim().substring(thisLine.trim().length() - 2, thisLine.trim().length()).contains("/>")))
					System.out.println("Self Closing: Success");
				
				else if(thisLine.contains("<?xml"))
					System.out.println("Root tag");

				else if(thisLine.charAt(0) == '<'){
					String[] token = thisLine.split(" ");
					for(int i = 0; i < token.length; i++){
						
					
						//Close
						 if(token[i].trim().contains("</")){
							token[i] = token[i].substring(token[i].indexOf('/')+1, token[i].length()-1);
							if(mainStack.peek().toString().equals(token[i]))
								System.out.println("Close Tag: Success!");
							else if(mainStack.peek().toString().equals(errorQ.peek()))
								errorQ.dequeue();
							else if(mainStack.isEmpty())
								errorQ.enqueue((E) "Empty Stack");
							else{
								System.out.println("Closed Tag: Unsuccessful! Peek: " + mainStack.peek() + " Actual: " + token[i]);
								if(mainStack.contains((E) token[i])){
									while(!(mainStack.peek().equals(token[i]))){
										errorQ.enqueue(mainStack.pop());
									}
								}else{
									extrasQ.enqueue((E) token[i]);
								}
							}
							mainStack.pop();

						}
						 else if(i  == 0){
								
								token[i] = token[i].substring(token[i].indexOf('<')+1, token[i].length());
								if(token[i].contains(">")){
									token[i] = token[i].substring(0, token[i].indexOf('>'));
								}
								System.out.println("First Tag: " + token[i]);
								mainStack.push((E) token[i]);
							}
						else if(token[i].trim().contains("<")){
							
							token[i] = token[i].substring(token[i].indexOf('<')+1, token[i].indexOf('>') );
							System.out.println("Open Token: " + token[i]);
							mainStack.push((E) token[i]);
						}
						
						
					}
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmptyStackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmptyQueueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (NullPointerException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
		
		System.out.println("\n\n*** STOP! ERROR TIME! ***");
		
		while(!mainStack.isEmpty()){
			errorQ.enqueue(mainStack.pop());
		}
		while(!(errorQ.isEmpty()) || !(extrasQ.isEmpty())){
			try {
				if(!errorQ.isEmpty()){
					System.out.println("Error: " + errorQ.dequeue());
				}
				if(!extrasQ.isEmpty()){
					System.out.println("Error: " + extrasQ.dequeue());
				}
			} catch (EmptyQueueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				
		}
		while(!(errorQ.isEmpty() && extrasQ.isEmpty())){
			try {
				if(errorQ.peek().equals(extrasQ.peek())){
					errorQ.dequeue();
					extrasQ.dequeue();
				}else{
					System.out.println("Error: " + errorQ.dequeue());
				}
			} catch (EmptyQueueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
