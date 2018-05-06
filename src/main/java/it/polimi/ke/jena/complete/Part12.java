package it.polimi.ke.jena.complete;

import org.apache.jena.rdf.model.*;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.OWL;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Part12:
 * <p>
 * Load part10.rdf.xml from resource folder
 **/

public class Part12 {

    public static void main(String[] args) throws FileNotFoundException {

        String uri = "http://example.org#";

        Model model = ModelFactory.createDefaultModel();

        Resource john = model.createResource(uri + "JonDoe");
        Resource se = model.createResource(uri + "SoftwareEng");
        Resource oxford = model.createResource(uri + "Oxford");

        model.add(john, RDF.type, FOAF.Person);

        Property teaches = model.createProperty(uri + "teaches");
        teaches.addProperty(RDF.type, OWL.ObjectProperty);

        Property isPartOf = model.createProperty(uri + "isPartOf");
        isPartOf.addProperty(RDF.type, OWL.ObjectProperty);

        john.addProperty(teaches, se)
                .addProperty(isPartOf, oxford);

        Resource subject = model.createResource(uri + "Subject").addProperty(RDF.type, RDFS.Class);
        Resource inst = model.createResource(uri + "Institution").addProperty(RDF.type, RDFS.Class);

        model.add(se, RDF.type, subject);
        model.add(oxford, RDF.type, inst);

        model.write(new FileOutputStream(new File("./src/main/resources/part12.rdf.xml")), "RDF/XML");

    }
}
