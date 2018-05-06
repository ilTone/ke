package it.polimi.ke.jena.complete;

import org.apache.jena.query.Dataset;
import org.apache.jena.query.DatasetFactory;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

import java.io.FileNotFoundException;

/**
 * Part12:
 * <p>
 * Load part10.rdf.xml from resource folder
 **/

public class Part15 {

    public static void main(String[] args) throws FileNotFoundException {

        String uri = "http://example.org#";

        Model g1 = ModelFactory.createDefaultModel().read("./src/main/resources/part13.rdf.ttl");
        Model g2 = ModelFactory.createDefaultModel().read("./src/main/resources/part12.rdf.xml");

        Dataset ds = DatasetFactory.create();

        ds.addNamedModel(uri + "g1", g1);
        ds.addNamedModel(uri + "g2", g2);

        ds.getDefaultModel().write(System.err);

        ds.getNamedModel(uri + "g1").write(System.out);
        ds.getNamedModel(uri + "g1").write(System.out);

        ds.setDefaultModel(ds.getUnionModel());

        ds.getDefaultModel().write(System.out);

    }
}
