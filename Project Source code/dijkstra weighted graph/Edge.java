package graph;

import java.util.Comparator;

//
public class Edge implements Comparable<Edge>{
	public int v, w;
	
	public  Edge() {
		
	}

	public Edge(int v, int w) {
		this.v = v;
		this.w = w;
	}

	public String getCharForNumber(int i) {
		char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		if (i > 25) {
			return null;
		}
		return Character.toString(alphabet[i]);
	}
	
	public int getVertex() {
        return v;
    }
	
	public int getWeight() {
        return w;
    }
	
	@Override
	public int compareTo(Edge next){ 
        if (this.w > next.w) {
			return 1;
		}        
        return -1;        
    } 

	@Override
	public String toString() {
		String c = this.getCharForNumber(v);
		return "(" + c + "|" + w + ")"+"-->";
	}	
}
