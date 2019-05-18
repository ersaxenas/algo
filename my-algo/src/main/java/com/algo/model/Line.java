package com.algo.model;

public class Line {
	private Coordinate start;
	private Coordinate end;
	private boolean horizontal = false;
	
	public Line(Coordinate start, Coordinate end) {
		this.start = start;
		this.end = end;
		if(start.getY() == end.getY()) {
			horizontal = true;
		}
	}
	public Coordinate getStart() {
		return start;
	}
	public void setStart(Coordinate start) {
		this.start = start;
	}
	public Coordinate getEnd() {
		return end;
	}
	public void setEnd(Coordinate end) {
		this.end = end;
	}
	public boolean isHorizontal() {
		return horizontal;
	}
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}
	@Override
	public String toString() {
		return "Line [start=" + start + ", end=" + end + ", horizontal=" + horizontal + "]";
	}
	

}
