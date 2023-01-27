package referidos

import grails.gorm.services.Service

@Service(Postulation)
interface PostulationService {

    Postulation get(Serializable id)

    List<Postulation> list(Map args)

    Long count()

    void delete(Serializable id)

    Postulation save(Postulation postulation)

}