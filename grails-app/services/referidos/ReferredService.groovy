package referidos

import grails.gorm.services.Service

@Service(Referred)
interface ReferredService {

    Referred get(Serializable id)

    List<Referred> list(Map args)

    Long count()

    void delete(Serializable id)

    Referred save(Referred referred)

}