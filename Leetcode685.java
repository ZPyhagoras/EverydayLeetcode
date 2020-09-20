public class Leetcode685 {

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int nodesCount = edges.length;
        DisjointedSet uf = new DisjointedSet(nodesCount);
        int[] parent = new int[nodesCount + 1];
        for (int i = 1; i <= nodesCount; i++) {
            parent[i] = i;
        }
        int conflict = -1, cycle = -1;
        for (int i = 0; i < nodesCount; i++) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            if (parent[node2] != node2) {
                conflict = i;
            } 
            else {
                parent[node2] = node1;
                if (uf.find(node1, node2)) {
                    cycle = i;
                } 
                else {
                    uf.union(node1, node2);
                }
            }
        }
        int[] redundant = new int[2];
        if (conflict < 0) {
            redundant[0] = edges[cycle][0];
            redundant[1] = edges[cycle][1];
        } 
        else {
            int[] conflictEdge = edges[conflict];
            redundant[0] = cycle >= 0 ? parent[conflictEdge[1]] : conflictEdge[0];
            redundant[1] = conflictEdge[1];
        }
        return redundant;
    }

    private class DisjointedSet {
        private int[] id;

        DisjointedSet(int n){
            id = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                id[i]=i;
            }
        }
        private void union(int p, int q){
            int pRoot = getRoot(p);
            int qRoot = getRoot(q);
            id[pRoot]=qRoot;
        }
    
        private int getRoot(int i){
            while (i != id[i]){
                i = id[i];
            }
            return i;
        }
    
        private boolean find(int p, int q){
            return getRoot(p)==getRoot(q);
        }
    }
}
