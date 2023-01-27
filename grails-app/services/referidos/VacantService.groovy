package referidos

import grails.gorm.services.Service

@Service(Vacant)
interface VacantService {

    Vacant get(Serializable id)

    List<Vacant> list(Map args)

    Long count()

    void delete(Serializable id)

    Vacant save(Vacant vacant)

}