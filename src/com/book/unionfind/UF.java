package com.book.unionfind;

public class UF {
    private int[] id;
    private int count;

    public UF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public static void main(String[] args) {
        UF uf = new UF(10);
        uf.union(4,3);
        boolean connected = uf.connected(4, 3);
        System.out.println(connected);
        uf.union(3,8);
        boolean connected1 = uf.connected(4, 8);
        System.out.println(connected1);
    }

    public int count(){
        return count;
    }

    public boolean connected(int p,int q){
        return find(p) == find(q);
    }

    //quick-find -> quick-union
    public int find(int p){
        while (p != id[p]) p = id[p];
        return p;
    }

    //
    public void union(int p,int q){
//        int pID = find(p);
//        int qID = find(q);
//
//        if(pID == qID) return;
//
//        for (int i = 0; i < id.length; i++) {
//                if(id[i] == pID) id[i] = qID;
//                count--;
//        }

        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot) return;

        id[pRoot] = qRoot;

        count--;
    }

//    public static void main(String[] args) {
//        int N = StdIn.readInt();
//        UF uf = new UF(N);
//        while (!StdIn.isEmpty()){
//            int p = StdIn.readInt();
//            int q = StdIn.readInt();
//            if(uf.connected(p,q)) continue;
//            uf.union(p,q);
//            StdOut.println(p + "" + q);
//        }
//        StdOut.println(uf.count() + "components");
//    }
}
