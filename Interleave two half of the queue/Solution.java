import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		q.add(6);
		q.add(7);
		q.add(8);
		Queue<Integer> q1= new LinkedList<>();
		int n=0;
		int size = q.size();
		while(n < size/2){
		    q1.add(q.remove());
		    n++;
		}
		
		while(!q1.isEmpty()){
		    q.add(q1.remove());
		    q.add(q.remove());
		}
		
		while(!q.isEmpty()){
		    System.out.println(q.remove());
		}
	}
}
