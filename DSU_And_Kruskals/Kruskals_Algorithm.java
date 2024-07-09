package DSU_And_Kruskals;
import java.util.*;
public class Kruskals_Algorithm {
HashMap<Integer,HashMap<Integer,Integer>>map;
public  Kruskals_Algorithm(int v) {
	this.map=new HashMap<>();
	for(int i=1;i<=v;i++) {
		map.put(i, new HashMap<>());		
	}
 }
public void addedge(int v1,int v2,int cost) {
	map.get(v1).put(v2, cost);
	map.get(v2).put(v1, cost);
}
public void Kruskals() {
List<EdgePair>ll=AllEdge();
Collections.sort(ll,new Comparator<EdgePair>(){
	@Override
	public int compare(EdgePair o1,EdgePair o2) {
	return o1.cost-o2.cost;	
	}
});
int ans=0;
DisJointSet ds=new DisjointSet();
for(int v:map.keySet()) {
	ds.CreateSet(v);
}
for(EdgePair e:ll) {
	int e1=e.e1;
	int e2=e.e2;
	int re1=ds.find(e1);
	int re2=ds.find(e2);
	if(re1==re2) {		
	}else {
		ds.union(e1, e2);
		System.out.println(e);
		ans+=e.cost;
	}
}
System.out.println(ans);
}
public class EdgePair{
	int e1;
	int e2;
	int cost;
	public EdgePair(int e1,int e2,int cost) {
		this.e1=e1;
		this.e2=e2;
		this.cost=cost;
	}
	@Override
	public String toString() {
		return this.e1+"-->"+this.e2+"@"+this.cost;
	}
 }
public List<EdgePair>AllEdge(){
	for(int e1:map.keySet()) {
		for(int e2:map.get(e1).keySet()) {
			int cost=map.get(e1).get(e2);
			ll.add(new EdgePair(e1,e2,cost));
		}
	}
	return ll;
}
}