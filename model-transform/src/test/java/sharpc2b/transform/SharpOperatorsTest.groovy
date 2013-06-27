package sharpc2b.transform

import org.semanticweb.owlapi.apibinding.OWLManager
import org.semanticweb.owlapi.model.IRI
import org.semanticweb.owlapi.model.OWLDataFactory
import org.semanticweb.owlapi.model.OWLOntology
import org.semanticweb.owlapi.model.OWLOntologyManager
import org.semanticweb.owlapi.reasoner.OWLReasoner
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory
import org.semanticweb.owlapi.vocab.PrefixOWLOntologyFormat

/**
 * User: rk
 * Date: 6/19/13
 * Time: 2:36 PM
 */
class SharpOperatorsTest extends GroovyTestCase {

    static File excelFile = FileUtil.getFileInProjectDir(
            "/model-transform/src/main/resources/SharpOperators.xlsx" );

    static IRI outputOntIRI = IriUtil.sharpEditorIRI( "shops" );
    static File outputOntFile = FileUtil.getFileInProjectDir(
            "/model-transform/src/test/resources/onts/editor-models/shops.ofn" );

    static String opsCoreBaseIRI = IriUtil.sharpEditorIRI( "ops" ).toString() + "#";
    static String operatorsBaseIRI = outputOntIRI.toString() + "#";

    OWLOntologyManager oom;
    OWLDataFactory odf;
    PrefixOWLOntologyFormat oFormat
//    Set<OWLOntology> onts;
    OWLReasonerFactory reasonerFactory;
    OWLReasoner reasoner;

    OWLOntology ont;

    void setUp () {

    }

    void tearDown () {

    }

    void testSharpOperators () {

        SharpOperators sharpOperatorsCreator = new SharpOperators();

        oom = OWLManager.createOWLOntologyManager();
        ont = oom.createOntology( outputOntIRI );
        oFormat = IriUtil.getDefaultSharpOntologyFormat();
        sharpOperatorsCreator.addSharpOperators( excelFile, ont );

        oom.saveOntology( ont, oFormat, IRI.create( outputOntFile ) );
    }

}
