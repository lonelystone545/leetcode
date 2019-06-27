package com.wy.linkedlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/*
 * 133. Clone Graph
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:
 */
public class CloneGraph {
	//深搜 递归
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null) return null;
        Map<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();
        return clone(node,map);
    }

	private UndirectedGraphNode clone(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
		if(node==null) return null;
		//遍历过的节点会存放在map集合 (set集合)
		if(map.containsKey(node)) {
			return map.get(node);
		}
		//如果没有被遍历过
		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		map.put(node, newNode);
		for(UndirectedGraphNode neighbour : node.neighbors) {
			newNode.neighbors.add(clone(neighbour,map));
		}
		return newNode;
	}
	
	//深搜 非递归
	public UndirectedGraphNode cloneGraph3(UndirectedGraphNode node) {
		if(node==null) return null;
		Map<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();
		Stack<UndirectedGraphNode> stack = new Stack<>();
		UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
		map.put(node, newHead);
		stack.push(node);
		while(!stack.isEmpty()) {
			UndirectedGraphNode tmp = stack.pop();
			for(UndirectedGraphNode neighbour : tmp.neighbors) {
				if(!map.containsKey(neighbour)) {
					UndirectedGraphNode copy = new UndirectedGraphNode(neighbour.label);
					map.put(neighbour, copy);
					map.get(tmp).neighbors.add(copy);
					stack.push(neighbour);
				} else {
					map.get(tmp).neighbors.add(map.get(neighbour));
				}
			}
		}
		return newHead;
	}
	
	//广搜 使用队列实现
	public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
		if(node==null) return null;
		Map<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
		
		map.put(node,newHead);
		queue.add(node);
		while(!queue.isEmpty()) {
			UndirectedGraphNode tmp = queue.poll();
			for(UndirectedGraphNode neighbour : tmp.neighbors) {
				if(!map.containsKey(neighbour)) {
					UndirectedGraphNode copy = new UndirectedGraphNode(neighbour.label);
					map.put(neighbour,copy);
					map.get(tmp).neighbors.add(copy);
					queue.add(neighbour);
				} else {
					map.get(tmp).neighbors.add(map.get(neighbour));
				}
			}
		}
		return newHead;
	}
}

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};
