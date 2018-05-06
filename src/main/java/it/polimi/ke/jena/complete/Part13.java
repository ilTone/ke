package it.polimi.ke.jena.complete;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.vocabulary.OWL;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Part12:
 * <p>
 * Load part10.rdf.xml from resource folder
 **/

public class Part13 {

    public static void main(String[] args) throws FileNotFoundException {

        String uri = "http://example.org#";

        Model model = ModelFactory.createDefaultModel().read("part11.rdf.xml");

        model.write(new FileOutputStream(new File("./src/main/resources/part13.rdf.ttl")), "TTL");

    }
}
