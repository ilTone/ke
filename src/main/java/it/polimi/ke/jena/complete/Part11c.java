package it.polimi.ke.jena.complete;

import org.apache.jena.rdf.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Part11c: Resources
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
 * Each call to addProperty also add the triple to the model
 **/

public class Part11c {

    public static void main(String[] args) throws FileNotFoundException {

        String uri = "http://example.org#";

        Model model = ModelFactory.createDefaultModel();

        Resource me = model.createResource(uri + 10324137);

        Property p = model.createProperty(uri + "fullname");

        Resource name = model.createResource(uri + "RiccardoTommasini");

        Resource subject = me.addProperty(p, name);

        System.out.println(subject);

        StmtIterator stmtIterator = model.listStatements();

        while (stmtIterator.hasNext()) {

            System.err.println(stmtIterator.nextStatement());

        }

        model.write(new FileOutputStream(new File("rart1c.ttl")), "TTL");
        model.write(new FileOutputStream(new File("Part11c.jsonld")), "JSON-LD");
        model.write(new FileOutputStream(new File("Part11c.rdf.xml")), "RDF/XML");

    }
}
