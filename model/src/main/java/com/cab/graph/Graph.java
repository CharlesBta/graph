package com.cab.graph;

import com.cab.treenode.NaryTreeNode;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class Graph<E> implements IGraph<E> {
    private final List<INode<E>> nodes = new ArrayList<>();

    @Override
    public void addNode(@NonNull final INode<E> node) {
        if (!this.nodes.contains(node)) {
            this.nodes.add(node);
        }
    }

    @Override
    public NaryTreeNode<INode<E>> getMinSpanningTreeByPrim() {
        if (this.getNodes().isEmpty()) return null;
        NaryTreeNode<INode<E>> spanningTree = new NaryTreeNode<>(this.get(0));
        while (spanningTree.getSize() != this.getNodes().size()) {
            ILink<E> minLink = getMinLinkFromTreeNode(spanningTree);
            if (minLink != null) {
                spanningTree.getNodeFromElement(minLink.getStart()).addChild(minLink.getEnd());
            }
        }
        return spanningTree;
    }

    public final INode<E> get(final int index) {
        return this.getNodes().get(index);
    }

    private static <E> ILink<E> getMinLinkFromTreeNode(final NaryTreeNode<INode<E>> treeNode) {
        ILink<E> minLink = null;
        for (INode<E> node : treeNode.toByWidthList()) {
            for (ILink<E> link : node.getLinks()) {
                if (!treeNode.contains(link.getEnd())) {
                    minLink = (minLink == null) ? link : link.compareTo(minLink) < 0 ? link : minLink;
                }
            }
        }
        return minLink;
    }

}
