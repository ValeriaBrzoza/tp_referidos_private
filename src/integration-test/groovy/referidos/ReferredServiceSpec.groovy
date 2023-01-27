package referidos

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ReferredServiceSpec extends Specification {

    ReferredService referredService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Referred(...).save(flush: true, failOnError: true)
        //new Referred(...).save(flush: true, failOnError: true)
        //Referred referred = new Referred(...).save(flush: true, failOnError: true)
        //new Referred(...).save(flush: true, failOnError: true)
        //new Referred(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //referred.id
    }

    void "test get"() {
        setupData()

        expect:
        referredService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Referred> referredList = referredService.list(max: 2, offset: 2)

        then:
        referredList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        referredService.count() == 5
    }

    void "test delete"() {
        Long referredId = setupData()

        expect:
        referredService.count() == 5

        when:
        referredService.delete(referredId)
        sessionFactory.currentSession.flush()

        then:
        referredService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Referred referred = new Referred()
        referredService.save(referred)

        then:
        referred.id != null
    }
}
