package referidos

import grails.gorm.services.Service

@Service(Enterprise)
interface EnterpriseService {

    Enterprise get(Serializable id)

    List<Enterprise> list(Map args)

    Long count()

    void delete(Serializable id)

    Enterprise save(Enterprise enterprise)

}