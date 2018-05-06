package it.polimi.ke.jena.complete;

import org.apache.jena.graph.Node;
import org.apache.jena.graph.NodeFactory;
import org.apache.jena.graph.Triple;

/**
 * Part11c: Triples
 * <p>
 * Work at a very low level, they are basic block of Statements
 **/

public class Part11a {

    public static void main(String[] args) {

        String uri = "http://example.org#";

        Node me = NodeFactory.createURI(uri + 10324137);
        Node ke = NodeFactory.createURI(uri + "KnowledgeEngineering");
        Node teaches = NodeFactory.createURI(uri + "teaches");

        Triple triple = new Triple(me, teaches, ke);

        System.out.println(triple);

    }
}
