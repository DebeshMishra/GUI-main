package GUI;

import java.util.Random;
import java.util.*;

public class DBSCAN {
	
	int A= 10;
	int B=10;
    List<ArrayList<Integer>> points = new ArrayList<ArrayList<Integer>>();
    List<ArrayList<Integer>> C = new ArrayList<ArrayList<Integer>>();
    
    List<List<ArrayList<Integer>>> test = new ArrayList<List<ArrayList<Integer>>>();

    List<List<ArrayList<Integer>>> map = new ArrayList<List<ArrayList<Integer>>>();

	
	
	public DBSCAN(int A, int B, double eps, int minPts) {
				
		Random rd = new Random();
		
		int[][] grid = new int[A][B];
		
		for (int x = 0; x < A; x++) {
			
				for(int y = 0; y < B; y++) {
										
					grid[x][y]= rd.nextInt(2);
//					 System.out.println(grid[x][y]);
					
//					 System.out.println();

					 
					
				}
			  
		}
		
//		double x1; 
//		double y1; 
//		double x2; 
//		double y2;
//		double distance;
//		System.out.println("here");
//		distance = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));

		for (int x = 0; x < A; x++) {
			
			for(int y = 0; y < B; y++) {
				
				if(grid[x][y] == 1) {
					
			        ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(x);
					temp.add(y);
					points.add(temp);
					
					
				}
				
			}
			
		}
		


		points.forEach((coordinate)  -> 
        {
            List<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
	        ArrayList<Integer> temp = new ArrayList<Integer>();
	        temp.add(coordinate.get(0));
	        temp.add(coordinate.get(1));
	        map.add(temp);


//    		System.out.print(coordinate);
//    		System.out.print(coordinate.get(0));
//    		System.out.print(" ");
//    		System.out.print(coordinate.get(1));
//    		System.out.println();
    		
        	
	        
//        	List<ArrayList<Integer>> pointNeighbors = new ArrayList<ArrayList<Integer>>();
//	        List<ArrayList<Integer>> pointNeighbors = new ArrayList<ArrayList<Integer>>();



	        points.forEach((neightboor)  -> 
	        {
	        	

	    		double distance = Math.sqrt((neightboor.get(1) - coordinate.get(1)) * (neightboor.get(1) - 
	    				coordinate.get(1)) + (neightboor.get(0) - coordinate.get(0)) * (neightboor.get(0) - coordinate.get(0)));
	    		
	    		
//	    		System.out.print(distance);
//	    		System.out.println();
	    		
	    		if(distance < eps && (coordinate.get(0) != neightboor.get(0) && coordinate.get(1) != neightboor.get(1) )) {
	    			
//	    			System.out.println("true");
	    	        ArrayList<Integer> temp2 = new ArrayList<Integer>();

	    	        temp2.add(neightboor.get(0));
	    	        temp2.add(neightboor.get(1));
	    			map.add(temp2);

	    			
	    		}
	    		

	        	
	        });


	        
//	        System.out.println(map);
//	        test.add(temp);
	        
	        if(map.size() > 1) {
	        	
		        test.add(map);

	        	
	        }
//			map.add(pointNeighbors);

//        	point.forEach((coordinate)->
//        	
//        		System.out.println(coordinate)	
//        			
//        			);
        }
                );
		
		
		test.forEach((point)  -> 
        {
//        	System.out.println(point.size() - 1);
//        	System.out.println(point);
        	if(point.size() - 1 >= minPts) {
        		map.add(point);
        		
        	}
        	
        	
        });
		
		
		
		
		map.forEach((point)  -> 
        {
        	System.out.println(point.size() - 1);
//        	System.out.println(point);
        	
        	
        });
		
		
		
		
//		
		

		
	}
	
}