package referidos

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class EnterpriseController {

    EnterpriseService enterpriseService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond enterpriseService.list(params), model:[enterpriseCount: enterpriseService.count()]
    }

    def show(Long id) {
        respond enterpriseService.get(id)
    }

    def create() {
        respond new Enterprise(params)
    }

    def save(Enterprise enterprise) {
        if (enterprise == null) {
            notFound()
            return
        }

        try {
            enterpriseService.save(enterprise)
        } catch (ValidationException e) {
            respond enterprise.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'enterprise.label', default: 'Enterprise'), enterprise.id])
                redirect enterprise
            }
            '*' { respond enterprise, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond enterpriseService.get(id)
    }

    def update(Enterprise enterprise) {
        if (enterprise == null) {
            notFound()
            return
        }

        try {
            enterpriseService.save(enterprise)
        } catch (ValidationException e) {
            respond enterprise.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'enterprise.label', default: 'Enterprise'), enterprise.id])
                redirect enterprise
            }
            '*'{ respond enterprise, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        enterpriseService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'enterprise.label', default: 'Enterprise'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'enterprise.label', default: 'Enterprise'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
