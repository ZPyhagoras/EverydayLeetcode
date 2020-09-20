public class Leetcode684 {
    public int[] findRedundantConnection(int[][] edges){
        int n = edges.length;
        DisjointedSet nodeDS = new DisjointedSet(n);
        for (int[] edge : edges) {
            if (nodeDS.find(edge[0], edge[1])) {
                return edge;
            }
            else {
                nodeDS.union(edge[0],edge[1]);
            }
        }
        return edges[0];
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
            return getRoot(p) == getRoot(q);
        }
    }
}
