package referidos

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class RewardServiceSpec extends Specification {

    RewardService rewardService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Reward(...).save(flush: true, failOnError: true)
        //new Reward(...).save(flush: true, failOnError: true)
        //Reward reward = new Reward(...).save(flush: true, failOnError: true)
        //new Reward(...).save(flush: true, failOnError: true)
        //new Reward(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //reward.id
    }

    void "test get"() {
        setupData()

        expect:
        rewardService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Reward> rewardList = rewardService.list(max: 2, offset: 2)

        then:
        rewardList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        rewardService.count() == 5
    }

    void "test delete"() {
        Long rewardId = setupData()

        expect:
        rewardService.count() == 5

        when:
        rewardService.delete(rewardId)
        sessionFactory.currentSession.flush()

        then:
        rewardService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Reward reward = new Reward()
        rewardService.save(reward)

        then:
        reward.id != null
    }
}
