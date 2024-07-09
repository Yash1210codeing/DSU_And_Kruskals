package DSU_And_Kruskals;
import java.util.*;
public class Dijkstra_Algo {
private HashMap<Integer,HashMap<Integer,Integer>>map;
public Dijkstra_Algo(int v) {
	map=new HashMap<>();
	for(int i=1;i<=v;i++) {
		map.put(i,new HashMap<>());
	}
 }
public void AddEdge(int v1,int v2,int cost) {
	map.get(v1).put(v2, cost);
	map.get(v2).put(v1, cost);
   }
public void Dijkstra(int src) {
	HashSet<Integer>visited=new HashSet<>();
	PriorityQueue<DijkstraPair>pq=new PriorityQueue<>(new Comparator<DijkstraPair>();
	@Override;
	public  int compare(DijkstraPair o1,DijkstraPair o2) {
		return o1.cost-o2.cost;
	}
});
	pq.add(new DijkstraPair(src,""+src,0));
	while(pq.isEmpty()) {
		DijkstraPair rp=pq.poll();
		if(visited.contains(rp.vtx)) {
			continue;
		}
		visited.add(rp.vtx);
		System.out.println(rp);
		for(int nbrs:map.get(rp.vtx).keySet()) {
			if(!visited.contains(nbrs)) {
				int cost=rp.cost+map.get(rp.vtx).get(nbrs);
				DijkstraPair np=new DijkstraPair(nbrs,rp.acq+nbrs,cost);
				pq.add(np);
			}
		}
	}
  }
class DijkstraPair{
	int vtx;
	String acq;
	int cost;
	public DijkstraPair(int vtx,String acq, int cost) {
		this.vtx=vtx;
		this.acq=acq;
		this.cost=cost;
	}
 }
public static void main(String[]args) {
	Dijkstra_Algo dj=new Dijkstra_Algo(7);
	dj.AddEdge(1, 4, 6);
	dj.AddEdge(1, 2, 10);
	dj.AddEdge(2, 3, 7);
	dj.AddEdge(3, 4, 5);
	dj.AddEdge(4, 5, 1);
	dj.AddEdge(5, 6, 4);
	dj.AddEdge(7, 5, 2);
	dj.AddEdge(6, 7, 3);
	dj.Dijkstra(1);
}5

}