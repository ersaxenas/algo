package com.algo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

import algo.symboltable.BinarySearchTree;

import com.algo.model.Coordinate;
import com.algo.model.Line;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      App obj = new App();
      obj.findIntersectionOfLines();
    }
    
    /**
     * Function exploits BST to find intersection of lines.
     */
    public void findIntersectionOfLines() {
    Line hLines[] = new Line[5];
    hLines[0] = new Line(new Coordinate(1, 1), new Coordinate(5, 1));
    hLines[1] = new Line(new Coordinate(3, 4), new Coordinate(9, 4));
    hLines[2] = new Line(new Coordinate(2, 6), new Coordinate(13, 6));
    hLines[3] = new Line(new Coordinate(4, 8), new Coordinate(7, 8));
    hLines[4] = new Line(new Coordinate(12, 4), new Coordinate(16, 4));
    
    Line vLines[] = new Line[4];
    vLines[0] = new Line(new Coordinate(3, 1), new Coordinate(3, 3));
    vLines[1] = new Line(new Coordinate(6, 5), new Coordinate(6, 9));
    vLines[2] = new Line(new Coordinate(9, 4), new Coordinate(9, 8));
    vLines[3] = new Line(new Coordinate(11, 5), new Coordinate(11, 7));

    TreeMap<Integer, ArrayList<Line>> xLine = new TreeMap<Integer, ArrayList<Line>>();
    int maxX = 0;
    for(Line line : hLines) {
    	/*put start x coordinate of horizontal line*/
    	int x = line.getStart().getX();
    	if(xLine.containsKey(x)) {
    		xLine.get(x).add(line);
    	}
    	else {
    		ArrayList<Line> lst = new ArrayList<Line>();
    		lst.add(line);
    		xLine.put(x,lst);
    	}
    	if(x > maxX) {
    		maxX = x;
    	}
    	/*Put end x coordinate of horizontal line*/
        x = line.getEnd().getX();
    	if(xLine.containsKey(x)) {
    		xLine.get(x).add(line);
    	}
    	else {
    		ArrayList<Line> lst = new ArrayList<Line>();
    		lst.add(line);
    		xLine.put(x,lst);
    	}
    	if(x > maxX) {
    		maxX = x;
    	}
    }
    
    for(Line line : vLines) {
    	/*Put start x coordinate of vertical line*/
    	int x = line.getStart().getX();
    	if(xLine.containsKey(x)) {
    		xLine.get(x).add(line);
    	}
    	else {
    		ArrayList<Line> lst = new ArrayList<Line>();
    		lst.add(line);
    		xLine.put(x,lst);
    	}
        x = line.getStart().getX();
        if(x > maxX) {
    		maxX = x;
    	}
    }
    BinarySearchTree<Integer, Line> bst = new BinarySearchTree<Integer, Line>();
    for(int xcnt =0; xcnt<= maxX; xcnt++) {
    	ArrayList<Line> llst = xLine.get(xcnt);
    	if(llst == null) {
    		continue;
    	}
    	for(Line line :llst) {
    		if(line.isHorizontal()) { /*horizontal line*/
        		if(xcnt == line.getStart().getX()) {
        			bst.put(line.getStart().getY(), line);
        		}
        		else if(xcnt == line.getEnd().getX()) {
        			bst.delete(line.getEnd().getY());
        		}
        	}
    		else { /*Vertical line*/
    			Iterator<Integer> itr = bst.findKeyInRange(line.getStart().getY(),line.getEnd().getY()).iterator();
    			if(itr.hasNext()) {
    				System.out.println("------------------------");
    				System.out.println("Intersection found with Line : "+ line);
    				while(itr.hasNext()) {
    					System.out.println(bst.getValue(itr.next()));
    				}
    				System.out.println("------------------------");
    			}
    		}
    	}
    	
    }
    
    
    	
    }
    
    
    
}
