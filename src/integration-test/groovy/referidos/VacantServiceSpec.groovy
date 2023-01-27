package referidos

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VacantServiceSpec extends Specification {

    VacantService vacantService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Vacant(...).save(flush: true, failOnError: true)
        //new Vacant(...).save(flush: true, failOnError: true)
        //Vacant vacant = new Vacant(...).save(flush: true, failOnError: true)
        //new Vacant(...).save(flush: true, failOnError: true)
        //new Vacant(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //vacant.id
    }

    void "test get"() {
        setupData()

        expect:
        vacantService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Vacant> vacantList = vacantService.list(max: 2, offset: 2)

        then:
        vacantList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        vacantService.count() == 5
    }

    void "test delete"() {
        Long vacantId = setupData()

        expect:
        vacantService.count() == 5

        when:
        vacantService.delete(vacantId)
        sessionFactory.currentSession.flush()

        then:
        vacantService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Vacant vacant = new Vacant()
        vacantService.save(vacant)

        then:
        vacant.id != null
    }
}
