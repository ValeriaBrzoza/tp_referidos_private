package referidos

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class EnterpriseServiceSpec extends Specification {

    EnterpriseService enterpriseService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Enterprise(...).save(flush: true, failOnError: true)
        //new Enterprise(...).save(flush: true, failOnError: true)
        //Enterprise enterprise = new Enterprise(...).save(flush: true, failOnError: true)
        //new Enterprise(...).save(flush: true, failOnError: true)
        //new Enterprise(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //enterprise.id
    }

    void "test get"() {
        setupData()

        expect:
        enterpriseService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Enterprise> enterpriseList = enterpriseService.list(max: 2, offset: 2)

        then:
        enterpriseList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        enterpriseService.count() == 5
    }

    void "test delete"() {
        Long enterpriseId = setupData()

        expect:
        enterpriseService.count() == 5

        when:
        enterpriseService.delete(enterpriseId)
        sessionFactory.currentSession.flush()

        then:
        enterpriseService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Enterprise enterprise = new Enterprise()
        enterpriseService.save(enterprise)

        then:
        enterprise.id != null
    }
}
