package Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.*;

public class SkylineProblem {
	public static void main(String[] args){
		int[][] nums = {{2,9, 10}, {3 ,7 ,15}, {5, 12 ,12}, {15, 20, 10}, {19, 24 ,8}};
		List<int[]> result = getSkyline(nums);
		
//		for(int i=0; i<result.size(); i++){
//			int[] n = result.get(i);
//			for(int k:n){
//				System.out.print(k+" ");
//			}
//			System.out.println();
//		}
	}
	
	public static class Edge {
		public int x;
		public int height;
		public boolean isStart;
		
		public Edge(int x, int h, boolean isStart){
			this.x = x;
			height = h;
			this.isStart = isStart;
		}
		
	}
	
	public static List<int[]> getSkyline(int[][] buildings){
		List<int[]> result = new ArrayList<int[]>();
		List<Edge> list = new ArrayList<Edge>();
		
		for(int[] building:buildings){
			Edge startEdge = new Edge(building[0], building[2], true);
			list.add(startEdge);
			Edge endEdge = new Edge(building[1],building[2],false);
			list.add(endEdge);
		}
		
		Collections.sort(list, new Comparator<Edge>(){

			@Override
			public int compare(Edge a, Edge b) {
				// TODO Auto-generated method stub
				if(a.x!=b.x){
					return a.x-b.x;
				}
				
				if(a.isStart && b.isStart){
					return b.height-a.height;
				}
				
				if(!a.isStart && !b.isStart){
					return a.height-b.height;
				}
				
				return a.isStart?-1:1;
			}
			
		}); 
		
		for(Edge e : list) System.out.println("x: "+e.x+" height: "+e.height+" isStart: "+e.isStart);
		
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(10,Collections.reverseOrder());
		
		for(Edge edge : list){
			if(edge.isStart){
				if(heap.isEmpty() || edge.height>heap.peek()){
					result.add(new int[] {edge.x,edge.height});
				}
				heap.add(edge.height);
			}else{
				heap.remove(edge.height);
				if(heap.isEmpty()){
					result.add(new int[] {edge.x,0});
				}else if(edge.height>heap.peek()){
					result.add(new int[] {edge.x,heap.peek()});
				}
			}
		}
		
		return result; 
		
	}

}
