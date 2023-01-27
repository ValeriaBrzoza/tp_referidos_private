package referidos

import grails.gorm.services.Service

@Service(Recruiter)
interface RecruiterService {

    Recruiter get(Serializable id)

    List<Recruiter> list(Map args)

    Long count()

    void delete(Serializable id)

    Recruiter save(Recruiter recruiter)

}