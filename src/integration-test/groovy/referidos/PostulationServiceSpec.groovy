package referidos

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PostulationServiceSpec extends Specification {

    PostulationService postulationService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Postulation(...).save(flush: true, failOnError: true)
        //new Postulation(...).save(flush: true, failOnError: true)
        //Postulation postulation = new Postulation(...).save(flush: true, failOnError: true)
        //new Postulation(...).save(flush: true, failOnError: true)
        //new Postulation(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //postulation.id
    }

    void "test get"() {
        setupData()

        expect:
        postulationService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Postulation> postulationList = postulationService.list(max: 2, offset: 2)

        then:
        postulationList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        postulationService.count() == 5
    }

    void "test delete"() {
        Long postulationId = setupData()

        expect:
        postulationService.count() == 5

        when:
        postulationService.delete(postulationId)
        sessionFactory.currentSession.flush()

        then:
        postulationService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Postulation postulation = new Postulation()
        postulationService.save(postulation)

        then:
        postulation.id != null
    }
}
