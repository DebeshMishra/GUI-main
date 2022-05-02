package GUI;

import javax.swing.*;
import java.util.*;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class DBSCAN {

	private Grid panel;
	private int distance;

	private int visitedCount = 0;

	private Queue<int[]> coordinateQueue = new LinkedList<>();

	public DBSCAN(){

	}


	public void addPanel(Grid panel){
		this.panel = panel;
	}

	public void run(int distance) {
		visitedCount = 0;
		boolean[] visited = new boolean[panel.dotCoordinates.size()];
		while (visitedCount < panel.dotCoordinates.size() -1){
			Random ran = new Random();
			int x = ran.nextInt(panel.dotCoordinates.size()-1);

			if(!visited[x]){
				coordinateQueue.add(panel.dotCoordinates.get(x));
				visited[x] = true;
				visitedCount++;
			}
			// Your database code here
			//keep going to neighbors
			while(!coordinateQueue.isEmpty()){
				//coordinates of the random dot selected
				int[] selected = coordinateQueue.remove();
				for (int i = 0; i < panel.dotCoordinates.size(); i++){
					int[] a = panel.dotCoordinates.get(i);
					//look at selected neighbors
					double dist = Math.sqrt(Math.pow(Math.abs(a[0] - selected[0]),2) + Math.pow(Math.abs(a[1] - selected[1]), 2));
					if (dist <= distance && !visited[i]){
						//add them to visited
						coordinateQueue.add(a);
						visited[i] = true;
						visitedCount++;
						//draw a line between these two dots
						panel.lineCoordinates.add(new int[]{a[0], a[1], selected[0], selected[1]});
					}
				}
			}
		}
		panel.repaint();
	}


}
