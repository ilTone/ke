package it.polimi.ke.jena.complete;

import org.apache.jena.rdf.model.*;

/**
 * Part11c: Statements
 * <p>
 * <p>
 * Anything identifiable by a IRI.
 * <p>
 * Resources have properties, which are also identified by IRI.
 * I.E. properties are resouces too.
 * <p>
 * Literals, i.e., primitive types are not resources.
 * <p>
 * Note:
 * <p>
 * create statement does NOT add the triple to the model
 **/

public class Part11b {

    public static void main(String[] args) {

        String uri = "http://example.org#";

        Model model = ModelFactory.createDefaultModel();

        Resource me = model.createResource(uri + 10324137);
        Resource ke = model.createResource(uri + "KnowledgeEngineering");
        Property teaches = model.createProperty(uri + "teaches");

        Statement statement = model.createStatement(me, teaches, ke);

        model.add(statement);

        StmtIterator stmtIterator = model.listStatements();

        while (stmtIterator.hasNext()) {

            System.out.println(stmtIterator.nextStatement());

        }

    }
}
