package referidos

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class RecruiterServiceSpec extends Specification {

    RecruiterService recruiterService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Recruiter(...).save(flush: true, failOnError: true)
        //new Recruiter(...).save(flush: true, failOnError: true)
        //Recruiter recruiter = new Recruiter(...).save(flush: true, failOnError: true)
        //new Recruiter(...).save(flush: true, failOnError: true)
        //new Recruiter(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //recruiter.id
    }

    void "test get"() {
        setupData()

        expect:
        recruiterService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Recruiter> recruiterList = recruiterService.list(max: 2, offset: 2)

        then:
        recruiterList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        recruiterService.count() == 5
    }

    void "test delete"() {
        Long recruiterId = setupData()

        expect:
        recruiterService.count() == 5

        when:
        recruiterService.delete(recruiterId)
        sessionFactory.currentSession.flush()

        then:
        recruiterService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Recruiter recruiter = new Recruiter()
        recruiterService.save(recruiter)

        then:
        recruiter.id != null
    }
}
