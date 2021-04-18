package com.teambition.base;

import sun.security.provider.certpath.Vertex;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yitouwushui on 2018/9/24.
 */

public class BFSTraverse {

    public static final long MONTH = 24 * 60 * 60 * 1000L * 30;
    public static final long YEAR = 24 * 60 * 60 * 1000L * 365;

    public static void main(String[] args) {
        System.out.println(MONTH);
        System.out.println(System.currentTimeMillis());
        System.out.println(YEAR);
        System.out.println(String.format("%1$d分钟前", YEAR / MONTH));
    }
//
//    public Iterator BFSTraverse(Vertex v) {
//        LinkedList traverseSeq = new LinkedList();//遍历结果
//        resetVexStatus();  //重置顶点状态
//        BFS(v, traverseSeq);  //从 v 点出发广度优先搜索
//        Iterator it = getVertex(); //从图中未访问的顶点重新搜索（调用图操作③）
//        for(it.first(); !it.isDone(); it.next()){
//            Vertex u = (Vertex)it.currentItem();
//            if (!u.isVisited()) BFS(u, traverseSeq);
//        }
//        return traverseSeq.elements();
//    }
//    private void BFS(Vertex v, LinkedList list){
//        Queue q = new QueueSLinked();
//        v.setToVisited();  //访问顶点 v
//        list.insertLast(v);
//        q.enqueue(v); //顶点 v 入队
//        while (!q.isEmpty()){
//            Vertex u = (Vertex)q.dequeue();  //队首元素出队
//            Iterator it = adjVertexs(u);  //访问其未曾访问的邻接点，并入队
//            for(it.first(); !it.isDone(); it.next()){
//                Vertex adj = (Vertex)it.currentItem();
//                if (!adj.isVisited()){
//                    adj.setToVisited();
//                    list.insertLast(adj);
//                    q.enqueue(adj);
//                }//if
//            }//for
//        }//while
//    }
}
