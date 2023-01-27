package referidos

import grails.gorm.services.Service

@Service(Reward)
interface RewardService {

    Reward get(Serializable id)

    List<Reward> list(Map args)

    Long count()

    void delete(Serializable id)

    Reward save(Reward reward)

}