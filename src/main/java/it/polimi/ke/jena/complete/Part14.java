package it.polimi.ke.jena.complete;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.vocabulary.RDF;

import java.io.FileNotFoundException;

/**
 * Part14:
 * <p>
 * Load part10.rdf.xml from resource folder
 **/

public class Part14 {

    public static void main(String[] args) throws FileNotFoundException {

        String uri = "http://example.org#";

        Model g1 = ModelFactory.createDefaultModel().read("./src/main/resources/part13.rdf.ttl");

        Model m2 = ModelFactory.createDefaultModel();

        m2.createResource(uri + "ke")
                .addProperty(m2.createProperty(uri + "hasNumberAttendees"), m2.createLiteral("15"))
                .addProperty(m2.createProperty(uri + "edition"), m2.createLiteral("12th"))
                .addProperty(m2.createProperty(uri + "hasProfessor"), m2.createResource("ColombettiMarco"));

        m2.createResource("ColombettiMarco").addProperty(RDF.type, m2.createResource(uri + "Professor"));

        Model union = g1.union(m2);

        union.write(System.out, "TTL");

        System.out.println("==========");

        Model difference = m2.difference(g1);

        difference.write(System.err, "TTL");

    }
}
