package it.polimi.ke.owlapi.complete.building;

import org.semanticweb.HermiT.ReasonerFactory;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;

/**
 * Part 7: Reasoning with HermiT
 **/
public class Part8 {

    public static void main(String[] args) throws OWLOntologyCreationException {

        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();

        IRI base = IRI.create("http:://example.org/");

        OWLReasonerFactory factory = new ReasonerFactory();

        OWLOntology o = manager.loadOntologyFromOntologyDocument(Part6.class.getClassLoader().getResourceAsStream("part6.owl"));

        OWLClass student = o.getOWLOntologyManager().getOWLDataFactory().getOWLClass(base + "#Student");

        o.logicalAxioms().forEach(System.out::println);

        OWLReasoner reasoner = factory.createReasoner(o);
        reasoner.getInstances(student).forEach(System.out::println);

    }

}
